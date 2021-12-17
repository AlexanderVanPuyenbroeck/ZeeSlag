/**
 * Alexander Van Puyenbroeck
 * 17/12/2021
 * 14
 * 31
 */
public class SpeelVeld {
    public final int MAXSPEELVELD = 10;
    private char[][] speelMatrix;
    private Schip[] schepen;

    public SpeelVeld() {
    }


    public SpeelVeld(Schip[] schepen) {

        this.schepen = schepen;
        speelMatrix = new char[MAXSPEELVELD][MAXSPEELVELD];
        tekenSchepen();
    }

    private void tekenSchepen() {
        for (Schip schip : schepen) {
            if (schip.getRichting() == Schip.Richting.NOORD) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    speelMatrix[schip.getX()][schip.getY() - i] = 'X';
                }
            } else if (schip.getRichting() == Schip.Richting.OOST) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    speelMatrix[schip.getX() + i][schip.getY()] = 'X';
                }
            } else if (schip.getRichting() == Schip.Richting.ZUID) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    speelMatrix[schip.getX()][schip.getY() + i] = 'X';
                }
            } else if (schip.getRichting() == Schip.Richting.WEST) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    speelMatrix[schip.getX() - i][schip.getY()] = 'X';
                }
            }
        }
    }

    public char checkLocatie(int x, int y) {
        return speelMatrix[x][y];
    }

    public void schipGeraakt(int x, int y) {
        speelMatrix[x][y] = 'H';
    }


    public void setSchepen(Schip[] schepen) {
        this.schepen = schepen;
        tekenSchepen();
    }

    public void draw() {
        for (char[] chars : speelMatrix) {
            StringBuilder stringBuilder = new StringBuilder("|");
            for (char aChar : chars) {
                stringBuilder.append(aChar + " ");
            }
            System.out.println(stringBuilder);
        }
    }

    //   public void setSpeelveld(char[][] speelveld) {
    //       this.speelMatrix = speelveld;
    //   }
}
