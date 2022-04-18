package fa.training.srumanagementg4.configuration;

import fa.training.srumanagementg4.dto.MessageDTO;
import fa.training.srumanagementg4.dto.NameYearOfClassDTO;
import fa.training.srumanagementg4.dto.TrainingObjectiveDTO;
import fa.training.srumanagementg4.utils.Utilities;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class BeanFactory {

    @Bean
    public Utilities nameAndYear() {
        return new Utilities();
    }

    @Bean
    public NameYearOfClassDTO nameYearOfClassDTO() {
        return new NameYearOfClassDTO();
    }

    @Bean
    public MessageDTO messageDTO() {
        return new MessageDTO();
    }


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper;
    }

    @Bean
    public TrainingObjectiveDTO trainingObjectiveDTO() {
        return new TrainingObjectiveDTO();
    }
}
