package learn.spaceflight;

import learn.spaceflight.personnel.Astronaut;
import learn.spaceflight.spacecraft.InterstellarTransport;
import learn.spaceflight.spacecraft.MoonHopper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        // Spring code here...
        ApplicationContext container = new ClassPathXmlApplicationContext("dependency-configuration.xml");

        InterstellarTransport transport = container.getBean(InterstellarTransport.class);
        System.out.println(transport);
//        MoonHopper hopper = container.getBean(MoonHopper.class);
//        System.out.println(hopper);

//        Astronaut astronaut = container.getBean("captain",Astronaut.class);
//        Astronaut notTheCaptain = container.getBean("crew",Astronaut.class);
//        System.out.println(astronaut);
//        System.out.println(notTheCaptain);
    }
}
