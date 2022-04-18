//package fa.training.srumanagementg4.Controller;
//
//import fa.training.srumanagementg4.controller.ClassController;
//import fa.training.srumanagementg4.dto.ClassDTO;
//import fa.training.srumanagementg4.entities.Class;
//import fa.training.srumanagementg4.service.ClassService;
//import fa.training.srumanagementg4.utils.Constant;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestContext;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;
//import java.util.Arrays;
//
//import static org.hamcrest.Matchers.*;
//import static org.hamcrest.Matchers.is;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//
///**
// * @author SonTN9
// *
// */
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ClassController.class)
//public class ClassControllerTest {
//
//    @MockBean
//    ClassService classService;
//
//    @Autowired
//    MockMvc mockMvc;
//
//    /**
//     * @author SonTN9
//     *
//     */
//    @Test
//    public void getAllClass() throws Exception {
//        ClassDTO first = new ClassDTO(1L, "Java 01", "10", 10, "good", "Fresher", "Waiting");
//        ClassDTO second = new ClassDTO(2L, "Java 02", "11", 10, "good", "Internship", "Release");
//
//        Mockito.when(classService.getAllClass()).thenReturn(Arrays.asList(first, second));
//        mockMvc.perform(get("/get-all-class"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("class-management"))
//                .andExpect(forwardedUrl("/WEB-INF/views/class-management.jsp"))
//                .andExpect(model().attribute("classDTOS", hasSize(2)))
//                .andExpect(model().attribute("classDTOS", hasItem(
//                        allOf(
//                                hasProperty("id", is(1L)),
//                                hasProperty("name", is("Java 01")),
//                                hasProperty("planCount", is("10")),
//                                hasProperty("currentCount", is(10)),
//                                hasProperty("note", is("good")),
//                                hasProperty("status", is("Waiting")),
//                                hasProperty("type", is("Fresher"))
//                        )
//                )))
//                .andExpect(model().attribute("classDTOS", hasItem(
//                        allOf(
//                                hasProperty("id", is(2L)),
//                                hasProperty("name", is("Java 02")),
//                                hasProperty("planCount", is("11")),
//                                hasProperty("currentCount", is(10)),
//                                hasProperty("note", is("good")),
//                                hasProperty("status", is("Release")),
//                                hasProperty("type", is("Internship"))
//                        )
//                )));
//
//        Mockito.verify(classService, times(1)).getAllClass();
//        Mockito.verifyNoMoreInteractions(classService);
//    }
//
//    /**
//     * @author SonTN9
//     *
//     */
//    @Test
//    void formCreateClass() throws Exception {
//        mockMvc.perform(get("/form-create-class"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("add-class"))
//                .andExpect(forwardedUrl("/WEB-INF/views/add-class.jsp"))
//                .andExpect(model().attributeExists("classDTO"));
//    }
//    /**
//     * @author SonTN9
//     *
//     */
//    @Test
//    void formUpdateClass() throws Exception {
//        ClassDTO classDTO = new ClassDTO(1L, "Java 88", "10", 10, "good", "Fresher", "Waiting");
//        Mockito.when(classService.findById(1L)).thenReturn(classDTO);
//
//        mockMvc.perform(get("/form-update-class")
//                .param("classId", "1"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("add-class"))
//                .andExpect(forwardedUrl("/WEB-INF/views/add-class.jsp"))
//                .andExpect(model().attributeExists("classDTO"));
//
//        Mockito.verify(classService, times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(classService);
//    }
//
//}