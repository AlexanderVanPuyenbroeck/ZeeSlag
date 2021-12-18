/**
 * Nemo Van den Eynde
 * 17/12/2021
 */
public class DemoVeld {
    public static void main(String[] args) {
        Schip[] bootjes = new Schip[]{
                new Schip(5,6, Schip.SoortSchip.PATROUILLESCHIP, Schip.Richting.NOORD),
                new Schip(3,1, Schip.SoortSchip.PATROUILLESCHIP, Schip.Richting.OOST),
                new Schip(1,2, Schip.SoortSchip.PATROUILLESCHIP, Schip.Richting.ZUID)
        };
        SpeelVeld veldje = new SpeelVeld(bootjes);
        veldje.draw();
        RadarVeld radar = new RadarVeld(veldje);
        radar.draw();

    }
}
