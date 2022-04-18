package fa.training.srumanagementg4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trainee")
public class CalendarAttendanceController {

    @GetMapping("/calendar-attendance")
    public String showCalendarAttendance() {
        return "calendar-attendance";
    }
}
