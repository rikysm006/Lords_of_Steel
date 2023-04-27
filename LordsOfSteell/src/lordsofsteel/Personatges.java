
package lordsofsteel;
import java.util.Scanner;

 //  @author Ricard

public class Personatges {
    // Atributs principals
    protected String NOM;
    protected Categoria categoria;
    protected Arma arma;
    protected int exp;
    protected int nivell;
    
    protected int FOR;
    protected int CON;
    protected int VEL;
    protected int INT;
    protected int SOR;
    
    protected int PS;
    protected int PD;
    protected int PA;
    protected int PE;       
    
    public Personatges(int FOR, int CON, int VEL, int SOR, Arma arma){
    this.FOR = FOR;
    this.CON = CON;
    this.VEL = VEL;
    this.SOR = SOR;
    this.arma = arma;
    calculaEstadistiquesDerivades();
    }
    protected void calculaEstadistiquesDerivades() {
        PS = CON + FOR;
        PD = FOR+arma.WPOW/4;
        PA = INT + SOR + arma.WVEl;
        PE = VEL + SOR + INT;
    }
}
