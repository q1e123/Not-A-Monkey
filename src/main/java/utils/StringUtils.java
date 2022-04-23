package utils;

public class StringUtils {
    public static String removeLastOccurence(String string, String pattern){
        StringBuilder stringBuilder=new StringBuilder(string);
        int index=stringBuilder.lastIndexOf(pattern);
        if (index == -1){
            return string;
        }
        stringBuilder.replace(index,pattern.length()+index,"");
        return stringBuilder.toString();
    }
}
