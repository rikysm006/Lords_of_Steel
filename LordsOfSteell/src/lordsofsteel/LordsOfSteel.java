

package lordsofsteel;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ricard
 */
public class LordsOfSteel {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Personatge> personatges = new ArrayList<Personatge>();

    public static void main(String[] args) {

        Nan n1 = new Nan("Tirion", 8, 6, 13, 16, 16, new Arma("Daga"));
        Huma h1 = new Huma("Luis", 13, 16, 6, 10, 6, new Arma("Espasa"));
        Mitja mi1 = new Mitja("Frodo", 9, 7, 7, 15, 16, new Arma("Martell"));
        Maia ma1 = new Maia("Nil", 7, 9, 12, 15, 17, new Arma("Daga"));

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
                addPj();
                break;
            case 2:
                deletePj();
                break;
            case 3:
                editPj();
                break;
            case 4:
                iniciarCombat(personatges);
                break;
            case 5:
                System.out.println("¡Gracias por jugar!");
                break;
            default:
                break;
        }
    }

    public static void mostraPj() {
        for (int i = 0; i < personatges.size(); i++) {
            System.out.println((i + 1) + ".-" + personatges.get(i).getNom());
        }
    }
    public static void addPj() {
        System.out.println("* Afegir personatge *");
        System.out.println("");
        System.out.println("Has de repartir 60 punts per les habilitats, totes les habilitats han de tenir mínim 3 punts i màxim 18 punts");
        System.out.println("");

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
        switch (tipus) {
        case "huma":
            nou = new Huma(nom, forca, constitucio, velocitat, inteligencia, sort, new Arma(arma));
            break;
        case "maia":
            nou = new Maia(nom, forca, constitucio, velocitat, inteligencia, sort, new Arma(arma));
            break;
        case "mitja":
            nou = new Mitja(nom, forca, constitucio, velocitat, inteligencia, sort, new Arma(arma));
            break;
        case "nan":
            nou = new Nan(nom, forca, constitucio, velocitat, inteligencia, sort, new Arma(arma));
            break;
        default:
            System.out.println("Tipus de personatge no vàlid.");
            break;
    }

    if (nou != null) {
        personatges.add(nou);
        System.out.println("Personatge afegit amb èxit!");
    }
}
    
    public static void deletePj() {
        System.out.println("* Esborrar personatge *");
        System.out.println("");
        mostraPj();
        System.out.println("");
        System.out.print("Selecciona personatge a esborrar [1-" + personatges.size() + "]: ");
        int selecciona = Integer.parseInt(sc.next());
        if (selecciona > 0 && selecciona <= personatges.size()) {
            personatges.remove(selecciona - 1);
            System.out.println("Personatge esborrat amb èxit!");
        } else {
            System.out.println("Opció incorrecta.");
    }
}
    
    public static void editPj() {
    System.out.println("* Editar personatge *");
    System.out.println("");
    mostraPj();
    System.out.println("");
    System.out.print("Selecciona personatge a editar [1-" + personatges.size() + "]: ");
    int opcio = Integer.parseInt(sc.next());
    if (opcio > 0 && opcio <= personatges.size()) {
        Personatge personatge = personatges.get(opcio - 1);

        System.out.print("Força (" + personatge.getForca() + "): ");
        int forca = Integer.parseInt(sc.next());

        System.out.print("Consistencia (" + personatge.getConstitucio() + "): ");
        int constitucio = Integer.parseInt(sc.next());

        System.out.print("Velocitat (" + personatge.getVelocitat() + "): ");
        int velocitat = Integer.parseInt(sc.next());

        System.out.print("Inteligencia (" + personatge.getInteligencia() + "): ");
        int inteligencia = Integer.parseInt(sc.next());

        System.out.print("Sort (" + personatge.getSort() + "): ");
        int sort = Integer.parseInt(sc.next());

        System.out.print("Arma (" + personatge.getArma().getTipus() + "): ");
        String arma = sc.next();

        if (forca + constitucio + velocitat + inteligencia + sort <= 60) {
            personatge.setForca(forca);
            personatge.setConstitucio(constitucio);
            personatge.setVelocitat(velocitat);
            personatge.setInteligencia(inteligencia);
            personatge.setSort(sort);
            personatge.getArma().setTipus(arma);
            System.out.println("Personatge editat amb èxit!");
        } else {
            System.out.println("No es pot editar, la suma de les habilitats és superior a 60.");}
        } else {System.out.println("Opció incorrecta.");}
    }
    
    
    public static void iniciarCombat(ArrayList<Personatge> personatge) {
        Scanner sc = new Scanner(System.in);
        boolean[] PjA = new boolean[personatge.size()];
        Personatge[] lluitadors = new Personatge[2];
        for (int i = 1; i <= 2; i++) {
            for (int j = 0; j < personatge.size(); j++) {
                if (!PjA[j]) {
                    String tipus = "";
                    if (personatge.get(j) instanceof Nan) {
                        tipus = "Nan";
                    } else if (personatge.get(j) instanceof Huma) {
                        tipus = "Humà";
                    } else if (personatge.get(j) instanceof Mitja) {
                        tipus = "Mitjà";
                    } else if (personatge.get(j) instanceof Maia) {
                        tipus = "Maia";
                    }

                    System.out.println((j + 1) + ".- " + personatges.get(j).getNom() + "(" + tipus + ")");
                }
            }System.out.print("Tria un personatge " + i + ": ");
            int opcio = sc.nextInt();
            PjA[opcio - 1] = true;
            
            System.out.println("Personatge triat: " + personatges.get(opcio - 1).getNom());
            System.out.print("Escull la devocio del personatge [Caos / Ordre]: ");
            String devocio = sc.next();
            if (devocio.toLowerCase().equals("ordre")) {
                switch (personatges.get(opcio - 1).mostraNomTipus()){
                    case "Nan":
                            NanOrdre NO1 = new NanOrdre(personatges.get(opcio - 1).getNom(), personatges.get(opcio - 1).getForca(), personatges.get(opcio - 1).getConstitucio(), personatges.get(opcio - 1).getVelocitat(), personatges.get(opcio - 1).getInteligencia(), personatges.get(opcio - 1).getSort(),personatges.get(opcio - 1).getArma());
                            lluitadors[i - 1] = NO1;
                            break;
                    case "Humà":
                            HumaOrdre HO1 = new HumaOrdre(personatges.get(opcio - 1).getNom(), personatges.get(opcio - 1).getForca(), personatges.get(opcio - 1).getConstitucio(), personatges.get(opcio - 1).getVelocitat(), personatges.get(opcio - 1).getInteligencia(), personatges.get(opcio - 1).getSort(),personatges.get(opcio - 1).getArma());
                            lluitadors[i - 1] = HO1;
                            break;
                    case "Mitjà":
                            MitjaOrdre MO1 = new MitjaOrdre(personatges.get(opcio - 1).getNom(), personatges.get(opcio - 1).getForca(), personatges.get(opcio - 1).getConstitucio(), personatges.get(opcio - 1).getVelocitat(), personatges.get(opcio - 1).getInteligencia(), personatges.get(opcio - 1).getSort(),personatges.get(opcio - 1).getArma());
                            lluitadors[i - 1] = MO1;
                            break;
                    case "Maia":
                            MaiaOrdre MaO1 = new MaiaOrdre(personatges.get(opcio - 1).getNom(), personatges.get(opcio - 1).getForca(), personatges.get(opcio - 1).getConstitucio(), personatges.get(opcio - 1).getVelocitat(), personatges.get(opcio - 1).getInteligencia(), personatges.get(opcio - 1).getSort(),personatges.get(opcio - 1).getArma());
                            lluitadors[i - 1] = MaO1;                       
                            break;
                    default:
                            break;
                }
            } else if (devocio.toLowerCase().equals("caos")) {
                  switch (personatges.get(opcio - 1).mostraNomTipus()){
                    case "Nan":
                            NanCaos NC1 = new NanCaos(personatges.get(opcio - 1).getNom(), personatges.get(opcio - 1).getForca(), personatges.get(opcio - 1).getConstitucio(), personatges.get(opcio - 1).getVelocitat(), personatges.get(opcio - 1).getInteligencia(), personatges.get(opcio - 1).getSort(),personatges.get(opcio - 1).getArma());
                            lluitadors[i - 1] = NC1;
                            break;
                    case "Humà":
                            HumaCaos HC1 = new HumaCaos(personatges.get(opcio - 1).getNom(), personatges.get(opcio - 1).getForca(), personatges.get(opcio - 1).getConstitucio(), personatges.get(opcio - 1).getVelocitat(), personatges.get(opcio - 1).getInteligencia(), personatges.get(opcio - 1).getSort(),personatges.get(opcio - 1).getArma());
                            lluitadors[i - 1] = HC1;
                            break;
                    case "Mitjà":
                            MitjaCaos MC1 = new MitjaCaos(personatges.get(opcio - 1).getNom(), personatges.get(opcio - 1).getForca(), personatges.get(opcio - 1).getConstitucio(), personatges.get(opcio - 1).getVelocitat(), personatges.get(opcio - 1).getInteligencia(), personatges.get(opcio - 1).getSort(),personatges.get(opcio - 1).getArma());
                            lluitadors[i - 1] = MC1;
                            break;
                    case "Maia":
                            MaiaCaos MaC1 = new MaiaCaos(personatges.get(opcio - 1).getNom(), personatges.get(opcio - 1).getForca(), personatges.get(opcio - 1).getConstitucio(), personatges.get(opcio - 1).getVelocitat(), personatges.get(opcio - 1).getInteligencia(), personatges.get(opcio - 1).getSort(),personatges.get(opcio - 1).getArma());
                            lluitadors[i - 1] = MaC1;
                            break;
                    default:
                            break;
                }
            }
            

        }
        Personatge atacant = lluitadors[0];
        Personatge defensor = lluitadors[1];
        Dau dau1 = new Dau();
        Dau dau2 = new Dau();
        Dau dau3 = new Dau();
        Personatge guanyador=atacant;
        Personatge perdedor=defensor;
        do {
                        sc.nextLine();
            int valor = dau1.llencar() + dau2.llencar() + dau3.llencar();
            System.out.println("Valor dels daus: " + valor);

            if (valor <= atacant.getPa()) {
                System.out.println(  atacant.getNom() + " pot atacar" );
                int valor2 = dau1.llencar() + dau2.llencar() + dau3.llencar();
                if (valor2 > defensor.getPe()) {
                    System.out.println( defensor.getNom() + " no ha pogut esquivar l'atac" );
                    defensor.setPs(defensor.getPs() - atacant.getPd());
                        if (atacant instanceof Ordre) {
                            atacant.restauraPS();
                            System.out.println(atacant.getNom()+" ha restaurat un 10% de PS ja que te equipada la devocio Ordre");
                            System.out.println(atacant.getNom() + " s'ha quedat amb " + atacant.getPs() + " punts de salut");
                            
                        }
                    if (defensor.getPs() > 0) {
                        System.out.println(defensor.getNom() + " s'ha quedat amb " + defensor.getPs() + " punts de salut");
                    } else
                        System.out.println( defensor.getNom() + " ha mort!");
                        guanyador = atacant;
                        perdedor = defensor;
                } else {
                    System.out.println(defensor.getNom() + " ha pogut esquivar l'atac"  );
                        if (defensor instanceof Caos) {
                               if (defensor.ContraAtaca(dau1,dau2,dau3)) {
                                System.out.println(defensor.getNom()+" ha pogut contraatacar!");
                                atacant.setPs(atacant.getPs() - (defensor.getPd()/2));
                                if (atacant.getPs() > 0) {
                                    System.out.println(atacant.getNom() + " s'ha quedat amb " + atacant.getPs() + " punts de salut");
                                } else
                                    System.out.println( atacant.getNom() + " ha mort!");
                                    guanyador = defensor;
                                    perdedor = atacant;
                            } else {
                                   System.out.println(defensor.getNom()+" no ha pogut contraatacar!");
                               }
                        }
                }

            } else {
                System.out.println(atacant.getNom() + " no pot atacar");
            }

            Personatge aux = atacant;
            atacant = defensor;
            defensor = aux;

        } while (defensor.getPs() > 0 && atacant.getPs() > 0);
        int MAXPsPerdedor=0;
        for (int i = 0; i < personatges.size(); i++) {
            if (personatges.get(i).getNom().equals(perdedor.getNom())) {
                MAXPsPerdedor=personatges.get(i).getPs();
            }
        }
        for (int i = 0; i < personatge.size(); i++) {
            if (personatge.get(i).getNom().equals(guanyador.getNom())) {
                personatge.get(i).guanayExp(MAXPsPerdedor);
            }
        }
    }
}
