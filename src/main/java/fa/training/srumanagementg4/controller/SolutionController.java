package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.IssueDTO;
import fa.training.srumanagementg4.dto.SolutionDTO;
import fa.training.srumanagementg4.entities.Issue;
import fa.training.srumanagementg4.service.SolutionService;
import fa.training.srumanagementg4.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class SolutionController {

    @Autowired
    SolutionService solutionService;

    @PostMapping("create-solution")
    public String createSolution(@Validated @ModelAttribute("solutionDTO") SolutionDTO solutionDTO,
                                 BindingResult theBindingResult, ModelMap theModel, HttpSession httpSession) {
        if (theBindingResult.hasErrors()) {
            httpSession.setAttribute("messageIssue", Constant.CREATE_SOLUTION_FAIL);
            httpSession.setMaxInactiveInterval(1000);
            return "redirect:/admin/get-all-issue?classId=" + Constant.classId;
        }
        Issue issue = new Issue();
        issue.setId(Long.parseLong(Constant.issueId));
        solutionDTO.setIssue(issue);
        if (solutionDTO.getId() == null) {
            httpSession.setAttribute("messageIssue", Constant.CREATE_SOLUTION_SUCCESS);
        } else {
            httpSession.setAttribute("messageIssue", Constant.UPDATE_SOLUTION_SUCCESS);
        }
        solutionService.saveSolution(solutionDTO);
        httpSession.setMaxInactiveInterval(1000);
        return "redirect:/admin/get-all-issue?classId=" + Constant.classId;
    }

    @GetMapping("delete-solution")
    public String deleteSolution(@RequestParam("solutionId") String solutionId, HttpSession httpSession) {
        solutionService.deleteById(Long.parseLong(solutionId));
        httpSession.setAttribute("messageIssue", Constant.DELETE_SOLUTION_SUCCESS);
        httpSession.setMaxInactiveInterval(1000);
        return "redirect:/admin/get-all-issue?classId=" + Constant.classId;
    }
}
