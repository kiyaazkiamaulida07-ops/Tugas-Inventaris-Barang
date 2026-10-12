
import java.util.HashMap;

public class MainInventaris {
    public static void main(String[] args) {
        // Key = kode produk, Value = objek Produk
        HashMap<String, Produk> mapInventaris = new HashMap<>();

        // Menambahkan 5 produk
        mapInventaris.put("P001", new Produk("P001", "Laptop", 10));
        mapInventaris.put("P002", new Produk("P002", "Mouse", 25));
        mapInventaris.put("P003", new Produk("P003", "Keyboard", 15));
        mapInventaris.put("P004", new Produk("P004", "Monitor", 8));
        mapInventaris.put("P005", new Produk("P005", "Printer", 6));

        // Cetak daftar awal
        System.out.println("===== DAFTAR INVENTARIS AWAL =====");
        tampilkanInventaris(mapInventaris);
        System.out.println("Total stok awal: "
                + hitungTotalStok(mapInventaris));

        // Ubah stok Mouse dari 25 menjadi 30
        String kodeUpdate = "P002";

        if (mapInventaris.containsKey(kodeUpdate)) {
            mapInventaris.get(kodeUpdate).setStok(30);
            System.out.println("\nStok Mouse berhasil diubah menjadi 30.");
        }

        // Hapus Monitor
        String kodeHapus = "P004";
        Produk produkDihapus = mapInventaris.remove(kodeHapus);

        if (produkDihapus != null) {
            System.out.println("Produk yang dihapus: "
                    + produkDihapus.getNama()
                    + " (" + kodeHapus + ")");
        }

        // Cetak daftar akhir
        System.out.println("\n===== DAFTAR INVENTARIS AKHIR =====");
        tampilkanInventaris(mapInventaris);
        System.out.println("Total stok akhir: "
                + hitungTotalStok(mapInventaris));
    }

    // Menampilkan semua produk menggunakan for-each
    public static void tampilkanInventaris(
            HashMap<String, Produk> mapInventaris) {

        for (String key : mapInventaris.keySet()) {
            Produk p = mapInventaris.get(key);

            System.out.println(
                    "Kode: " + p.getKodeProduk()
                    + " | Nama: " + p.getNama()
                    + " | Stok: " + p.getStok()
            );
        }
    }

    // Menghitung total seluruh stok
    public static int hitungTotalStok(
            HashMap<String, Produk> mapInventaris) {

        int totalStok = 0;

        for (String key : mapInventaris.keySet()) {
            Produk p = mapInventaris.get(key);
            totalStok += p.getStok();
        }

        return totalStok;
    }
}
