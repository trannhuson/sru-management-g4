package fa.training.srumanagementg4.repository;

import fa.training.srumanagementg4.dto.StatisticDTO;
import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.enums.TypeClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface StatisticTraineeRepositoty extends JpaRepository<Trainee, Long> {
    @Query("select new fa.training.srumanagementg4.dto.StatisticDTO(t.status.type,count(t.status.type)) " +
            "from Trainee t where t.classRoom.type = ?1 and t.active = true and t.classRoom.active=true group by t.status.type")
    List<StatisticDTO> statisticTrainee(TypeClass typeClass);

    @Query("select new fa.training.srumanagementg4.dto.StatisticDTO(t.status.type,count(t.status.type)) " +
            "from Trainee t where t.classRoom.type = ?1 and t.classRoom.openDate>=?2 and t.classRoom.endDate <= ?3 and t.active =true and t.classRoom.active=true group by t.status.type")
    List<StatisticDTO> statisticTrainee(TypeClass typeClass, Date start, Date end);

    @Query("select new fa.training.srumanagementg4.dto.StatisticDTO(t.status.type,count(t.status.type)) " +
            "from Trainee t where t.classRoom.type = ?1 and t.classRoom.id = ?2 and t.active=true and t.classRoom.active=true group by t.status.type")
    List<StatisticDTO> statisticTrainee(TypeClass typeClass, Long classId);

    @Query("select new fa.training.srumanagementg4.dto.StatisticDTO(t.status.type,count(t.status.type)) " +
            "from Trainee t where t.classRoom.type = ?1 and t.classRoom.openDate>=?2 and t.classRoom.endDate <= ?3" +
            " and t.classRoom.id =?4 and t.active=true and t.classRoom.active=true group by t.status.type")
    List<StatisticDTO> statisticTrainee(TypeClass typeClass, Date start, Date end, Long classId);
}
