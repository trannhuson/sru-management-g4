package fa.training.srumanagementg4.repository;

import fa.training.srumanagementg4.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    @Query("SELECT t from Trainer t where t.account = ?1")
    Trainer findByAccount(String account);

    @Query("SELECT DISTINCT t FROM Trainer t JOIN t.trainingObjectives c WHERE c.classClass.id = ?1")
    public List<Trainer> findByClassId(Long classId);

}
