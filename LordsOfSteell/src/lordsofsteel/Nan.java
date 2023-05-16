
package lordsofsteel;

 //  @author Ricard

public class Nan extends Personatge {
    
    public Nan(String nom,int forca, int constitucio, int velocitat,
               int intelligencia, int sort, Arma arma) {

        super(nom,forca,constitucio,velocitat,intelligencia,sort,arma);
    }

    @Override
    protected void calculaEstadistiquesSecundaries() {
        super.calculaEstadistiquesSecundaries();
        pd = (forca + arma.getWpow() + constitucio)/4;
    }
    
    
    
    
    @Override
    public String mostraNomTipus(){
        return("Nan");
    }    
}
