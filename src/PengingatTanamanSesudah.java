// File: PengingatTanamanSesudah.java
import java.util.Scanner;
//putrii
/**
 * Program PengingatTanamanSesudah digunakan untuk membantu pengguna
 * mengatur jadwal perawatan tanaman berdasarkan interval penyiraman,
 * pemupukan, dan kebutuhan sinar matahari setiap hari.
 *
 * <p>Program ini merupakan hasil refactoring dari versi sebelumnya agar
 * lebih terstruktur dengan konsep OOP (Object Oriented Programming),
 * memanfaatkan kelas {@link Tanaman} untuk mengelola data tanaman.</p>
 *
 * @author Putri
 * @version 1.0
 */
public class PengingatTanamanSesudah {

    /**
     * Method utama program.
     * Meminta input pengguna mengenai data tanaman dan menampilkan saran perawatannya.
     *
     * @param args argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama tanaman: ");
        String nama = input.nextLine();

        System.out.print("Berapa hari sekali disiram: ");
        int siram = input.nextInt();

        System.out.print("Berapa hari sekali diberi pupuk: ");
        int pupuk = input.nextInt();

        System.out.print("Berapa jam butuh sinar matahari per hari: ");
        int cahaya = input.nextInt();

        // Membuat objek tanaman berdasarkan input pengguna
        Tanaman tanamanSaya = new Tanaman(nama, siram, pupuk, cahaya);
        tanamanSaya.tampilkanPerawatan();
    }
}

/**
 * Kelas Tanaman merepresentasikan data dan perilaku dari sebuah tanaman.
 * Kelas ini menyimpan informasi nama tanaman, interval penyiraman, pemupukan,
 * serta kebutuhan sinar matahari.
 */
class Tanaman {
    private String nama;
    private int intervalSiram;
    private int intervalPupuk;
    private int jamCahaya;


    /**
     * Konstruktor Tanaman untuk menginisialisasi data perawatan tanaman.
     *
     * @param nama nama tanaman
     * @param intervalSiram berapa hari sekali tanaman disiram
     * @param intervalPupuk berapa hari sekali tanaman diberi pupuk
     * @param jamCahaya berapa jam sinar matahari dibutuhkan per hari
     */
    public Tanaman(String nama, int intervalSiram, int intervalPupuk, int jamCahaya) {
        this.nama = nama;
        this.intervalSiram = intervalSiram;
        this.intervalPupuk = intervalPupuk;
        this.jamCahaya = jamCahaya;
    }

    /** @return nama tanaman */
    public String getNama() { return nama; }

    /** @return interval penyiraman dalam hari */
    public int getIntervalSiram() { return intervalSiram; }

    /** @return interval pemupukan dalam hari */
    public int getIntervalPupuk() { return intervalPupuk; }

    /** @return kebutuhan sinar matahari per hari dalam jam */
    public int getJamCahaya() { return jamCahaya; }

    /**
     * Menampilkan rincian perawatan tanaman beserta saran otomatis.
     * Menggunakan method {@link #saranPenyiraman()} dan {@link #saranCahaya()}.
     */
    public void tampilkanPerawatan() {
        System.out.println("\n=== Rincian Perawatan Tanaman ===");
        System.out.println("Nama Tanaman        : " + nama);
        System.out.println("Penyiraman setiap   : " + intervalSiram + " hari");
        System.out.println("Pemupukan setiap    : " + intervalPupuk + " hari");
        System.out.println("Butuh sinar matahari: " + jamCahaya + " jam/hari");

        System.out.println("\nSaran Perawatan:");
        System.out.println(saranPenyiraman());
        System.out.println(saranCahaya());
    }

    /**
     * Memberikan saran berdasarkan frekuensi penyiraman tanaman.
     *
     * @return teks saran penyiraman
     */
    private String saranPenyiraman() {
        return intervalSiram <= 2 ? "Perlu disiram cukup sering."
                : "Tahan terhadap kekeringan.";
    }

    /**
     * Memberikan saran berdasarkan kebutuhan cahaya tanaman.
     *
     * @return teks saran kebutuhan cahaya
     */
    private String saranCahaya() {
        return jamCahaya >= 6 ? "Tempatkan di area yang sangat terang."
                : "Cukup cahaya sedang saja.";
    }
}
