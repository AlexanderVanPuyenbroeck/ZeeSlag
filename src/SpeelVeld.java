/**
 * Alexander Van Puyenbroeck
 * 17/12/2021
 * 14
 * 31
 */
public class SpeelVeld {
    public final int MAXSPEELVELD = 10;
    //private char[][] speelMatrix;
    private Vakje[][] speelMatrix;
    private Schip[] schepen;
    private Speler eigenaar;
    private int schepenteller=0;

    public SpeelVeld() {
    }

    public SpeelVeld(Speler eigenaar) {
        this.eigenaar = eigenaar;
        speelMatrix = new Vakje[MAXSPEELVELD][MAXSPEELVELD];
        blanco();
    }

    public SpeelVeld(Schip[] schepen) {
        this.schepen = schepen;
        speelMatrix = new Vakje[MAXSPEELVELD][MAXSPEELVELD];
        blanco();
        tekenSchepen();
    }

    public SpeelVeld(Schip[] schepen, Speler eigenaar) {
        this.schepen = schepen;
        this.eigenaar = eigenaar;
        speelMatrix = new Vakje[MAXSPEELVELD][MAXSPEELVELD];
        blanco();
        tekenSchepen();
    }

    public void schipToevoegen(Schip schip){
        schepen[schepenteller]=schip;
        schepenteller++;
    }

    private void tekenSchepen() {
        for (Schip schip : schepen) {
            if (schip.getRichting() == Schip.Richting.NOORD) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    speelMatrix[schip.getY() - i][schip.getX() ] = Vakje.SH;
                }
            } else if (schip.getRichting() == Schip.Richting.OOST) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    speelMatrix[schip.getY()][schip.getX() + i] = Vakje.SH;
                }
            } else if (schip.getRichting() == Schip.Richting.ZUID) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    speelMatrix[schip.getY() + i][schip.getX()] = Vakje.SH;
                }
            } else if (schip.getRichting() == Schip.Richting.WEST) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    speelMatrix[schip.getY()][schip.getX() - i] = Vakje.SH;
                }
            }
        }
    }

    public void blanco(){
        for (int i = 0; i < MAXSPEELVELD; i++) {
            for (int j = 0; j < MAXSPEELVELD; j++) {
                speelMatrix[i][j]= Vakje.WA;
            }
        }
    }

    public Vakje checkLocatie(int x, int y) {
        return speelMatrix[x][y];
    }

    public boolean isVrij(int x,int y){
        if (speelMatrix[y][x].equals(Vakje.SH)){
            return false;
        }else return true;
    }

    public void schipGeraakt(int x, int y) {
        speelMatrix[x][y] = Vakje.SR;
    }

    public void schipGemist(int x, int y) {
        speelMatrix[x][y] = Vakje.WM;
    }


    public void setSchepen(Schip[] schepen) {
        this.schepen = schepen;
        tekenSchepen();
    }

    public Vakje[][] getMatrix() {
        return speelMatrix;
    }


    @Override
    public String toString() {
        int teller = 0;
        StringBuilder builder = new StringBuilder("  0  1  2  3  4  5  6  7  8  9  \n" +
                                                  " --------------------------------\n"
        );
        for (Vakje[] vakjes : speelMatrix) {
            char c = (char) (65 + teller);
            StringBuilder stringBuilder = new StringBuilder( c + "|");
            teller++;
            for (Vakje vakje : vakjes) {
                stringBuilder.append(vakje + " ");
            }
            stringBuilder.append("|");
            builder.append(stringBuilder + "\n");
        }
        builder.append(" --------------------------------");
        return builder.toString();
    }
    public enum Vakje {
        WA, WM, SH, SR
    }
}
