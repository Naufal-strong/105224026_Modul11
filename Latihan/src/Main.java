import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // soal 1 
        System.out.println(" SOAL 1 ");

        int[] hargaMenu = new int[3];

        try {

            for (int i = 0; i < 4; i++) {

                System.out.print("Masukkan harga menu ke-" + (i + 1) + ": ");
                hargaMenu[i] = input.nextInt();
            }

        } catch (InputMismatchException e) {

            System.out.println("Error: Input harga harus berupa angka!");

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Error: Kapasitas memori harga sudah penuh!");
        }
        // soal 2 
        System.out.println("\n SOAL 2");

        Pelanggan pelanggan = new Pelanggan();

        try {

            pelanggan.daftarMember(15);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
        // soal 3 
         System.out.println("\n SOAL 3 ");

        try {

            pelanggan.pesanKopi(10);

        } catch (KopiHabisException e) {

            System.out.println(e.getMessage());
        }
        //soal 4
         System.out.println("\n SOAL 4 ");

        MesinKasir kasir = new MesinKasir();

        try {

            kasir.bayar(50000, 30000);

        } catch (UangKurangException e) {

            System.out.println(e.getMessage());
        }
        // soal 5 
         System.out.println("\n SOAL 5 ");
         try {

            kasir.cetakStruk(false);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        } finally {

            System.out.println(
                    "Terima kasih telah berkunjung ke Cafe Java Bean. Program kasir ditutup.");
        }

        input.close();
     }

        

    }

    
