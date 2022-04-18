package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.*;
import fa.training.srumanagementg4.entities.Class;
import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.entities.Trainer;
import fa.training.srumanagementg4.entities.TrainingObjective;
import fa.training.srumanagementg4.enums.StatusEnum;
import fa.training.srumanagementg4.repository.ClassRepository;
import fa.training.srumanagementg4.repository.TraineeRepository;
import fa.training.srumanagementg4.repository.TrainerRepository;
import fa.training.srumanagementg4.repository.TrainingObjectiveRepository;
import fa.training.srumanagementg4.service.ClassService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassServiceImpl implements ClassService {

    private static final Logger logger = LoggerFactory.getLogger(ClassServiceImpl.class);

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    @Autowired
    ClassRepository classRepository;

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    TraineeRepository traineeRepository;

    @Autowired
    TrainingObjectiveRepository trainingObjectiveRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public void saveClass(ClassDTO classDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Class saveClass = modelMapper.map(classDTO, Class.class);
        saveClass.setActive(true);
        classRepository.save(saveClass);
    }

    @Transactional
    @Override
    public List<ClassDTO> getAllClass() {
        List<Class> classes = classRepository.findAllClassByActive();
        List<ClassDTO> classDTOS = new ArrayList<>();
        ClassDTO classDTO = null;

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        for (Class classRoom : classes) {
            classDTO = modelMapper.map(classRoom, ClassDTO.class);
            classDTO.setCurrentCount(classRoom.getTrainees().size());
            classDTOS.add(classDTO);
        }
        return classDTOS;
    }

    @Transactional
    @Override
    public boolean deleteClass(Long classId) {
        Optional<Class> classRoom = classRepository.findById(classId);
        if (!classRoom.isPresent()) {
            return false;
        }
        classRoom.get().setActive(false);
        classRepository.save(classRoom.get());
        return true;
    }

    @Transactional
    @Override
    public ClassDTO findById(Long id) {
        if (id == null) {
            return null;
        }
        Optional<Class> classRom = classRepository.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ClassDTO classDTO = new ClassDTO();
        classDTO = modelMapper.map(classRom.get(), ClassDTO.class);
        classDTO.setCurrentCount(classRom.get().getTrainees().size());
        return classDTO;
    }

    @Transactional
    @Override
    public List<TrainerDTO> getTrainerByClassId(Long classId) {
        List<Trainer> trainers = trainerRepository.findByClassId(classId);
        List<TrainerDTO> trainerDTOS = new ArrayList<>();
        TrainerDTO trainerDTO = null;
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        for (Trainer trainer : trainers) {
            trainerDTO = modelMapper.map(trainer, TrainerDTO.class);
            trainerDTOS.add(trainerDTO);
        }
        return trainerDTOS;
    }

    @Transactional
    @Override
    public List<TraineeDTO> getTraineeByClassId(Long classId) {
        List<Trainee> trainees = traineeRepository.getTraineesByClassId(classId);
        List<TraineeDTO> traineeDTOS = new ArrayList<>();
        TraineeDTO traineeDTO = null;
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        for (Trainee trainee : trainees) {
            traineeDTO = modelMapper.map(trainee, TraineeDTO.class);
            traineeDTOS.add(traineeDTO);
        }
        return traineeDTOS;
    }

    @Transactional
    @Override
    public List<TraineeDTO> getAllTrainee(Long classId) {
        List<Trainee> trainees = traineeRepository.getAllTraineeNotInClass(classId);
        List<TraineeDTO> traineeDTOS = new ArrayList<>();
        TraineeDTO traineeDTO = null;
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        for (Trainee trainee : trainees) {
            traineeDTO = modelMapper.map(trainee, TraineeDTO.class);
            traineeDTOS.add(traineeDTO);
        }
        return traineeDTOS;
    }

    @Transactional
    @Override
    public List<TrainerDTO> getALLTrainer() {
        List<Trainer> trainers = trainerRepository.findAll();
        List<TrainerDTO> trainerDTOS = new ArrayList<>();
        TrainerDTO trainerDTO = null;
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        for (Trainer trainer : trainers) {
            trainerDTO = modelMapper.map(trainer, TrainerDTO.class);
            trainerDTOS.add(trainerDTO);
        }
        return trainerDTOS;
    }

    @Override
    public List<TrainingObjectiveDTO> getAllTrainingObjectiveByClassId(Long classId) {
        List<TrainingObjective> trainingObjectives = trainingObjectiveRepository.getTrainingObjectivesByClassId(classId);
        List<TrainingObjectiveDTO> trainingObjectiveDTOS = new ArrayList<>();
        TrainingObjectiveDTO trainingObjectiveDTO = null;
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        for (TrainingObjective trainingObjective : trainingObjectives) {
            trainingObjectiveDTO = modelMapper.map(trainingObjective, TrainingObjectiveDTO.class);
            trainingObjectiveDTOS.add(trainingObjectiveDTO);
        }
        return trainingObjectiveDTOS;
    }

    @Transactional
    @Override
    public void deleteTrainee(Long classId, Long traineeId) {
        traineeRepository.removeTraineeFromClass(classId, traineeId);
    }

    @Transactional
    @Override
    public void addTrainee(Long classId, Long traineeId) {
        traineeRepository.addTraineeToClass(classId, traineeId);
    }

    @Override
    public Page<Trainee> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return traineeRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public boolean checkExistByNameAndYear(String name, String dateStartStr, String endDateStr) {
        boolean check = false;
        try {
            Date startTime = new SimpleDateFormat("yyyy-MM-dd").parse(dateStartStr);
            Date endTime = new SimpleDateFormat("yyyy-MM-dd").parse(dateStartStr);
            List<Class> classes = classRepository.findByNameAndDate(name, startTime, endTime);
            if (classes.size() > 0) {
                check = true;
            }
        } catch (ParseException e) {
            logger.error(e.getMessage());
            check = true;
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<ClassDTO> getNameAndYearOfClassNotRelease() {
        List<ClassDTO> classDTOS = new ArrayList<>();

        final List<Class> allClass = classRepository.getNameAndYearOfClassNotRelease(StatusEnum.Release);

        allClass.forEach(aClass -> {
            ClassDTO map = modelMapper.map(aClass, ClassDTO.class);
            classDTOS.add(map);
        });
        return classDTOS;
    }

    @Override
    public Long getNameAndYear(String name, String year) {
        Long ID = null;

        try {
            final Class byNameAndYear = classRepository.getByNameAndYear(name, Integer.parseInt(year));

            if (byNameAndYear != null) {
                ID = byNameAndYear.getId();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return ID;
    }

    private void writeHeaderLine() {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("class_management" + (int)Math.random()*10000);

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();

        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Class ID", style);
        createCell(row, 1, "Class Name", style);
        createCell(row, 2, "Plan count", style);
        createCell(row, 3, "Start Date", style);
        createCell(row, 4, "End Date", style);
        createCell(row, 5, "Type", style);
        createCell(row, 6, "Status", style);

    }
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines(List<ClassDTO> classes) {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (ClassDTO classs : classes) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, classs.getId(), style);
            createCell(row, columnCount++, classs.getName(), style);
            createCell(row, columnCount++, classs.getPlanCount(), style);
            createCell(row, columnCount++, classs.getOpenDate().toString(), style);
            createCell(row, columnCount++, classs.getEndDate().toString(), style);
            createCell(row, columnCount++, classs.getType().toString(), style);
            createCell(row, columnCount++, classs.getStatus().toString(), style);
        }
    }

    @Override
    public void exportData(HttpServletResponse httpServletResponse) throws IOException {
        writeHeaderLine();
        writeDataLines(getAllClass());
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
    private void writeHeaderLineGetOne() {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("class_management" + (int)Math.random()*10000);

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();

        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCellGetOne(row, 0, "Trainee name", style);
        createCellGetOne(row, 1, "Account", style);
        createCellGetOne(row, 2, "Email", style);
        createCellGetOne(row, 3, "University", style);
        createCellGetOne(row, 4, "Status", style);
        createCellGetOne(row, 5, "Interview Date", style);
        createCellGetOne(row, 6, "Interview Status", style);
        createCellGetOne(row, 7, "Subject", style);
        createCellGetOne(row, 8, "Trainer", style);

    }
    private void createCellGetOne(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLinesGetOne(ClassDTO classDTO) {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        List<String> subjectName = classDTO.getTrainingObjectives().stream().map(s->s.getName()).collect(Collectors.toList());
        List<String> trainer = classDTO.getTrainingObjectives().stream().map(s -> s.getTrainer().getFullName()).collect(Collectors.toList());

        for (Trainee trainee : classDTO.getTrainees()) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, trainee.getFullName().toString(), style);
            createCell(row, columnCount++, trainee.getAccount().toString(), style);
            createCell(row, columnCount++, trainee.getEmail().toString(), style);
            createCell(row, columnCount++,trainee.getUniversity().toString(), style);
            createCell(row, columnCount++, trainee.getStatus()== null? "null":trainee.getStatus().getType().toString(), style);
            createCell(row, columnCount++, trainee.getRecInterviewDate().toString(), style);
            createCell(row, columnCount++, trainee.getRecInterviewStatus().toString(), style);
            createCell(row, columnCount++, subjectName.toString(), style);
            createCell(row, columnCount++, trainer.toString(), style);

        }
    }
    @Override
    public void exportDataOneClass(HttpServletResponse httpServletResponse, ClassDTO classDTO) throws IOException {
        writeHeaderLineGetOne();
        writeDataLinesGetOne(classDTO);
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
