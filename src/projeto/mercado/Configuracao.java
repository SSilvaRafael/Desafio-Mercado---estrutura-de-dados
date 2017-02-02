package projeto.mercado;

public class Configuracao {

    private int horario;
    private double prob;
    
    private double saldo;
    private double lucro;
    private double custo;
    
    private int numeroDeCaixas;
    
    private double mediaDeEspera;
    private int tempoMaximoDeEspera;
    
    private int numeroDeClientesAtendidos;
    private int numeroDeClientesNoCaixa;
    private int numeroDeClientesNaFila;
    private int totalDeClientes;
    
    
    private  Configuracao prox;
    
    Configuracao(int horario, double prob, double saldo, int numeroDeCaixas, double mediaDeEspera, 
     int tempoMaximoDeEspera, int numeroDeClientesAtendido, int numeroDeClienteNoCaixa, int numeroDeClienteNafila){
        
        this.horario = horario;
        this.prob = prob;
        
        this.numeroDeCaixas = numeroDeCaixas;
        
        this.saldo = saldo;
        this.custo = this.numeroDeCaixas * 300.0;
        this.lucro = this.saldo - this.custo;
        
        this.mediaDeEspera = mediaDeEspera;
        this.tempoMaximoDeEspera = tempoMaximoDeEspera;
        
        this.numeroDeClientesAtendidos = numeroDeClientesAtendido;
        this.numeroDeClientesNoCaixa = numeroDeClienteNoCaixa;
        this.numeroDeClientesNaFila  = numeroDeClienteNafila;
        
        this.totalDeClientes = this.numeroDeClientesAtendidos + this.numeroDeClientesNaFila + this.numeroDeClientesNoCaixa;
        
        this.prox = null;
    }

    
    
    
    public void infoConfiguracao(){
        System.out.println( "Horario: " + getHorario()+ " Horas." + " Probabilidade: " + getProb() + "\n" 
        + "Clientes Atendidos: " + getNumeroDeClientesAtendidos() + " Clientes no caixa: " + getNumeroDeClientesNoCaixa() +
        " Clientes na fila: " + getNumeroDeClientesNaFila() +  " Total de clientes: " + getTotalDeClientes() + "\n"         
        + "Numero de Caixas ativo: " + getNumeroDeCaixas() + " Média de espera: " + getMediaDeEspera() + " Tempo máximo de espera: " + getTempoMaximoDeEspera()
        + " Saldo: " + getSaldo() + " Custo: " + getCusto() + " Lucro:" + getLucro() );
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println();
    }  
    
    public String infoConfiguracao(String texto){ // método de sobrecarga usado para mandar os dados para o arquivo. 
        texto = "Horario: " + String.valueOf(getHorario()) + " Horas." + " Probabilidade: " + String.valueOf(getProb()) + "\n" 
        + " Clientes Atendidos: " + String.valueOf(getNumeroDeClientesAtendidos()) + " Clientes no caixa: " + String.valueOf(getNumeroDeClientesNoCaixa()) 
        + " clientes na fila: " + String.valueOf(getNumeroDeClientesNaFila()) +  " Total de clientes: " + String.valueOf(getTotalDeClientes()) + "\n"         
        + " Numero de Caixas ativo: " + String.valueOf(getNumeroDeCaixas()) + " Média de espera: " + String.valueOf(getMediaDeEspera()) + " Tempo máximo de espera: " + getTempoMaximoDeEspera()
        + " Saldo: " + String.valueOf(getSaldo() ) + " Custo: " + String.valueOf(getCusto() ) + " Lucro:" + String.valueOf(getLucro() 
        + "\n" + "-----------------------------------------------------------------------------------------------------------") ;
        
        return texto;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public int getNumeroDeCaixas() {
        return numeroDeCaixas;
    }

    public void setNumeroDeCaixas(int numeroDeCaixas) {
        this.numeroDeCaixas = numeroDeCaixas;
    }

    public double getMediaDeEspera() {
        return mediaDeEspera;
    }

    public void setMediaDeEspera(double mediaDeEspera) {
        this.mediaDeEspera = mediaDeEspera;
    }

    public int getTempoMaximoDeEspera() {
        return tempoMaximoDeEspera;
    }

    public void setTempoMaximoDeEspera(int tempoMaximoDeEspera) {
        this.tempoMaximoDeEspera = tempoMaximoDeEspera;
    }

    public int getNumeroDeClientesAtendidos() {
        return numeroDeClientesAtendidos;
    }

    public void setNumeroDeClientesAtendidos(int numeroDeClientesAtendidos) {
        this.numeroDeClientesAtendidos = numeroDeClientesAtendidos;
    }

    public int getNumeroDeClientesNoCaixa() {
        return numeroDeClientesNoCaixa;
    }

    public void setNumeroDeClientesNoCaixa(int numeroDeClientesNoCaixa) {
        this.numeroDeClientesNoCaixa = numeroDeClientesNoCaixa;
    }

    public int getNumeroDeClientesNaFila() {
        return numeroDeClientesNaFila;
    }

    public void setNumeroDeClientesNaFila(int numeroDeClientesNaFila) {
        this.numeroDeClientesNaFila = numeroDeClientesNaFila;
    }

    public int getTotalDeClientes() {
        return totalDeClientes;
    }

    public void setTotalDeClientes(int totalDeClientes) {
        this.totalDeClientes = totalDeClientes;
    }

    public Configuracao getProx() {
        return prox;
    }

    public void setProx(Configuracao prox) {
        this.prox = prox;
    }

   
    
    
    
    
    
    
    
    
    
    
}
