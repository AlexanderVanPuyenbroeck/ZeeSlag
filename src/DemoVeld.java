/**
 * Nemo Van den Eynde
 * 17/12/2021
 */
public class DemoVeld {
    public static void main(String[] args) {
        Speler p1 = new Speler("Nemo");
        Schip[] bootjes = new Schip[]{
                new Schip(5,6, Schip.SoortSchip.PATROUILLESCHIP, Schip.Richting.NOORD),
                new Schip(3,1, Schip.SoortSchip.PATROUILLESCHIP, Schip.Richting.OOST),
                new Schip(1,2, Schip.SoortSchip.VLIEGDEKSCHIP, Schip.Richting.ZUID)
        };
        SpeelVeld veldje = new SpeelVeld(bootjes, p1);
        System.out.println(veldje.toString());

    }
}
