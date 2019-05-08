import exceptions.FileAccessException;
import exceptions.InvalidNumberException;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

        ExecutorService esvc = Executors.newFixedThreadPool(8);

        Cracker worker = new Cracker(dictionary, passFile);
        Future future = esvc.submit(worker);
        System.out.printf("[%s] main thread\n", Thread.currentThread().toString());
        try {
            System.out.println("Task returned: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        esvc.shutdown();

//        Cracker cracker = new Cracker(dictionary, passFile);
//        cracker.crack();
    }

}
