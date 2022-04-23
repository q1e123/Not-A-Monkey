import controller.QueryBuilder;
import model.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

public class QueryBuilderTest {
    @Test
    void getConditionTableTest() {
        Hashtable<String,String> conditionTable = getConditionTable();
        String expected = "SELECT entity FROM UserEntity entity WHERE entity.password = 'pass' AND entity.username = 'user'";
        String actual = QueryBuilder.getSelectWhereStringConditionQuery(conditionTable, UserEntity.class);
        Assertions.assertEquals(expected, actual);
    }

    private Hashtable<String,String> getConditionTable() {
        Hashtable<String,String> conditionTable = new Hashtable<>();
        conditionTable.put("username", "user");
        conditionTable.put("password", "pass");
        return conditionTable;
    }
}
