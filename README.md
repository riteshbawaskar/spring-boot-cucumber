# spring-boot-cucumber
A sample spring boot cucumber project with dependency injection using spring.
### Getting Started:
1. Spring framework 2.4.0
2. Cucumber 6.8.0

####Steps:
1. Create a plan maven project.
2. Add dependencies

To add spring to the add the parent tag 

~~~
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.4.0</version>
        <relativePath/> <!-- lookup parent from repository -->
</parent>
~~~
The above tag loads the pom.xml in the spring boot parent starter and hence 
the versions in dependencies will be loaded

other dependencies we need are 
~~~
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-test</artifactId>
            <version>2.0.2.RELEASE</version>
</dependency>
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
</dependency>
~~~

cucumber dependencies we are adding for the latest version
6.8.0
~~~
 <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-core</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-spring</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
~~~
Create a @SpringBootApplication Class to bootstrap the whole process in the main

~~~
@SpringBootApplication
public class SampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }
}
~~~
@SpringBootApplication is a convenience annotation that adds all of the following:

- *@Configuration:* Tags the class as a source of bean definitions for the application context.

- *@EnableAutoConfiguration:* Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.

- *@EnableWebMvc:* Flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet. Spring Boot adds it automatically when it sees spring-webmvc on the classpath.

- *@ComponentScan:* Tells Spring to look for other components, configurations, and services in the same package, letting it find the Other class.


Now we need to create a Sprint boot Test class with @SpringBootTest annotation tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context.
once the context is initialized we can use it to @Autowire any of the @components from the application.

To make cucumber aware of this context configuration we need to annotate this class with @CucumberContextConfiguration
(this only works for cucumber version > 5.7.0)

~~~
@CucumberContextConfiguration
@ComponentScan("org.sample")
@SpringBootTest(classes = SampleApplication.class)
public class SpringIntegrationTest {
}
~~~

Finally we need to create our cucumber runner. we extend it with the SpringBootTest class so that it uses the same context configuration
~~~
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = "org.example")
public class CucumberRunnerTest extends SpringIntegrationTest  {
}
~~~
## Execute with profile
- To load profile specific config, set active profile using command line while execution
  clean test -Dspring.profiles.active=dev

## Issues
- In case of errors or glue code not found we get error like -
Please annotate a glue class with some context configuration.
- Step defination file has to be in same folder as springboottest folder.