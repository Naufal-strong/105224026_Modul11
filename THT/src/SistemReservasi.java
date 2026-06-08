import java.util.HashMap;
import java.util.Map;
public class SistemReservasi {

    private Map<String, Kereta> daftarKereta;

    public SistemReservasi() {
        daftarKereta = new HashMap<>();
        tambahKereta(new Kereta("K01", "Argo Bromo",  "JKT - SBY", 50));
        tambahKereta(new Kereta("K02", "Parahyangan", "JKT - BDG", 15));
    }
    private void tambahKereta(Kereta k) {
        daftarKereta.put(k.getKodeKereta(), k);
    }
    public void pesanTiket(String kodeKereta, String nik, String namaPenumpang, int jumlahTiket)
            throws RuteTidakDitemukanException, TiketHabisException {

        if (nik.length() != 16) {
            throw new DataPenumpangTidakValidException(
                "NIK harus tepat 16 karakter! Input anda: " + nik.length() + " karakter.", nik);
        }
        for (char c : nik.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new DataPenumpangTidakValidException(
                    "NIK hanya boleh berisi angka, bukan huruf atau simbol!", nik);
            }
        }
        Kereta kereta = daftarKereta.get(kodeKereta.toUpperCase());
        if (kereta == null) {
            throw new RuteTidakDitemukanException(
                "Kode kereta '" + kodeKereta + "' tidak ditemukan dalam sistem.", kodeKereta);
        }
        if (jumlahTiket > kereta.getSisaKursi()) {
            throw new TiketHabisException(
                "Kursi tidak mencukupi untuk kereta " + kereta.getNamaKereta() + ".",
                kereta.getNamaKereta(),
                kereta.getSisaKursi());
        }
        kereta.kurangiKursi(jumlahTiket);
        System.out.println("TIKET BERHASIL DIPESAN!");
        System.out.printf ("Penumpang  : ", namaPenumpang);
        System.out.printf ("NIK        : ", nik);
        System.out.printf ("Kereta     : ", kereta.getNamaKereta());
        System.out.printf ("Rute       : ", kereta.getRute());
        System.out.printf ("Jumlah     : ", jumlahTiket + " tiket");
        System.out.printf ("Sisa Kursi : ", kereta.getSisaKursi() + " kursi");
    }
}