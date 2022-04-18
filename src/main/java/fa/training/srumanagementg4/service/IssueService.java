package fa.training.srumanagementg4.service;

import fa.training.srumanagementg4.dto.IssueDTO;
import fa.training.srumanagementg4.entities.Issue;

import java.util.List;

public interface IssueService {

    List<IssueDTO> getAllIssueByClassId(Long classId);
    Issue saveIssue(IssueDTO issueDTO);
    void deleteIssueById(Long id);
    IssueDTO findById(Long id);
}
