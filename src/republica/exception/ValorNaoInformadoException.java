package republica.exception;

public class ValorNaoInformadoException extends RuntimeException {
    public ValorNaoInformadoException() {
        super("O valor nao foi informado");
    }
}
