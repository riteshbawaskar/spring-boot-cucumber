package org.sample;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;


@CucumberContextConfiguration
@ComponentScan("org.sample")
@SpringBootTest(classes = SampleApplication.class)
public class SpringIntegrationTest {


}