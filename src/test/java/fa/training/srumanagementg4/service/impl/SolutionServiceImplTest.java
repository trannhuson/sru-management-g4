package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.SolutionDTO;
import fa.training.srumanagementg4.entities.Issue;
import fa.training.srumanagementg4.entities.Solution;
import fa.training.srumanagementg4.repository.SolutionRepository;
import fa.training.srumanagementg4.service.SolutionService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

/**
 * @author SonTN9
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SolutionServiceImplTest {

    @MockBean
    SolutionRepository solutionRepository;

    @Autowired
    SolutionService solutionService;

    @Captor
    ArgumentCaptor<Solution> solutionArgumentCaptor;

    @Captor
    ArgumentCaptor<Long> solutionId;

    /**
     * @author SonTN9
     *
     */
    @Test
    void saveSolution() {
        SolutionDTO solutionDTO = new SolutionDTO("Vao lop dung gio", new Issue(), "2021-08-09");
        solutionService.saveSolution(solutionDTO);
        verify(solutionRepository).save(solutionArgumentCaptor.capture());
        Solution solution = solutionArgumentCaptor.getValue();
        assertEquals(solution.getNameSolution(), solutionDTO.getNameSolution());
    }

    /**
     * @author SonTN9
     *
     */
    @Test
    void deleteById() {
        solutionService.deleteById(1L);
        verify(solutionRepository).deleteById(solutionId.capture());
        Long id = solutionId.getValue();
        assertEquals(String.valueOf(1L), String.valueOf(id));
    }
}