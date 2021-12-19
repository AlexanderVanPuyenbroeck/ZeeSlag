import javax.management.StringValueExp;
import java.util.Scanner;

/**
 * Alexander Van Puyenbroeck
 * 17/12/2021
 * 14
 * 32
 */
public class ZeeSlag {
    private Speler speler1;
    private Speler speler2;
    int MAX_Schepen = 5;
    int geplaatsteSchepen = 0;

    //zeeslag uitwerken
    public void uitwerking() {
        Scanner scanner = new Scanner(System.in);
        Speler speler = new Speler();
        System.out.print("wat is uw naam?: ");
        speler.setNaam(scanner.nextLine());
        System.out.println("Hallo " + speler.getNaam());

        //Start

        while (geplaatsteSchepen < MAX_Schepen) {
            Schip schip = new Schip();
            System.out.println("waar staat Schip 1? (x-waarde): ");
            schip.setX(scanner.nextInt());
            System.out.println("waar staat Schip 1? (y-waarde): ");
            schip.setY(scanner.nextInt());
            System.out.println("welk soort schip wil je plaatsen? (PATROUILLESCHIP(2), TORPEDOBOOTJAGER(4), SLAGSCHIP(5), VLIEGDEKSCHIP(6)): ");
            schip.setSoort(scanner.nextLine());
            System.out.println("in welke richting moet het schip staan? (N, O, Z of W): ");
            schip.setRichting(scanner.nextLine());
            geplaatsteSchepen++;
        }

    }

    @Override
    public String toString() {
        return String.format("het spel is op ronde %d",0);
        //0 vervangen door ronde teller is voor later
    }
}
