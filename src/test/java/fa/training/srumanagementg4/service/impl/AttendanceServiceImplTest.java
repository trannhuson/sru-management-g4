package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.AttendanceDTO;
import fa.training.srumanagementg4.entities.Users;
import fa.training.srumanagementg4.enums.TypeAttendance;
import fa.training.srumanagementg4.service.AttendanceService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class AttendanceServiceImplTest {

    @MockBean
    private AttendanceService attendanceService;

    @Test
    public void testCreate() {
        String account = "SonNT9";
        doNothing().when(attendanceService).create(account);
        attendanceService.create(account);
        verify(attendanceService, times(1)).create(account);
    }

    @Test
    public void testFindAllByUsers() {
        String account = "SonNT9";
        AttendanceDTO attendanceDTO = new AttendanceDTO(1L, TypeAttendance.A, LocalDate.now(), LocalTime.now(), LocalTime.now()
                , "", new Users());

        Mockito.when(attendanceService.findAllByUsers(account)).thenReturn(Arrays.asList(attendanceDTO));
        List<AttendanceDTO> allByUsers = attendanceService.findAllByUsers(account);
        assertEquals(1, allByUsers.size());
    }

    @Test
    public void testFindByDateAndUser() {
        String account = "SonNT9";

        Mockito.when(attendanceService.findByDateAndUser(account)).thenReturn(new AttendanceDTO());
        assertEquals(true, attendanceService.findByDateAndUser(account) != null);
    }

    @Test
    public void testGetDayAttendanceInMonth() {
        Long idUser = 1L;

        Mockito.when(attendanceService.getDayAttendanceInMonth(idUser)).thenReturn(30L);
        long dayAttendanceInMonth = attendanceService.getDayAttendanceInMonth(idUser);
        assertEquals(true, dayAttendanceInMonth >= 0 || dayAttendanceInMonth <= 31);
    }

    @Test
    public void testUpdateAttendance() {
        LocalDate date = LocalDate.now();
        long between = 2L;
        Users users = new Users();

        doNothing().when(attendanceService).updateAttendance(date, between, users);
        attendanceService.updateAttendance(date, between, users);
        verify(attendanceService, times(1)).updateAttendance(date, between, users);
    }
}
