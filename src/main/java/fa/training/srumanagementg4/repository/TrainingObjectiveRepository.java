package fa.training.srumanagementg4.repository;

import fa.training.srumanagementg4.entities.TrainingObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainingObjectiveRepository extends JpaRepository<TrainingObjective, Long> {

    @Query("SELECT t from TrainingObjective t where t.code = ?1 and t.classClass.id = ?2")
    TrainingObjective getByCodeAndClass(String code,Long classId);

    @Query("SELECT t from TrainingObjective t where t.classClass.id = ?1")
    List<TrainingObjective> getTrainingObjectivesByClassId(Long classId);

    @Query("SELECT t from TrainingObjective t where t.trainer.email = ?1")
    List<TrainingObjective> getTrainingObjectivesByTrainerEmail(String email);

    @Query("SELECT t from TrainingObjective t where t.trainer.id = ?1")
    List<TrainingObjective> getSubjectByTrainerId(Long id);

    @Query("SELECT t from TrainingObjective t where t.id = ?1")
    TrainingObjective getById(Long id);

    @Query("SELECT t from TrainingObjective t where t.trainer.id = ?1 AND t.classClass.id = ?2")
    List<TrainingObjective> getAllTrainingObjectByTrainerAndClass(Long trainerId, Long classId);

    @Query("SELECT t from TrainingObjective t where t.classClass.id = ?1")
    List<TrainingObjective> getSubjectByClass(Long id);
}
