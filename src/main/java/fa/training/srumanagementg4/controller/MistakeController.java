package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.MistakeDTO;
import fa.training.srumanagementg4.dto.TraineeDTO;
import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.service.MistakeService;
import fa.training.srumanagementg4.service.TraineeService;
import fa.training.srumanagementg4.utils.Constant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class MistakeController {

    @Autowired
    private MistakeService mistakeService;

    @Autowired
    private TraineeService traineeService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/create-mistake/{traineeId}")
    public String formAddMistake(final ModelMap modelMap, @PathVariable("traineeId") Long traineeId, final HttpServletRequest request){

        modelMap.addAttribute("traineeId", traineeId);
        modelMap.addAttribute("mistake", new MistakeDTO());
        return "trainee/mistake";
    }
    @PostMapping("/create-mistake/{traineeId}")
    public String createMistake(final ModelMap modelMap, @Valid @ModelAttribute("mistake")MistakeDTO mistakeDTO,
                                final BindingResult bindingResult, @PathVariable("traineeId") Long traineeId, final HttpServletRequest request){
        TraineeDTO traineeDTO = traineeService.getById(traineeId);
        Trainee trainee = modelMapper.map(traineeDTO, Trainee.class);

        mistakeDTO.setTrainee(trainee);
        mistakeDTO.setCreatedDate(new Date());
        mistakeService.saveOrUpdate(mistakeDTO);
        request.getSession().setAttribute("mistakeMessage", Constant.CREATE_MISTAKE_SUCCESS);
        request.getSession().setMaxInactiveInterval(1000);
        return "redirect:/admin/detail-class/"+traineeDTO.getClassRoom().getId();
    }
    @PostMapping("/update-mistake")
    public String updateMistake(final ModelMap modelMap, @Valid @ModelAttribute("mistakeEdit")MistakeDTO mistakeDTO,
                                final BindingResult bindingResult, final HttpServletRequest request){

        mistakeDTO.setCreatedDate(new Date());
        mistakeService.saveOrUpdate(mistakeDTO);
        request.getSession().setAttribute("mistakeMessage", Constant.UPDATE_MISTAKE_SUCCESS);
        request.getSession().setMaxInactiveInterval(1000);
        return "redirect:/admin/trainee/trainee-detail/"+mistakeDTO.getTrainee().getId();
    }
    @GetMapping("/delete-mistake")
    public String deleteMistake(final ModelMap modelMap, @RequestParam("mistakeId") Long mistakeId, @RequestParam("traineeId") Long traineeId, final  HttpServletRequest request){

        mistakeService.deleteMistake(mistakeId);
        request.getSession().setAttribute("mistakeMessage", Constant.DELETE_MISTAKE_SUCCESS);
        request.getSession().setMaxInactiveInterval(1000);
        return "redirect:/admin/trainee/trainee-detail/"+traineeId;
    }

}
