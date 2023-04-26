package Modul4;

import java.util.HashMap;
import java.util.Scanner;

public class DataPraktikan {
    static HashMap<String, String> tabelData = new HashMap<>();
    static HashMap<String, String> tabelSesiLogin = new HashMap<>();
    static Scanner in = new Scanner(System.in);
    static Scanner input = new Scanner(System.in);
    static String nimPraktikan;
    static String namaAsisten;
    static String cNim;
    static String eNim;
    static String newNama;
    static String eMail;
    static String password;

    public static void main(String[] args) {
        menu2(tabelSesiLogin);
    }
    public static void menu(){
        int pilihan;
        while (true){
            System.out.println();
            System.out.println("[PENDATAAN MAHASISWA]");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Tampilkan List NIM Praktikan");
            System.out.println("4. Tampilkan List Nama Asisten");
            System.out.println("5. Hapus Data");
            System.out.println("6. Edit Data");
            System.out.println("7. Log Out");
            System.out.print("Masukkan pilihan: ");
            pilihan = in.nextInt();
            switch (pilihan){
                case 1:
                    in.nextLine();
                    tambahData(tabelData);
                    break;
                case 2:
                    tampil(tabelData);
                    break;
                case 3:
                    listNim(tabelData);
                    break;
                case 4:
                    listNama(tabelData);
                    break;
                case 5:
                    hapusData(tabelData);
                    break;
                case 6:
                    editData(tabelData);
                    break;
                case 7:
                    menu2(tabelSesiLogin);
                    break;
            }
        }
    }

    public static boolean cekNim(String nimPraktikan){
        return nimPraktikan.startsWith("IF") && nimPraktikan.substring(3).matches("^[0-9]+$") && nimPraktikan.length() == 17;
    }
    public static boolean cekNama(String namaAsisten){
        return namaAsisten.matches("^[a-zA-Z]+(([',.-][a-zA-Z])?[a-zA-Z]*)*$");
    }

    public static boolean tambahData(HashMap<String, String> tabelData){
        while (true){
            System.out.print("Masukkan NIM: ");
            nimPraktikan = in.nextLine();
            if (!cekNim(nimPraktikan)) {
                System.out.println("Inputan tidak sesuai!");
            }else{
                break;
            }
        }
        while (true){
            System.out.print("Masukkan Nama Asisten: ");
            namaAsisten = in.nextLine();
            if (!cekNama(namaAsisten)){
                System.out.println("Inputan tidak sesuai!");
            }else {
                break;
            }
        }
        tabelData.put(nimPraktikan,namaAsisten);
        return true;
    }
    public static void tampil(HashMap<String, String> tabelData){
        System.out.println("Total data yang berhasil diinput: " +tabelData.size());
        for (HashMap.Entry<String, String> entry : tabelData.entrySet()) {
            String nimPraktikan = entry.getKey();
            String namaAsisten = entry.getValue();
            System.out.printf("NIM Praktikan: %s \t\t Nama Asisten: %s\n", nimPraktikan, namaAsisten);
        }
    }
    public static void listNim(HashMap<String, String> tabelData){
        System.out.println("[LIST NIM PRAKTIKAN]");
        for (HashMap.Entry<String, String> entry : tabelData.entrySet()){
            String nimPraktikan = entry.getKey();
            System.out.println(nimPraktikan);
        }

    }
    public static void listNama(HashMap<String, String> tabelData){
        System.out.println("[LIST NAMA ASISTEN]");
        for (HashMap.Entry<String, String> entry : tabelData.entrySet()){
            String namaAsisten = entry.getValue();
            System.out.println(namaAsisten);
        }
    }
    public static boolean hapusData(HashMap<String, String> tabelData){
        while (true){
            in.nextLine();
            System.out.println("[HAPUS DATA]");
            System.out.print("Masukkan NIM yang akan dihapus: ");
            cNim = in.nextLine();
            for (String i : tabelData.keySet()) {
                if (!tabelData.containsKey(cNim)) {
                    System.out.println("Data tidak ditemukan!");
                    break;
                }
            }
            tabelData.remove(cNim);
            System.out.println("Data dengan NIM " + cNim + " berhasil dihapus.");
            break;
        }
        return true;
    }

    public static void editData(HashMap<String, String> tabelData){
        in.nextLine();
        System.out.println("[EDIT DATA]");
        System.out.print("Masukkan NIM yang akan diedit: ");
        eNim = in.nextLine();
        if (!tabelData.containsKey(eNim)) {
            System.out.println("Data tidak ditemukan!");
        }else{
            System.out.print("Masukkan Nama Asisten baru: ");
            newNama = in.nextLine();
            tabelData.replace(eNim,newNama);
        }

    }
    public static void menu2(HashMap<String, String> tabelSesiLogin){
        int pilih = 0;
        while(pilih < 3){
            System.out.println("[PROGRAM PENDATAAN PRAKTIKAN]");
            System.out.println("1. SIGN IN");
            System.out.println("2. LOG IN");
            System.out.print("Masukkan pilihan: ");
            pilih = input.nextInt();
            switch (pilih){
                case 1:
                    input.nextLine();
                    signIn(tabelSesiLogin);
                    break;
                case 2:
                    logIn(tabelSesiLogin);
                    break;
            }
        }
    }

    public static void signIn(HashMap<String, String> tabelSesiLogin){
        while (true){
            System.out.println("[SIGN IN]");
            System.out.print("Masukkan e-Mail: ");
            eMail = in.nextLine();
            if (!eMail.endsWith("@umm.ac.id")){
                System.out.println("e-Mail harus berdomain '@umm.ac.id'!");
            }else {
                break;
            }
        }
        System.out.print("Masukkan Password: ");
        password = input.nextLine();
        tabelSesiLogin.put(eMail, password);
    }

    public static void logIn(HashMap<String, String> tabelSesiLogin){
        input.nextLine();
        System.out.println("[LOG IN]");
        System.out.print("Masukkan e-Mail: ");
        String eMail2 = input.nextLine();
        System.out.print("Masukkan Password: ");
        String password2 = input.nextLine();
        if (tabelSesiLogin.containsKey(eMail2) && tabelSesiLogin.get(eMail2).equals(password2)){
            menu();
        }else{
            System.out.println("Data tidak sesuai!");
            logIn(tabelSesiLogin);
        }
    }

}
