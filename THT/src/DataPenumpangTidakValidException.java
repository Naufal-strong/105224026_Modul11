public class DataPenumpangTidakValidException extends RuntimeException {

    private String nikInput;

    public DataPenumpangTidakValidException(String pesan, String nikInput) {
        super(pesan);
        this.nikInput = nikInput;
    }

    public String getNikInput() {
        return nikInput;
    }
}