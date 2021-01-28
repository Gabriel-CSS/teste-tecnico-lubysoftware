package maquinadevenda;

public class Bebida {
    
    private int bebida_id;
    private String bebida_nome;
    private double bebida_preco;
    private int bebida_estoque;
    
    public Bebida(int id, String nome, double preco, int estoque){
        this.bebida_id = id;
        this.bebida_nome = nome;
        this.bebida_preco = preco;
        this.bebida_estoque = estoque;
    }
    
    public Bebida(int id){
        this.bebida_id = id;
    }
    
    public Bebida(){}
    
    //Métodos gets e sets (somente os necessários)
    public int getID(){
        return this.bebida_id;
    }
    
    public String getNome(){
        return this.bebida_nome;
    }
    
    public double getPreco(){
        return this.bebida_preco;
    }
    
    public int getEstoque(){
        return this.bebida_estoque;
    }
    
    public void alteraEstoque(){
        this.bebida_estoque--;
    }
    
}
