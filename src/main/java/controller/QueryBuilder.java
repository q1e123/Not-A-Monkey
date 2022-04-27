package controller;

import utils.ClassGetter;
import utils.StringUtils;

import java.util.Hashtable;
import java.util.Map;

public class QueryBuilder {
    static public <T> String getSelectWhereStringConditionQuery(Hashtable<String, String> conditionTable, Class<T> table){
        String tableAsString = ClassGetter.getClassAsString(table);
        String query = "SELECT entity FROM " + tableAsString + " entity WHERE ";
        for (String column : conditionTable.keySet()) {
            String columnValue = conditionTable.get(column);
            columnValue = columnValue.replace("'", "");
            query += "entity." + column + " = '" + columnValue + "' AND ";
        }
        query = StringUtils.removeLastOccurence(query, " AND ");
        return query;
    }

    static public <T> String getSelectByColumnQuery(String column, String value, Class<T> table){
        String tableAsString = ClassGetter.getClassAsString(table);
        String query = "SELECT entity FROM %s entity WHERE %s = '%s'";
        return query;
    }
}
