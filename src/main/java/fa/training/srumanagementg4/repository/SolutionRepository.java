package fa.training.srumanagementg4.repository;

import fa.training.srumanagementg4.entities.Issue;
import fa.training.srumanagementg4.entities.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Long> {
}
