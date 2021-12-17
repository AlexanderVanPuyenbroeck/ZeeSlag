/**
 * Alexander Van Puyenbroeck
 * 17/12/2021
 * 14
 * 30
 */
public class RadarVeld extends SpeelVeld{
    private char[][] radarMatrix;
    private SpeelVeld doelwit;

    public RadarVeld(SpeelVeld doelwit) {
        this.doelwit = doelwit;
    }

    public boolean schiet(int x,int y){
        if (doelwit.checkLocatie(x,y)== 'X'){
            radarMatrix[x][y] = 'H';
            doelwit.schipGeraakt(x,y);
            return true;
        }
        else {
            radarMatrix[x][y] = 'M';
            return false;
        }
    }
}
