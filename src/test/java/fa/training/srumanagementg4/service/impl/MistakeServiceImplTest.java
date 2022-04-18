package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.MistakeDTO;
import fa.training.srumanagementg4.dto.TraineeDTO;
import fa.training.srumanagementg4.entities.Mistake;
import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.repository.MistakeReponsitory;
import fa.training.srumanagementg4.service.MistakeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author HoangNV37
 *
 */
@SpringBootTest
public class MistakeServiceImplTest {
    @Autowired
    private MistakeService mistakeService;
    @Autowired
    private ModelMapper modelMapper;
    @MockBean
    private MistakeReponsitory mistakeReponsitory;
    @Captor
    private ArgumentCaptor<Mistake> captor;

    @Captor
    private ArgumentCaptor<Long> captorId;

    @Test
    void testSaveOrUpdate(){
        TraineeDTO traineeDTO = new TraineeDTO(1L, "hoangnv37","hoang@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,null, null, null);
        Trainee trainee = modelMapper.map(traineeDTO, Trainee.class);

        MistakeDTO mistakeDTO = new MistakeDTO(1L,"luoi hoc qua","khong lam bai tap mon java","nhac lan 2", trainee,new Date());

        mistakeService.saveOrUpdate(mistakeDTO);
        verify(mistakeReponsitory).save(captor.capture());

        Mistake mistakeTest = captor.getValue();
        Assert.assertEquals(mistakeDTO.getName(), mistakeTest.getName());
    }

    @Test
    void testFindAllMistakeByTrainee(){
        TraineeDTO traineeDTO = new TraineeDTO(1L, "hoangnv37","hoang@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,null, null, null);
        Trainee trainee = modelMapper.map(traineeDTO, Trainee.class);

        MistakeDTO mistakeDTO1 = new MistakeDTO(1L,"luoi hoc qua","khong lam bai tap mon java","nhac lan 2", trainee,new Date());
        MistakeDTO mistakeDTO2 = new MistakeDTO(2L,"luoi hoc qua dang","khong lam bai tap mon java","nhac lan 2", trainee,new Date());

        Mistake mistake1= modelMapper.map(mistakeDTO1, Mistake.class);
        Mistake mistake2 = modelMapper.map(mistakeDTO2, Mistake.class);
        when(mistakeReponsitory.findAllByTrainee(1L)).thenReturn(Arrays.asList(mistake1, mistake2));
        List<MistakeDTO> mistakeDTOS = mistakeService.findAllMistakeByTrainee(1L);
         Assert.assertEquals(2, mistakeDTOS.size());
    }

    @Test
    void testDeleteMistake(){
        mistakeService.deleteMistake(1L);
        verify(mistakeReponsitory).deleteById(captorId.capture());
        Long id = captorId.getValue();
        Assert.assertEquals(Long.valueOf(1), id);
    }
}
