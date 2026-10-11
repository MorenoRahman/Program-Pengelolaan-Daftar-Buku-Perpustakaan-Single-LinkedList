import java.util.Scanner;

// Main: menu program pengelolaan daftar buku perpustakaan
public class Main {
    static final int MIN_BUKU = 5;
    static final int MAKS_KODE = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList daftar = new LinkedList();
        int pilihan;

        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            try {
                pilihan = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                pilihan = 0;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = sc.nextLine().trim();
                    // Validasi kode: tidak kosong, maksimal 5 karakter, dan unik
                    if (kode.isEmpty() || kode.length() > MAKS_KODE) {
                        System.out.println("Kode buku tidak valid (maksimal " + MAKS_KODE + " karakter).");
                        break;
                    }
                    if (daftar.kodeSudahAda(kode)) {
                        System.out.println("Kode buku sudah digunakan.");
                        break;
                    }
                    System.out.print("Masukkan Judul: ");
                    String judul = sc.nextLine().trim();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = sc.nextLine().trim();
                    daftar.tambahBuku(kode, judul, penulis);
                    System.out.println("Data berhasil ditambahkan!");
                    break;
                case 2:
                    if (daftar.hapusBuku()) {
                        System.out.println("Buku terakhir berhasil dihapus.");
                    } else {
                        System.out.println("Tidak ada data untuk dihapus.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan Kode Buku: ");
                    Node hasil = daftar.cariBuku(sc.nextLine().trim());
                    if (hasil != null) {
                        System.out.println("Buku ditemukan!");
                        System.out.println("Kode: " + hasil.kodeBuku + " | Judul: " + hasil.judul
                                + " | Penulis: " + hasil.penulis);
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;
                case 4:
                    daftar.tampilSemua();
                    if (daftar.getSize() < MIN_BUKU) {
                        System.out.println("(Catatan: data minimal " + MIN_BUKU + " buku, saat ini baru "
                                + daftar.getSize() + ")");
                    }
                    break;
                case 5:
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia, coba lagi.");
            }
        } while (pilihan != 5);
        sc.close();
    }
}
