package projeto.mercado;

import java.util.Random;


public class Item {

    private double preco;
    private Random gerador;
    private Item prox;
   
    
    public Item(){
        gerador = new Random();
        this.preco = gerador.nextInt( 46 ) + 5; // valores de 5 a 50
        
    }
    
    
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Item getProx() {
        return prox;
    }

    public void setProx(Item prox) {
        this.prox = prox;
    }

    public Random getGerador() {
        return gerador;
    }

    public void setGerador(Random gerador) {
        this.gerador = gerador;
    }

    
    
    
    
    
    
    
}
