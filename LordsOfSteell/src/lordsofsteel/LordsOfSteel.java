

package lordsofsteel;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ricard
 */
public class LordsOfSteel {

    static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Personatge normal: pd = (8+5)/4 = 3
        // Nan: pd = (8+6+5)/4 = 4
        // Nan: ps = (8+6) = 14
        //System.out.println("Punts de dany de n1: " + n1.getPd());
        //System.out.println("Punts de salut de n1: " + n1.getPs());
        
        /* Creació de personatges inicials */
        //Arma arma = new Arma("Daga");
        Nan n1 = new Nan("Tirion",8,6, 13,16,16,new Arma("Daga"));        
        Huma h1 = new Huma("Luis",13,16,6,10,6,new Arma("Espasa"));
        Mitja mi1 = new Mitja("Frodo",9,7,7,15,16,new Arma("Martell"));
        Maia ma1 = new Maia("Nil",7,9, 12,15,17,new Arma("Daga"));
        
        /*Personatge[] personatges = new Personatge[4];
        personatges[0] = n1;
        personatges[1] = h1;*/
        ArrayList<Personatge> personatges = new ArrayList<Personatge>();
        personatges.add(n1);
        personatges.add(h1);
        personatges.add(mi1);
        personatges.add(ma1);
                
        
        /* Menú principal */
        System.out.println("");
        System.out.println("** MENÚ PRINCIPAL **");
        System.out.println("1.- Afegir personatge");
        System.out.println("2.- Esborrar personatge");
        System.out.println("3.- Editar personatge");
        System.out.println("4.- Iniciar combat");
        System.out.println("5.- Sortir");
        System.out.println("");
        System.out.print("Tria opció [1-5]: ");
        
        String entrada = sc.nextLine();
        
        
        int opcio = Integer.parseInt(entrada);
        
        switch (opcio) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                iniciarCombat(personatges);
                break;
            case 5:
                break;
        }
        
        
    }
    
    
    public static void iniciarCombat(ArrayList<Personatge> personatges) {
        
        boolean[] seleccionats = new boolean[personatges.size()];
        Personatge[] lluitadors = new Personatge[2];
        for (int selec = 1; selec <= 2; selec++) {
            for (int i = 0; i < personatges.size(); ++i) {
                if (!seleccionats[i]) {
                    String tipus = "";
                    if (personatges.get(i) instanceof Nan)
                        tipus = "Nan";
                    else if (personatges.get(i) instanceof Huma)
                        tipus = "Huma";
                    else if (personatges.get(i) instanceof Mitja)
                        tipus = "Mitja";
                    else if (personatges.get(i) instanceof Maia)
                        tipus = "Maia";

                    System.out.printf("%d %s (%s)\n",(i+1),personatges.get(i).getNom(),
                                                     tipus);
                }            
            }
            System.out.print("\nTria un personatge " + selec + ": ");
            int opcio = sc.nextInt();
            seleccionats[opcio-1] = true;
            lluitadors[selec-1] = personatges.get(opcio-1);
            System.out.println("Personatge triat: " + 
                              personatges.get(opcio-1).getNom());        
        }
        
        
        
        Personatge atacant  = lluitadors[0];
        Personatge defensor = lluitadors[1];
        
        
        Dau dau1 = new Dau();
        Dau dau2 = new Dau();
        Dau dau3 = new Dau();
        
        int valor = dau1.llencar() + dau2.llencar() + dau3.llencar();
        
        
        if (valor <= atacant.getPa()) { // Atacant ataca
            valor = dau1.llencar() + dau2.llencar() + dau3.llencar();
            if (valor > defensor.getPe()) { // No aconsegueix esquivar
                defensor.setPs(defensor.getPs() - atacant.getPd());
            }
        }
        
        
        Personatge aux = atacant;
        atacant  = defensor;
        defensor = aux;
    }
    
}
