package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.ClassDTO;
import fa.training.srumanagementg4.dto.IssueDTO;
import fa.training.srumanagementg4.entities.Issue;
import fa.training.srumanagementg4.repository.IssueRepository;
import fa.training.srumanagementg4.service.IssueService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    IssueRepository issueRepository;

    @Override
    public List<IssueDTO> getAllIssueByClassId(Long classId) {
        List<IssueDTO> issueDTOS = new ArrayList<>();
        IssueDTO issueDTO = null;
        List<Issue> issues = issueRepository.findAllByClassId(classId);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        for(Issue issue: issues) {
            issueDTO = modelMapper.map(issue, IssueDTO.class);
            issueDTOS.add(issueDTO);
        }
        return issueDTOS;
    }

    @Override
    public Issue saveIssue(IssueDTO issueDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Issue issue = modelMapper.map(issueDTO, Issue.class);
        issue.setCreatedDate(new Date());
        return issueRepository.save(issue);
    }

    @Override
    public void deleteIssueById(Long id) {
        issueRepository.deleteById(id);
    }

    @Override
    public IssueDTO findById(Long id) {
        Optional<Issue> issue = issueRepository.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        IssueDTO issueDTO = modelMapper.map(issue.get(), IssueDTO.class);
        return issueDTO;
    }
}
