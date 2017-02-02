package projeto.mercado;

import java.util.Random;

public class Horario {
    private int horario;
    private double prob;
    Horario[] tabela;
    
    private Random gerador;
    
    public Horario(){
        this.horario = 0;
        this.prob = 0;
        this.gerador = new Random();
        
        this.tabela = new Horario[7];
        
        this.tabela[0] = new Horario(8,  0.3);
        this.tabela[1] = new Horario(10, 0.4);
        this.tabela[2] = new Horario(12, 0.5);
        this.tabela[3] = new Horario(14, 0.7);
        this.tabela[4] = new Horario(16, 0.9);
        this.tabela[5] = new Horario(18, 0.8);
        this.tabela[6] = new Horario(20, 0.6);
   }

    public Horario(int horario, double prob) {
        this.horario = horario;
        this.prob = prob;
    }

    
    public int calculaProbCliente(){ 
        int na = this.gerador.nextInt(10) + 1;
        return na;
    }

    
    public Horario[] getTabela() {
        return tabela;
    }

    public void setTabela(Horario[] tabela) {
        this.tabela = tabela;
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

    public Random getGerador() {
        return gerador;
    }

    public void setGerador(Random gerador) {
        this.gerador = gerador;
    }
    
    
    
    
    
    }
