package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.TraineeDTO;
import fa.training.srumanagementg4.service.TraineeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
/**
 * @author HoangNV37
 *
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class TraineeServiceImplTest {

    @MockBean
    TraineeService traineeService;

    @Test
    void testSaveOrUpdate() {
        MockMultipartFile file = new MockMultipartFile("fileimage.jpg", new byte[1]);
        TraineeDTO traineeDTO = new TraineeDTO(1L, "hoangnv37","hoang@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,null, null, null);
       doNothing().when(traineeService).saveOrUpdate(new TraineeDTO(), new MockMultipartFile("fileimage.jpg", new byte[1]));
       traineeService.saveOrUpdate(traineeDTO, file);
       verify(traineeService, times(1)).saveOrUpdate(traineeDTO, file);
    }

    @Test
    void testDeleteTrainee(){
        doNothing().when(traineeService).delete(isA(Long.class));
        traineeService.delete(1L);
        verify(traineeService, times(1)).delete(1L);
    }

    @Test
    void testGetById(){
        TraineeDTO traineeDTO = new TraineeDTO(1L, "hoangnv37","hoang@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,null, null, null);
        Mockito.when(traineeService.getById(1L)).thenReturn(traineeDTO);
        Assert.assertEquals("hoangnv37",traineeService.getById(1L).getAccount());
    }

    @Test
    void testFindAll(){
        TraineeDTO traineeDTO1 = new TraineeDTO(1L, "hoangnv37","hoang@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,null, null, null);
        TraineeDTO traineeDTO2 = new TraineeDTO(2L, "hoangnv37","hoang@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,null, null, null);
        Mockito.when(traineeService.findAll()).thenReturn(Arrays.asList(traineeDTO1,traineeDTO2));
        Assert.assertEquals(2,traineeService.findAll().size());
    }

    @Test
    void testIsExistsAccountOrEmail(){
        TraineeDTO traineeDTO1 = new TraineeDTO(1L, "hoangnv37","hoang@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,null, null, null);
        TraineeDTO traineeDTO2 = new TraineeDTO(2L, "hoangnv38","hoang1999@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,null, null, null);

        Mockito.when(traineeService.isExistAccountOrEmail("hoangnv","hoanghuy@gmail.com")).thenReturn(true);
        Assert.assertEquals(true,traineeService.isExistAccountOrEmail("hoangnv", "hoanghuy@gmail.com"));
    }

    @Test
    void testSearchTraineeByAccountOrFullName(){
        TraineeDTO traineeDTO1 = new TraineeDTO(1L, "hoangnv37","hoang@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,null, null, null);
        TraineeDTO traineeDTO2 = new TraineeDTO(2L, "hoangnv38","hoang@gmail.com","Nong Viet Hoang",null,"0369548634",
                null, "2021-05-06", "Waiting", null, null, "HaUI",null,null, null, null);
        Mockito.when(traineeService.findTraineeByAccountORFullName("hoangnv")).thenReturn(Arrays.asList(traineeDTO1,traineeDTO2));
        Assert.assertEquals(2,traineeService.findTraineeByAccountORFullName("hoangnv").size());
    }
}
