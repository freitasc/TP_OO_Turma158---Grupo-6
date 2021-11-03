package republica.modelo;

public class Categoria {

    private int id;
    private String descricao;
    private String subcategoria;

    public Categoria(String descricao, String subcategoria) {
        setDescricao(descricao);
        setSubcategoria(subcategoria);
    }

    public Categoria(int id, String descricao, String subcategoria) {
        setId(id);
        setDescricao(descricao);
        setSubcategoria(subcategoria);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    private void setDescricao(String descricao) {
        this.descricao = descricao.trim().toLowerCase();
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    private void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria.trim().toLowerCase();
    }
}