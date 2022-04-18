package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.ClassDTO;
import fa.training.srumanagementg4.dto.NameYearOfClassDTO;
import fa.training.srumanagementg4.entities.Class;
import fa.training.srumanagementg4.enums.TypeClass;
import fa.training.srumanagementg4.repository.ClassRepository;
import fa.training.srumanagementg4.service.ClassService;
import fa.training.srumanagementg4.utils.Utilities;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/admin")
public class ChartController {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private Utilities utilities;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/chart")
    public String show(ModelMap modelMap) {
        final List<Class> classByFresher = classRepository.getClassByType(TypeClass.Fresher);
        List<Class> classByInternship = classRepository.getClassByType(TypeClass.Internship);
        List<ClassDTO> fresher = new ArrayList<>();
        List<ClassDTO> internship = new ArrayList<>();

        classByFresher.forEach(aClass -> {
            ClassDTO map = modelMapper.map(aClass, ClassDTO.class);
            fresher.add(map);
        });

        classByInternship.forEach(aClass -> {
            ClassDTO map = modelMapper.map(aClass, ClassDTO.class);
            internship.add(map);
        });

        List<NameYearOfClassDTO> nameAndYear = utilities.getNameAndYear(fresher);
        List<NameYearOfClassDTO> nameAndYear1 = utilities.getNameAndYear(internship);

        modelMap.addAttribute("classByFresher",nameAndYear);
        modelMap.addAttribute("classByInternship",nameAndYear1);
        return "chart";
    }
}
