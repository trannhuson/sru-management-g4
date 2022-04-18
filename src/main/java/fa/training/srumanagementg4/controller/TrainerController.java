package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.*;
import fa.training.srumanagementg4.entities.ScoreId;
import fa.training.srumanagementg4.entities.TrainingObjective;
import fa.training.srumanagementg4.security.service.UserPrinciple;
import fa.training.srumanagementg4.service.ClassService;
import fa.training.srumanagementg4.service.InterviewResultService;
import fa.training.srumanagementg4.service.ScoreService;
import fa.training.srumanagementg4.service.TrainerService;
import fa.training.srumanagementg4.utils.Constant;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    ClassService classService;

    @Autowired
    TrainerService trainerService;

    @Autowired
    ScoreService scoreService;

    @Autowired
    private InterviewResultService interviewResultService;
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/get-subject")
    public String getAllSubject(final ModelMap theModel, Authentication authentication) {
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        List<TrainingObjectiveDTO> trainingObjectiveDTOS = trainerService.getSubjectByTrainerEmail(userPrincipal.getEmail());
        theModel.addAttribute("trainingObjectiveDTOS", trainingObjectiveDTOS);
        theModel.addAttribute("interviewResult", interviewResultService);
        return "trainer/trainer-subject";
    }

    @GetMapping("/get-score/{subjectId}")
        public String classDetail(final ModelMap theModel, @PathVariable("subjectId") String trainingObjectiveId, final HttpSession session) {
        List<ScoreDTO> scoreDTOS = trainerService.getScoreBySubjectId(Long.valueOf(trainingObjectiveId));
        theModel.addAttribute("scoreDTOS", scoreDTOS);
        String message = (String) session.getAttribute("messageScore");
        theModel.addAttribute("messageScore", message);
        session.setAttribute("subjectId", trainingObjectiveId);
        return "trainer/trainer-score";
    }

    @GetMapping("/create-score/{subjectId}")
    public String showFormAdd(final ModelMap modelMap, final HttpServletRequest request, @PathVariable("subjectId") String trainingObjectiveId) {

        TrainingObjectiveDTO trainingObjectiveDTO = trainerService.getTrainingObjectiveById(Long.valueOf(trainingObjectiveId));

        List<TraineeDTO> traineeDTOS = trainerService.getTraineeNotHasScore(trainingObjectiveDTO.getaClass().getId(), Long.valueOf(trainingObjectiveId));
        if (request.getParameter("message") != null) {
            String message = (String) request.getParameter("message");
            modelMap.addAttribute("message", message);
        }
        modelMap.addAttribute("trainee", traineeDTOS);
        modelMap.addAttribute("score", new ScoreDTO());
        return "trainer/create-score";
    }

    @GetMapping("/edit-score")
    public String showFormUpdate(final ModelMap modelMap, @RequestParam("subjectId") String trainingObjectiveId,
                                 @RequestParam("traineeId") String traineeId) {
        ScoreDTO scoreDTO =  scoreService.findScoreTrainee(Long.valueOf(traineeId), Long.valueOf(trainingObjectiveId));

        modelMap.addAttribute("score", scoreDTO);
        return "trainer/update-score";
    }

    @PostMapping("/create-score/{subjectId}")
    public String createScore(@Valid @ModelAttribute("score") ScoreDTO scoreDTO, final HttpSession httpSession,
                              BindingResult theBindingResult, @PathVariable("subjectId") Long trainingObjectiveId){
        if(theBindingResult.hasErrors()){
           return "redirect:/trainer/create-score/" + trainingObjectiveId;
        }else{
            TrainingObjectiveDTO trainingObjectiveDTO = trainerService.getTrainingObjectiveById(trainingObjectiveId);
            TrainingObjective trainingObjective =  convertToTrainingObjective(trainingObjectiveDTO);

            scoreDTO.setTrainingObjective(trainingObjective);
            scoreService.saveOrUpdate(scoreDTO);
            httpSession.setAttribute("messageScore", Constant.CREATE_SCORE_SUCCESS);
            httpSession.setMaxInactiveInterval(1000);
            return "redirect:/trainer/get-score/" + trainingObjectiveId;
        }
    }

    @PostMapping("/edit-score")
    public String updateScore(@Valid @ModelAttribute("score") ScoreDTO scoreDTO, final HttpSession httpSession,
                              BindingResult theBindingResult){
        Long trainingObjectiveId = scoreDTO.getTrainingObjective().getId();
        Long traineeId = scoreDTO.getTrainee().getId();
        if(theBindingResult.hasErrors()){
            return "redirect:/trainer/edit-score?subjectId=" + trainingObjectiveId+"&traineeId="+traineeId;
        }else{
            TrainingObjectiveDTO trainingObjectiveDTO = trainerService.getTrainingObjectiveById(trainingObjectiveId);
            TrainingObjective trainingObjective =  convertToTrainingObjective(trainingObjectiveDTO);

            scoreDTO.setTrainingObjective(trainingObjective);
            scoreService.saveOrUpdate(scoreDTO);
            httpSession.setAttribute("messageScore", Constant.UPDATE_SCORE_SUCCESS);
            httpSession.setMaxInactiveInterval(1000);
            return "redirect:/trainer/get-score/" + trainingObjectiveId;
        }
    }

    public TrainingObjective convertToTrainingObjective(TrainingObjectiveDTO trainingObjectiveDTO){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(trainingObjectiveDTO, TrainingObjective.class);
    }
}
