package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.*;
import fa.training.srumanagementg4.entities.Attendance;
import fa.training.srumanagementg4.entities.Trainer;
import fa.training.srumanagementg4.entities.TrainingObjective;
import fa.training.srumanagementg4.repository.AttendanceRepository;
import fa.training.srumanagementg4.repository.TrainerRepository;
import fa.training.srumanagementg4.repository.TrainingObjectiveRepository;
import fa.training.srumanagementg4.service.AttendanceService;
import fa.training.srumanagementg4.service.ClassService;
import fa.training.srumanagementg4.service.TrainerService;
import fa.training.srumanagementg4.service.TrainingObjectiveService;
import fa.training.srumanagementg4.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/json")
public class JSONController {
    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private TrainingObjectiveService trainingObjectiveService;

    @Autowired
    private Utilities utilities;

    @Autowired
    private MessageDTO messageDTO;

    @Autowired
    private ClassService classService;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @GetMapping("/training-object/code")
    public MessageDTO checkCodeOfTrainingObject(HttpServletRequest request) {
        TrainingObjective byCode = null;
        String code = request.getParameter("code");
        String id = request.getParameter("id");
        String classId = request.getParameter("classId");

        if (classId == null || !utilities.isCheckId(classId)) {
            messageDTO.setCode("class");
            messageDTO.setMessage("Class ID is invalid");
        } else {
            ClassDTO byId = classService.findById(Long.valueOf(classId));
            if (byId == null) {
                messageDTO.setCode("class");
                messageDTO.setMessage("Class does not exist");
            } else {
                TrainingObjectiveDTO codeAndClass = trainingObjectiveService.getByCodeAndClass(code, classId);

                if (codeAndClass != null) {
                    if ("".equals(id)) {
                        messageDTO.setCode("code");
                        messageDTO.setMessage("The class already has this subject");
                    } else {
                        if (codeAndClass.getId() != Long.valueOf(id)) {
                            messageDTO.setCode("code");
                            messageDTO.setMessage("The class already has this subject");
                        } else {
                            messageDTO = new MessageDTO();
                        }
                    }
                } else {
                    messageDTO = new MessageDTO();
                }
            }
        }
        return messageDTO;
    }

    @PostMapping("/trainer")
    public TrainerDTO trainerDTO(HttpServletRequest request) {
        String account = request.getParameter("account");
        Trainer byAccount = trainerRepository.findByAccount(account);
        TrainerDTO trainerDTO = new TrainerDTO();
        trainerDTO.setId(byAccount.getId());

        return trainerDTO;
    }

    @PostMapping("/class/id")
    public MessageDTO classDTO(HttpServletRequest request) {
        String name = request.getParameter("name");
        String nameAndYear = name.trim();

        int start = nameAndYear.indexOf("(");
        int end = nameAndYear.lastIndexOf(")");

        String nameClass = nameAndYear.substring(0, start);
        String year = nameAndYear.substring(start + 1, end);

        Long nameAndYear1 = classService.getNameAndYear(nameClass, year);
        messageDTO.setCode(nameAndYear1 + "");

        return messageDTO;
    }


    @PostMapping("/attendance/update")
    public AttendanceDTO attendanceDTO(HttpServletRequest request) {
        System.out.println("Attendance:" + 1);
        String createTime = request.getParameter("createTime");
        String endTime = request.getParameter("endTime");
        String id = request.getParameter("id");
        AttendanceDTO attendanceDTO = null;

        if ("".equals(createTime) || "".equals(endTime)) {
            attendanceDTO = new AttendanceDTO();
            attendanceDTO.setCreatedDate(LocalDate.now());
        } else {
            attendanceDTO = new AttendanceDTO(Long.valueOf(id), LocalTime.parse(createTime), LocalTime.parse(endTime));
            LocalTime time = LocalTime.parse(createTime);
            LocalTime time1 = LocalTime.parse(endTime);
            if (time.compareTo(time1) > 0) {
                attendanceDTO = new AttendanceDTO();
                attendanceDTO.setId(0L);
                attendanceDTO.setCreatedDate(LocalDate.now());
            } else {
                boolean update = attendanceService.update(attendanceDTO);
                if (update) {
                    Attendance byId = attendanceRepository.getById(Long.valueOf(id));
                    attendanceDTO.setType(byId.getType());
                    attendanceDTO.setCreatedDate(byId.getCreatedDate());
                    attendanceDTO.setNote(byId.getNote());
                } else {
                    attendanceDTO = new AttendanceDTO();
                }
            }
        }
        return attendanceDTO;
    }

    @PostMapping("/attendance/list")
    public List<AttendanceDTO> attendanceDTOList(HttpServletRequest request) {
        String monthAndYear = request.getParameter("monthAndYear");
        String id = request.getParameter("id");

        List<AttendanceDTO> byMonthAndYear = attendanceService.findByMonthAndYear(monthAndYear, Long.valueOf(id));

        return byMonthAndYear;
    }

}
