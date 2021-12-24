import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Alexander Van Puyenbroeck
 * 17/12/2021
 * 14
 * 30
 */
public class Speler {
    private String naam;
    private SpeelVeld speelVeld;
    private SpeelVeld radarveld;
    private int score;
    public final int MAX_Schepen = 5;
    public int geplaatsteSchepen = 0;
    private Scanner scanner = new Scanner(System.in);
    private Schip[] schepen = new Schip[MAX_Schepen];
    private Pattern cords = Pattern.compile("[ABCDEFGHIJ][0-9]");


    public Speler() {
        speelVeld = new SpeelVeld(this);
    }

    public Speler(String naam) {
        this.naam = naam;
        speelVeld = new SpeelVeld(this);
    }

    public String getNaam() {
        return naam;
    }

    public String setNaam(String naam) {
        this.naam = naam;
        return naam;
    }

    public void setSchepen(Schip[] schepen) {

    }

    public void setSchip() {
        boolean geldigeLocatie = true;
        Schip schip = new Schip();
        do {
            System.out.println(speelVeld.toString());
            Matcher m;
            System.out.printf("waar staat Schip %d? (vb:C5): ", geplaatsteSchepen + 1);
            boolean inputCorrect = true;
            String plek;
            do {
                plek = scanner.next().toUpperCase();
                m = cords.matcher(plek);
                if (!m.matches()) {
                    System.out.println("geef geldige coordinaten in");
                    inputCorrect = false;
                } else inputCorrect = true;
            } while (!inputCorrect);
            int y = plek.charAt(0) - 65;
            schip.setY(y);
            int x = Integer.parseInt(plek.substring(1, 2));
            schip.setX(x);
            System.out.println("welk soort schip wil je plaatsen?\nPATROUILLESCHIP (2)\nTORPEDOBOOTJAGER (3)\nSLAGSCHIP(4)\nVLIEGDEKSCHIP(5)): ");
            int welkSchip = scanner.nextInt();
            switch (welkSchip) {
                case 1:
                    schip.setSoort(Schip.SoortSchip.PATROUILLESCHIP);
                    break;
                case 2:
                    schip.setSoort(Schip.SoortSchip.TORPEDOBOOTJAGER);
                    break;
                case 3:
                    schip.setSoort(Schip.SoortSchip.SLAGSCHIP);
                    break;
                default:
                    schip.setSoort(Schip.SoortSchip.VLIEGDEKSCHIP);
            }
            System.out.println("gekozen schip: " + schip.getSoort());

            System.out.println("in welke richting moet het schip staan?\n" +
                    "1) N \n2) O \n3) Z \n4) W");
            int welkeRichting = scanner.nextInt();
            switch (welkeRichting) {
                case 1:
                case 2:
                    schip.setRichting(Schip.Richting.NOORD);
                    break;
                case 3:
                    schip.setRichting(Schip.Richting.OOST);
                    break;
                case 4:
                    schip.setRichting(Schip.Richting.ZUID);
                    break;
                default:
                    schip.setRichting(Schip.Richting.WEST);
            }

            if (schip.getRichting() == Schip.Richting.NOORD) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    if(!speelVeld.isVrij(x,y-i)){
                        geldigeLocatie = false;
                        System.out.println("Locatie is al bezet!");
                    }
                }
            } else if (schip.getRichting() == Schip.Richting.OOST) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    if(!speelVeld.isVrij(x+i,y)){
                        geldigeLocatie = false;
                        System.out.println("Locatie is al bezet!");
                    }
                }
            } else if (schip.getRichting() == Schip.Richting.ZUID) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    if(!speelVeld.isVrij(x,y+i)){
                        geldigeLocatie = false;
                        System.out.println("Locatie is al bezet!");
                    }
                }
            } else if (schip.getRichting() == Schip.Richting.WEST) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    if(!speelVeld.isVrij(x-i,y)){
                        geldigeLocatie = false;
                        System.out.println("Locatie is al bezet!");
                    }
                }
            }


//            System.out.println("gekozen richting: " + schip.getRichting());
//            System.out.println("x waarde: " + schip.getX());
//            System.out.println("y waarde: " + schip.getY());
//            schepen[geplaatsteSchepen] = schip;
//            geplaatsteSchepen++;
        } while (!geldigeLocatie);
        speelVeld.schipToevoegen(schip);
    }


    public boolean schiet(Speler doelwit, int x, int y) {
        SpeelVeld.Vakje vakje = doelwit.getSpeelVeld().checkLocatie(x, y);
        if (vakje.equals(SpeelVeld.Vakje.SH)) {
            doelwit.getSpeelVeld().schipGeraakt(x, y);
            radarveld.schipGeraakt(x, y);
            return true;
        } else {
            doelwit.getSpeelVeld().schipGemist(x, y);
            radarveld.schipGemist(x, y);
            return false;
        }
    }

    public SpeelVeld getRadarveld() {
        return radarveld;
    }

    public SpeelVeld getSpeelVeld() {
        return speelVeld;
    }

    @Override
    public String toString() {
        return String.format("speler: %s", naam);
    }
}
