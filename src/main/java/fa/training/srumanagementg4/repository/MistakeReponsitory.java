package fa.training.srumanagementg4.repository;

import fa.training.srumanagementg4.entities.Mistake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MistakeReponsitory extends JpaRepository<Mistake, Long> {

    @Query("SELECT m from Mistake m where m.trainee.id = ?1")
    List<Mistake> findAllByTrainee(Long id);
}
