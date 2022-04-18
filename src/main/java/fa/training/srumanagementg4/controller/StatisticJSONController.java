package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.StatisticDTO;
import fa.training.srumanagementg4.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/json")
public class StatisticJSONController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/class")
    public List<StatisticDTO> statisticClass(HttpServletRequest request) {
        final String type = request.getParameter("type");
        final String start = request.getParameter("start");
        final String end = request.getParameter("end");

        return statisticService.statisticClass(type, start, end);
    }

    @GetMapping("/trainee")
    public List<StatisticDTO> statisticTrainee(HttpServletRequest request) {
        final String type = request.getParameter("type");
        final String start = request.getParameter("start");
        final String end = request.getParameter("end");
        String classID = request.getParameter("class");

        return statisticService.statisticTrainee(type, start, end, classID);
    }

}
