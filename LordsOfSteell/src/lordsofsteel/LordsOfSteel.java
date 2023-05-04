

package lordsofsteel;


import java.util.ArrayList;

/**
 *
 * @author ricard
 */
public class LordsOfSteel {
 static void main(String[] args) {
        
        Nan n1 = new Nan(8,6, 13,16,16,new Arma("Daga"));        
        Huma h1 = new Huma(13,16,6,10,6,new Arma("Espasa"));
        Mitja mi1 = new Mitja(9,7,7,15,16,new Arma("Martell"));
        Maia ma1 = new Maia(7,9, 12,15,17,new Arma("Daga"));
        
        ArrayList<Personatge> personatges = new ArrayList<Personatge>();
        personatges.add(n1);
        personatges.add(h1);
        personatges.add(mi1);
        personatges.add(ma1);
        
    }
    
}
