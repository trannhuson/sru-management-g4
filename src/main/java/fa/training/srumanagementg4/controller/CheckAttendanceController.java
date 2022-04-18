package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.AttendanceDTO;
import fa.training.srumanagementg4.dto.MessageDTO;
import fa.training.srumanagementg4.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/trainee")
public class CheckAttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private MessageDTO messageDTO;

    @GetMapping("/check")
    public MessageDTO attendanceCheck(HttpServletRequest request) {
        messageDTO = new MessageDTO();
        String account = request.getParameter("account");
        AttendanceDTO byDateAndUser = attendanceService.findByDateAndUser(account.trim());

        if (byDateAndUser != null) {
            messageDTO.setMessage("Account joined today !!!");
        }

        return messageDTO;
    }
}
