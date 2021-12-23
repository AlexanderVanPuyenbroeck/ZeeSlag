import java.util.Scanner;

/**
 * Alexander Van Puyenbroeck
 * 17/12/2021
 * 14
 * 30
 */
public class Speler {
    private String naam;
    private SpeelVeld speelVeld;
    private int score;
    public final int MAX_Schepen = 10;
    private int geplaatsteSchepen = 0;
    private Scanner scanner = new Scanner(System.in);


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

    public void setSchepen() {
        Schip[] schepen = new Schip[MAX_Schepen];
        while (geplaatsteSchepen < MAX_Schepen) {
            Schip schip = new Schip();
            System.out.println("waar staat Schip 1? (x-waarde): ");
            schip.setX(scanner.nextInt());
            System.out.println("waar staat Schip 1? (y-waarde): ");
            schip.setY(scanner.nextInt());
            System.out.println("welk soort schip wil je plaatsen?\nPATROUILLESCHIP (2)\nTORPEDOBOOTJAGER (3)\nSLAGSCHIP(4)\n VLIEGDEKSCHIP(5)): ");
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
            System.out.println("gekozen richting: " + schip.getRichting());
            System.out.println("x waarde: " + schip.getX());
            System.out.println("y waarde: " + schip.getY());
            schepen[geplaatsteSchepen] = schip;
            geplaatsteSchepen++;
        }
    }

    public boolean schiet(Speler doelwit, int x, int y){
        SpeelVeld.Vakje vakje = doelwit.getSpeelVeld().checkLocatie(x,y);
        if (vakje.equals(SpeelVeld.Vakje.SH)){
            doelwit.getSpeelVeld().schipGeraakt(x,y);
            return true;
        }
        else {
            doelwit.getSpeelVeld().schipGemist(x,y);
            return false;
        }
    }


    public SpeelVeld getSpeelVeld() {
        return speelVeld;
    }

    @Override
    public String toString() {
        return String.format("speler: %s", naam);
    }
}
