import controller.ActionManager;
import controller.DatabaseManager;
import model.BrowserEntity;
import model.RoutineEntity;
import org.junit.jupiter.api.Test;

public class ActionManagerTest {
    @Test
    void addGoTo() {
        addBrowser();
        addRoutine();
        ActionManager actionManager = ActionManager.getInstance();
        actionManager.addGoTo(4, "knightrobert.com");
    }

    void addBrowser() {
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        BrowserEntity browserEntity = new BrowserEntity();
        browserEntity.setBrowserType("CHROME");
        browserEntity.setDriverPath("D:/Workshop/Utils/chromedriver-88.exe");
        browserEntity.setName("Chrome");
        databaseManager.add(browserEntity);
    }

    void addRoutine(){
        RoutineEntity routineEntity = new RoutineEntity();
        routineEntity.setBrowserId(1);
        routineEntity.setName("asdasdasd");
        routineEntity.setUserId(3);
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        databaseManager.add(routineEntity);
    }
}
