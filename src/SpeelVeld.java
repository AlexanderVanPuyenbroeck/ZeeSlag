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
    private Speler eigenaar;

    public SpeelVeld() {
    }

    public SpeelVeld(Speler eigenaar) {
        this.eigenaar = eigenaar;
        speelMatrix = new char[MAXSPEELVELD][MAXSPEELVELD];
    }

    public SpeelVeld(Schip[] schepen) {

        this.schepen = schepen;
        speelMatrix = new char[MAXSPEELVELD][MAXSPEELVELD];
        tekenSchepen();
    }

    public SpeelVeld(Schip[] schepen, Speler eigenaar) {
        this.schepen = schepen;
        this.eigenaar = eigenaar;
        speelMatrix = new char[MAXSPEELVELD][MAXSPEELVELD];
        tekenSchepen();
    }

    private void tekenSchepen() {
        for (Schip schip : schepen) {
            if (schip.getRichting() == Schip.Richting.NOORD) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    speelMatrix[schip.getX() - i][schip.getY()] = 'X';
                }
            } else if (schip.getRichting() == Schip.Richting.OOST) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    speelMatrix[schip.getX()][schip.getY() + i] = 'X';
                }
            } else if (schip.getRichting() == Schip.Richting.ZUID) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    speelMatrix[schip.getX() + i][schip.getY()] = 'X';
                }
            } else if (schip.getRichting() == Schip.Richting.WEST) {
                for (int i = 0; i < schip.getLengte(); i++) {
                    speelMatrix[schip.getX()][schip.getY() - i] = 'X';
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

    public char[][] getMatrix() {
        return speelMatrix;
    }



    public void draw() {
        int teller = 0;
        System.out.println(eigenaar.getNaam());

        System.out.println("  0 1 2 3 4 5 6 7 8 9  ");
        System.out.println(" ----------------------");
        for (char[] chars : speelMatrix) {
            StringBuilder stringBuilder = new StringBuilder(teller + "|");
            teller++;
            for (char aChar : chars) {
                stringBuilder.append(aChar + " ");
            }
            stringBuilder.append("|");
            System.out.println(stringBuilder);
        }
        System.out.println(" ----------------------");
    }

    //   public void setSpeelveld(char[][] speelveld) {
    //       this.speelMatrix = speelveld;
    //   }
}
