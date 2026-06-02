public class MesinKasir {

    public void bayar(int totalBelanja, int uangDiberikan)
            throws UangKurangException {

        if (uangDiberikan < totalBelanja) {

            throw new UangKurangException(
                    "Uang yang diberikan kurang Rp"
                            + (totalBelanja - uangDiberikan));
        }

        System.out.println(
                "Pembayaran berhasil. Kembalian: Rp"
                        + (uangDiberikan - totalBelanja));
    }

    public void cetakStruk(boolean statusPrinter)
            throws Exception {

        if (!statusPrinter) {

            throw new Exception(
                    "Printer error: Kertas struk habis!");
        }

        System.out.println("Struk berhasil dicetak.");
    }
}