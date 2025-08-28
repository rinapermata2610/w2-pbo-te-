import java.util.InputMismatchException;
import java.util.Scanner;

public class KantinPolbanApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Kasir kasir = new Kasir();

        try {
            System.out.println("=== Selamat Datang di Kantin Polban ===");
            boolean lanjutPesan = true;

            // Looping untuk input pesanan
            while (lanjutPesan) {
                kasir.tampilkanMenu();

                System.out.print("Pilih nomor menu: ");
                int nomorMenu = sc.nextInt();

                System.out.print("Masukkan jumlah porsi: ");
                int jumlah = sc.nextInt();

                kasir.tambahPesanan(nomorMenu, jumlah);

                System.out.print("Tambah pesanan lagi? (y/n): ");
                lanjutPesan = sc.next().equalsIgnoreCase("y");
            }

            // Pembayaran
            int total = kasir.hitungTotal();
            System.out.println("\nTotal yang harus dibayar: Rp" + total);
            System.out.print("Masukkan uang pembayaran: ");
            int uangBayar = sc.nextInt();

            if (uangBayar < total) {
                System.out.println("Uang tidak cukup, transaksi dibatalkan!");
            } else {
                kasir.cetakStruk(uangBayar);
            }

        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid, silakan masukkan angka!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
