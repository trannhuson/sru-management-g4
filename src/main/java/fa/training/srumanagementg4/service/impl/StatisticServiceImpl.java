package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.StatisticDTO;
import fa.training.srumanagementg4.enums.TypeClass;
import fa.training.srumanagementg4.repository.ClassRepository;
import fa.training.srumanagementg4.repository.StatisticTraineeRepositoty;
import fa.training.srumanagementg4.repository.TraineeRepository;
import fa.training.srumanagementg4.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private StatisticTraineeRepositoty statisticTrainee;

    @Override
    public List<StatisticDTO> statisticClass(String type, String start, String end) {
        List<StatisticDTO> statisticDTOS = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if ("".equals(start) || "".equals(end)) {
                if ("Fresher".equalsIgnoreCase(type)) {
                    statisticDTOS = classRepository.statisticClass(TypeClass.Fresher);
                } else if ("Internship".equalsIgnoreCase(type)) {
                    statisticDTOS = classRepository.statisticClass(TypeClass.Internship);
                }
            } else {
                if ("Fresher".equalsIgnoreCase(type)) {
                    statisticDTOS = classRepository.statisticClass(TypeClass.Fresher, simpleDateFormat.parse(start), simpleDateFormat.parse(end));
                } else if ("Internship".equalsIgnoreCase(type)) {
                    statisticDTOS = classRepository.statisticClass(TypeClass.Internship, simpleDateFormat.parse(start), simpleDateFormat.parse(end));
                }
            }
        } catch (Exception e) {
            statisticDTOS = new ArrayList<>();
        }
        return statisticDTOS;
    }

    @Override
    public List<StatisticDTO> statisticTrainee(String type, String start, String end) {
        List<StatisticDTO> statisticDTOS = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if ("".equalsIgnoreCase(start) || "".equals(end)) {
                {
                    if ("Fresher".equalsIgnoreCase(type)) {
                        statisticDTOS = statisticTrainee.statisticTrainee(TypeClass.Fresher);
                    } else if ("Internship".equalsIgnoreCase(type)) {
                        statisticDTOS = statisticTrainee.statisticTrainee(TypeClass.Internship);
                    }
                }
            } else {
                if ("Fresher".equalsIgnoreCase(type)) {
                    statisticDTOS = statisticTrainee.statisticTrainee(TypeClass.Fresher, simpleDateFormat.parse(start), simpleDateFormat.parse(end));
                } else if ("Internship".equalsIgnoreCase(type)) {
                    statisticDTOS = statisticTrainee.statisticTrainee(TypeClass.Internship, simpleDateFormat.parse(start), simpleDateFormat.parse(end));
                }
            }

        } catch (Exception e) {
            statisticDTOS = new ArrayList<>();
        }

        return statisticDTOS;
    }

    @Override
    public List<StatisticDTO> statisticTrainee(String type, String start, String end, String id) {
        List<StatisticDTO> statisticDTOS = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if (id == null) {
                statisticDTOS = statisticTrainee(type, start, end);
            } else {
                if ("".equalsIgnoreCase(start) || "".equals(end)) {
                    {
                        if ("".equals(id)) {
                            statisticDTOS = statisticTrainee(type, start, end);
                        } else {
                            if ("Fresher".equalsIgnoreCase(type)) {
                                statisticDTOS = statisticTrainee.statisticTrainee(TypeClass.Fresher, Long.valueOf(id));
                            } else {
                                statisticDTOS = statisticTrainee.statisticTrainee(TypeClass.Internship, Long.valueOf(id));
                            }
                        }
                    }
                } else {
                    if ("Fresher".equalsIgnoreCase(type)) {
                        if ("".equals(id)) {
                            statisticDTOS = statisticTrainee.statisticTrainee(TypeClass.Fresher, simpleDateFormat.parse(start), simpleDateFormat.parse(end));
                        } else {
                            statisticDTOS = statisticTrainee.statisticTrainee(TypeClass.Fresher, simpleDateFormat.parse(start), simpleDateFormat.parse(end), Long.valueOf(id.trim()));
                        }
                    } else if ("Internship".equalsIgnoreCase(type)) {
                        if ("".equals(id)) {
                            statisticDTOS = statisticTrainee.statisticTrainee(TypeClass.Internship, simpleDateFormat.parse(start), simpleDateFormat.parse(end));
                        } else {
                            statisticDTOS = statisticTrainee.statisticTrainee(TypeClass.Internship, simpleDateFormat.parse(start), simpleDateFormat.parse(end), Long.valueOf(id.trim()));
                        }
                    }
                }
            }

        } catch (Exception e) {
            statisticDTOS = new ArrayList<>();
            e.printStackTrace();
        }

        return statisticDTOS;
    }
}
