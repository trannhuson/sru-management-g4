package fa.training.srumanagementg4.service;

import fa.training.srumanagementg4.dto.SolutionDTO;
import fa.training.srumanagementg4.entities.Solution;

public interface SolutionService {
    Solution saveSolution(SolutionDTO solutionDTO);
    void deleteById(Long id);
}
