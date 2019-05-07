import exceptions.DeniedAccessException;
import exceptions.FileAccessException;
import exceptions.InvalidNumberException;

import java.io.File;
import java.io.FileNotFoundException;

public class CrackerValidator {
    public static void validate(String[] args) throws InvalidNumberException, IllegalArgumentException, FileAccessException {
        if (args.length == 2) {

            //dictionary
            try {
                File dictionary = new File(args[0]);
                if (!dictionary.exists()){
                    throw new FileNotFoundException("file was not found");
                }
                if (!dictionary.canRead()){
                    throw new DeniedAccessException("Unable to access file properly");
                }

            }catch (FileNotFoundException | DeniedAccessException e){
                throw new FileAccessException("Unable to handle file: \"" + args[0] + "\", " + e.getMessage());
            }
            //passFile
            try {
                File passFile = new File(args[1]);
                if (!passFile.exists()){
                    throw new FileNotFoundException("file was not found");
                }
                if (!passFile.canWrite()){
                    throw new DeniedAccessException("Unable to access file properly");
                }

            }catch (FileNotFoundException | DeniedAccessException e){
                throw new FileAccessException("Unable to handle file: \"" + args[1] + "\", " + e.getMessage());
            }
        }else{
            throw new IllegalArgumentException("Incorrect amount of arguments, should be between 1 and 2");
        }
    }

/*    private static boolean inRange(int input, int start, int end){
        if (input <= end && input >= start)
            return true;

        return false;
    }*/
/*    private static void validateFile(File source) throws InvalidFileFormatException {
            Scanner sc = null;
            try {
                sc = new Scanner(source);
                while(sc.hasNext()){
                    Integer.parseInt(sc.next());
                }
            } catch (FileNotFoundException | NumberFormatException e) {
                throw new InvalidFileFormatException("Invalid format in file \"" + source.toPath().toString() + "\", should be all integers");
            }

    }*/
}
