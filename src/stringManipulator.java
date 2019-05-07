public class stringManipulator {
    public static String prependToWord(char c ,String word){
        return c + word;
    }
    public static String appendToWord(char c ,String word){
        return word + c;
    }
    public static String deleteFirst(String word){
        return word.substring(1);
    }
    public static String deleteLast(String word){
        return word.substring(0, word.length() - 1);
    }
    public static String reverse(String word){
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }
    public static String duplicate(String word){
        return word + word;
    }
    public static String reflectNormal(String word){
        StringBuilder sb = new StringBuilder(word);
        return word + sb.reverse().toString();
    }
    public static String reflectReverse(String word){
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString() + word;
    }
    public static String upperCase(String word){
        return word.toUpperCase();
    }
    public static String lowerCase(String word){
        return word.toLowerCase();
    }
    public static String capitalize(String word){
        return word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
    }
    public static String nCapitalize(String word){
        return word.substring(0,1).toLowerCase() + word.substring(1).toUpperCase();
    }
    public static String toggle(String word){
        String result = "";
        String lowerWord = word.toLowerCase();
        Boolean toggle = true;
        for (int i = 0; i < word.length(); i++){
            if (toggle == true){
                result += lowerWord.toUpperCase().charAt(i);
                toggle = false;
            }else {
                result += lowerWord.charAt(i);
                toggle = true;
            }
        }
        return result;
    }
    public static String toggleReverse(String word){
        String result = "";
        String lowerWord = word.toLowerCase();
        Boolean toggle = false;
        for (int i = 0; i < word.length(); i++){
            if (toggle == true){
                result += lowerWord.toUpperCase().charAt(i);
                toggle = false;
            }else {
                result += lowerWord.charAt(i);
                toggle = true;
            }
        }
        return result;
    }
}
