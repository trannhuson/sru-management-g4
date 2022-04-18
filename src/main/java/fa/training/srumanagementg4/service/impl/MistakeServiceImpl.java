package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.MistakeDTO;
import fa.training.srumanagementg4.entities.Mistake;
import fa.training.srumanagementg4.repository.MistakeReponsitory;
import fa.training.srumanagementg4.service.MistakeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MistakeServiceImpl implements MistakeService {
    @Autowired
    private MistakeReponsitory mistakeReponsitory;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public void saveOrUpdate(MistakeDTO mistakeDTO) {
        mistakeReponsitory.save(modelMapper.map(mistakeDTO, Mistake.class));
    }

    @Transactional
    @Override
    public void deleteMistake(Long id) {
        mistakeReponsitory.deleteById(id);
    }

    @Transactional
    @Override
    public List<MistakeDTO> findAllMistakeByTrainee(Long traineeId) {

        List<Mistake> mistakes = mistakeReponsitory.findAllByTrainee(traineeId);

        List<MistakeDTO> mistakeDTOS = new ArrayList<>();
        mistakes.forEach(m ->{
            MistakeDTO mistakeDTO = modelMapper.map(m, MistakeDTO.class);
            mistakeDTOS.add(mistakeDTO);
        });
        return mistakeDTOS;
    }
}
