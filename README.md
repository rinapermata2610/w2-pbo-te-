# PBO Teori W2 - Manajemen Kantin

## Deskripsi

Program berbasis **console** dengan konsep **PBO** untuk mengelola sistem kantin. Fitur: tambah menu makanan/minuman, input pesanan, hitung total belanja, dan tampilkan struk.

---

## Cara Menjalankan

```bash
git clone https://github.com/rinapermata2610/praktikum-pbo-w2-kantin.git
cd praktikum-pbo-w2-kantin
javac -d bin src/*.java
java -cp bin KantinApp
```

---

## Konsep PBO

* **Encapsulation** → atribut private + getter/setter pada `Menu` & `Pesanan`
* **Composition** → `Pesanan` berisi daftar `Menu`
* **Class & Object** → Menu, Pesanan, Kasir
* **Polymorphism** → cetak detail menu dengan `toString()`
* **Modularisasi** → tiap class dipisah per file

---

## Author

Rina Permata Dewi - 241511061
Kelas: 2B/D3 Teknik Informatika - Politeknik Negeri Bandung
