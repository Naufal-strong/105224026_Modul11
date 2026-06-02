public class Main {

    public static void main(String[] args) {

        AkunBank rekeningA =
                new AkunBank(
                        "021313451",
                        5000000);

        AkunBank rekeningB =
                new AkunBank(
                        "923283421",
                        2000000);

        try {
            // TRANSAKSI 1
            //tarik saldo sampe habis

            System.out.println(
                    " Penarikan Tunai ");

            rekeningA.tarikTunai(5000000);

            // TRANSAKSI 2
            // Transfer saat saldo kosong
            System.out.println(
                    "\n Transfer Saat Saldo Habis");

            rekeningA.transfer(
                    rekeningB,
                    1000000);

        }
        catch (SaldoTidakMencukupiException e) {

            System.out.println(
                    "\n[ERROR SALDO] "
                            + e.getMessage());

            System.out.println(
                    "Kekurangan saldo : Rp"
                            + e.getKekuranganSaldo());

            // Simulasi transfer melebihi limit
            try {

                AkunBank rekeningC =
                        new AkunBank(
                                "111111111",
                                20000000);

                rekeningC.transfer(
                        rekeningB,
                        12000000);

            }

            catch (SaldoTidakMencukupiException ex) {

                System.out.println(
                        ex.getMessage());
            }

            catch (BatasTransferHarianException ex) {

                System.out.println(
                        "\n ERROR LIMIT TRANSFER "
                                + ex.getMessage());
            }
        }

        catch (BatasTransferHarianException e) {

            System.out.println(
                    e.getMessage());
        }
        finally {
            System.out.println(
                    "Sesi transaksi ATM Anda telah diakhiri.");

            System.out.println(
                    "Kartu dikeluarkan otomatis.");
        }
    }
}