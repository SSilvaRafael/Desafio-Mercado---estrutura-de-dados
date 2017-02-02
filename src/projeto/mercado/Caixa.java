package projeto.mercado;

public class Caixa {
    
    
    private Caixa prox;
    private double saldo; // dinheiro do caixa 
    private Cliente cliente;
    
    
    public Caixa(){
        
        this.prox = null;
        this.saldo = 0;
        this.cliente = null;
    }

    public double getSaldo() {
        return saldo;
    }

   
    
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double recebeDinheiro(double saldo){
        this.saldo += saldo;
        return this.saldo;
    }
    
    public void passaItem(){
        this.cliente.getPilha().remover();
    }
   

    public Caixa getProx() {
        return prox;
    }

    public void setProx(Caixa prox) {
        this.prox = prox;
    }

    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    public void recebePrecoItem(Item item){
        this.saldo += item.getPreco();
    }
    
    
    
    
    
    
}
