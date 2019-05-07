import exceptions.FileAccessException;
import exceptions.InvalidNumberException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordCrack {

    public static void main(String[] args) {
        System.out.println("Welcome to the Password Cracker");
        try {
            crackerValidator.validate(args);
        } catch (InvalidNumberException | IllegalArgumentException | FileAccessException e) {
            System.out.println("Could not validate with passing result : " + e.getMessage());
            System.exit(1);
        }

        final File dictionary = new File(args[0]);
        final File passFile = new File(args[1]);

        String[] passargs = extractPassInfo(passFile);
        String username = passargs[0];
        String salt = passargs[1].substring(0,2);
        String hash = passargs[1].substring(1);
        String fullname = passargs[4];
        String firstname = fullname.split(" ")[0];
        String lastname = fullname.split(" ")[1];

        System.out.println(jcrypt.crypt("(b", "amazing"));
    }

    private static String[] extractPassInfo(File pass){
        Scanner sc = null;
        try {
            sc = new Scanner(pass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String passEntry = sc.nextLine();

        return passEntry.split(":");
    }
}
