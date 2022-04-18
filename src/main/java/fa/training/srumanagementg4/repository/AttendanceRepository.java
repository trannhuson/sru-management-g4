package fa.training.srumanagementg4.repository;

import fa.training.srumanagementg4.dto.AttendanceDTO;
import fa.training.srumanagementg4.entities.Attendance;
import fa.training.srumanagementg4.enums.TypeAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Query("select a from Attendance a where a.users.account = ?1 order by a.createdDate")
    List<Attendance> findAllByCreateDate(String account);

    @Query("select a from Attendance  a where a.createdDate = ?1 and a.users.account = ?2")
    Attendance findByDateAndUsers(LocalDate date, String account);

    @Query(value = "select count(*) from attendance a where MONTH(a.created_date) =:month" +
            " and YEAR(a.created_date) =:year and a.id_person =:id and a.type <>'a'", nativeQuery = true)
    long getDayAttendanceInMonth(@Param("month") long month, @Param("year") long year,
                                 @Param("id") Long idUser);

    @Query(value = "select * from attendance a where MONTH(a.created_date) =:month" +
            " and YEAR(a.created_date) =:year and a.id_person =:id", nativeQuery = true)
    List<Attendance> findByMonthAndYear(@Param("month") long month, @Param("year") long year,
                                        @Param("id") Long idUser);

    @Query(value = "SELECT * FROM attendance a INNER JOIN users u ON a.id_person = u.id "
                + "WHERE MONTH(a.created_date) = :month "
                + "AND YEAR(a.created_date) = :year and u.account = :account", nativeQuery = true)
    List<Attendance> getAttendanceByMonthAndYear(@Param("month") String month,
                                                 @Param("year") String year,
                                                 @Param("account") String account);
}
