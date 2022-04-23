package utils;

public class ClassGetter {
    static public <T> String getClassAsString(Class<T> classType){
        String classToString = classType.toString();
        String[] splitResult = classToString.split("\\.");
        String classAsString = splitResult[splitResult.length - 1];
        return classAsString;
    }
}
