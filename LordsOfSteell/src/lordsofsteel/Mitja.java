
package lordsofsteel;

 //  @author Ricard

public class Mitja extends Personatge {
    
    public Mitja(String nom,int forca, int constitucio, int velocitat,
                 int inteligencia, int sort, Arma arma) {

        super(nom,forca,constitucio,velocitat,inteligencia,sort,arma);
    }
    

    @Override
    protected void calculaEstadistiquesSecundaries() {
        super.calculaEstadistiquesSecundaries();
        pe = velocitat+ sort + inteligencia + forca;
    }
    
    @Override
    public String mostraNomTipus(){
        return("Mitja");
    } 
}


