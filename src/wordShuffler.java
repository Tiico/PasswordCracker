import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class wordShuffler {
    private final String[] characters = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
            "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private enum shuffleTypes {
            PREPEND, APPEND, DELETEFIRST, DELETELAST, REVERSE, DUPLICATE,
            REFLECTNORMAL, REFLECTREVERSE, UPPERCASE, LOWERCASE, CAPITALIZE,
            NCAPITALIZE, TOGGLE, TOGGLEREVERSE
    }
    private String word;
    private ArrayList<String> shuffled = new ArrayList<String>();
    Iterator<shuffleTypes> iter = Arrays.stream(shuffleTypes.values()).iterator();
    private shuffleTypes currentType;

    public wordShuffler(String word){
        this.word = word;
    }

    public void shuffle(){
        if (currentType == null){
            nextType();
        }
        System.out.println("Switching with: " + currentType);
        switch (currentType){
            case PREPEND:
                for (String s : characters){
                    shuffled.add(stringManipulator.prependToWord(s, word));
                }
                break;
            case APPEND:
                for (String s : characters){
                    shuffled.add(stringManipulator.appendToWord(s, word));
                }
                break;
            case DELETEFIRST:
                shuffled.add(stringManipulator.deleteFirst(word));
                break;
            case DELETELAST:
                shuffled.add(stringManipulator.deleteLast(word));
                break;
            case REVERSE:
                shuffled.add(stringManipulator.reverse(word));
                break;
            case DUPLICATE:
                shuffled.add(stringManipulator.duplicate(word));
                break;
            case REFLECTNORMAL:
                shuffled.add(stringManipulator.reflectNormal(word));
                break;
            case REFLECTREVERSE:
                shuffled.add(stringManipulator.reflectReverse(word));
                break;
            case UPPERCASE:
                shuffled.add(stringManipulator.upperCase(word));
                break;
            case LOWERCASE:
                shuffled.add(stringManipulator.lowerCase(word));
                break;
            case CAPITALIZE:
                shuffled.add(stringManipulator.capitalize(word));
                break;
            case NCAPITALIZE:
                shuffled.add(stringManipulator.nCapitalize(word));
                break;
            case TOGGLE:
                shuffled.add(stringManipulator.toggle(word));
                break;
            case TOGGLEREVERSE:
                shuffled.add(stringManipulator.toggleReverse(word));
                break;
        }
    }
    public String[] getShuffled(){
        return Arrays.copyOf(shuffled.toArray(), shuffled.toArray().length, String[].class);
    }

    public String nextType() {
        if (iter.hasNext()){
            currentType = iter.next();
            shuffled.clear();
        }else{
            return null;
        }
        return currentType.toString();
    }
}
