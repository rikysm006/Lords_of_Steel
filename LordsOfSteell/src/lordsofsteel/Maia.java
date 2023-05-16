
package lordsofsteel;

 //  @author Ricard

public class Maia extends Personatge {

    public Maia(String nom,int forca, int constitucio, int velocitat,
                int inteligencia, int sort, Arma arma) {

        super(nom,forca,constitucio,velocitat,inteligencia,sort,arma);
    }

    @Override
    protected void calculaEstadistiquesSecundaries() {
        super.calculaEstadistiquesSecundaries();
        pa = inteligencia + sort + arma.wvel + velocitat;
    }
    
    @Override
    public String mostraNomTipus(){
        return("Maia");
    } 
    
}

