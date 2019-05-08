import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

        LinkedList<Account> accountList = populateAccountList(passEntries);
        ArrayList<String> dict = readFromFile(dictionary);

        sweep(accountList, dict);


    }

    private void sweep(LinkedList<Account> accs, ArrayList<String> dict){
        ArrayList<String> words = dict;
        File common = new File("AssInc/common.txt");
        words.addAll(0, readFromFile(common));
        ArrayList<String> result = new ArrayList<String>();
        contlabel:
        for (Account a : accs) {
            System.out.println("Account: " + a.getFirstname() + " " + a.getLastname());
            words.add(0, a.getFirstname());
            words.add(0, a.getLastname());
            for (String s : words) {
                wordShuffler ws = new wordShuffler(s);
                ws.generateShuffled();
                for (int i = 0; i < ws.getShuffled().length; i++){
                    if (a.getHash().equals(jcrypt.crypt(a.getSalt(),ws.getShuffled()[i]))){
                        String pass = ws.getShuffled()[i];
                        System.out.println("Pass found! " + pass);
                        result.add(pass);
                        continue contlabel;
                    }
                }
            }
        }
        writeToFile(Arrays.copyOf(result.toArray(), result.toArray().length, String[].class));
    }

    private void printList(String[] list){
        for (int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
    }
    private void print2DList(String[][] list){
        for (int i = 0; i < list.length; i++){
            for (int j = 0; j < list[0].length; j++) {
                System.out.println(list[i][j]);
            }
        }
    }
    public static void writeToFile(String[] source){
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("AssInc/passwd2-plain.txt"));
            for (int i = 0; i < source.length; i++){
                out.write(source[i]);
                out.newLine();
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readFromFile(File source){
        Scanner sc = null;
        try {
            sc = new Scanner(source);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        while(sc.hasNext()){
            list.add(sc.nextLine());
        }
        return list;
    }
    private static LinkedList<Account> populateAccountList(String[][] passInfo) {
        LinkedList<Account> accountList = new LinkedList<Account>();
        for (int i = 0; i < passInfo.length; i++){
            String[] accountCreds = passInfo[i][4].split(" ");
            if (accountCreds[0].contains(".") ){
                accountList.add(new Account(accountCreds[1], accountCreds[2], passInfo[i][1].substring(0,2), passInfo[i][1]));
                continue;
            }else if(accountCreds[1].contains(".")){
                accountList.add(new Account(accountCreds[0], accountCreds[2], passInfo[i][1].substring(0,2), passInfo[i][1]));
                continue;
            }
            accountList.add(new Account(accountCreds[0], accountCreds[1], passInfo[i][1].substring(0,2), passInfo[i][1]));
        }
        return accountList;
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
