package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.AttendanceDTO;
import fa.training.srumanagementg4.security.service.UserPrinciple;
import fa.training.srumanagementg4.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainee")
public class AttendanceJsonController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/get-attendance-trainee")
    public List<AttendanceDTO> getAttendanceTrainee(@RequestParam("month") String month, @RequestParam("year") String year, Authentication authentication) {
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        List<AttendanceDTO> attendanceDTOS = attendanceService.findAllByUsersAndMonthAndYear(userPrincipal.getUsername(), month, year);
        return attendanceDTOS;
    }
}
