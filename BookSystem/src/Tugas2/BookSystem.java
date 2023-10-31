package Tugas2;

import java.util.Scanner;

/**
 * Kelas BookSystem merupakan sistem pemesanan kamar dengan informasi kamar, harga, dan informasi pelanggan.
 */
public class BookSystem {
    private String[] kamarTersedia;
    private double[] hargaKamar;
    private String[] kamarTerisi;
    private double totalHarga;
    private double uangMasuk;

    /**
     * Konstruktor kelas BookSystem, menginisialisasi array kamar dan harga kamar.
     * @param jumlahKamar Jumlah kamar yang tersedia
     */
    public BookSystem(int jumlahKamar) {
        kamarTersedia = new String[jumlahKamar];
        hargaKamar = new double[jumlahKamar];
        kamarTerisi = new String[jumlahKamar];
    }

    /**
     * Menambahkan informasi kamar dan harganya ke sistem.
     * @param nomorKamar Nomor kamar
     * @param namaKamar Nama kamar
     * @param harga Harga kamar per malam
     * @return true jika informasi kamar berhasil ditambahkan, false jika gagal.
     */
    public boolean tambahKamar(int nomorKamar, String namaKamar, double harga) {
        kamarTersedia[nomorKamar] = namaKamar;
        hargaKamar[nomorKamar] = harga;
        return true;
    }

    /**
      Memesan kamar untuk pelanggan dengan informasi pelanggan dan nomor kamar.
     * @param nomorKamar Nomor kamar yang dipesan
     * @param namaPelanggan Nama pelanggan
     * @param alamatEmail Alamat email pelanggan (harus mengandung karakter '@')
     * @param nomorTelepon Nomor telepon pelanggan (harus berisi angka)
     * @param alamat Alamat pelanggan
     * @return true jika pemesanan berhasil, false jika gagal.
     * @throws Exception jika uang yang dimasukkan kurang dari total harga
     */
    public boolean pesanKamar(int nomorKamar, String namaPelanggan, String alamatEmail, String nomorTelepon, String alamat, double uangMasuk) throws Exception {
        if (kamarTersedia[nomorKamar] != null) {
            if (uangMasuk < hargaKamar[nomorKamar]) {
                throw new Exception("Uang yang dimasukkan kurang");
            }

            kamarTerisi[nomorKamar] = namaPelanggan;
            totalHarga += hargaKamar[nomorKamar];
            this.uangMasuk = uangMasuk;
            System.out.println("Kamar " + kamarTersedia[nomorKamar] + " berhasil dipesan oleh " + namaPelanggan);
            System.out.println("Total harga: " + totalHarga);
            return true;
        } else {
            System.out.println("Kamar tidak tersedia.");
            return false;
        }
    }

    /**
     * Menghitung kembalian berdasarkan jumlah uang yang dimasukkan.
     * @return Jumlah kembalian yang harus dikembalikan kepada pelanggan.
     */
    public double hitungKembalian() {
        double kembalian = uangMasuk - totalHarga;
        System.out.println("Uang masuk: " + uangMasuk);
        System.out.println("Kembalian: " + kembalian);
        return kembalian;
    }

    public static void main(String[] args) {
        // Contoh penggunaan kelas BookSystem
        BookSystem bookSystem = new BookSystem(3);
        bookSystem.tambahKamar(0, "Kamar A", 100.0);
        bookSystem.tambahKamar(1, "Kamar B", 150.0);
        bookSystem.tambahKamar(2, "Kamar C", 200.0);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan nama Anda: ");
        String nama = scanner.nextLine();
        System.out.println("Masukkan alamat email Anda: ");
        String email = scanner.nextLine();
        System.out.println("Masukkan nomor telepon Anda: ");
        String telepon = scanner.nextLine();
        System.out.println("Masukkan alamat rumah Anda: ");
        String alamat = scanner.nextLine();

        System.out.println("Pilih nomor kamar yang ingin Anda pesan (0, 1, 2): ");
        int nomorKamar = scanner.nextInt();

        System.out.println("Masukkan jumlah uang yang Anda ingin masukkan: ");
        double uangMasuk = scanner.nextDouble();

        try {
            bookSystem.pesanKamar(nomorKamar, nama, email, telepon, alamat, uangMasuk);
            double kembalian = bookSystem.hitungKembalian();
            System.out.println("Kembalian yang diberikan: " + kembalian);
        } catch (Exception e) {
            System.out.println("Pemesanan gagal: " + e.getMessage());
        }
    }
}
