# BookSystem

BookSystem adalah sebuah program Java sederhana yang memungkinkan pengguna untuk melakukan pemesanan kamar dengan memilih kamar yang ingin dipesan, memasukkan informasi pelanggan, dan menghitung kembalian. Program ini menggunakan kelas `BookSystem` untuk mengelola pemesanan kamar.

## Deskripsi Kelas

### Konstruktor
- `BookSystem(int jumlahKamar)`: Konstruktor ini digunakan untuk menginisialisasi sistem pemesanan dengan jumlah kamar yang tersedia.

### Metode
1. `boolean tambahKamar(int nomorKamar, String namaKamar, double harga)`: Metode ini digunakan untuk menambahkan informasi kamar dan harga kamar ke sistem. Jika informasi kamar berhasil ditambahkan, metode akan mengembalikan `true`, jika tidak, akan mengembalikan `false`.

2. `boolean pesanKamar(int nomorKamar, String namaPelanggan, String alamatEmail, String nomorTelepon, String alamat, double uangMasuk) throws Exception`: Metode ini memungkinkan pengguna untuk memesan kamar dengan memasukkan informasi pelanggan, nomor kamar, dan jumlah uang yang dimasukkan. Jika uang yang dimasukkan kurang dari harga kamar, metode akan melempar pengecualian `Exception`.

3. `double hitungKembalian()`: Metode ini digunakan untuk menghitung kembalian berdasarkan jumlah uang yang dimasukkan oleh pelanggan. Metode ini mengembalikan jumlah kembalian.

## Cara Penggunaan

1. Inisialisasi kelas `BookSystem` dengan jumlah kamar yang tersedia.

2. Tambahkan informasi kamar dan harga kamar ke sistem dengan metode `tambahKamar`.

3. Masukkan informasi pelanggan, termasuk nama, alamat email, nomor telepon, alamat rumah, dan jumlah uang yang ingin dimasukkan.

4. Pilih nomor kamar yang ingin dipesan.

5. Memanggil metode `pesanKamar` dengan informasi di atas. Jika berhasil, program akan menghitung kembalian.

6. Program akan menangani pengecualian jika uang yang dimasukkan kurang dari total harga pesanan.

## Contoh Penggunaan

```java
BookSystem bookSystem = new BookSystem(3);
bookSystem.tambahKamar(0, "Kamar A", 100.0);
bookSystem.tambahKamar(1, "Kamar B", 150.0);
bookSystem.tambahKamar(2, "Kamar C", 200.0);

// Masukkan informasi pelanggan
String nama = "John Doe";
String email = "johndoe@example.com";
String telepon = "1234567890";
String alamat = "123 Main St";

// Pilih nomor kamar
int nomorKamar = 1;

// Masukkan jumlah uang yang ingin dimasukkan
double uangMasuk = 200.0;

try {
    bookSystem.pesanKamar(nomorKamar, nama, email, telepon, alamat, uangMasuk);
    double kembalian = bookSystem.hitungKembalian();
    System.out.println("Kembalian yang diberikan: " + kembalian);
} catch (Exception e) {
    System.out.println("Pemesanan gagal: " + e.getMessage());
}
