public class AkunBank {

    private String nomorRekening;
    private double saldo;
    private double totalTransferHarian;

    private final double LIMIT_TRANSFER = 10000000;

    public AkunBank(String nomorRekening, double saldo) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.totalTransferHarian = 0;
    }

    public void tarikTunai(double nominal)
            throws SaldoTidakMencukupiException {

        if (nominal > saldo) {

            double kurang = nominal - saldo;

            throw new SaldoTidakMencukupiException(
                    "Saldo tidak mencukupi untuk penarikan.",
                    kurang);
        }

        saldo -= nominal;

        System.out.println(
                "Penarikan berhasil sebesar Rp" + nominal);
        System.out.println(
                "Sisa saldo : Rp" + saldo);
    }

    public void transfer(
            AkunBank tujuan,
            double nominal)
            throws SaldoTidakMencukupiException,
            BatasTransferHarianException {

        if (nominal > saldo) {

            double kurang = nominal - saldo;

            throw new SaldoTidakMencukupiException(
                    "Saldo tidak mencukupi untuk transfer.",
                    kurang);
        }

        if (totalTransferHarian + nominal > LIMIT_TRANSFER) {

            throw new BatasTransferHarianException(
                    "Transfer melebihi batas harian Rp10.000.000");
        }

        saldo -= nominal;
        tujuan.saldo += nominal;

        totalTransferHarian += nominal;

        System.out.println(
                "Transfer Rp" + nominal +
                " ke rekening " + tujuan.nomorRekening +
                " berhasil.");
    }
}