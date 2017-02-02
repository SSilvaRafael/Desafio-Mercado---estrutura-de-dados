package projeto.mercado;


public class FilaCliente {
    
    private Cliente inicio;
    
    public FilaCliente(){
        this.inicio = null;
    }
    
    
    public void add( ){
        
        Cliente aux = this.inicio;
        Cliente ant = null;
        Cliente novo = new Cliente();
        
        while( aux != null){
            ant = aux;
            aux = aux.getProx();
        }
        
        if(ant != null){
            ant.setProx(novo);
           novo.setProx(aux);
        }
        else{
            novo.setProx(this.inicio);
            this.inicio = novo;
        }
        
    }
    /*sobre carga de métodos */
     public void add( Cliente c ){
        
        Cliente aux = this.inicio;
        Cliente ant = null;
        Cliente novo = c ;
        
         
        
        while( aux != null){
            ant = aux;
            aux = aux.getProx();
        }
        
        if(ant != null){
            ant.setProx(novo);
           novo.setProx(aux);
        }
        else{
            novo.setProx(this.inicio);
            this.inicio = novo;
        }
        
    }
    
     
     
      
    public void acrescentaTempoDeEspera(){
        Cliente aux = this.inicio;
        while( aux != null  ){
            aux.aumentaTempoDeEspera();
            aux = aux.getProx();
        }
    }
     
     
      public void remove(){
         if(filaVazia()){
              this.inicio = this.inicio.getProx();
         }
      }
      
     private boolean filaVazia(){
         return this.inicio != null;
     }
    
    public void esvaziaFila(){
        this.inicio = null;
    }
    
    public int contElement(){
        int cont = 0;
        
        Cliente aux = this.inicio;
        
        while(aux != null){
            cont++;
            aux = aux.getProx();
        }
        return cont;
    }

    
    
    public Cliente getInicio() {
        return inicio;
    }

    public void setInicio(Cliente inicio) {
        this.inicio = inicio;
    }

    
    
    
    
    
    
}
