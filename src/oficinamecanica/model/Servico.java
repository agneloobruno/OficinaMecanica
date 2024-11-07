package oficinamecanica.model;
public class Servico {
   private int id;
   private String descricao;
   private float preco;
   
   //Construtores
    public Servico(){}

    public Servico(int id, String descricao, float preco) {
       this.id = id;
       this.descricao = descricao;
       this.preco = preco;
    }
   
    //Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
}
