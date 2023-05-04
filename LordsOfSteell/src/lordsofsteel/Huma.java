
package lordsofsteel;

 //  @author Ricard


public class Huma extends Personatge {
    
    public Huma(int forca, int constitucio, int velocitat,
                int intelligencia, int sort, Arma arma) {

        super(forca,constitucio,velocitat,intelligencia,sort,arma);
        
    }

    @Override
    protected void calculaEstadistiquesSecundaries() {
        super.calculaEstadistiquesSecundaries();
        ps = constitucio + forca + intelligencia;
    }
            
}

