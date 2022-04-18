package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.ScoreDTO;
import fa.training.srumanagementg4.dto.TraineeDTO;
import fa.training.srumanagementg4.entities.Score;
import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.repository.ScoreRepository;
import fa.training.srumanagementg4.entities.Users;
import fa.training.srumanagementg4.entities.Role;
import fa.training.srumanagementg4.enums.RoleName;
import fa.training.srumanagementg4.repository.TraineeRepository;
import fa.training.srumanagementg4.repository.RoleRepository;
import fa.training.srumanagementg4.service.TraineeService;
import fa.training.srumanagementg4.utils.Constant;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class TraineeServiceImpl implements TraineeService {

    @Autowired
    private TraineeRepository traineeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    MailService mailService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleRepository roleRepository;

    @Transactional
    @Override
    public void saveOrUpdate(TraineeDTO trainee, MultipartFile multipartFile) {
        String currentDirectory = System.getProperty("user.dir");
        try {
        if(trainee.getId() != null){
            String pathDelete = trainee.getImage();
            if(!isEmptyFile(multipartFile)){
                new File(currentDirectory + Constant.ROOT_UPLOAD_FILE+pathDelete).delete();
                String path = multipartFile.getOriginalFilename();
                trainee.setImage(path);
                multipartFile.transferTo(new File(currentDirectory + Constant.ROOT_UPLOAD_FILE+path));
            }
        }
        if(!isEmptyFile(multipartFile) && trainee.getId() == null){
            String path = multipartFile.getOriginalFilename();
            trainee.setImage(path);
           multipartFile.transferTo(new File(currentDirectory + Constant.ROOT_UPLOAD_FILE+path));
        }
    }
    catch (IOException e){
        e.printStackTrace();
    }
    ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Trainee traineeSave = mapper.map(trainee, Trainee.class);
        Set<Role> roles = new HashSet<>();
        Optional<Role> adminRole = roleRepository.findByName(RoleName.ROLE_TRAINEE);
        roles.add(adminRole.get());
        if(trainee.getId() == null) {
            String password = Constant.getRandomNumberString();
            traineeSave.setPassword(encoder.encode(password));
            mailService.sendEmailLogin(traineeSave.getEmail(), traineeSave.getFullName(), password);
        }
        traineeSave.setRoles(roles);
        traineeRepository.save(traineeSave);

    }

    @Transactional
    @Override
    public void delete(Long id) {
        TraineeDTO traineeDTO = getById(id);
        traineeDTO.setActive(false);
        traineeDTO.setClassRoom(null);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Trainee traineeSave = mapper.map(traineeDTO, Trainee.class);
        traineeRepository.save(traineeSave);
    }

    @Transactional
    @Override
    public List<TraineeDTO> findAll() {
        List<Trainee> trainees = traineeRepository.findAll();
        List<TraineeDTO> traineeDTOS = new ArrayList<>();
        TraineeDTO traineeDTO = null;

        for (Trainee trainee: trainees
             ) {
            traineeDTO = convertTrainee(trainee);
            traineeDTOS.add(traineeDTO);
        }
        return traineeDTOS;
    }

    @Transactional
    @Override
    public TraineeDTO getById(Long id) {
        Trainee trainee = traineeRepository.getById(id);
        return convertTrainee(trainee);
    }

    @Transactional
    @Override
    public boolean isExistAccountOrEmail(String account, String email) {
        List<Users> trainee = traineeRepository.findByAccountOrEmail(account, email);
        if(trainee.size() == 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public List<TraineeDTO> findTraineeByAccountORFullName(String keySearch) {
        List<Trainee> trainees = traineeRepository.findTraineeByAccountORFullName(keySearch);
        List<TraineeDTO> traineeDTOS = new ArrayList<>();
        TraineeDTO traineeDTO = null;
        for(Trainee trainee : trainees){
            traineeDTO = convertTrainee(trainee);
            traineeDTOS.add(traineeDTO);
        }
        return traineeDTOS;
    }


    @Transactional
    @Override
    public Page<Trainee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

        return traineeRepository.findAll(pageable);
    }

    @Override
    public List<TraineeDTO> getAllTraineeByClassId(Long id) {
        List<Trainee> trainees = traineeRepository.getAllTraineeByClassId(id);
        List<TraineeDTO> traineeDTOS = new ArrayList<>();
        TraineeDTO traineeDTO = null;
        for(Trainee trainee: trainees){
            traineeDTO = modelMapper.map(trainee, TraineeDTO.class);
            traineeDTOS.add(traineeDTO);
        }
        return traineeDTOS;
    }

    @Override
    public List<TraineeDTO> findAllTraineeNotInterview(Long classId, Long trainingObjectiveId) {
        List<Trainee> trainees = traineeRepository.findAllTraineeNotInterview(classId, trainingObjectiveId);
        List<TraineeDTO> traineeDTOS = new ArrayList<>();
        TraineeDTO traineeDTO = null;
        for(Trainee trainee: trainees){
            traineeDTO = modelMapper.map(trainee, TraineeDTO.class);
            traineeDTOS.add(traineeDTO);
        }
        return traineeDTOS;
    }

    @Override
    public Float getAverageOfScoreByTraineeId(Long traineeId) {
        return scoreRepository.averageOfScoreByTrainee(traineeId);
    }

    @Override
    public List<ScoreDTO> getAllScoreByTraineeId(Long traineeId) {
        List<Score> scores = scoreRepository.getAllScoreByTraineeId(traineeId);
        List<ScoreDTO> scoreDTOS = new ArrayList<>();
        ScoreDTO scoreDTO = null;
        for(Score score: scores){
            scoreDTO = modelMapper.map(score, ScoreDTO.class);
            scoreDTOS.add(scoreDTO);
        }
        return scoreDTOS;
    }

    public TraineeDTO convertTrainee(Trainee trainee) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(trainee,TraineeDTO.class);
    }

    public boolean isEmptyFile(MultipartFile file){
        return file == null || file.getOriginalFilename().isEmpty();
    }

}
