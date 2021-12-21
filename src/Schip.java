import java.lang.management.ThreadInfo;

/**
 * Alexander Van Puyenbroeck
 * 17/12/2021
 * 14
 * 29
 */
public class Schip {
    private int x;
    private int y;
    private SoortSchip soort;
    private Richting richting;
    private int levens;

    public Schip(int x, int y, SoortSchip soort, Richting richting) {
        this.x = x;
        this.y = y;
        this.soort = soort;
        this.richting = richting;
        levens = soort.lengte;
    }

    public Schip() {
        this.x = 0;
        this.y = 0;
        this.richting = Richting.ZUID;
        this.soort = SoortSchip.PATROUILLESCHIP;
    }

    public void geraakt(){
        levens--;
    }

    public int getY() {
        return y;
    }

    public int getLevens() {
        return levens;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public SoortSchip getSoort() {
        return soort;
    }

    public void setSoort(SoortSchip soort) {
        this.soort = soort;
    }

    public void setRichting(Richting richting) {
        this.richting = richting;
    }

    public int getLengte(){
        return soort.lengte;
    }

    public Richting getRichting() {
        return richting;
    }

    public enum SoortSchip {
        PATROUILLESCHIP(2), TORPEDOBOOTJAGER(3), SLAGSCHIP(4), VLIEGDEKSCHIP(5);

        private int lengte;

        SoortSchip(int lengte) {
            this.lengte = lengte;
        }
    }

    public enum Richting {
        NOORD, OOST, ZUID, WEST
    }
}
