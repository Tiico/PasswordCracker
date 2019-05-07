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
    Iterator<shuffleTypes> iterator = Arrays.stream(shuffleTypes.values()).iterator();
    private shuffleTypes currentType;

    public wordShuffler(String word){
        this.word = word;
    }

    public void shuffle(){
        if (currentType == null){
            nextType();
        }
        System.out.println("Switching with: " + currentType);
        //TODO Check for duplicates, now we get duplicates thanks to lowercase/uppercase/capitalize when original word is already of one of those forms.
        switch (currentType){
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
                for (String s : characters){
                    shuffled.add(StringManipulator.appendToWord(s, StringManipulator.reverse(word)));
                    shuffled.add(StringManipulator.prependToWord(s, StringManipulator.reverse(word)));
                }
                break;
            case DUPLICATE:
                shuffled.add(StringManipulator.duplicate(word));
                for (String s : characters){
                    shuffled.add(StringManipulator.appendToWord(s, StringManipulator.duplicate(word)));
                    shuffled.add(StringManipulator.prependToWord(s, StringManipulator.duplicate(word)));
                }
                break;
            case REFLECTNORMAL:
                shuffled.add(StringManipulator.reflectNormal(word));
                for (String s : characters){
                    shuffled.add(StringManipulator.appendToWord(s, StringManipulator.reflectNormal(word)));
                    shuffled.add(StringManipulator.prependToWord(s, StringManipulator.reflectNormal(word)));
                }
                break;
            case REFLECTREVERSE:
                shuffled.add(StringManipulator.reflectReverse(word));
                for (String s : characters){
                    shuffled.add(StringManipulator.appendToWord(s, StringManipulator.reflectReverse(word)));
                    shuffled.add(StringManipulator.prependToWord(s, StringManipulator.reflectReverse(word)));
                }
                break;
            case UPPERCASE:
                shuffled.add(StringManipulator.upperCase(word));
                for (String s : characters){
                    shuffled.add(StringManipulator.appendToWord(s, StringManipulator.upperCase(word)));
                    shuffled.add(StringManipulator.prependToWord(s, StringManipulator.upperCase(word)));
                }
                break;
            case LOWERCASE:
                shuffled.add(StringManipulator.lowerCase(word));
                for (String s : characters){
                    shuffled.add(StringManipulator.appendToWord(s, StringManipulator.lowerCase(word)));
                    shuffled.add(StringManipulator.prependToWord(s, StringManipulator.lowerCase(word)));
                }
                break;
            case CAPITALIZE:
                shuffled.add(StringManipulator.capitalize(word));
                for (String s : characters){
                    shuffled.add(StringManipulator.appendToWord(s, StringManipulator.capitalize(word)));
                    shuffled.add(StringManipulator.prependToWord(s, StringManipulator.capitalize(word)));
                }
                break;
            case NCAPITALIZE:
                shuffled.add(StringManipulator.nCapitalize(word));
                for (String s : characters){
                    shuffled.add(StringManipulator.appendToWord(s, StringManipulator.nCapitalize(word)));
                    shuffled.add(StringManipulator.prependToWord(s, StringManipulator.nCapitalize(word)));
                }
                break;
            case TOGGLE:
                shuffled.add(StringManipulator.toggle(word));
                for (String s : characters){
                    shuffled.add(StringManipulator.appendToWord(s, StringManipulator.toggle(word)));
                    shuffled.add(StringManipulator.prependToWord(s, StringManipulator.toggle(word)));
                }
                break;
            case TOGGLEREVERSE:
                shuffled.add(StringManipulator.toggleReverse(word));
                for (String s : characters){
                    shuffled.add(StringManipulator.appendToWord(s, StringManipulator.toggleReverse(word)));
                    shuffled.add(StringManipulator.prependToWord(s, StringManipulator.toggleReverse(word)));
                }
                break;
        }
    }
    public String[] getAllShuffled(){
        return Arrays.copyOf(shuffled.toArray(), shuffled.toArray().length, String[].class);
    }

    public String nextType() {
        if (iterator.hasNext()){
            currentType = iterator.next();
        }else{
            return null;
        }
        return currentType.toString();
    }
//    public String[] getAllShuffled(){
//
//    }
}
