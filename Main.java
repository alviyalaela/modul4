package Modul4;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> myMap = new HashMap<String, Integer>();
        getInput(myMap);
        printHashMap(myMap);
    }

    public static void getInput(HashMap<String, Integer> myMap) {
        Scanner input = new Scanner(System.in);
        String key;
        int value;
        System.out.println("Masukkan pasangan kunci-nilai ke dalam HashMap (kunci harus berupa string, nilai harus berupa integer):");
        do {
            System.out.print("Kunci (tekan enter untuk keluar): ");
            key = input.nextLine();
            if (!key.isEmpty()) {
                System.out.print("Nilai: ");
                value = input.nextInt();
                input.nextLine();
                myMap.put(key, value);
            }
        } while (!key.isEmpty());
    }

    public static void printHashMap(HashMap<String, Integer> myMap) {
        System.out.println("Isi HashMap:");
        for (String key : myMap.keySet()) {
            System.out.println(key + " = " + myMap.get(key));
        }
    }
}

