import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class wordShuffler {
    private final String[] characters = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
            "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private enum shuffleTypes {
            PLAIN, PREPEND, APPEND, DELETEFIRST, DELETELAST, REVERSE, DUPLICATE,
            REFLECTNORMAL, REFLECTREVERSE, UPPERCASE, LOWERCASE, CAPITALIZE,
            NCAPITALIZE, TOGGLE, TOGGLEREVERSE
    }
    private String word;
    private ArrayList<String> shuffled = new ArrayList<String>();
    Iterator<shuffleTypes> iterator = Arrays.stream(shuffleTypes.values()).iterator();
    private shuffleTypes currentType;
    private String[] shuffledArray;

    public wordShuffler(String word){
        this.word = word;
    }

    public void shuffle(){
        if (currentType == null){
            nextType();
        }
        switch (currentType){
            case PLAIN:{
                shuffled.add(word);
            }
            case PREPEND:
                for (String s : characters){
                    shuffled.add(StringManipulator.prependToWord(s, word));
                }
                break;
            case APPEND:
                for (String s : characters){
                    shuffled.add(StringManipulator.appendToWord(s, word));
                }
                break;
            case DELETEFIRST:
                shuffled.add(StringManipulator.deleteFirst(word));
                break;
            case DELETELAST:
                shuffled.add(StringManipulator.deleteLast(word));
                break;
            case REVERSE:
                shuffled.add(StringManipulator.reverse(word));
                break;
            case DUPLICATE:
                shuffled.add(StringManipulator.duplicate(word));
                break;
            case REFLECTNORMAL:
                shuffled.add(StringManipulator.reflectNormal(word));
                break;
            case REFLECTREVERSE:
                shuffled.add(StringManipulator.reflectReverse(word));
                break;
            case UPPERCASE:
                shuffled.add(StringManipulator.upperCase(word));
                break;
            case LOWERCASE:
                shuffled.add(StringManipulator.lowerCase(word));
                break;
            case CAPITALIZE:
                shuffled.add(StringManipulator.capitalize(word));
                break;
            case NCAPITALIZE:
                shuffled.add(StringManipulator.nCapitalize(word));
                break;
            case TOGGLE:
                shuffled.add(StringManipulator.toggle(word));
                break;
            case TOGGLEREVERSE:
                shuffled.add(StringManipulator.toggleReverse(word));
                break;
        }
    }
    public void generateShuffled(){
        for (int i = 0; i < shuffleTypes.values().length; i++){
            shuffle();
            nextType();
        }
        shuffledArray = Arrays.copyOf(shuffled.toArray(), shuffled.toArray().length, String[].class);
    }
    public String[] getShuffled(){
        return shuffledArray;
    }

    public String nextType() {
        if (iterator.hasNext()){
            currentType = iterator.next();
        }else{
            return null;
        }
        return currentType.toString();
    }
}
