// LinkedList: single linked list untuk menyimpan daftar buku
public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    // Tambah buku di akhir daftar (push)
    public void tambahBuku(String kode, String judul, String penulis) {
        Node baru = new Node(kode, judul, penulis);
        if (head == null) {
            head = baru;             // daftar masih kosong
        } else {
            Node bantu = head;
            while (bantu.next != null) { // telusuri sampai simpul terakhir
                bantu = bantu.next;
            }
            bantu.next = baru;
        }
        size++;
    }

    // Hapus buku terakhir (pop); mengembalikan false jika daftar kosong
    public boolean hapusBuku() {
        if (head == null) {
            return false;
        }
        if (head.next == null) {     // hanya ada satu simpul
            head = null;
        } else {
            Node bantu = head;
            while (bantu.next.next != null) { // berhenti di simpul sebelum terakhir
                bantu = bantu.next;
            }
            bantu.next = null;
        }
        size--;
        return true;
    }

    // Cari buku berdasarkan kode; null jika tidak ada
    public Node cariBuku(String kode) {
        Node bantu = head;
        while (bantu != null) {
            if (bantu.kodeBuku.equalsIgnoreCase(kode)) {
                return bantu;
            }
            bantu = bantu.next;
        }
        return null;
    }

    // Cek apakah kode sudah dipakai
    public boolean kodeSudahAda(String kode) {
        return cariBuku(kode) != null;
    }

    // Tampilkan semua buku sesuai urutan input
    public void tampilSemua() {
        if (head == null) {
            System.out.println("Daftar buku masih kosong.");
            System.out.println("Total Buku: 0");
            return;
        }
        System.out.println("Daftar Buku:");
        Node bantu = head;
        while (bantu != null) {
            System.out.println("Kode: " + bantu.kodeBuku + " | Judul: " + bantu.judul
                    + " | Penulis: " + bantu.penulis);
            bantu = bantu.next;
        }
        System.out.println("Total Buku: " + size);
    }
}
