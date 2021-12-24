import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Nemo Van den Eynde
 * 17/12/2021
 */
public class DemoVeld {
    public static void main(String[] args) {
//        Speler p1 = new Speler("Nemo");
//        Schip[] bootjes = new Schip[]{
//                new Schip(5,6, Schip.SoortSchip.PATROUILLESCHIP, Schip.Richting.NOORD),
//                //new Schip(3,1, Schip.SoortSchip.PATROUILLESCHIP, Schip.Richting.OOST),
//                // new Schip(1,2, Schip.SoortSchip.VLIEGDEKSCHIP, Schip.Richting.ZUID)
//        };
//        SpeelVeld veldje = new SpeelVeld(bootjes, p1);
//        System.out.println(veldje.toString());
        Scanner scanner = new Scanner(System.in);
        Pattern cords = Pattern.compile("[ABCDEFGHIJ][0-9]");
        String plek = scanner.next();
        Matcher matcher = cords.matcher(plek);
        boolean b = matcher.matches();
        System.out.println(b);
        System.out.println(plek.substring(0,1));System.out.println(plek.substring(1,2));
        char c = 'A';
        int a = c;
        System.out.println(a);
    }
}
