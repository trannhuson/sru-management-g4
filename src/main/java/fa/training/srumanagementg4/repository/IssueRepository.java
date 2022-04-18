package fa.training.srumanagementg4.repository;

import fa.training.srumanagementg4.dto.IssueDTO;
import fa.training.srumanagementg4.entities.Issue;
import fa.training.srumanagementg4.entities.Status;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

    @Query(value = "select i from Issue i " +
            "where i.classIssue.id = :id ORDER BY i.createdDate DESC")
    List<Issue> findAllByClassId(@Param("id") Long id);
}
