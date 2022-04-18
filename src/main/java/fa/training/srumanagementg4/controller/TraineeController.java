package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.*;
import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.service.*;
import fa.training.srumanagementg4.utils.Constant;
import fa.training.srumanagementg4.utils.Utilities;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HoangNV37
 */
@Controller
@RequestMapping("/admin/trainee")
public class TraineeController {

    @Autowired
    private TraineeService traineeService;
    @Autowired
    private ClassService classService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private InterviewResultService interviewResultService;
    @Autowired
    private MistakeService mistakeService;

    @Autowired
    private Utilities utilities;

    @GetMapping("/trainee-add")
    public String showFormAdd(final ModelMap modelMap, final HttpServletRequest request) {

        if (request.getParameter("message") != null) {
            String message = (String) request.getParameter("message");
            modelMap.addAttribute("message", message);
        }
        modelMap.addAttribute("trainee", new TraineeDTO());
        modelMap.addAttribute("listClass", classService.getAllClass());
        modelMap.addAttribute("status", statusService.findAll());

        return "trainee/trainee-add";
    }

    @PostMapping("/trainee-add")
    public String addTrainee(final ModelMap modelMap, @Valid @ModelAttribute("trainee") TraineeDTO traineeDTO,
                             final BindingResult bindingResult, @RequestParam("imageFile") MultipartFile file, final HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "trainee/trainee-add";
        } else {
            if (traineeService.isExistAccountOrEmail(traineeDTO.getAccount(), traineeDTO.getEmail())) {
                traineeService.saveOrUpdate(traineeDTO, file);
                session.setAttribute("traineeMessage", Constant.ADD_TRAINEE_SUCCESS);
                session.setMaxInactiveInterval(1000);
                return "redirect:/admin/trainee/trainee-list";
            } else {
                modelMap.addAttribute("trainee", traineeDTO);
                modelMap.addAttribute("message", Constant.ACCOUNT_EXISTS);
                modelMap.addAttribute("status", statusService.findAll());
                modelMap.addAttribute("traineeMessage", Constant.ADD_TRAINEE_FAIL);
                return "trainee/trainee-add";
            }
        }
    }

    @PostMapping("/trainee-edit")
    public String editTrainee(final ModelMap modelMap, @Valid @ModelAttribute("trainee") TraineeDTO traineeDTO,
                              final BindingResult bindingResult, @RequestParam("imageFile") MultipartFile file, final HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("traineeMessage", Constant.UPDATE_TRAINEE_FAIL);
            return "trainee/trainee-add";
        } else {
            traineeService.saveOrUpdate(traineeDTO, file);
            request.getSession().setAttribute("traineeMessage", Constant.UPDATE_TRAINEE_SUCCESS);
            request.getSession().setMaxInactiveInterval(1000);
            return "redirect:/admin/trainee/trainee-list";
        }
    }

    @GetMapping("/trainee-update")
    public String updateTrainee(final ModelMap modelMap, @RequestParam("traineeId") String id) {
        TraineeDTO traineeUpdate = traineeService.getById(Long.valueOf(id));

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        TraineeDTO traineeDTO = mapper.map(traineeUpdate, TraineeDTO.class);

        modelMap.addAttribute("trainee", traineeDTO);
        modelMap.addAttribute("listClass", classService.getAllClass());
        modelMap.addAttribute("status", statusService.findAll());
        modelMap.addAttribute("classRoom", classService.getAllClass());
        return "trainee/trainee-edit";
    }

    @GetMapping("/trainee-delete")
    public String deleteTrainee(final ModelMap modelMap, @RequestParam("traineeId") String id, final HttpServletRequest request) {
        traineeService.delete(Long.valueOf(id));
        request.getSession().setAttribute("traineeMessage", Constant.DELETE_TRAINEE_SUCCESS);
        request.getSession().setMaxInactiveInterval(1000);
        return "redirect:/admin/trainee/trainee-list";
    }

    @GetMapping("/trainee-list")
    public String getAllTrainee(final ModelMap modelMap, final HttpServletRequest request) {

        return findPaginated(modelMap, 1, request);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(final ModelMap modelMap, @PathVariable(value = "pageNo") int pageNo, final HttpServletRequest request
    ) {
        int pageSize = 10;
        String traineeMessage = (String) request.getSession().getAttribute("traineeMessage");
        if (request.getParameter("pageSize") != null) {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        }
        Page<Trainee> page = traineeService.findPaginated(pageNo, pageSize, "active", "DESC");
        List<Trainee> listTrainee = page.getContent();

        modelMap.addAttribute("currentPage", pageNo);
        modelMap.addAttribute("totalPages", page.getTotalPages());
        modelMap.addAttribute("totalItems", page.getTotalElements());
        modelMap.addAttribute("listTrainee", listTrainee);
        modelMap.addAttribute("pageSize", pageSize);
        modelMap.addAttribute("traineeMessage", traineeMessage);

        request.getSession().removeAttribute("traineeMessage");
        return "trainee/trainee-list";
    }

    @GetMapping("/trainee-search")
    public String searchTrainee(final ModelMap modelMap, @RequestParam("keySearch") String keySearch) {
        if (keySearch.isEmpty()) {
            return "redirect:/admin/trainee/trainee-list";
        }
        List<TraineeDTO> traineeDTOS = traineeService.findTraineeByAccountORFullName(keySearch);
        modelMap.addAttribute("listTrainee", traineeDTOS);
        modelMap.addAttribute("keySearch", keySearch);
        return "trainee/trainee-list";
    }

    @GetMapping("/trainee-detail/{id}")
    public String showTraineeDetail(final ModelMap modelMap, @PathVariable("id") String id, final HttpServletRequest request) {
        TraineeDTO traineeDTO = traineeService.getById(Long.valueOf(id));
        if (traineeDTO.getScores().isEmpty()) {
            traineeDTO.setRank("None");
        }
        Float averageOfScoreByTraineeId = traineeService.getAverageOfScoreByTraineeId(Long.valueOf(id));

        List<ScoreDTO> scoreDTOS = traineeService.getAllScoreByTraineeId(Long.valueOf(id));
        List<InterviewResultDTO> interviewResultDTOS = interviewResultService.getInterviewResultByTrainee(Long.valueOf(id));
        List<MistakeDTO> mistakeDTOS = mistakeService.findAllMistakeByTrainee(Long.valueOf(id));

        long dayAttendanceInMonth = attendanceService.getDayAttendanceInMonth(traineeDTO.getId());
        List<AttendanceDTO> allByUsers = attendanceService.findByMonthAndYear(null, traineeDTO.getId());
        String dayInMonth = dayAttendanceInMonth + "/" + LocalDate.now().lengthOfMonth();
        String monthAndYear = utilities.getMonthAndYear(LocalDate.now());
        String mistakeMessage = (String) request.getSession().getAttribute("mistakeMessage");

        modelMap.addAttribute("scoreDTOS", scoreDTOS);
        modelMap.addAttribute("grade", averageOfScoreByTraineeId);
        modelMap.addAttribute("trainee", traineeDTO);
        modelMap.addAttribute("count", interviewResultDTOS.size());
        modelMap.addAttribute("interviewResult", interviewResultDTOS);
        modelMap.addAttribute("allByUsers", allByUsers);
        modelMap.addAttribute("dayInMonth", dayInMonth);
        modelMap.addAttribute("month", monthAndYear);
        modelMap.addAttribute("mistakeEdit", new MistakeDTO());
        modelMap.addAttribute("mistakes", mistakeDTOS);
        modelMap.addAttribute("mistakeMessage", mistakeMessage);

        request.getSession().removeAttribute("mistakeMessage");
        return "trainee/trainee-detail";
    }
}
