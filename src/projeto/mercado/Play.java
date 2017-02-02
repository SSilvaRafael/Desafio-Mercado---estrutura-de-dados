package projeto.mercado;

public final class Play {
    
    private final FilaCliente filaDeClientesAtendidos;
    private final FilaCliente filaDeEspera;
    private final Horario quadroDeHorario;
    private final ListaCaixa listaDeCaixas;
    private final ListaConfiguracao listaDeConfiguracoes; 
    private ListaConfiguracao resultado;
    private final Arquivo arquivo;
     
    
    
    public Play(){
        this.filaDeClientesAtendidos = new FilaCliente();
        this.filaDeEspera = new FilaCliente();
        this.quadroDeHorario = new Horario();
        this.listaDeCaixas = new ListaCaixa();
        this.listaDeConfiguracoes = new ListaConfiguracao();
        this.resultado = null;
        this.arquivo = new Arquivo();
        playStart();
        
    }
    
    
    
    private void playStart(){ // método principal que roda a app.
        try{
       
            for(int i = 0; i < 7; i++) { 
                for(int j = 5 ; j <= 20; j++){
                    instanciarCaixas(j); // instacia j caixas de 5 a 20
                    for(int k = 1; k <= 120; k++){
                        simulaRodada(i);
                       }
                    verificarConfiguracao(i,j); // se a configuração respeitar o pré-requisitos ela é add na lista.
                    esvaziarFilasListas();
                }  
            }
            
           buscaResultado(); // busca as melhores configurações para cada horário
           escritaDeArquivo(this.resultado); // escrevar os resultados no arquivo.
        } catch(UnsupportedOperationException e){
             System.err.println("Erro ao criar a lista de caixas");
             System.exit(1);
        }
   }
    
    
    
    
    
    private void instanciarCaixas(int j){ // método que inicializa lista com número de 5 a 20 de caixas
        for( int i = 1; i <= j; i++ ){
            try{
                this.listaDeCaixas.addNoComeco();
            }catch( java.lang.NullPointerException nullPointerException){
                System.err.println(nullPointerException.getMessage());
                System.exit(1);
            }
            
        }
    }
    
    
    
    
    private void simulaRodada(int i){ // método que simula a cada minuto entrada o fluxo de clientes.
        addClientesNaFilaDeEspera(i);
        addNaFilaClientesAtendidos();
        addClientesNoCaixa();
        removeItensCliente();
        acrescentaTempoDeEspera();
    }
    
    
    
    /*métodos de inserção e remoção */
      
    
    private void addNaFilaClientesAtendidos(){ /* método que adiciona clientes que já foram atendidos no 
    caixa,  para fila clienteAtendidos */
      FilaCliente fila = removeClientesDoCaixa();
      Cliente aux = fila.getInicio(); 
    
      while( aux != null){
          this.filaDeClientesAtendidos.add(aux);
          aux = aux.getProx();
      }
    }
    
    
    private FilaCliente removeClientesDoCaixa(){/*Método que remove os clientes que terminaram o atendimento ao caixa*/ 
        return this.listaDeCaixas.removeClienteDoCaixa(); // método retorna um fila com os clientes que acabaram de
        // sair do caixa.
    }

   private void addClientesNoCaixa(){ /* método que recebe filaClientesNaoAtendidos e envia para o caixa caso o caixa 
       esteja livre */
       this.listaDeCaixas.addClienteNoCaixa(filaDeEspera);
   }
        
    
   private void addClientesNaFilaDeEspera( int i){/*  Método responsavel por adicionar clientes na fila de espera
       dependendo da probabilidade do horario e o número randomico.
       */
       probClienteEntraNaFila( i  );
   } 
    
   private void removeItensCliente(){ /*remove itens que estão no topo da pilha de cada cliente da lista de caixa 
   */
       this.listaDeCaixas.retiraItensTopo(); // método também recebe o valor do topp
   }
   
   
   
   
   
   
   private void acrescentaTempoDeEspera(){ // método que acrescente + 1 ao tempo de espera dos clientes da fila
       this.filaDeEspera.acrescentaTempoDeEspera();
   }
           
   private void probClienteEntraNaFila(int i  ){ // adiciona cliente na fila dependendo da prob
        int numeroAleatorio = this.quadroDeHorario.calculaProbCliente(); // número de 1 a 10.
        int numeroProb = (int) (this.quadroDeHorario.tabela[i].getProb() * 10); // recebe a probilidade * 10
        if( numeroAleatorio <= numeroProb ){
            this.filaDeEspera.add();
        }
    }
    

   
   
        /* métodos para verificar configuração */
   
   
   private void buscaResultado(){
        this.resultado = this.listaDeConfiguracoes.buscaResultados();
        this.resultado.imprimi();
   }
    
    
    
    private void verificarConfiguracao(int i, int j){ // método responsavel pela verificação se a configuração atinge os pre requisitos
            if( verificaTempoDeEspera()){
                this.listaDeConfiguracoes.add(this.quadroDeHorario.tabela[i].getHorario(), this.quadroDeHorario.tabela[i].getProb()
              , somaSaldo(), j, calculaMediaDeEspera(), tempoMaximoDeEspera(), contFilaDeClientesAtendidos(), contListaCaixa(), contFilaDeEspera());
            }
    }
    
    
    private boolean verificaTempoDeEspera(){/* método verifica o tempo de espera de cada cliente teve na fila.*/
        Cliente aux = this.filaDeClientesAtendidos.getInicio();
        Cliente auxb = this.filaDeEspera.getInicio();
        Caixa   cx = this.listaDeCaixas.getInicio();
        
        while( aux != null){ // verifica  o tempo de espera dos clientes na fila de atendidos
            if(  aux.getTempoDeEspera() >= 10 ){
                return false;
            }
             aux = aux.getProx();
        }
        
        while( auxb != null){// verifica  o tempo de espera dos clientes nos caixas
            if(  auxb.getTempoDeEspera() >= 10 ){
                return false;
            }
             auxb = auxb.getProx();
        }
        
        
        
        
        while( cx != null  ){
           if( cx.getCliente() != null  ){ // verifica  o tempo de espera dos clientes na fila de espera
                if(  cx.getCliente().getTempoDeEspera() >= 10 ){
                  return false;
                }
           }
           cx = cx.getProx();
        }
        
        
        return true;
    }
    
    
    private double somaSaldo(){ // método que retorna a soma dos saldo dos caixas;
        return this.listaDeCaixas.somaSaldo();
    }
    
   
    
    private int calculaNumeroTotalDeClientes(){ // retorna o tatal de clientes de cada configuração
        Cliente aux1 = this.filaDeClientesAtendidos.getInicio();
        Cliente aux2 = this.filaDeEspera.getInicio();
        Cliente aux3 = this.listaDeCaixas.getInicio().getCliente();
        int cont = 0;
        
        while(aux1 != null){
            cont++;
            aux1 = aux1.getProx();
        }
        
         
        while(aux2 != null){
            cont++;
            aux2 = aux2.getProx();
        }
    
         
        while(aux3 != null){
            cont++;
            aux3 = aux3.getProx();
        }
        return cont;
    }
    
    
    
    private int tempoMaximoDeEspera(){
         int max = 0;
        
        
        Cliente aux1 = this.filaDeClientesAtendidos.getInicio();
        Cliente aux2 = this.filaDeEspera.getInicio();
        Cliente aux3 = this.listaDeCaixas.getInicio().getCliente();
        
        while( aux1 != null  ){
            if(   max < aux1.getTempoDeEspera()   ){
                max = aux1.getTempoDeEspera();
            }
            
            aux1 = aux1.getProx();
        }
        while( aux2 != null  ){
             if(   max < aux2.getTempoDeEspera()   ){
                max = aux2.getTempoDeEspera();
             }
            aux2 = aux2.getProx();
        }
        while( aux3 != null  ){
             if(   max < aux3.getTempoDeEspera()   ){
                max = aux3.getTempoDeEspera();
            }
            aux3 = aux3.getProx();
        }
    
        return max;
    
    }   
    
    
    
    
    
    
    private double calculaMediaDeEspera(){ // método caucula a média de espera dos clientes.
        
        int totalDeEspera = 0;
        
        
        Cliente aux1 = this.filaDeClientesAtendidos.getInicio();
        Cliente aux2 = this.filaDeEspera.getInicio();
        Cliente aux3 = this.listaDeCaixas.getInicio().getCliente();
        
        while( aux1 != null  ){
            totalDeEspera += aux1.getTempoDeEspera();
            aux1 = aux1.getProx();
        }
        while( aux2 != null  ){
            totalDeEspera += aux2.getTempoDeEspera();
            aux2 = aux2.getProx();
        }
        while( aux3 != null  ){
            totalDeEspera += aux3.getTempoDeEspera();
            aux3 = aux3.getProx();
        }
        
        
        return totalDeEspera / calculaNumeroTotalDeClientes();
        
    }
    
   
    
    
    
                        /*método de arquivo */
    
   
    private void escritaDeArquivo(ListaConfiguracao lista){
          this.arquivo.criaArquivo(lista);
    }
    
    
    
    
                    /*métodos para esvaziar as estrutura elementares */
    
   
    
    private void esvaziarFilasListas(){
        esvaziaClientesAtendidos();
        esvaziaFilaDeEspera();
        esvaziaListaCaixa();
    }
    
    private void esvaziaClientesAtendidos(){
        this.filaDeClientesAtendidos.esvaziaFila();
    }
    
    private void esvaziaFilaDeEspera(){
        this.filaDeEspera.esvaziaFila();
    }
    
    private void esvaziaListaCaixa(){
        this.listaDeCaixas.esvaziaLista();
    }
      
   
    
    
    
                   /* Métodos de contagens */
    
    
     private int contFilaDeClientesAtendidos(){
        return this.filaDeClientesAtendidos.contElement();
    }
    
    private int contFilaDeEspera(){
        return this.filaDeEspera.contElement();
    }
    
    private int contListaCaixa(){
        return this.listaDeCaixas.contElementos();
    }

    private void contNumeroDeItensDaCompra(){
        Cliente aux = this.listaDeCaixas.getInicio().getCliente();
        System.out.println("Numero de Itens dos cliente do caixa:");
        System.out.println();
        while( aux != null){
            System.out.println(aux.getPilha().getNumeroItens());
            aux = aux.getProx();
        }
    }

}   
    
   









