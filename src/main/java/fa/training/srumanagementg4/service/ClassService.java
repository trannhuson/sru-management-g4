package fa.training.srumanagementg4.service;

import fa.training.srumanagementg4.dto.*;
import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.enums.TypeClass;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ClassService {

    void saveClass(ClassDTO classRoom);
    List<ClassDTO> getAllClass();
    boolean deleteClass(Long classId);
    ClassDTO findById(Long id);
    List<TrainerDTO> getTrainerByClassId(Long classId);
    List<TraineeDTO> getTraineeByClassId(Long classId);
    List<TraineeDTO> getAllTrainee(Long classId);
    List<TrainerDTO> getALLTrainer();
    List<TrainingObjectiveDTO> getAllTrainingObjectiveByClassId(Long classId);
    void deleteTrainee(Long classId, Long traineeId);
    void addTrainee(Long classId, Long traineeId);
    Page<Trainee> findPaginated(int pageNo, int pageSize);
    boolean checkExistByNameAndYear(String name, String dateStartStr, String endDateStr) throws ParseException;

    List<ClassDTO> getNameAndYearOfClassNotRelease();

    Long getNameAndYear(String name,String year);

    void exportData(HttpServletResponse httpServletResponse) throws IOException;

    void exportDataOneClass(HttpServletResponse httpServletResponse, ClassDTO classDTO) throws IOException;
}
