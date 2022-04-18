package fa.training.srumanagementg4.service;

import fa.training.srumanagementg4.dto.StatisticDTO;

import java.util.List;

public interface StatisticService {

    List<StatisticDTO> statisticClass(String type, String start, String end);

    List<StatisticDTO> statisticTrainee(String type, String start, String end);

    List<StatisticDTO> statisticTrainee(String type, String start, String end, String id);
}
