import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.CommandLineInterface;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);
        logger.info("Application has started");
        CommandLineInterface commandLineInterface = new CommandLineInterface();
        commandLineInterface.run();
        logger.info("Application has ended");
    }
}
