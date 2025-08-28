public class Makanan extends Menu {
    public Makanan(String nama, int harga) {
        super(nama, harga);
    }

    @Override
    public String getKategori() {
        return "Makanan";
    }
}
