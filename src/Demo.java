/**
 * Alexander Van Puyenbroeck
 * 17/12/2021
 * 14
 * 33
 */
public class Demo {
    public static void main(String[] args) {
        Schip[] bootjes = new Schip[]{
                new Schip(5,9, Schip.SoortSchip.PATROUILLESCHIP, Schip.Richting.NOORD),
                new Schip(3,1, Schip.SoortSchip.PATROUILLESCHIP, Schip.Richting.OOST),
                new Schip(1,2, Schip.SoortSchip.PATROUILLESCHIP, Schip.Richting.ZUID)
        };
        SpeelVeld veldje = new SpeelVeld(bootjes);
        veldje.draw();
    }
}
