
package lordsofsteel;

 //  @author Ricard

public class Mitja extends Personatge {
    
    public Mitja(int forca, int constitucio, int velocitat,
                 int intelligencia, int sort, Arma arma) {

        super(forca,constitucio,velocitat,intelligencia,sort,arma);
    }
    

    @Override
    protected void calculaEstadistiquesSecundaries() {
        super.calculaEstadistiquesSecundaries();
        pe = velocitat+ sort + intelligencia + forca;
    }

}

