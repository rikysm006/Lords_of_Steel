

package lordsofsteel;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ricard
 */
public class LordsOfSteel {

    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        Nan n1 = new Nan("Tirion",8,6, 13,16,16,new Arma("Daga"));        
        Huma h1 = new Huma("Luis",13,16,6,10,6,new Arma("Espasa"));
        Mitja mi1 = new Mitja("Frodo",9,7,7,15,16,new Arma("Martell"));
        Maia ma1 = new Maia("Nil",7,9, 12,15,17,new Arma("Daga"));
        
        ArrayList<Personatge> personatges = new ArrayList<Personatge>();
        personatges.add(n1);
        personatges.add(h1);
        personatges.add(mi1);
        personatges.add(ma1);
        
        public static void mostraPj(ArrayList<Personatge> personatges) {
        for (int i = 0; i < personatges.size(); i++) {
            System.out.println((i + 1) + ".-" + personatges.get(i).getNom());
        }
    }
        
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
                        addPj(personatges);
                        break;
                    case 2:
                        deletePj(personatges);
                        break;
                    case 3:
                        editPj(personatges);
                        break;
                    case 4:
                        iniciarCombat(personatges);
                        break;
                    case 5:
                        System.out.println("¡Gracies per jugar!");
                        break;
                    default:
                        break;
                }
        
        
    }
    public static void addPj (ArrayList<Personatge> personatge){
        System.out.println("* Afegir personatge *");
        System.out.println("");
        System.out.println("Has de repartir 60 punts per les habilitats, " + "totes les habilitates han de tenir minim 3 punts i maxim 18 punts");
        System.out.println("");
        
        
         Scanner sc = new Scanner(System.in);

        System.out.print("Nom: ");
        String nom = sc.next();
        System.out.print("Tipus [Huma, Maia, Mitja, Nan]:");
        String tipus = sc.next();

        System.out.print("Força: ");
        int forca = Integer.parseInt(sc.next());

        System.out.print("Consistencia: ");
        int constitucio = Integer.parseInt(sc.next());

        System.out.print("Velocitat: ");
        int velocitat = Integer.parseInt(sc.next());

        System.out.print("Inteligencia: ");
        int inteligencia = Integer.parseInt(sc.next());

        System.out.print("Sort: ");
        int sort = Integer.parseInt(sc.next());

        System.out.print("Arma [Daga,Espasa,Martell]:");
        String arma = sc.next();


        Personatge nou = null;
        tipus= tipus.toLowerCase();
            if (forca+constitucio+velocitat+inteligencia+sort<=60) {
                if (tipus.equals("huma")) {
                nou = new Huma(nom.toLowerCase(), forca, constitucio, velocitat, inteligencia, sort, new Arma(arma.toLowerCase()));
            } else if (tipus.equals("mitja")) {
                nou = new Mitja(nom.toLowerCase(), forca, constitucio, velocitat, inteligencia, sort, new Arma(arma.toLowerCase()));
            } else if (tipus.equals("nan")) {
                nou = new Nan(nom.toLowerCase(), forca, constitucio, velocitat, inteligencia, sort, new Arma(arma.toLowerCase()));
            } else if (tipus.equals("maia")) {
                nou = new Maia(nom.toLowerCase(), forca, constitucio, velocitat, inteligencia, sort, new Arma(arma.toLowerCase()));
            }

            personatges.add(nou);
            mostraPj(personatges);
            System.out.println("Personatge afegit amb èxit!");
        } else {
                System.out.println("Els punts maxim per el personatge nou son 60 punts");
            }
        
    }
    
    public static void deletePj(ArrayList<Personatge> personatge){
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Personatges existens");
        mostraPj(personatge);
        System.out.println("Quin personatge vols esborrar?");
        int selecciona = sc.nextInt();
        personatges.remove(tria - 1);
        mostraPj(personatge);
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
            System.out.println("Personatge triat: " +personatges.get(opcio-1).getNom());
            System.out.print("Escull la devocio del personatge [Caos / Ordre]: ");
            String devocio = sc.next();
            }
        
        
        
        Personatge atacant  = lluitadors[0];
        Personatge defensor = lluitadors[1];
        
        
        Dau dau1 = new Dau();
        Dau dau2 = new Dau();
        Dau dau3 = new Dau();
        
        int valor = dau1.llencar() + dau2.llencar() + dau3.llencar();
        
        
        if (valor <= atacant.getPa()) { 
            valor = dau1.llencar() + dau2.llencar() + dau3.llencar();
            if (valor > defensor.getPe()) { 
                defensor.setPs(defensor.getPs() - atacant.getPd());
            }
        }
        
        
        Personatge aux = atacant;
        atacant  = defensor;
        defensor = aux;
    }
    
}
