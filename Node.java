// Node: satu simpul yang menyimpan data satu buku
public class Node {
    String kodeBuku;
    String judul;
    String penulis;
    Node next; // penunjuk ke simpul berikutnya

    public Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}
