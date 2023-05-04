
package lordsofsteel;
import java.util.Scanner;

 //  @author Ricard

public class Arma {
    protected String tipus;
    protected int wpow;
    protected int wvel;
        
    public Arma(String tipus) {
        this.tipus = tipus;
        switch (tipus) {
            case "Daga":
                this.wpow  = 5;
                this.wvel  = 15;
                break;
            case "Espasa":
                this.wpow  = 10;
                this.wvel  = 10;
                break;
            case "Martell":
                this.wpow  = 15;
                this.wvel  = 5;
                break;                                
        }
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getWpow() {
        return wpow;
    }

    public void setWpow(int wpow) {
        this.wpow = wpow;
    }

    public int getWvel() {
        return wvel;
    }

    public void setWvel(int wvel) {
        this.wvel = wvel;
    }
    
    
}
