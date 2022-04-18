package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.ClassDTO;
import fa.training.srumanagementg4.dto.ClassTrainerDTO;
import fa.training.srumanagementg4.dto.TraineeDTO;
import fa.training.srumanagementg4.dto.TrainerDTO;
import fa.training.srumanagementg4.entities.Class;
import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.entities.Trainer;
import fa.training.srumanagementg4.entities.Users;
import fa.training.srumanagementg4.enums.StatusEnum;
import fa.training.srumanagementg4.enums.TypeClass;
import fa.training.srumanagementg4.repository.ClassRepository;
import fa.training.srumanagementg4.service.ClassService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author SonTN9
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ClassServiceImplTest {

    @Autowired
    ClassService classService;

    @Captor
    private ArgumentCaptor<Class> captor;

    @MockBean
    ClassRepository classRepository;

    /**
     * @author SonTN9
     *
     */
    @Test
    void saveClass() {
        ClassDTO classDTO = new ClassDTO(1L, "Java 888", "10", 10, "good", "Fresher", "Waiting");
        classService.saveClass(classDTO);
        verify(classRepository).save(captor.capture());
        Class classRoom = captor.getValue();
        assertEquals(classDTO.getName(), classRoom.getName());
    }

    /**
     * @author SonTN9
     *
     */
    @Test
    void getAllClass() {
        Trainee trainee1 = new Trainee();
        trainee1.setId(1L);
        Trainee trainee2 = new Trainee();
        trainee2.setId(2L);

        Set<Trainee> trainees1 = new HashSet<>();
        trainees1.add(trainee1);
        Set<Trainee> trainees2 = new HashSet<>();
        trainees2.add(trainee2);

        Class first = new Class(1L, "Java 01", 10, new Date(), new Date(), TypeClass.Fresher, StatusEnum.Release, trainees1);
        first.setActive(true);
        Class second = new Class(2L, "Java 02", 10, new Date(), new Date(), TypeClass.Fresher, StatusEnum.Release, trainees2);
        second.setActive(true);
        Mockito.when(classRepository.findAllClassByActive()).thenReturn(Arrays.asList(first, second));
        List<ClassDTO> classDTOS = classService.getAllClass();
        assertEquals(2, classDTOS.size());
    }

    /**
     * @author SonTN9
     *
     */
    @Test
    void deleteClass() {
        Trainee trainee1 = new Trainee();
        trainee1.setId(1L);
        Set<Trainee> trainees1 = new HashSet<>();
        trainees1.add(trainee1);
        Class first = new Class(1L, "Java 01", 10, new Date(), new Date(), TypeClass.Fresher, StatusEnum.Release, trainees1);
        Optional<Class> classOptional = Optional.of(first);
        when(classRepository.findById(1L)).thenReturn(classOptional);
        boolean check = classService.deleteClass(1L);
        verify(classRepository).save(captor.capture());
        Class captorValue = captor.getValue();
        assertEquals(captorValue.getName(), first.getName());
        assertTrue(check);
    }

    /**
     * @author SonTN9
     *
     */
    @Test
    void findById() {
        Trainee trainee1 = new Trainee();
        trainee1.setId(1L);
        Set<Trainee> trainees1 = new HashSet<>();
        trainees1.add(trainee1);
        Class aClass = new Class(1L, "Java 01", 10, new Date(), new Date(), TypeClass.Fresher, StatusEnum.Release, trainees1);

        when(classRepository.findById(1L)).thenReturn(Optional.of(aClass));
        ClassDTO classDTO = classService.findById(1L);

        assertEquals("Java 01", classDTO.getName());
        assertEquals(String.valueOf(10), classDTO.getPlanCount());

    }

//    /**
//     * @author TanTT5
//     *
//     */
//    @Test
//    void testGetTraineeByClassId(){
//        Class first = new Class(1L, "Java 01", 10);
//        TraineeDTO trainee1 = new TraineeDTO(1L, "tantt5", "tantt@gmail.com", " ", "Trinh Thanh Tan", "0123456789", "FS", "2021-08-15", "Pass", "FS", "FF", "FU", first);
//        TraineeDTO trainee2 = new TraineeDTO(2L, "tantt", "tantt5@gmail.com", " ", "Trinh Thanh Tan", "0123456789", "FS", "2021-08-15", "Pass", "FS", "FF", "FU", first);
//
//        Mockito.when(classService.getTraineeByClassId(1L)).thenReturn(Arrays.asList(trainee1, trainee2));
//        List<TraineeDTO> traineeDTOS = classService.getTraineeByClassId(1L);
//        assertEquals(2, traineeDTOS.size());
//    }

    /**
     * @author TanTT5
     *
     */
//    @Test
//    void testGetTrainerByClassId(){
//        Class first = new Class(1L, "Java 01", 10);
//        TrainerDTO trainer1 = new TrainerDTO(1L, "hoabt2", "Lavender%123","Trinh Thanh Tan", "hoabt2@gmail.com", "0123456789");
//        TrainerDTO trainer2 = new TrainerDTO(2L, "tritd", "Lavender%123","Trinh Thanh Tan", "tritd@gmail.com", "0123456789");
////        ClassTrainerDTO classTrainerDTO1 = new ClassTrainerDTO(first, trainer1);
//        Mockito.when(classService.getTrainerByClassId(1L)).thenReturn(Arrays.asList(trainer1, trainer2));
//        List<TrainerDTO> trainerDTOS = classService.getTrainerByClassId(1L);
//        assertEquals(2, trainerDTOS.size());
//    }

    /**
     *
     * @author TanTT5
     *
     */
//    @Test
//    void testGetAllTrainer(){
//        TrainerDTO trainer1 = new TrainerDTO(1L, "hoabt2", "Lavender%123","Trinh Thanh Tan", "hoabt2@gmail.com", "0123456789");
//        TrainerDTO trainer2 = new TrainerDTO(2L, "tritd", "Lavender%123","Trinh Thanh Tan", "tritd@gmail.com", "0123456789");
//
//        Mockito.when(classService.getALLTrainer()).thenReturn(Arrays.asList(trainer1, trainer2));
//        List<TrainerDTO> trainerDTOS = classService.getALLTrainer();
//        assertEquals(2, trainerDTOS.size());
//    }

    /**
     * @author SonTN9
     *
     */
    @Test
    void test_check_exist_by_name_and_year_success() throws ParseException {
        Class first = new Class(1L, "java01", 10);
        Date startTime = new Date();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStartStr = dateFormat.format(startTime);

        when(classRepository.findByNameAndDate("java01", new SimpleDateFormat("yyyy-MM-dd").parse(dateStartStr), new SimpleDateFormat("yyyy-MM-dd").parse(dateStartStr))).thenReturn(Arrays.asList(first));
        boolean check = classService.checkExistByNameAndYear("java01", dateStartStr, dateStartStr);
        assertEquals(true, check);
    }

    /**
     * @author SonTN9
     *
     */
    @Test
    void test_check_exist_by_name_and_year_fail() throws ParseException {
        Class first = new Class(1L, "java01", 10);
        Date startTime = new Date();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStartStr = dateFormat.format(startTime);

        when(classRepository.findByNameAndDate("java01", new SimpleDateFormat("yyyy-MM-dd").parse(dateStartStr),
                new SimpleDateFormat("yyyy-MM-dd").parse(dateStartStr))).thenReturn(Arrays.asList(first));
        boolean check = classService.checkExistByNameAndYear("java02", dateStartStr, dateStartStr);
        assertEquals(false, check);
    }
}