package learn.spaceflight;

import learn.spaceflight.personnel.Astronaut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        // Spring code here...
        ApplicationContext container = new ClassPathXmlApplicationContext("dependency-configuration.xml");

        Astronaut astronaut = container.getBean(Astronaut.class);
        System.out.println(astronaut);
    }
}
