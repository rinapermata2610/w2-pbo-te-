public abstract class Menu {
    private final String nama;
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
