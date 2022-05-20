import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.CommandLineInterface;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);
        logger.info("Application has started");
        String filePath = new File("").getAbsolutePath();
        filePath.concat("path to the property file");
        logger.info("Application has ended");
    }
}
