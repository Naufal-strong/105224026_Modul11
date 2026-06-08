public class RuteTidakDitemukanException extends Exception {

    private String kodeInput;

    public RuteTidakDitemukanException(String pesan, String kodeInput) {
        super(pesan);
        this.kodeInput = kodeInput;
    }

    public String getKodeInput() {
        return kodeInput;
    }
}