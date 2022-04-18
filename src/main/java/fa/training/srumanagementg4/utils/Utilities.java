package fa.training.srumanagementg4.utils;

import fa.training.srumanagementg4.dto.ClassDTO;
import fa.training.srumanagementg4.dto.MonthAndYearDTO;
import fa.training.srumanagementg4.dto.NameYearOfClassDTO;
import fa.training.srumanagementg4.enums.TypeAttendance;
import fa.training.srumanagementg4.service.impl.ClassServiceImpl;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Utilities {
    private Logger logger = Logger.getLogger(Utilities.class);

    public List<NameYearOfClassDTO> getNameAndYear(List<ClassDTO> classDTOS) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        List<NameYearOfClassDTO> nameYearOfClassDTOS = new ArrayList<>();
        NameYearOfClassDTO nameYearOfClassDTO = null;

        try {
            for (ClassDTO classDTO : classDTOS) {
                nameYearOfClassDTO = new NameYearOfClassDTO();
                nameYearOfClassDTO.setId(classDTO.getId());
                nameYearOfClassDTO.setTitle(classDTO.getName() + "(" + df.format(simpleDateFormat.parse(classDTO.getOpenDate())) + ")");

                nameYearOfClassDTOS.add(nameYearOfClassDTO);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return nameYearOfClassDTOS;
    }

    public TypeAttendance typeAttendance(LocalTime time) {
        TypeAttendance attendance = null;
        LocalTime timeInStandard = LocalTime.parse(Constant.TIME_STANDARD);
        LocalTime timeOutStandard = LocalTime.parse(Constant.TIME_OUT_STANDARD);

        if (time.compareTo(timeOutStandard) > 0) {
            attendance = TypeAttendance.A;
        } else if (time.compareTo(timeInStandard) > 0 && time.compareTo(timeOutStandard) < 0) {
            attendance = TypeAttendance.L;
        } else {
            attendance = TypeAttendance.P;
        }

        return attendance;
    }

    public String getWorkTimeInThisDay(LocalTime time) {
        String timeString = null;
        long minutes = 0;
        LocalTime timeOutStandard = LocalTime.parse(Constant.TIME_OUT_STANDARD);

        if (time.compareTo(timeOutStandard) < 0) {
            minutes = ChronoUnit.MINUTES.between(time, timeOutStandard);
            int hours = (int) minutes / 60;
            int minute = (int) (minutes - hours * 60);
            timeString = "Ends earlier than " + hours + ":" + minute;
        } else if (time.compareTo(timeOutStandard) > 0) {
            minutes = ChronoUnit.MINUTES.between(timeOutStandard, time);
            int hours = (int) minutes / 60;
            int minute = (int) (minutes - hours * 60);
            timeString = "Ends later than " + hours + ":" + minute;
        }

        return timeString;
    }

    public String getMonthAndYear(LocalDate date) {
        String result = null;
        int monthValue = date.getMonthValue();
        int year = date.getYear();

        if (monthValue < 10) {
            result = year + "-0" + monthValue;
        } else {
            result = year + "-" + monthValue;
        }
        return result;
    }

    public MonthAndYearDTO monthAndYearDTO(String monthAndYear) {
        MonthAndYearDTO monthAndYearDTO = null;
        int indexOf = monthAndYear.indexOf("-");

        String year = monthAndYear.substring(0, indexOf);
        String month = monthAndYear.substring(indexOf + 1, monthAndYear.length());
        monthAndYearDTO = new MonthAndYearDTO(Long.valueOf(month), Long.valueOf(year));
        return monthAndYearDTO;
    }

    public boolean isCheckId(String id) {
        return id.matches(Constant.REGEX_ID);
    }
}
