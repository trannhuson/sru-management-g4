package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.TrainingObjectiveDTO;
import fa.training.srumanagementg4.entities.Class;
import fa.training.srumanagementg4.entities.Trainer;
import fa.training.srumanagementg4.entities.TrainingObjective;
import fa.training.srumanagementg4.service.TrainingObjectiveService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainingObjectServiceImplTest {
    @MockBean
    private TrainingObjectiveService trainingObjectiveService;

    @Test
    public void testSaveSuccess() {
        TrainingObjectiveDTO trainingObjectiveDTO = new TrainingObjectiveDTO(1L, "Java", "101", new Trainer(), new Class());
        doNothing().when(trainingObjectiveService).create(new TrainingObjectiveDTO());
        trainingObjectiveService.create(trainingObjectiveDTO);
        verify(trainingObjectiveService, times(1)).create(trainingObjectiveDTO);
    }

    @Test
    public void testFindAll() {
        TrainingObjectiveDTO first = new TrainingObjectiveDTO(1L, "Java", "101", new Trainer(), new Class());
        TrainingObjectiveDTO last = new TrainingObjectiveDTO(2L, "Java", "101", new Trainer(), new Class());

        Mockito.when(trainingObjectiveService.findAll()).thenReturn(Arrays.asList(first, last));
        final List<TrainingObjectiveDTO> all = trainingObjectiveService.findAll();
        assertEquals(2, all.size());
    }

    @Test
    public void testDelete() {
        doNothing().when(trainingObjectiveService).delete(isA(Long.class));
        trainingObjectiveService.delete(1L);
        verify(trainingObjectiveService, times(1)).delete(1L);
    }

    @Test
    public void testUpdate() {
        TrainingObjectiveDTO trainingObjectiveDTO = new TrainingObjectiveDTO(1L, "Java", "101", new Trainer(), new Class());
        doNothing().when(trainingObjectiveService).update(new TrainingObjectiveDTO());
        trainingObjectiveService.update(trainingObjectiveDTO);
        verify(trainingObjectiveService, times(1)).update(trainingObjectiveDTO);
    }

    @Test
    public void testGetByCodeAndClass() {
        String code = "101";
        String classId = "1L";
        Mockito.when(trainingObjectiveService.getByCodeAndClass(code, classId)).thenReturn(new TrainingObjectiveDTO());
        assertEquals(true, trainingObjectiveService.getByCodeAndClass(code, classId) != null);
    }

    @Test
    public void testGetAllTrainingObjectByTrainerAndClass() {
        Long trainerId = 1L;
        Long classId = 1L;
        TrainingObjectiveDTO first = new TrainingObjectiveDTO(1L, "Java", "101", new Trainer(), new Class());
        TrainingObjectiveDTO last = new TrainingObjectiveDTO(2L, "Java", "101", new Trainer(), new Class());

        Mockito.when(trainingObjectiveService.getAllTrainingObjectByTrainerAndClass(trainerId, classId))
                .thenReturn(Arrays.asList(first, last));

        List<TrainingObjectiveDTO> list = trainingObjectiveService.getAllTrainingObjectByTrainerAndClass(trainerId, classId);
        assertEquals(2, list.size());
    }

    @Test
    public void testGetSubjectByTrainerId() {
        Long trainerId = 1L;
        TrainingObjectiveDTO first = new TrainingObjectiveDTO(1L, "Java", "101", new Trainer(), new Class());

        Mockito.when(trainingObjectiveService.getSubjectByTrainerId(trainerId)).thenReturn(Arrays.asList(first));
        List<TrainingObjectiveDTO> subjectByTrainerId = trainingObjectiveService.getSubjectByTrainerId(trainerId);
        assertEquals(1, subjectByTrainerId.size());
    }
}
