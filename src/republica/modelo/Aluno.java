package republica.modelo;

public class Aluno {

    private int id;
    private String nome;
    private String email;
    private float renda;

    public void setId (int id){
        this.id = id;
    }
    public int getId (){
        return id;
    }

    public void setNome (String nome){
        this.nome = nome;
    }
    public String getNome (){
        return nome;
    }

    public void setEmail (String Email){
        this.email = Email;
    }
    public String getEmail (){
        return email;
    }

    public void setRenda (float renda){
        this.renda = renda;
    }
    public float getRenda (){
        return renda;
    }
}
