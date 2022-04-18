package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.InterviewResultDTO;
import fa.training.srumanagementg4.dto.TraineeDTO;
import fa.training.srumanagementg4.dto.TrainingObjectiveDTO;
import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.entities.Trainer;
import fa.training.srumanagementg4.entities.TrainingObjective;
import fa.training.srumanagementg4.repository.TraineeRepository;
import fa.training.srumanagementg4.repository.TrainerRepository;
import fa.training.srumanagementg4.repository.TrainingObjectiveRepository;
import fa.training.srumanagementg4.security.service.UserPrinciple;
import fa.training.srumanagementg4.service.InterviewResultService;
import fa.training.srumanagementg4.service.TraineeService;
import fa.training.srumanagementg4.service.TrainerService;
import fa.training.srumanagementg4.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author HoangNV37
 *
 */
@Controller
@RequestMapping("/trainer")
public class InterviewResultController {

    @Autowired
    private TrainerService trainerService;
    @Autowired
    private TraineeService traineeService;
    @Autowired
    private InterviewResultService interviewResultService;

    @GetMapping("/interview-result/{subjectId}")
    public String formTypeInterview(final ModelMap modelMap, @PathVariable("subjectId") Long subjectId, Authentication authentication, final HttpServletRequest request){
        TrainingObjectiveDTO trainingObjectiveDTO = trainerService.getTrainingObjectiveById(subjectId);
        List<TraineeDTO> traineeDTOS = traineeService.findAllTraineeNotInterview(trainingObjectiveDTO.getaClass().getId(), subjectId);
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        List<InterviewResultDTO> interviewResultDTOS = interviewResultService.getInterviewResultBySubjecIdAndTrainer(userPrincipal.getId(),subjectId);
        String interviewMessage = (String) request.getSession().getAttribute("interviewMessage");

        modelMap.addAttribute("trainee", traineeDTOS);
        modelMap.addAttribute("trainer", userPrincipal);
        modelMap.addAttribute("listInterview", interviewResultDTOS);
        modelMap.addAttribute("subject", trainingObjectiveDTO);
        modelMap.addAttribute("interviewResult", new InterviewResultDTO());
        modelMap.addAttribute("interviewMessage", interviewMessage);

        request.getSession().removeAttribute("interviewMessage");
        return "trainer/trainer-interview-list";
    }
    @PostMapping("/interview-result/{subjectId}")
    public String saveInterview(final ModelMap modelMap, @Valid @ModelAttribute("interviewResult") InterviewResultDTO interviewResultDTO,
                                BindingResult bindingResult, @PathVariable("subjectId") Long subjectId, final HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "trainer/trainer-interview-list";
        }
        else if(interviewResultDTO.getId() == null) {
            interviewResultDTO.setDateInterview(new Date());
            interviewResultService.saveOrUpdate(interviewResultDTO);
            request.getSession().setAttribute("interviewMessage", Constant.CREATE_INTERVIEW_SUCCESS);
            request.getSession().setMaxInactiveInterval(1000);
            return "redirect:/trainer/interview-result/"+interviewResultDTO.getTrainingObjective().getId();
        }
        else {
            interviewResultDTO.setDateInterview(new Date());
            interviewResultService.saveOrUpdate(interviewResultDTO);
            request.getSession().setAttribute("interviewMessage", Constant.UPDATE_INTERVIEW_SUCCESS);
            request.getSession().setMaxInactiveInterval(1000);
            return "redirect:/trainer/interview-result/"+interviewResultDTO.getTrainingObjective().getId();
        }
    }

    @GetMapping("/interview-result-edit/{interviewResultId}")
    public String formEditInterview(final ModelMap modelMap, @PathVariable("interviewResultId") Long interviewId){
        InterviewResultDTO interviewResultDTO = interviewResultService.getById(interviewId);

        modelMap.addAttribute("interviewResult", interviewResultDTO);
        return "trainer/update-interview-result";
    }
}
