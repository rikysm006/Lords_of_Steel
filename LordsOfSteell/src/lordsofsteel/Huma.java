
package lordsofsteel;

 //  @author Ricard


public class Huma extends Personatge {
    
    public Huma(String nom,int forca, int constitucio, int velocitat,
                int inteligencia, int sort, Arma arma) {

        super(nom,forca,constitucio,velocitat,inteligencia,sort,arma);
        
    }

    
    protected void calculaEstadistiquesSecundaries() {
        super.calculaEstadistiquesSecundaries();
        ps = constitucio + forca + inteligencia;
    }
    
    @Override
    public String mostraNomTipus(){
        return("Huma");
    }
}
