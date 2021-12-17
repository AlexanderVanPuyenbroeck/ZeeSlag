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

    public SoortSchip getSoort() {
        return soort;
    }

    public int getLengte(){
        return soort.lengte;
    }

    public Richting getRichting() {
        return richting;
    }

    public enum SoortSchip {
        PATROUILLESCHIP(2), TORPEDOBOOTJAGER(4), SLAGSCHIP(5), VLIEGDEKSCHIP(6);

        private int lengte;

        SoortSchip(int lengte) {
            this.lengte = lengte;
        }
    }



    public enum Richting {
        NOORD, OOST, ZUID, WEST
    }
}
