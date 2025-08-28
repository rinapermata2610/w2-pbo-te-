/**
 * WEEK 2 | TUGAS PBO
 *
 * Nama  : Rina Permata Dewi
 * NIM   : 241511061
 * Kelas : 2B/D3 Teknik Informatika
 */

import java.util.*;

// ================= SUPERCLASS =================
abstract class Menu {
    private final String nama;   // Ubah protected → private (enkapsulasi)
    private final int harga;

    public Menu(String nama, int harga) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama menu tidak boleh kosong!");
        }
        if (harga <= 0) {
            throw new IllegalArgumentException("Harga harus lebih dari 0!");
        }
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public abstract String getKategori();
}

// ================= SUBCLASS MAKANAN =================
class Makanan extends Menu {
    public Makanan(String nama, int harga) {
        super(nama, harga);
    }

    @Override
    public String getKategori() {
        return "Makanan";
    }
}

// ================= SUBCLASS MINUMAN =================
class Minuman extends Menu {
    public Minuman(String nama, int harga) {
        super(nama, harga);
    }

    @Override
    public String getKategori() {
        return "Minuman";
    }
}

// ================= CLASS PESANAN =================
class Pesanan {
    private final Menu menu;
    private final int jumlah;

    public Pesanan(Menu menu, int jumlah) {
        if (menu == null) {
            throw new IllegalArgumentException("Menu tidak boleh null!");
        }
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah harus lebih dari 0!");
        }
        this.menu = menu;
        this.jumlah = jumlah;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getSubtotal() {
        return menu.getHarga() * jumlah;
    }
}

// ================= CLASS KASIR =================
class Kasir {
    private final List<Menu> daftarMenu = new ArrayList<>();
    private final List<Pesanan> daftarPesanan = new ArrayList<>();

    public Kasir() {
        // Daftar menu kantin Polban
        daftarMenu.add(new Makanan("Nasi Goreng Spesial", 15000));
        daftarMenu.add(new Makanan("Ayam Geprek", 14000));
        daftarMenu.add(new Makanan("Mie Ayam Bakso", 13000));
        daftarMenu.add(new Minuman("Es Teh Manis", 5000));
        daftarMenu.add(new Minuman("Kopi Hitam", 7000));
        daftarMenu.add(new Minuman("Jus Alpukat", 10000));
    }

    public void tampilkanMenu() {
        System.out.println("\n=========== DAFTAR MENU KANTIN POLBAN ===========");
        System.out.printf("%-3s | %-25s | %-10s | %-10s\n", "No", "Nama Menu", "Kategori", "Harga");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < daftarMenu.size(); i++) {
            Menu m = daftarMenu.get(i);
            System.out.printf("%-3d | %-25s | %-10s | Rp%-9d\n",
                    (i + 1), m.getNama(), m.getKategori(), m.getHarga());
        }
        System.out.println("=================================================\n");
    }

    public void tambahPesanan(int nomorMenu, int jumlah) {
        if (nomorMenu < 1 || nomorMenu > daftarMenu.size()) {
            throw new IllegalArgumentException("Nomor menu tidak valid!");
        }
        Menu menuDipilih = daftarMenu.get(nomorMenu - 1);
        daftarPesanan.add(new Pesanan(menuDipilih, jumlah));
    }

    public int hitungTotal() {
        return daftarPesanan.stream()
                .mapToInt(Pesanan::getSubtotal)
                .sum();
    }

    public void cetakStruk(int uangBayar) {
        System.out.println("\n============= STRUK PEMBELIAN =============");
        System.out.printf("%-25s %-5s %-10s %-10s\n", "Menu", "Qty", "Harga", "Subtotal");
        System.out.println("-------------------------------------------------");

        for (Pesanan p : daftarPesanan) {
            System.out.printf("%-25s %-5d Rp%-9d Rp%-9d\n",
                    p.getMenu().getNama(), p.getJumlah(),
                    p.getMenu().getHarga(), p.getSubtotal());
        }

        System.out.println("-------------------------------------------------");
        int total = hitungTotal();
        System.out.printf("%-35s Rp%-9d\n", "TOTAL:", total);
        System.out.printf("%-35s Rp%-9d\n", "BAYAR:", uangBayar);
        System.out.printf("%-35s Rp%-9d\n", "KEMBALI:", (uangBayar - total));
        System.out.println("============= TERIMA KASIH =============\n");
    }
}

// ================= MAIN PROGRAM =================
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
/**
 * WEEK 2 | TUGAS PBO
 *
 * Nama  : Rina Permata Dewi
 * NIM   : 241511061
 * Kelas : 2B/D3 Teknik Informatika
 */