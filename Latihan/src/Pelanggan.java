public class Pelanggan {

    private int stokKopi = 5;

    public void daftarMember(int umur) {

        if (umur < 17) {
            throw new IllegalArgumentException(
                    "Maaf, umur Anda belum mencukupi untuk menjadi Member VIP");
        }

        System.out.println("Pendaftaran Member VIP berhasil.");
    }

    public void pesanKopi(int jumlahPesanan) {

        if (jumlahPesanan > stokKopi) {
            throw new KopiHabisException(
                    "Stok kopi tidak mencukupi! Sisa stok: " + stokKopi);
        }

        stokKopi -= jumlahPesanan;

        System.out.println(
                "Pesanan berhasil. Sisa stok kopi: " + stokKopi);
    }
    
}