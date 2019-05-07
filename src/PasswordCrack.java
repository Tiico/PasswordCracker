import exceptions.FileAccessException;
import exceptions.InvalidNumberException;

import java.io.File;

public class PasswordCrack {

    public static void main(String[] args) {
        System.out.println("Welcome to the Password Cracker");
        try {
            CrackerValidator.validate(args);
        } catch (InvalidNumberException | IllegalArgumentException | FileAccessException e) {
            System.out.println("Could not validate with passing result : " + e.getMessage());
            System.exit(1);
        }

        final File dictionary = new File(args[0]);
        final File passFile = new File(args[1]);

        Cracker cracker = new Cracker(dictionary, passFile);
        cracker.crack();
    }

}
