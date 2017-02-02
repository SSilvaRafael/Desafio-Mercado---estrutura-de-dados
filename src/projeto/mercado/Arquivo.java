package projeto.mercado;

import java.io.FileWriter; 
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.io.IOException;
import java.util.Locale;


public class Arquivo {
    private String texto;
    private String nome;
    private Formatter saida;
    Arquivo(){
        this.nome = "resultado.txt";
    }
    
    
     public void criaArquivo(ListaConfiguracao lista){
         try{
          
            this.saida = new Formatter(this.nome);
            Configuracao aux = lista.getInicio();
            this.saida.format("Resultados:\n");
            while(  aux != null ){
                this.saida.format(aux.infoConfiguracao(texto));
                this.saida.format("\n");
                this.saida.format("\n");
                aux = aux.getProx();
            }
     
             saida.close();
     
         }catch(FileNotFoundException fileNotFoundException){
             System.err.println("Erro ao criar o arquivo." + fileNotFoundException.getMessage());
             System.exit(1);
         }
     
       
     }
    //tentando criar arquivo
   
    
     /*
    public void gravaArquivo(ListaConfiguracao lista){
        try{
        
            criaArquivo();
            //construtor que recebe o objeto do tipo arquivo
            FileWriter fw = new FileWriter(this.nome,false);
            //construtor recebe como argumento o objeto do tipo FileWriter
            BufferedWriter bw = new BufferedWriter( fw );
            Configuracao aux = lista.getInicio();
        
            while(  aux != null ){
                bw.write(aux.infoConfiguracao(texto));
                bw.newLine();
                aux = aux.getProx();
            }
       
        
            bw.close();
            fw.close();
            this.saida.close();
        }catch(IOException iOException){
            System.err.println("Erro ao gravar o arquivo");
            System.exit(1);
        }    
    
    
    }

     
*/     
}
