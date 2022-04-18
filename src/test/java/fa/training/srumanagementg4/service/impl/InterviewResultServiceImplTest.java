package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.*;
import fa.training.srumanagementg4.entities.Class;
import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.entities.Trainer;
import fa.training.srumanagementg4.entities.TrainingObjective;
import fa.training.srumanagementg4.enums.Gender;
import fa.training.srumanagementg4.service.InterviewResultService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.Mockito.*;

@SpringBootTest
public class InterviewResultServiceImplTest {
    @MockBean
    InterviewResultService interviewResultService;
    @MockBean
    ModelMapper modelMapper;

    @Test
    void testSaveOrUpdate(){
        TrainerDTO trainerDTO = new TrainerDTO(1L,"khoehd","123456","Ha Dinh Khoe", Gender.Male,"khoe@gmail.com","0123456789","khoe.com");
        ClassDTO classDTO = new ClassDTO(1L, "Java01","01-01-2021","20",0,"01-03-2021",null,null,"Waiting",null);

        Trainer trainer = modelMapper.map(trainerDTO, Trainer.class);
        Class aClass = modelMapper.map(classDTO, Class.class);

        TraineeDTO traineeDTO = new TraineeDTO(1L, "hoangnv37","hoang@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,aClass, null, null);
        Trainee trainee = modelMapper.map(traineeDTO, Trainee.class);

        TrainingObjectiveDTO trainingObjectiveDTO = new TrainingObjectiveDTO(2L,"Java","JPL", trainer, aClass);
        TrainingObjective trainingObjective = modelMapper.map(trainingObjectiveDTO, TrainingObjective.class);

        InterviewResultDTO interviewResultDTO = new InterviewResultDTO(1L,5,"Good",new Date(),trainer,trainee, trainingObjective);
        doNothing().when(interviewResultService).saveOrUpdate(new InterviewResultDTO());
        interviewResultService.saveOrUpdate(interviewResultDTO);
        verify(interviewResultService, times(1)).saveOrUpdate(interviewResultDTO);
    }

    @Test
    void testGetById(){
        TrainerDTO trainerDTO = new TrainerDTO(1L,"khoehd","123456","Ha Dinh Khoe", Gender.Male,"khoe@gmail.com","0123456789","khoe.com");
        ClassDTO classDTO = new ClassDTO(1L, "Java01","01-01-2021","20",0,"01-03-2021",null,null,"Waiting",null);

        Trainer trainer = modelMapper.map(trainerDTO, Trainer.class);
        Class aClass = modelMapper.map(classDTO, Class.class);

        TraineeDTO traineeDTO = new TraineeDTO(2L, "hoangnv37","hoang@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,aClass, null, null);
        Trainee trainee = modelMapper.map(traineeDTO, Trainee.class);

        TrainingObjectiveDTO trainingObjectiveDTO = new TrainingObjectiveDTO(2L,"Java","JPL", trainer, aClass);
        TrainingObjective trainingObjective = modelMapper.map(trainingObjectiveDTO, TrainingObjective.class);

        InterviewResultDTO interviewResultDTO = new InterviewResultDTO(1L,5,"Good",new Date(),trainer,trainee, trainingObjective);
        Mockito.when(interviewResultService.getById(1L)).thenReturn(interviewResultDTO);
        Assert.assertEquals("Good", interviewResultService.getById(1L).getComment());
    }

    @Test
    void testGetInterviewResultByTraineeAndSubject(){
        TrainerDTO trainerDTO = new TrainerDTO(1L,"khoehd","123456","Ha Dinh Khoe", Gender.Male,"khoe@gmail.com","0123456789","khoe.com");
        ClassDTO classDTO = new ClassDTO(1L, "Java01","01-01-2021","20",0,"01-03-2021",null,null,"Waiting",null);

        Trainer trainer = modelMapper.map(trainerDTO, Trainer.class);
        Class aClass = modelMapper.map(classDTO, Class.class);

        TraineeDTO traineeDTO = new TraineeDTO(2L, "hoangnv37","hoang@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,aClass, null, null);
        Trainee trainee = modelMapper.map(traineeDTO, Trainee.class);

        TrainingObjectiveDTO trainingObjectiveDTO = new TrainingObjectiveDTO(2L,"Java","JPL", trainer, aClass);
        TrainingObjective trainingObjective = modelMapper.map(trainingObjectiveDTO, TrainingObjective.class);

        InterviewResultDTO interviewResultDTO = new InterviewResultDTO(1L,5,"Good",new Date(),trainer,trainee, trainingObjective);
        Mockito.when(interviewResultService.getInterviewResultByTraineeAndSubject(2L,2L)).thenReturn(interviewResultDTO);
        Assert.assertEquals(5, interviewResultService.getInterviewResultByTraineeAndSubject(2L,2L).getLevel());
    }

    @Test
    void testGetListInterviewResultByTrainerAndSubject(){
        TrainerDTO trainerDTO = new TrainerDTO(1L,"khoehd","123456","Ha Dinh Khoe", Gender.Male,"khoe@gmail.com","0123456789","khoe.com");
        ClassDTO classDTO = new ClassDTO(1L, "Java01","01-01-2021","20",0,"01-03-2021",null,null,"Waiting",null);

        Trainer trainer = modelMapper.map(trainerDTO, Trainer.class);
        Class aClass = modelMapper.map(classDTO, Class.class);

        TraineeDTO traineeDTO1 = new TraineeDTO(2L, "hoangnv37","hoang@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,aClass, null, null);
        TraineeDTO traineeDTO2 = new TraineeDTO(3L, "hoangnv38","hoang1@gmail.com","Nong Viet Huy",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,aClass, null, null);
        Trainee trainee1 = modelMapper.map(traineeDTO1, Trainee.class);
        Trainee trainee2 = modelMapper.map(traineeDTO2, Trainee.class);

        TrainingObjectiveDTO trainingObjectiveDTO = new TrainingObjectiveDTO(2L,"Java","JPL", trainer, aClass);
        TrainingObjective trainingObjective = modelMapper.map(trainingObjectiveDTO, TrainingObjective.class);

        InterviewResultDTO interviewResultDTO1 = new InterviewResultDTO(1L,5,"Good",new Date(),trainer,trainee1, trainingObjective);
        InterviewResultDTO interviewResultDTO2 = new InterviewResultDTO(2L,5,"Good",new Date(),trainer,trainee2, trainingObjective);
        Mockito.when(interviewResultService.getInterviewResultByTrainerAndSubject(1L,2L)).thenReturn(Arrays.asList(interviewResultDTO1, interviewResultDTO2));
        interviewResultService.getInterviewResultByTrainerAndSubject(1L, 2L);
        Assert.assertEquals(2, interviewResultService.getInterviewResultByTrainerAndSubject(1L, 2L).size());
    }

    @Test
    void testGetListInterviewResultByTrainee(){
        TrainerDTO trainerDTO = new TrainerDTO(1L,"khoehd","123456","Ha Dinh Khoe", Gender.Male,"khoe@gmail.com","0123456789","khoe.com");
        ClassDTO classDTO = new ClassDTO(1L, "Java01","01-01-2021","20",0,"01-03-2021",null,null,"Waiting",null);

        Trainer trainer = modelMapper.map(trainerDTO, Trainer.class);
        Class aClass = modelMapper.map(classDTO, Class.class);

        TraineeDTO traineeDTO1 = new TraineeDTO(2L, "hoangnv37","hoang@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,aClass, null, null);

        Trainee trainee1 = modelMapper.map(traineeDTO1, Trainee.class);

        TrainingObjectiveDTO trainingObjectiveDTO1 = new TrainingObjectiveDTO(2L,"Java","JPL", trainer, aClass);
        TrainingObjectiveDTO trainingObjectiveDTO2 = new TrainingObjectiveDTO(2L,"Java","JPL", trainer, aClass);

        TrainingObjective trainingObjective1 = modelMapper.map(trainingObjectiveDTO1, TrainingObjective.class);
        TrainingObjective trainingObjective2 = modelMapper.map(trainingObjectiveDTO2, TrainingObjective.class);

        InterviewResultDTO interviewResultDTO1 = new InterviewResultDTO(1L,5,"Good",new Date(),trainer,trainee1, trainingObjective1);
        InterviewResultDTO interviewResultDTO2 = new InterviewResultDTO(2L,5,"Good",new Date(),trainer,trainee1, trainingObjective2);
        Mockito.when(interviewResultService.getInterviewResultByTrainee(2L)).thenReturn(Arrays.asList(interviewResultDTO1, interviewResultDTO2));
        interviewResultService.getInterviewResultByTrainee(2L);
        Assert.assertEquals(2, interviewResultService.getInterviewResultByTrainee(2L).size());
    }

    @Test
    void testGetListInterviewResultBySubjecIdAndTrainer(){
        TrainerDTO trainerDTO = new TrainerDTO(1L,"khoehd","123456","Ha Dinh Khoe", Gender.Male,"khoe@gmail.com","0123456789","khoe.com");
        ClassDTO classDTO = new ClassDTO(1L, "Java01","01-01-2021","20",0,"01-03-2021",null,null,"Waiting",null);

        Trainer trainer = modelMapper.map(trainerDTO, Trainer.class);
        Class aClass = modelMapper.map(classDTO, Class.class);

        TraineeDTO traineeDTO1 = new TraineeDTO(2L, "hoangnv37","hoang@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,aClass, null, null);
        TraineeDTO traineeDTO2 = new TraineeDTO(3L, "hoangnv38","hoang1@gmail.com","Nong Viet Huy",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,aClass, null, null);
        Trainee trainee1 = modelMapper.map(traineeDTO1, Trainee.class);
        Trainee trainee2 = modelMapper.map(traineeDTO2, Trainee.class);

        TrainingObjectiveDTO trainingObjectiveDTO = new TrainingObjectiveDTO(2L,"Java","JPL", trainer, aClass);
        TrainingObjective trainingObjective = modelMapper.map(trainingObjectiveDTO, TrainingObjective.class);

        InterviewResultDTO interviewResultDTO1 = new InterviewResultDTO(1L,5,"Good",new Date(),trainer,trainee1, trainingObjective);
        InterviewResultDTO interviewResultDTO2 = new InterviewResultDTO(2L,5,"Good",new Date(),trainer,trainee2, trainingObjective);
        Mockito.when(interviewResultService.getInterviewResultByTrainerAndSubject(1L,2L)).thenReturn(Arrays.asList(interviewResultDTO1, interviewResultDTO2));
        interviewResultService.getInterviewResultByTrainerAndSubject(1L, 2L);
        Assert.assertEquals(2, interviewResultService.getInterviewResultByTrainerAndSubject(1L, 2L).size());
    }
}
