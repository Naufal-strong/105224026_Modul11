public class SaldoTidakMencukupiException extends Exception {

    private double kekuranganSaldo;

    public SaldoTidakMencukupiException(
            String pesan,
            double kekuranganSaldo) {

        super(pesan);
        this.kekuranganSaldo = kekuranganSaldo;
    }

    public double getKekuranganSaldo() {
        return kekuranganSaldo;
    }
}