package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.*;
import fa.training.srumanagementg4.entities.*;
import fa.training.srumanagementg4.entities.Class;
import fa.training.srumanagementg4.service.IssueService;
import fa.training.srumanagementg4.service.ScoreService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author TanTT5
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ScoreServiceImplTest {

    @MockBean
    ScoreService scoreService;

    @Test
    void findScoreTraineeTest() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        ClassDTO classDTO = new ClassDTO(1L, "Java 888", "10", 10, "good", "Fresher", "Waiting");
        Class aClass = modelMapper.map(classDTO, Class.class);

        TraineeDTO traineeDTO = new TraineeDTO(1L, "tantt5", "tantt@gmail.com", " ", "Trinh Thanh Tan", "0123456789", "FS",
                "2021-08-15", "Pass", "FS", "FF", "FU", aClass);
        Trainee trainee = modelMapper.map(traineeDTO, Trainee.class);

        TrainerDTO trainerDTO = new TrainerDTO(22L, "hoabt2", "Hoa@12345","Bui Thanh Hoa", "hoabt@gmail.com", "0123456789");
        Trainer trainer = modelMapper.map(trainerDTO, Trainer.class);

        TrainingObjectiveDTO trainingObjectiveDTO = new TrainingObjectiveDTO(1L, "Database", "DBI", trainer, aClass);
        TrainingObjective trainingObjective = modelMapper.map(trainingObjectiveDTO, TrainingObjective.class);

        ScoreDTO scoreDTO = new ScoreDTO(1L, trainee, trainingObjective, "abc", new Float(10));
        Mockito.when(scoreService.findScoreTrainee(1L, 1L)).thenReturn(scoreDTO);
        ScoreDTO scoreDTO1 = scoreService.findScoreTrainee(1L, 1L);
        assertEquals(1L, scoreDTO1.getId());
    }

    @Test
    void saveScoreTest() {
        ScoreDTO scoreDTO = new ScoreDTO(1L, new Trainee(), new TrainingObjective(), "abc", new Float(10));

        Score score = new Score("abc", new Float(10));
        Mockito.when(scoreService.saveOrUpdate(scoreDTO)).thenReturn(score);
        assertEquals(score.getName(), scoreDTO.getName());
    }
}