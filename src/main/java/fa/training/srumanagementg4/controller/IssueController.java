package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.ClassDTO;
import fa.training.srumanagementg4.dto.IssueDTO;
import fa.training.srumanagementg4.dto.SolutionDTO;
import fa.training.srumanagementg4.entities.Class;
import fa.training.srumanagementg4.repository.ClassRepository;
import fa.training.srumanagementg4.service.ClassService;
import fa.training.srumanagementg4.service.IssueService;
import fa.training.srumanagementg4.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class IssueController {

    @Autowired
    IssueService issueService;

    @Autowired
    ClassRepository classRepository;

    @GetMapping("/get-all-issue")
    public String getAllIssue(ModelMap theModel, @RequestParam("classId") String classId,
                              @RequestParam(value = "issueId", required = false) String issueId, HttpSession httpSession) {
        Constant.classId = classId;
        Constant.issueId = issueId;
        List<IssueDTO> issueDTOS = issueService.getAllIssueByClassId(Long.valueOf(Constant.classId));
        Optional<Class> classRoom = classRepository.findById(Long.valueOf(classId));
        IssueDTO issueDTO = new IssueDTO();
        issueDTO.setClassIssue(classRoom.get());
        theModel.addAttribute("issue", issueDTO);
        theModel.addAttribute("issueDTOS", issueDTOS);

        SolutionDTO solutionDTO = new SolutionDTO();
        theModel.addAttribute("solutionDTO", solutionDTO);
        String message = (String) httpSession.getAttribute("messageIssue");
        theModel.addAttribute("messageIssue", message);
        return "issues";
    }

    @PostMapping("/create-issue")
    public String createIssue(@Validated @ModelAttribute("issue") IssueDTO issue,
                              BindingResult theBindingResult, ModelMap theModel, HttpSession httpSession) {
        if (theBindingResult.hasErrors()) {
            theModel.addAttribute("messageIssue", Constant.CREATE_ISSUE_FAIL);
            httpSession.setMaxInactiveInterval(1000);
            return "redirect:/admin/get-all-issue?classId=" + issue.getClassIssue().getId();
        }
        Long classId = issue.getClassIssue().getId();
        issueService.saveIssue(issue);
        httpSession.setAttribute("messageIssue", Constant.CREATE_ISSUE_SUCCESS);
        httpSession.setMaxInactiveInterval(1000);
        return "redirect:/admin/get-all-issue?classId=" + classId;
    }

    @GetMapping("/delete-issue")
    public String deleteIssue(@RequestParam("classId") String classId,
                              @RequestParam("issueId") String issueId, HttpSession httpSession) {
        issueService.deleteIssueById(Long.valueOf(issueId));
        httpSession.setAttribute("messageIssue", Constant.DELETE_ISSUE_SUCCESS);
        httpSession.setMaxInactiveInterval(1000);
        return "redirect:/admin/get-all-issue?classId=" + classId;
    }


}
