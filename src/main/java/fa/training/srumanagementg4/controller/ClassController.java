package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.*;
import fa.training.srumanagementg4.service.*;
import fa.training.srumanagementg4.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author SonTN9
 *
 */
@Controller
@RequestMapping("/admin")
public class ClassController {

    @Autowired
    ClassService classService;

    @Autowired
    IssueService issueService;
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/get-all-class")
    public String getAllClass(ModelMap theModel, HttpSession httpSession) {
        List<ClassDTO> classDTOS = classService.getAllClass();
        theModel.addAttribute("classDTOS", classDTOS);
        String message = (String) httpSession.getAttribute("messageClass");
        theModel.addAttribute("messageClass", message);
        return "class-management";
    }

    @GetMapping("/form-create-class")
    public String formCreateClass(ModelMap theModel, HttpSession httpSession) {
        ClassDTO classDTO = new ClassDTO();
        theModel.addAttribute("classDTO", classDTO);
        httpSession.setAttribute("messageClass", "");
        return "add-class";
    }

    @PostMapping("/create-class")
    public String createClass(@Validated @ModelAttribute("classDTO") ClassDTO classDTO, BindingResult theBindingResult,
                              ModelMap theModel, HttpSession httpSession) throws ParseException {
        if (theBindingResult.hasErrors()) {
            httpSession.setAttribute("messageClass", Constant.CREATE_CLASS_FAIL);
            theModel.addAttribute("messageClass", Constant.CREATE_CLASS_FAIL);
            httpSession.setMaxInactiveInterval(1000);
            return "add-class";
        }
        if(classDTO.getId() == null && classService.checkExistByNameAndYear(classDTO.getName().trim(), classDTO.getOpenDate(), classDTO.getEndDate())) {
            httpSession.setAttribute("messageClass", Constant.NAME_CLASS_EXIST);
            theModel.addAttribute("messageClass", Constant.NAME_CLASS_EXIST);
            httpSession.setMaxInactiveInterval(1000);
            return "add-class";
        }
        if(classDTO.getId() != null) {
            ClassDTO classDto = classService.findById(classDTO.getId());
            if (!classDTO.getName().equals(classDto.getName())
                    && classService.checkExistByNameAndYear(classDTO.getName().trim(), classDTO.getOpenDate(), classDTO.getEndDate())) {
                httpSession.setAttribute("messageClass", Constant.NAME_CLASS_EXIST);
                theModel.addAttribute("messageClass", Constant.NAME_CLASS_EXIST);
                httpSession.setMaxInactiveInterval(1000);
                return "add-class";
            }
        }
        classService.saveClass(classDTO);
        if (classDTO.getId() == null) {
            httpSession.setAttribute("messageClass", Constant.CREATE_CLASS_SUCCESS);
        } else {
            httpSession.setAttribute("messageClass", Constant.UPDATE_CLASS_SUCCESS);
        }
        httpSession.setMaxInactiveInterval(1000);
        return "redirect:/admin/get-all-class";
    }

    @GetMapping("/form-update-class")
    public String formUpdateClass(ModelMap theModel, @RequestParam("classId") String classId, HttpSession httpSession) {
        ClassDTO classDTO = classService.findById(Long.valueOf(classId));
        theModel.addAttribute("classDTO", classDTO);
        httpSession.setAttribute("messageClass", "");
        return "add-class";
    }

    @GetMapping("/delete-class")
    public String deleteClass(@RequestParam("classId") String classId, HttpSession httpSession) {
        classService.deleteClass(Long.valueOf(classId));
        httpSession.setAttribute("messageClass", Constant.DELETE_CLASS_SUCCESS);
        return "redirect:/admin/get-all-class";
    }

    @GetMapping("/detail-class/{id}")
    public String classDetail(ModelMap theModel, @PathVariable("id") Long classId, final HttpServletRequest request, HttpSession httpSession) {
        ClassDTO classDTO = classService.findById(classId);
        List<TrainerDTO> trainerDTOS = classService.getTrainerByClassId(classId);
        List<TraineeDTO> traineeDTOS = classService.getTraineeByClassId(classId);
        List<TraineeDTO> allTraineeDTOS = classService.getAllTrainee(classId);
        List<TrainingObjectiveDTO> allTrainingObjectiveDTOS = classService.getAllTrainingObjectiveByClassId(Long.valueOf(classId));
        String mistakeMessage = (String) request.getSession().getAttribute("mistakeMessage");
        String message = (String) httpSession.getAttribute("message");

        request.setAttribute("planCount",classDTO.getPlanCount());
        request.setAttribute("actual", classDTO.getCurrentCount());
        request.setAttribute("startDate",classDTO.getOpenDate());
        request.setAttribute("endDate",classDTO.getEndDate());

        theModel.addAttribute("traineesDTO", traineeDTOS);
        theModel.addAttribute("allTraineesDTO", allTraineeDTOS);
        theModel.addAttribute("trainingObjectives", allTrainingObjectiveDTOS);
        theModel.addAttribute("trainersDTO", trainerDTOS);
        theModel.addAttribute("classDTO", classDTO);
        theModel.addAttribute("message", message);
        httpSession.setAttribute("messageClass", "");
        theModel.addAttribute("mistake", new MistakeDTO());
        theModel.addAttribute("mistakeMessage", mistakeMessage);

        httpSession.removeAttribute("mistakeMessage");
        httpSession.removeAttribute("message");
        return "class-detail";
    }


    @GetMapping("/detail-class/{classId}/delete-trainee/{traineeId}")
    public String deleteTrainee(@PathVariable("traineeId") String traineeId, @PathVariable("classId") String classId, final HttpSession httpSession) {
        classService.deleteTrainee(null ,Long.valueOf(traineeId));
        httpSession.setAttribute("message", Constant.REMOVE_TRAINEE_FROM_CLASS);
        httpSession.setMaxInactiveInterval(1000);
        return "redirect:/admin/detail-class/"+classId;
    }

    @GetMapping("/detail-class/{classId}/add-trainee/{traineeId}")
    public String addTrainee(@PathVariable("classId") String classId, @PathVariable("traineeId") String traineeID, final HttpSession httpSession){
        classService.addTrainee(Long.valueOf(classId) ,Long.valueOf(traineeID));
        httpSession.setAttribute("message", Constant.ADD_TRAINEE_TO_CLASS_SUCCESS);
        httpSession.setMaxInactiveInterval(1000);
        return "redirect:/admin/detail-class/"+classId;
    }

    @GetMapping("/export-to-excel")
    public void exportFile(final HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=class_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        classService.exportData(response);
    }
    @GetMapping("/export-to-excel/{classId}")
    public void exportFileOneClass(final HttpServletResponse response, @PathVariable("classId") Long classId) throws IOException {
        response.setContentType("application/octet-stream");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        ClassDTO classDTO = classService.findById(classId);

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=class_"+classDTO.getName()+"-"+ currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        classService.exportDataOneClass(response, classDTO);
    }
}
