package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.*;
import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.entities.TrainingObjective;
import fa.training.srumanagementg4.security.service.UserPrinciple;
import fa.training.srumanagementg4.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/trainee")
public class TraineeSubjectController {
    @Autowired
    private TrainingObjectiveService trainingObjectiveService;

    @Autowired
    private TraineeService traineeService;

    @Autowired
    private InterviewResultService interviewResultService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private MistakeService mistakeService;

    @GetMapping("/get-all-subject")
    public String getAllSubject(final ModelMap modelMap, final Authentication authentication, HttpSession httpSession){
        UserPrinciple user = (UserPrinciple) authentication.getPrincipal();
        TraineeDTO traineeDTO = traineeService.getById(user.getId());

        if(traineeDTO.getClassRoom() == null){
            modelMap.addAttribute("trainee", traineeDTO);
        } else{
            List<TrainingObjectiveDTO> trainingObjectiveDTOS =  trainingObjectiveService.getSubjectByClass(traineeDTO.getClassRoom().getId());
            modelMap.addAttribute("trainingObjectiveDTOS", trainingObjectiveDTOS);
            modelMap.addAttribute("trainee", traineeDTO);
        }
        String message = (String) httpSession.getAttribute("messageFeedback");
        modelMap.addAttribute("messageFeedback", message);
        modelMap.addAttribute("mistakes", mistakeService.findAllMistakeByTrainee(traineeDTO.getId()));
        return "trainee/trainee-subject";
    }

    @GetMapping("/subject-result")
    public String getSubjectResult(final ModelMap modelMap, @RequestParam("traineeId") Long traineeId,
                                   @RequestParam("subjectId") Long subjectId, HttpSession httpSession){

        ScoreDTO scoreDTO = scoreService.findScoreTrainee(traineeId, subjectId);
        InterviewResultDTO interviewResultDTO = interviewResultService.getInterviewResultByTraineeAndSubject(traineeId, subjectId);

        modelMap.addAttribute("score", scoreDTO);
        modelMap.addAttribute("interviewResult", interviewResultDTO);
        httpSession.setAttribute("messageFeedback", "");
        return "trainee/trainee-result";
    }
}
