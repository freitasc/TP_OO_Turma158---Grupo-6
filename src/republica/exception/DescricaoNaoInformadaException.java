package republica.exception;

public class DescricaoNaoInformadaException extends RuntimeException {
    public DescricaoNaoInformadaException() {
        super("A descricao nao foi informada");
    }
}
