package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.ClassDTO;
import fa.training.srumanagementg4.dto.QuestionFeedbackDTO;
import fa.training.srumanagementg4.dto.TrainerDTO;
import fa.training.srumanagementg4.entities.TrainingObjective;
import fa.training.srumanagementg4.security.service.UserPrinciple;
import fa.training.srumanagementg4.service.ClassService;
import fa.training.srumanagementg4.service.FeedbackService;
import fa.training.srumanagementg4.service.TrainerService;
import fa.training.srumanagementg4.service.TrainingObjectiveService;
import fa.training.srumanagementg4.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/trainee")
public class FeedBackController {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private ClassService classService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private TrainingObjectiveService trainingObjectiveService;

    @GetMapping("/feed-back")
    public String showFormFeedBack(@RequestParam("classId") String classId, @RequestParam("trainerId") String trainerId,
                                   @RequestParam("subjectId") String subjectId, ModelMap theModel, Authentication authentication) {
        ClassDTO classRoom = classService.findById(Long.parseLong(classId));
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        TrainerDTO trainer = trainerService.getById(Long.parseLong(trainerId));
        TrainingObjective trainingObjective = trainingObjectiveService.findById(Long.parseLong(subjectId));
        QuestionFeedbackDTO questionFeedbackDTO = new QuestionFeedbackDTO();
        questionFeedbackDTO.setClassName(classRoom.getName());
        questionFeedbackDTO.setTrainerAccount(trainer.getAccount());
        questionFeedbackDTO.setNameSubject(trainingObjective.getName());
        questionFeedbackDTO.setAccountTrainee(userPrincipal.getUsername());
        questionFeedbackDTO.setTrainingObjectiveId(String.valueOf(trainingObjective.getId()));
        theModel.addAttribute("feedback", questionFeedbackDTO);
        return "feed-back";
    }

    @PostMapping("/create-feedback")
    public String createFeedback(@Validated @ModelAttribute("feedback") QuestionFeedbackDTO questionFeedbackDTO, BindingResult theBindingResult,
                                 ModelMap theModel, HttpSession httpSession) {
        if (theBindingResult.hasErrors()) {
            theModel.addAttribute("messageFeedback", Constant.CREATE_FEEDBACK_FAIL);
            httpSession.setAttribute("messageFeedback", Constant.CREATE_FEEDBACK_FAIL);
            httpSession.setMaxInactiveInterval(1000);
            return "feed-back";
        }
        feedbackService.createFeedback(questionFeedbackDTO);
        httpSession.setAttribute("messageFeedback", Constant.CREATE_FEEDBACK_SUCCESS);
        httpSession.setMaxInactiveInterval(1000);
        return "redirect:/trainee/get-all-subject";
    }
}
