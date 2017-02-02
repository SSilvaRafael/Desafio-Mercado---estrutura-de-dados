package projeto.mercado;
import java.util.Random;

public final class PilhaCompras {
    
    private Item inicio;
    private final Random gerador;
    private int numeroItens;
    
    public PilhaCompras(){
        this.gerador = new Random();
        this.numeroItens = this.gerador.nextInt( 36 ) + 5;
        addAleatoriamente();
    }
    
    
    
    public void addAleatoriamente(){
        for( int i = 1; i <= this.numeroItens; i++ ){
           add(); 
        }
    }
    
    
    
    private void add(   ){
        Item novo = new Item();
    
        Item aux = this.inicio;
        Item ant = null;
        
        
        while( aux != null ){
            ant = aux;
            aux = aux.getProx();
        }
    
        if( ant != null ){
            ant.setProx(novo);
            novo.setProx(null);
        }
        else{
            novo.setProx(this.inicio);
            this.inicio = novo;
        }
        
    }
    
    
    
    
    public void remover(){
        
        Item aux = this.inicio;
        Item ant = null;
        
        while(   aux.getProx() != null   ){
            ant = aux;
            aux = aux.getProx();
        }
    
       if( ant != null){
           ant.setProx(null);
       }
       else{
           this.inicio = null;
       }
        this.numeroItens--;
   }
    
    public void mostrarPilha(){
        try{
            System.out.println("números de itens:"  + this.numeroItens );
            Item aux = this.inicio;
        
            while( aux != null   ){
             System.out.println(aux.getPreco());
             aux = aux.getProx();
            }
        }catch(NullPointerException  nullPointerException){
        }    
    }
    
    
    
    
    public double precoTopo(){// retorna o preço do ultimo Item
        Item aux = this.inicio;
        Item ant = null;
     
        while( aux != null       ){
            ant = aux;
            aux = aux.getProx();
        }
    
        if(  ant != null  ){
            return ant.getPreco();
        }    
        
            return this.inicio.getPreco();
   }
    

    
    
    
    
    
    
    
    public Item getInicio() {
        return inicio;
    }

    public void setInicio(Item inicio) {
        this.inicio = inicio;
    }

    public  int getNumeroItens() {
        return numeroItens;
    }

    public  void setNumeroItens(int numero) {
        this.numeroItens = numero;
    }

   
    
    
    
    
    
    
    
}
