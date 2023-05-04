
package lordsofsteel;

 //  @author Ricard

public class Maia extends Personatge {

    public Maia(int forca, int constitucio, int velocitat,
                int intelligencia, int sort, Arma arma) {

        super(forca,constitucio,velocitat,intelligencia,sort,arma);
    }

    @Override
    protected void calculaEstadistiquesSecundaries() {
        super.calculaEstadistiquesSecundaries();
        pa = intelligencia + sort + arma.wvel + velocitat;
    }
    
}

