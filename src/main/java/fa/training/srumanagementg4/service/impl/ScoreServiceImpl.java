package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.ScoreDTO;
import fa.training.srumanagementg4.entities.Issue;
import fa.training.srumanagementg4.entities.Score;
import fa.training.srumanagementg4.repository.ScoreRepository;
import fa.training.srumanagementg4.service.ScoreService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    @Override
    @Transactional
    public Score saveOrUpdate(ScoreDTO scoreDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Score score = modelMapper.map(scoreDTO, Score.class);
        return scoreRepository.save(score);
    }

    @Override
    public ScoreDTO findScoreTrainee(Long traineeId, Long trainingObjectiveId) {
        Score score = scoreRepository.findScoreByTraineeAndSubject(traineeId, trainingObjectiveId);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ScoreDTO scoreDTO = null;
        if(score != null){
            scoreDTO = modelMapper.map(score, ScoreDTO.class);
        }
        return scoreDTO;
    }
}
