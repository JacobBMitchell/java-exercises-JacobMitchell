package memories;

import memories.data.MemoryFileRepository;
import memories.domain.MemoryService;
import memories.ui.ConsoleIO;
import memories.ui.Controller;
import memories.ui.View;

public class App {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("dependency-config.xml");
        MemoryFileRepository repository = new MemoryFileRepository("./src/main/java/memories/data/memories.txt");
        MemoryService service = new MemoryService(repository);

        ConsoleIO io = new ConsoleIO();
        View view = new View(io);

        Controller controller = new Controller(view, service);

        controller.run();
    }
}
