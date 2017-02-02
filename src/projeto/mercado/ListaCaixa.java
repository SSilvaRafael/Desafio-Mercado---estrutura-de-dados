package projeto.mercado;


public class ListaCaixa {

    
    private Caixa inicio;
    
    public ListaCaixa(){
        this.inicio = null;
    }
   
    public void addNoComeco(){
        Caixa novo = new Caixa();
        novo.setProx(this.inicio);
        this.inicio = novo;
    }
    
    public void addClienteNoCaixa(FilaCliente fila){ // fila filaDeEspera
        
        Caixa aux = this.inicio;
        
        while( aux != null   ){
            
            if( aux.getCliente() != null ){
                aux = aux.getProx();
            } else {
                aux.setCliente(fila.getInicio());// recebe primeiro elemento da fila de 
                fila.remove();
                aux = aux.getProx();
            }
        }
    }
    
    public FilaCliente removeClienteDoCaixa(){
       FilaCliente fila = new FilaCliente();
       
       Caixa aux = this.inicio;
       
        while( aux != null){
            if( aux.getCliente() != null){
                if ( aux.getCliente().getPilha().getInicio() != null){
                }
                else{
                    fila.add(); // adicionar clientes que já foram atendidos no caixas para filadePessoasAtendidas.
                    aux.setCliente(null);
                }
           }
           aux = aux.getProx();
       }
       return fila;
    }
  
   
    public double somaSaldo(){
        Caixa aux = this.inicio;
        double saldo = 0;
        while( aux != null ){
            saldo += aux.getSaldo();
            aux = aux.getProx();
        }
        return saldo;
    }
    
   public double calculaCustoCaixa(){
       double custo = contElementos() * 300.0;
       return custo;
   } 
    
    
    
  public void retiraItensTopo(){ /*método que passa os itens do topo de cada cliente que esta na lista de caixas */
      Caixa aux = this.inicio;
      
      while( aux != null){
          if(aux.getCliente() != null){
                if( aux.getCliente().getPilha().getInicio() != null){
                    aux.recebeDinheiro(aux.getCliente().getPilha().precoTopo());
                    aux.passaItem();
                }    
          } 
          aux = aux.getProx();
      }
  }
    
    
    public void esvaziaLista(){ // método que retira todos os caixas adicionados
        this.inicio = null;
    }
    
    
    public int contElementos(){
        Caixa aux = this.inicio;
        int cont = 0;
        
        while( aux != null   ){
            cont++;
            aux = aux.getProx();
        }
        
        return cont;
    }
    
    
    public void imprimirObjetosClientesListaCaixa(){
        Cliente aux = this.inicio.getCliente();
        
        while(  aux != null ){
            System.out.println(aux);
            aux = aux.getProx();
        }
        
        
    }
    
    public boolean verificaCaixaVazio(Caixa c){
        return c.getCliente() !=  null;
    }
    
    
    
    
    
    
    public Caixa getInicio() {
        return inicio;
    }

    public void setInicio(Caixa inicio) {
        this.inicio = inicio;
    }
    
    
}
