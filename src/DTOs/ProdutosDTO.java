package DTOs;

public class ProdutosDTO {
    public int id;
    public String descricao;
    public int preco;
    
    @Override
    public String toString(){
        return descricao;
    }
}
