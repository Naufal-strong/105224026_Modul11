import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = null;

        try {
            input = new Scanner(System.in);

            System.out.print("Masukkan pembilang : ");
            int pembilang = input.nextInt();

            System.out.print("Masukkan penyebut : ");
            int penyebut = input.nextInt();

            Kalkulator kalkulator = new Kalkulator();

            double hasil = kalkulator.bagi(pembilang, penyebut);

            System.out.println("Hasil pembagian = " + hasil);

        } catch (ArithmeticException e) {

            System.out.println(
                    "Error: Penyebut tidak boleh bernilai 0!");

        } catch (InputMismatchException e) {

            System.out.println(
                    "Error: Input harus berupa angka!");

        } finally {

            if (input != null) {
                input.close();
            }

            System.out.println(
                    "Proses kalkulasi selesai dan resource memori telah dibersihkan.");
        }
    }
}