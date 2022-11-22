package eduis.common;


import eduis.StoreApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { StoreApplication.class })
public class CucumberSpingConfiguration {
    
}
