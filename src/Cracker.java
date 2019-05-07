import java.io.File;
import java.io.FileNotFoundException;
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

        wordShuffler ws = new wordShuffler(accountList.get(2).lastname);
        for (int i = 0; i < 14; i++){
            ws.shuffle();
            ws.nextType();
        }
        printList(ws.getAllShuffled());




        /*wordShuffler.shuffle(fullname.split(" ")[1]);*/
    }
    private void printList(String[] list){
        for (int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
    }
//    private void printLinkedList(LinkedList<Account> list){
//        for (int i = 0; i < list.size(); i++){
//            System.out.print(list.get(i).firstname + " ");
//            System.out.print(list.get(i).lastname);
//            System.out.println();
//        }
//    }

    private static LinkedList<Account> populateAccountList(String[][] passInfo) {
        LinkedList<Account> accountList = new LinkedList<Account>();
        for (int i = 0; i < passInfo.length; i++){
            String[] accountCreds = passInfo[i][4].split(" ");
            if (accountCreds[0].contains(".") ){
                accountList.add(new Account(accountCreds[1], accountCreds[2]));
                continue;
            }else if(accountCreds[1].contains(".")){
                accountList.add(new Account(accountCreds[0], accountCreds[2]));
                continue;
            }
            accountList.add(new Account(accountCreds[0], accountCreds[1]));
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
