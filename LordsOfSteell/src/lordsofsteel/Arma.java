
package lordsofsteel;
import java.util.Scanner;

 //  @author Ricard

public class Arma {
    protected String tipus;
    protected int WPOW;
    protected int WVEl;
    
    public Arma (String tipus, int WPOW, int WVEL){
        this.tipus = tipus;
        this.WPOW = WPOW;
        this.WVEl = WVEL;
    
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getWPOW() {
        return WPOW;
    }

    public void setWPOW(int WPOW) {
        this.WPOW = WPOW;
    }

    public int getWVEl() {
        return WVEl;
    }

    public void setWVEl(int WVEl) {
        this.WVEl = WVEl;
    }
}
