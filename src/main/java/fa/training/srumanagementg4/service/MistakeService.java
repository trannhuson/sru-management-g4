package fa.training.srumanagementg4.service;

import fa.training.srumanagementg4.dto.MistakeDTO;

import java.util.List;

public interface MistakeService {

    void saveOrUpdate(MistakeDTO mistakeDTO);

    void deleteMistake(Long id);

    List<MistakeDTO> findAllMistakeByTrainee(Long traineeId);
}
