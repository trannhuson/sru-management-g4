package fa.training.srumanagementg4.service;

import fa.training.srumanagementg4.dto.AttendanceDTO;
import fa.training.srumanagementg4.entities.Attendance;
import fa.training.srumanagementg4.entities.Users;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {

    void create(String account);

    List<AttendanceDTO> findAllByUsers(String account);

    AttendanceDTO findByDateAndUser(String account);

    long getDayAttendanceInMonth(Long idUser);

    void updateAttendance(LocalDate endDate, long between, Users users);

    boolean update(AttendanceDTO attendanceDTO);

    List<AttendanceDTO> findByMonthAndYear(String monthAndYear, Long id);

    List<AttendanceDTO> findAllByUsersAndMonthAndYear(String account, String month, String year);
}
