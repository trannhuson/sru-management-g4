package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.AttendanceDTO;
import fa.training.srumanagementg4.dto.MessageDTO;
import fa.training.srumanagementg4.dto.UserDTO;
import fa.training.srumanagementg4.security.service.UserPrinciple;
import fa.training.srumanagementg4.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/trainee/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private MessageDTO messageDTO;

    @GetMapping("/get-trainee")
    public String attendance(ModelMap modelMap, Authentication authentication) {
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        UserDTO userDTO = new UserDTO();
        userDTO.setAccount(userPrincipal.getUsername());

        modelMap.addAttribute("user", userDTO);
        modelMap.addAttribute("namePage", "Attendance Management");
        return "attendance";
    }

    @GetMapping("/create/{account}")
    public String attendanceCreate(@PathVariable("account") String account) {
        attendanceService.create(account);
        return "redirect:/trainee/attendance/get-trainee";
    }

}
