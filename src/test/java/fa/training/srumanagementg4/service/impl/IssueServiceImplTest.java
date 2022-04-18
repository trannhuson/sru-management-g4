package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.ClassDTO;
import fa.training.srumanagementg4.dto.IssueDTO;
import fa.training.srumanagementg4.dto.SolutionDTO;
import fa.training.srumanagementg4.entities.Class;
import fa.training.srumanagementg4.entities.Issue;
import fa.training.srumanagementg4.entities.Solution;
import fa.training.srumanagementg4.repository.IssueRepository;
import fa.training.srumanagementg4.service.IssueService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author SonTN9
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class IssueServiceImplTest {

    @Autowired
    IssueService issueService;

    @MockBean
    IssueRepository issueRepository;

    @Captor
    ArgumentCaptor<Issue> captor;

    @Captor
    private ArgumentCaptor<Long> captorId;

    @Test
    void getAllIssueByClassId() {
        Issue issueFirst = new Issue(1L, "issue1", new Date());
        Issue issueSecond = new Issue(2L, "issue2", new Date());
        when(issueRepository.findAllByClassId(1L)).thenReturn(Arrays.asList(issueFirst, issueSecond));
        List<IssueDTO> issueDTOS = issueService.getAllIssueByClassId(1L);
        assertEquals(2, issueDTOS.size());
    }

    @Test
    void saveIssue() {
        IssueDTO issueDTOFirst = new IssueDTO("issue1", "2021-08-08", new Class());
        issueService.saveIssue(issueDTOFirst);
        verify(issueRepository).save(captor.capture());
        Issue issue = captor.getValue();
        assertEquals(issue.getName(), issueDTOFirst.getName());
    }

    @Test
    void deleteIssueById() {
        issueService.deleteIssueById(1L);
        verify(issueRepository).deleteById(captorId.capture());
        Long id = captorId.getValue();
        assertEquals(String.valueOf(1L), String.valueOf(id));
    }

    @Test
    void findById() {
        Issue issue = new Issue(1L, "issue1", new Date());
        when(issueRepository.findById(1L)).thenReturn(Optional.of(issue));

        IssueDTO issueDTO = issueService.findById(1L);
        assertEquals(issue.getName(), issueDTO.getName());
    }
}