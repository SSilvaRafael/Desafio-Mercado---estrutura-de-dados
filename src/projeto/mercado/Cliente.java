package projeto.mercado;


public class Cliente {

    private PilhaCompras pilha;
    private Cliente prox;
    private int tempoDeEspera;
    
    public Cliente(){
      this.pilha = new PilhaCompras();   
      this.prox = null;
      this.tempoDeEspera = 0;
    }
    
    
   
    
    public void excluiPilha(){
        this.pilha = null;
    }
    
    public void mostraPilha(){
        
            this.pilha.mostrarPilha();
        
    }
    
    
    public int aumentaTempoDeEspera(){
        this.tempoDeEspera++;
        return this.tempoDeEspera;
    }
    
    
    
    public int getTempoDeEspera() {
        return tempoDeEspera;
    }

    public void setTempoDeEspera(int tempoDeEspera) {
        this.tempoDeEspera = tempoDeEspera;
    }

    public PilhaCompras getPilha() {
        return pilha;
    }

    public void setPilha(PilhaCompras pilha) {
        this.pilha = pilha;
    }

    public Cliente getProx() {
        return prox;
    }

    public void setProx(Cliente prox) {
        this.prox = prox;
    }
    
    
    
}
