package fa.training.srumanagementg4.service;

import fa.training.srumanagementg4.dto.ScoreDTO;
import fa.training.srumanagementg4.dto.TraineeDTO;
import fa.training.srumanagementg4.entities.Score;
import fa.training.srumanagementg4.entities.Trainee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TraineeService {
    void saveOrUpdate(TraineeDTO traineeDTO, MultipartFile multipartFile);

    void delete(Long id);

    List<TraineeDTO> findAll();

    TraineeDTO getById(Long id);

    boolean isExistAccountOrEmail(String account, String email);

    List<TraineeDTO> findTraineeByAccountORFullName(String keySearch);

    Page<Trainee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    List<TraineeDTO> getAllTraineeByClassId(Long id);

    Float getAverageOfScoreByTraineeId(Long traineeId);

    List<ScoreDTO> getAllScoreByTraineeId(Long traineeId);
    List<TraineeDTO> findAllTraineeNotInterview(Long classId, Long trainingObjectiveId);

}
