package fa.training.srumanagementg4.repository;

import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.entities.Users;
import fa.training.srumanagementg4.utils.Constant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author HoangNV37
 *
 */
@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {

    @Query("SELECT t FROM Trainee  t ORDER BY t.id DESC")
    List<Trainee> getAllTrainee();

    @Query(Constant.FIND_ALL_USER_BY_ACCOUNT_OR_EMAIL)
    List<Users> findByAccountOrEmail(String account, String email);

    @Query("SELECT t FROM Trainee t JOIN t.classRoom c WHERE t.classRoom.id = ?1")
    List<Trainee> getTraineesByClassId(Long classId);

    @Modifying
    @Query("UPDATE Trainee t SET t.classRoom.id = ?1 WHERE t.id = ?2")
    void removeTraineeFromClass(Long classId, Long traineeId);

    @Modifying
    @Query("UPDATE Trainee t SET t.classRoom.id = ?1 WHERE t.id = ?2")
    void addTraineeToClass(Long classId, Long traineeId);

    @Query("SELECT t FROM Trainee  t WHERE t.classRoom.id IS NULL AND t.active = TRUE")
    List<Trainee> getAllTraineeNotInClass(Long classId);

    @Query("SELECT t FROM Trainee t WHERE t.account LIKE %:keySearch% OR t.fullName LIKE %:keySearch%")
    List<Trainee> findTraineeByAccountORFullName(String keySearch);

    @Query("SELECT t FROM Trainee t WHERE t.classRoom.id =?1")
    List<Trainee> getAllTraineeByClassId(Long id);

    @Query("SELECT DISTINCT t FROM Trainee t JOIN t.classRoom c " +
            "WHERE  t.classRoom.id = ?1 AND t.id NOT IN " +
            "(SELECT s.trainee.id FROM Score s WHERE s.trainingObjective.id = ?2) ")
    List<Trainee> findTraineeNotHasScore(Long classId, Long trainingObjectiveId);

    @Query("SELECT DISTINCT t FROM Trainee t JOIN t.classRoom c " +
            "WHERE  t.classRoom.id = ?1 AND t.id NOT IN " +
            "(SELECT i.trainee.id FROM InterviewResult i WHERE i.trainingObjective.id = ?2) ")
    List<Trainee> findAllTraineeNotInterview(Long classId, Long trainingObjectiveId);


}
