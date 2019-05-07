public class stringManipulator {
    public String prependToWord(char c ,String word){
        return c + word;
    }
    public String appendToWord(char c ,String word){
        return word + c;
    }
    public String deleteFirst(String word){
        return word.substring(1);
    }
    public String deleteLast(String word){
        return word.substring(0, word.length() - 1);
    }
    public String reverse(String word){
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }
    public String duplicate(String word){
        return word + word;
    }
    public String reflectNormal(String word){
        StringBuilder sb = new StringBuilder(word);
        return word + sb.reverse().toString();
    }
    public String reflectReverse(String word){
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString() + word;
    }
    public String upperCase(String word){
        return word.toUpperCase();
    }
    public String lowerCase(String word){
        return word.toLowerCase();
    }
    public String capitalize(String word){
        return word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
    }
    public String nCapitalize(String word){
        return word.substring(0,1).toLowerCase() + word.substring(1).toUpperCase();
    }
    public String toggle(String word){
        for (int i = 0; i < word.length(); i++){
            if (Math.floorMod(i, 2) == 0){

            }
        }
    }
}
