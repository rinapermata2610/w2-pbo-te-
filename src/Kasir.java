import java.util.ArrayList;
import java.util.List;

public class Kasir {
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
