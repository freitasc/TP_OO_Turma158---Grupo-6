package republica.exception;

public class CategoriaNaoInformadaException extends RuntimeException {
    public CategoriaNaoInformadaException() {
        super("A categoria nao foi informada");
    }
}
