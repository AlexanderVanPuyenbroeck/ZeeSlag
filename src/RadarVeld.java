/**
 * Alexander Van Puyenbroeck
 * 17/12/2021
 * 14
 * 30
 */
public class RadarVeld extends SpeelVeld {
    private char[][] radarMatrix;
    private SpeelVeld doelwit;

    public RadarVeld(SpeelVeld doelwit) {
        this.doelwit = doelwit;
        radarMatrix = doelwit.getMatrix();

    }

    @Override
    public void draw() {
        int teller = 0;
        System.out.println("  0 1 2 3 4 5 6 7 8 9  ");
        System.out.println(" ----------------------");
        for (char[] chars : radarMatrix) {
            StringBuilder stringBuilder = new StringBuilder(teller + "|");
            teller++;
            for (char aChar : chars) {
                if (aChar == 'X') {
                    stringBuilder.append('\0' + " ");
                } else {
                    stringBuilder.append(aChar + " ");
                }
            }
            stringBuilder.append("|");
            System.out.println(stringBuilder);
        }
        System.out.println(" ----------------------");
    }

    public boolean schiet(int x, int y) {
        if (doelwit.checkLocatie(x, y) == 'X') {
            radarMatrix[x][y] = 'H';
            doelwit.schipGeraakt(x, y);
            return true;
        } else {
            radarMatrix[x][y] = 'M';
            return false;
        }
    }
}
