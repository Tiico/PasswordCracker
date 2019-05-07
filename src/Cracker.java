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
        String[] names = extractNames(passEntries);
        wordShuffler ws = new wordShuffler(names[0]);
        for (int i = 0; i < 14; i++){
            ws.shuffle();
            printList(ws.getShuffled());
            ws.nextType();
        }

        System.out.println();



        /*wordShuffler.shuffle(fullname.split(" ")[1]);*/
    }
    private void printList(String[] list){
        for (int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
    }

    private static String[] extractNames(String[][] passInfo) {
        String[] result = new String[passInfo.length * 2];
        int k = 0;
        for (int i = 0; i < passInfo.length; i++){
            result[k++] = passInfo[i][4].split(" ")[0];
            result[k++] = passInfo[i][4].split(" ")[1];
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
