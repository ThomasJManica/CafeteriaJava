package DTOs;

public class ProdutosDTO {
    public Integer id;
    public String descricao;
    public Integer preco;
    
    @Override
    public String toString(){
        return descricao;
    }
}
