package fa.training.srumanagementg4.repository;

import fa.training.srumanagementg4.dto.ClassDTO;
import fa.training.srumanagementg4.dto.StatisticDTO;
import fa.training.srumanagementg4.entities.Class;
import fa.training.srumanagementg4.enums.StatusEnum;
import fa.training.srumanagementg4.enums.TypeClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

    @Query("select new fa.training.srumanagementg4.dto.StatisticDTO(c.status,count(c.status)) from Class c " +
            "where c.type = ?1 group by c.status")
    List<StatisticDTO> statisticClass(TypeClass typeClass);

    @Query("select new fa.training.srumanagementg4.dto.StatisticDTO(c.status,count(c.status)) from Class c " +
            "where c.type = ?1 and c.openDate>=?2 and c.endDate <=?3 group by c.status")
    List<StatisticDTO> statisticClass(TypeClass typeClass, Date start, Date end);

    @Query(value = "SELECT * FROM class c " +
            "WHERE c.name = :name " +
            "AND ((YEAR(c.open_date) = YEAR(:startTime)) " +
            "OR (YEAR(c.end_date) = YEAR(:endTime)))", nativeQuery = true)
    List<Class> findByNameAndDate(@Param("name") String name,
                                  @Param("startTime") Date startTime,
                                  @Param("endTime") Date endTime);

    @Query("select c from Class c where c.type =?1 and c.active=true")
    List<Class> getClassByType(TypeClass typeClass);

    @Query("select c from Class c where c.status <> ?1 and c.active=true")
    List<Class> getNameAndYearOfClassNotRelease(StatusEnum statusEnum);

    @Query(value = "select * from class c where c.name =:name and (YEAR(c.open_date))=:year", nativeQuery = true)
    Class getByNameAndYear(@Param("name") String name, @Param("year") Integer year);

    @Query(value = "select c from Class c where c.active = true")
    List<Class> findAllClassByActive();
}
