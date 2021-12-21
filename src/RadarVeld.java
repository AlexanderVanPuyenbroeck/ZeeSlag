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

    @Override
    public String toString() {
        int hTeller = 0;
        int mTeller = 0;
        for (char[] matrix : radarMatrix) {
            for (char c : matrix) {
                if (c == 'H'){
                    hTeller++;
                }
                if (c == 'M'){
                    mTeller++;
                }
            }
        }
        return String.format("hits: %d\ngemist: %d",hTeller,mTeller);
    }
}
