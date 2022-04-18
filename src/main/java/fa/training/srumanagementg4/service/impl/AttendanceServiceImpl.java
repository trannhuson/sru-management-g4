package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.AttendanceDTO;
import fa.training.srumanagementg4.dto.MonthAndYearDTO;
import fa.training.srumanagementg4.dto.UserDTO;
import fa.training.srumanagementg4.entities.Attendance;
import fa.training.srumanagementg4.entities.Users;
import fa.training.srumanagementg4.enums.TypeAttendance;
import fa.training.srumanagementg4.repository.AttendanceRepository;
import fa.training.srumanagementg4.service.AttendanceService;
import fa.training.srumanagementg4.service.UserService;
import fa.training.srumanagementg4.utils.Constant;
import fa.training.srumanagementg4.utils.Utilities;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    private Logger logger = LoggerFactory.getLogger(AttendanceServiceImpl.class);
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private Utilities utilities;

    @Override
    public void create(final String account) {
        Users byAccount = userService.findByAccount(account);
        AttendanceDTO attendance = null;
        TypeAttendance typeAttendance = null;
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        String note = null;
        LocalTime timeOutStandard = LocalTime.parse(Constant.TIME_OUT_STANDARD);
        List<AttendanceDTO> allByUsers = findAllByUsers(account);
        AttendanceDTO byDateAndUser = findByDateAndUser(account);

        if (byDateAndUser == null) {
            if (allByUsers.size() > 0) {
                AttendanceDTO attendanceDTO = allByUsers.get(allByUsers.size() - 1);
                long between = ChronoUnit.DAYS.between(attendanceDTO.getCreatedDate(), dateNow);
                if (byAccount != null) {
                    if (between > 1) {
                        updateAttendance(attendanceDTO.getCreatedDate(), between, byAccount);
                    }
                }
            }
            typeAttendance = utilities.typeAttendance(timeNow);
            attendance = new AttendanceDTO(typeAttendance, dateNow, timeNow, null, note, byAccount);
        } else {
            note = utilities.getWorkTimeInThisDay(timeNow);
            attendance = new AttendanceDTO(byDateAndUser.getId(), byDateAndUser.getType(), dateNow, byDateAndUser.getCreateTime()
                    , timeNow, note, byAccount);
        }

        Attendance map = modelMapper.map(attendance, Attendance.class);
        attendanceRepository.save(map);
    }

    @Override
    public List<AttendanceDTO> findAllByUsers(final String account) {
        List<Attendance> allByCreateDate = attendanceRepository.findAllByCreateDate(account);
        List<AttendanceDTO> attendanceDTOS = new ArrayList<>();
        AttendanceDTO attendanceDTO = null;
        if (allByCreateDate.size() > 0) {
            for (Attendance attendance : allByCreateDate) {
                attendanceDTO = modelMapper.map(attendance, AttendanceDTO.class);
                attendanceDTOS.add(attendanceDTO);
            }
        }
        return attendanceDTOS;
    }

    @Override
    public AttendanceDTO findByDateAndUser(String account) {
        LocalDate date = LocalDate.now();
        AttendanceDTO map = null;
        Attendance byDateAndUsers = attendanceRepository.findByDateAndUsers(date, account);
        if (byDateAndUsers != null) {
            map = modelMapper.map(byDateAndUsers, AttendanceDTO.class);
        }
        return map;
    }

    @Override
    public long getDayAttendanceInMonth(Long idUser) {
        LocalDate now = LocalDate.now();
        attendanceRepository.getDayAttendanceInMonth(now.getMonthValue(), now.getYear(), idUser);
        return attendanceRepository.getDayAttendanceInMonth(now.getMonthValue(), now.getYear(), idUser);
    }

    @Override
    public void updateAttendance(LocalDate endDate, long between, Users users) {
        AttendanceDTO attendance = null;
        for (int i = 1; i < between; i++) {
            attendance = new AttendanceDTO(TypeAttendance.A, endDate.plusDays(i), null, null, "", users);
            Attendance attendance1 = modelMapper.map(attendance, Attendance.class);
            attendanceRepository.save(attendance1);
        }
    }

    @Override
    public boolean update(AttendanceDTO attendanceDTO) {
        boolean status = true;

        try {
            Attendance map = attendanceRepository.getById(attendanceDTO.getId());
            map.setCreateTime(attendanceDTO.getCreateTime());
            map.setEndTime(attendanceDTO.getEndTime());
            TypeAttendance attendance = utilities.typeAttendance(map.getCreateTime());
            String workTimeInThisDay = utilities.getWorkTimeInThisDay(map.getEndTime());
            map.setNote(workTimeInThisDay);
            map.setType(attendance);
            attendanceRepository.save(map);
        } catch (Exception e) {
            logger.error(e.getMessage());
            status = false;
        }
        return status;
    }

    @Override
    public List<AttendanceDTO> findByMonthAndYear(String monthAndYear, Long id) {
        List<AttendanceDTO> attendanceDTOS = new ArrayList<>();
        AttendanceDTO attendanceDTO = null;
        List<Attendance> byMonthAndYear = null;
        MonthAndYearDTO monthAndYearDTO = null;
        try {
            if (monthAndYear == null) {
                byMonthAndYear = attendanceRepository.findByMonthAndYear(LocalDate.now().getMonthValue(),
                        LocalDate.now().getYear(), id);
            } else {
                monthAndYearDTO = utilities.monthAndYearDTO(monthAndYear);
                byMonthAndYear = attendanceRepository.findByMonthAndYear(monthAndYearDTO.getMonth(),
                        monthAndYearDTO.getYear(), id);
            }

            for (Attendance attendance : byMonthAndYear) {
                attendanceDTO = new AttendanceDTO(attendance.getId(), attendance.getType(),
                        attendance.getCreatedDate(), attendance.getCreateTime()
                        , attendance.getEndTime(), attendance.getNote());

                attendanceDTOS.add(attendanceDTO);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return attendanceDTOS;
    }

    public List<AttendanceDTO> findAllByUsersAndMonthAndYear(String account, String month, String year) {
        List<Attendance> attendances = attendanceRepository.getAttendanceByMonthAndYear(month, year, account);
        List<AttendanceDTO> attendanceDTOS = new ArrayList<>();
        AttendanceDTO attendanceDTO = null;
        if (attendances.size() > 0) {
            for (Attendance attendance : attendances) {
                attendanceDTO = modelMapper.map(attendance, AttendanceDTO.class);
                attendanceDTO.setUsers(null);
                attendanceDTOS.add(attendanceDTO);
            }
        }
        return attendanceDTOS.stream().filter(x -> !x.getType().equals(TypeAttendance.A)).collect(Collectors.toList());
    }
}