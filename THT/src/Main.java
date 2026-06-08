import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemReservasi reservasi = new SistemReservasi();

        System.out.println(" SELAMAT DATANG DI JAVA EXPRESS    ");
        System.out.println(" Sistem Reservasi Tiket Kereta Api ");

        boolean berjalan = true;

        while (berjalan) {
            System.out.println("\nMENU UTAMA");
            System.out.println("  1. Pesan Tiket");
            System.out.println("  2. Keluar");
            System.out.print("Pilih menu (1-2): ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine(); 

                switch (pilihan) {
                    case 1:
                        prosesPemesanan(scanner, reservasi);
                        break;

                    case 2:
                        berjalan = false;
                        break;

                    default:
                        System.out.println("Pilihan tidak valid. Masukkan angka 1, atau 2 ");
                }

            } catch (InputMismatchException e) {
                System.out.println("ERROR: Input menu harus berupa angka, bukan teks!");
                scanner.nextLine(); 
            }
        }
        try {
            System.out.println("\n Terima kasih telah menggunakan JAVA EXPRESS!");
            System.out.println(" Sampai jumpa dan selamat bepergian!");
        } finally {
            scanner.close();
            System.out.println("[Sistem] Scanner ditutup. Sesi berakhir.");
        }
    }
    private static void prosesPemesanan(Scanner scanner, SistemReservasi reservasi) {
        try {
            System.out.println("\n FORM PEMESANAN TIKET ");

            System.out.print("Kode Kereta (K01/K02): ");
            String kode = scanner.nextLine().trim();

            System.out.print("NIK Penumpang (16 digit): ");
            String nik = scanner.nextLine().trim();

            System.out.print("Nama Penumpang: ");
            String nama = scanner.nextLine().trim();

            System.out.print("Jumlah Tiket: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine();
            reservasi.pesanTiket(kode, nik, nama, jumlah);

        } catch (InputMismatchException e) {
            System.out.println("ERROR: Jumlah tiket harus berupa angka!");
            scanner.nextLine();
        } catch (DataPenumpangTidakValidException e) {
            System.out.println("DATA TIDAK VALID: " + e.getMessage());
            System.out.println("NIK yang Anda masukkan: " + e.getNikInput());
        } catch (RuteTidakDitemukanException e) {
            System.out.println("RUTE TIDAK DITEMUKAN: " + e.getMessage());
            System.out.println("Kode yang dimasukkan: " + e.getKodeInput());
        } catch (TiketHabisException e) {
            System.out.println("TIKET TIDAK TERSEDIA: " + e.getMessage());
            System.out.println("Kereta  : " + e.getNamaKereta());
            System.out.println("Sisa kursi: " + e.getSisaKursi() + " kursi");
        }
    }
}