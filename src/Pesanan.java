public class Pesanan {
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
