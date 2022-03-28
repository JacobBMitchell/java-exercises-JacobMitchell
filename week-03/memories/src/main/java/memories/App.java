package memories;

import memories.data.MemoryFileRepository;
import memories.domain.MemoryService;
import memories.ui.ConsoleIO;
import memories.ui.Controller;
import memories.ui.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@ComponentScan
//@PropertySource("classpath:data.properties")
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
//       // ApplicationContext container = new ClassPathXmlApplicationContext("dependency-config.xml");
//       ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
//        Controller controller = context.getBean(Controller.class);
////        MemoryFileRepository repository = new MemoryFileRepository("./src/main/java/memories/data/memories.txt");
////        MemoryService service = new MemoryService(repository);
////
////        ConsoleIO io = new ConsoleIO();
////        View view = new View(io);
////
////        Controller controller = new Controller(view, service);
//
//        controller.run();
    }
}
