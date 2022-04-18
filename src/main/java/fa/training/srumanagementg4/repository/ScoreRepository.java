package fa.training.srumanagementg4.repository;

import fa.training.srumanagementg4.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    @Query("SELECT s FROM Score s JOIN s.trainee  WHERE s.trainingObjective.id = ?1")
    List<Score> getAllScoreByCSubjectId(Long trainingObjectiveId);

    @Query("SELECT s FROM Score s WHERE s.trainee.id = ?1 AND s.trainingObjective.id = ?2")
    Score findScoreByTraineeAndSubject(Long traineeId, Long trainingObjectiveId);

    @Query("SELECT avg (s.value) FROM Score s WHERE s.trainee.id = ?1")
    Float averageOfScoreByTrainee(Long traineeId);

    @Query("SELECT s FROM Score s JOIN s.trainee  WHERE s.trainee.id = ?1")
    List<Score> getAllScoreByTraineeId(Long traineeId);
}
