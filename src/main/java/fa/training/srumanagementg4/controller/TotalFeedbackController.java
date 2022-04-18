package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.FeedbackDTO;
import fa.training.srumanagementg4.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TotalFeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/view-feedback")
    public String showFeedback(@RequestParam("subjectId") String subjectId, @RequestParam("className") String className,
                               @RequestParam("accountTrainer") String accountTrainer, @RequestParam("subjectName") String subjectName, ModelMap theModel) {
        FeedbackDTO feedbackDTO = feedbackService.findFeedbackBySubjectId(Long.parseLong(subjectId));
        theModel.addAttribute("feedbackDTO", feedbackDTO);
        theModel.addAttribute("className", className);
        theModel.addAttribute("accountTrainer", accountTrainer);
        theModel.addAttribute("subjectName", subjectName);
        return "total-feedback";
    }
}
