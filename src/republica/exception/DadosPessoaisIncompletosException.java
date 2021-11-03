package republica.exception;

public class DadosPessoaisIncompletosException extends RuntimeException {
    public DadosPessoaisIncompletosException() {
        super("Os dados pessoais estao incompletos");
    }
}
