import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Cracker {
    File dictionary;
    File passwords;

    public Cracker(File dict, File pass){
        this.dictionary = dict;
        this.passwords = pass;
    }

    public void crack(){
        String[][] passEntries = extractPassInfo(passwords);
        String[] test = extractNames(passEntries);

        System.out.println(test[0]);


        /*wordShuffler.shuffle(fullname.split(" ")[1]);*/
    }

    private static String[] extractNames(String[][] passInfo) {
        String[] result = new String[passInfo[0].length];
        int k = 0;
        for (int i = 0; i < passInfo[0].length; i++){
            result[i] = passInfo[i][4];
        }
        return result;
    }

    private static String[][] extractPassInfo(File pass){
        Scanner sc = null;
        try {
            sc = new Scanner(pass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        while(sc.hasNext()){
            list.add(sc.nextLine());
        }
        String[] passRows = Arrays.copyOf(list.toArray(), list.toArray().length, String[].class);
        String[][] passEntries = new String[passRows.length][passRows[0].split(":").length];
        int k = 0;
        for (int i = 0; i < passRows.length; i++){
            for (int j = 0; j < passRows[i].split(":").length; j++){
                passEntries[i][j] = passRows[i].split(":")[j];
            }
        }
        return passEntries;
    }
}
