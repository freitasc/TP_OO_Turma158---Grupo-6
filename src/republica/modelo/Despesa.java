package republica.modelo;

public class Despesa {
	
	private int id;
    private String descricao;
    private float valor;
    private int categoriaid;
    
    public void setId (int id){
        this.id = id;
    }
    public int getId (){
        return id;
    }

    public void setDescricao (String descricao){
        this.descricao = descricao;
    }
    public String getDescricao (){
        return descricao;
    }

    public void setValor (Float valor){
        this.valor = valor;
    }
    public Float getValor (){
        return valor;
    }

    public void setIdCategoria (int categoriaid){
        this.categoriaid = categoriaid;
    }
   
    public int getIdCategoria (){
        return categoriaid;
    }
