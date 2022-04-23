package controller;

import utils.ClassGetter;
import utils.StringUtils;

import java.util.Hashtable;
import java.util.Map;

public class QueryBuilder {
    static public <T> String getSelectWhereStringConditionQuery(Class<T> table, Hashtable<String, String> conditionTable){
        String tableAsString = ClassGetter.getClassAsString(table);
        String query = "SELECT entity FROM " + tableAsString + " entity WHERE ";
        for (String column : conditionTable.keySet()) {
            String columnValue = conditionTable.get(column);
            query += "entity." + column + " = '" + columnValue + "' AND ";
        }
        query = StringUtils.removeLastOccurence(query, " AND ");
        return query;
    }
}
