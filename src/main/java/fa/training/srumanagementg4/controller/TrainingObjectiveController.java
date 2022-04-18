package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.ClassDTO;
import fa.training.srumanagementg4.dto.NameYearOfClassDTO;
import fa.training.srumanagementg4.dto.TrainingObjectiveDTO;
import fa.training.srumanagementg4.entities.Class;
import fa.training.srumanagementg4.entities.Trainer;
import fa.training.srumanagementg4.entities.TrainingObjective;
import fa.training.srumanagementg4.repository.TrainerRepository;
import fa.training.srumanagementg4.repository.TrainingObjectiveRepository;
import fa.training.srumanagementg4.service.ClassService;
import fa.training.srumanagementg4.service.TrainingObjectiveService;
import fa.training.srumanagementg4.utils.Constant;
import fa.training.srumanagementg4.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/subject")
public class TrainingObjectiveController implements Serializable {
    @Autowired
    private TrainingObjectiveService trainingObjectiveService;
    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private ClassService classService;
    @Autowired
    private Utilities utilities;

    @GetMapping("/get-all-subject")
    public String showSubjectManagement(ModelMap modelMap, final HttpSession httpSession) {
        String namePage = "Training Objective Management";
        List<Trainer> trainers = trainerRepository.findAll();
        List<TrainingObjectiveDTO> trainingObjectives = trainingObjectiveService.findAll();
        List<ClassDTO> classes = classService.getNameAndYearOfClassNotRelease();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        List<NameYearOfClassDTO> nameAndYears = utilities.getNameAndYear(classes);
        String message = (String) httpSession.getAttribute("messageSubject");

        modelMap.addAttribute("messageSubject", message);
        modelMap.addAttribute("trainingObjective", new TrainingObjectiveDTO());
        modelMap.addAttribute("trainers", trainers);
        modelMap.addAttribute("trainingObjectives", trainingObjectives);
        modelMap.addAttribute("namePage", namePage);
        modelMap.addAttribute("dateFormat", dateFormat);
        modelMap.addAttribute("df", df);
        modelMap.addAttribute("nameAndYears", nameAndYears);
        return "subject-management";
    }

    @PostMapping("/training-objective-add")
    public String createObjectTraining(@ModelAttribute("trainingObjective") TrainingObjectiveDTO trainingObjectiveDTO, final HttpSession httpSession) {
        trainingObjectiveService.create(trainingObjectiveDTO);
        httpSession.setAttribute("messageSubject", Constant.CREATE_SUBJECT_SUCCESS);
        httpSession.setMaxInactiveInterval(1000);
        return "redirect:/admin/subject/get-all-subject";
    }

    @GetMapping("/training-objective-delete/{id}")
    public String deleteObjectTraining(@PathVariable("id") Long id, final HttpSession httpSession) {
        trainingObjectiveService.delete(id);
        httpSession.setAttribute("messageSubject", Constant.DELETE_SUBJECT_SUCCESS);
        httpSession.setMaxInactiveInterval(1000);
        return "redirect:/admin/subject/get-all-subject";
    }

    @PostMapping("/training-objective-update/{id}")
    public String update(@ModelAttribute("trainingObjective") TrainingObjectiveDTO trainingObjectiveDTO,
                         @PathVariable("id") Long id, final HttpSession httpSession) {
        trainingObjectiveDTO.setId(id);
        trainingObjectiveService.update(trainingObjectiveDTO);
        httpSession.setAttribute("messageSubject", Constant.UPDATE_SUBJECT_SUCCESS);
        httpSession.setMaxInactiveInterval(1000);
        return "redirect:/admin/subject/get-all-subject";
    }
}
