package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.SolutionDTO;
import fa.training.srumanagementg4.entities.Issue;
import fa.training.srumanagementg4.entities.Solution;
import fa.training.srumanagementg4.repository.SolutionRepository;
import fa.training.srumanagementg4.service.SolutionService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SolutionServiceImpl implements SolutionService {

    @Autowired
    SolutionRepository solutionRepository;

    @Override
    public Solution saveSolution(SolutionDTO solutionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Solution solution = modelMapper.map(solutionDTO, Solution.class);
        solution.setCreatedDate(new Date());
        return solutionRepository.save(solution);
    }

    @Override
    public void deleteById(Long id) {
        solutionRepository.deleteById(id);
    }
}
