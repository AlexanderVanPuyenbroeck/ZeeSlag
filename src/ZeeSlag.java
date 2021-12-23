import java.util.Scanner;

/**
 * Alexander Van Puyenbroeck
 * 17/12/2021
 * 14
 * 32
 */
public class ZeeSlag {
    private Speler speler1;
    private Speler speler2;
    public final int MAX_Schepen = 5;
    private int geplaatsteSchepen = 0;
    private int ronde;
    private Scanner scanner = new Scanner(System.in);



    //zeeslag uitwerken
    public void start() {
        speler1 = new Speler();
        System.out.print("wat is de naam van speler 1?: ");
        speler1.setNaam(scanner.nextLine());
        System.out.println("Hallo " + speler1.getNaam());
        speler2 = new Speler();
        System.out.print("wat is de naam van speler 2?: ");
        speler2.setNaam(scanner.nextLine());
        System.out.println("Hallo " + speler2.getNaam());
    }

    public void schepenZetten() {
        System.out.printf("Zetten van schepen voor %s", speler1.getNaam());
        speler1.setSchepen();
        System.out.printf("Zetten van schepen voor %s", speler2.getNaam());
        speler2.setSchepen();
    }

    public void rodne(){
        System.out.println("Speler 1 waar wilt u schieten");
        System.out.print("X:");
        int xa = scanner.nextInt();
        System.out.print("Y:");
        int ya = scanner.nextInt();
        boolean raaka = speler1.schiet(speler2,xa,ya);
        System.out.println(raaka?"raak":"mis");
        System.out.println("Speler 2 waar wilt u schieten");
        System.out.print("X:");
        int xb = scanner.nextInt();
        System.out.print("Y:");
        int yb = scanner.nextInt();
        boolean raakb = speler1.schiet(speler2,xb,yb);
        System.out.println(raakb?"raak":"mis");
        ronde++;
    }

//            boolean[][] Schepen = new boolean[10][10];
//
//
//
//            //bij richting noord
//            if (schip.getRichting() == Schip.Richting.NOORD) {
//                if (schip.getSoort() == Schip.SoortSchip.PATROUILLESCHIP){
//                    for (int i = schip.getX(); i > schip.getX() - 2; i--) {
//                        Schepen[i][schip.getY()] = true;
//                    }
//                }
//                else if (schip.getSoort() == Schip.SoortSchip.TORPEDOBOOTJAGER){
//                    for (int i = schip.getX(); i > schip.getX() - 3; i--) {
//                        Schepen[i][schip.getY()] = true;
//                    }
//                }
//                else if (schip.getSoort() == Schip.SoortSchip.SLAGSCHIP){
//                    for (int i = schip.getX(); i > schip.getX() - 4; i--) {
//                        Schepen[i][schip.getY()] = true;
//                    }
//                }
//                else if (schip.getSoort() == Schip.SoortSchip.VLIEGDEKSCHIP){
//                    for (int i = schip.getX(); i > schip.getX() - 5; i--) {
//                        Schepen[i][schip.getY()] = true;
//                    }
//                }
//            }
//
//
//
//            //bij richting oost
//            else if (schip.getRichting() == Schip.Richting.OOST) {
//                if (schip.getSoort() == Schip.SoortSchip.PATROUILLESCHIP){
//                    for (int i = schip.getY(); i < schip.getY() + 2; i++) {
//                        Schepen[schip.getX()][i] = true;
//                    }
//                }
//                else if (schip.getSoort() == Schip.SoortSchip.TORPEDOBOOTJAGER){
//                    for (int i = schip.getY(); i < schip.getY() + 3; i++) {
//                        Schepen[schip.getX()][i] = true;
//                    }
//                }
//                else if (schip.getSoort() == Schip.SoortSchip.SLAGSCHIP){
//                    for (int i = schip.getY(); i < schip.getY() + 4; i++) {
//                        Schepen[schip.getX()][i] = true;
//                    }
//                }
//                else if (schip.getSoort() == Schip.SoortSchip.VLIEGDEKSCHIP){
//                    for (int i = schip.getY(); i < schip.getY() + 5; i++) {
//                        Schepen[schip.getX()][i] = true;
//                    }
//                }
//            }
//
//
//
//            //bij richting zuid
//            else if (schip.getRichting() == Schip.Richting.NOORD) {
//                if (schip.getSoort() == Schip.SoortSchip.PATROUILLESCHIP){
//                    for (int i = schip.getX(); i < schip.getX() + 2; i++) {
//                        Schepen[i][schip.getY()] = true;
//                    }
//                }
//                else if (schip.getSoort() == Schip.SoortSchip.TORPEDOBOOTJAGER){
//                    for (int i = schip.getX(); i < schip.getX() + 3; i++) {
//                        Schepen[i][schip.getY()] = true;
//                    }
//                }
//                else if (schip.getSoort() == Schip.SoortSchip.SLAGSCHIP){
//                    for (int i = schip.getX(); i < schip.getX() + 4; i++) {
//                        Schepen[i][schip.getY()] = true;
//                    }
//                }
//                else if (schip.getSoort() == Schip.SoortSchip.VLIEGDEKSCHIP){
//                    for (int i = schip.getX(); i < schip.getX() + 5; i++) {
//                        Schepen[i][schip.getY()] = true;
//                    }
//                }
//            }
//
//
//
//            //bij richting west
//            else if (schip.getRichting() == Schip.Richting.OOST) {
//                if (schip.getSoort() == Schip.SoortSchip.PATROUILLESCHIP){
//                    for (int i = schip.getY(); i > schip.getY() - 2; i--) {
//                        Schepen[schip.getX()][i] = true;
//                    }
//                }
//                else if (schip.getSoort() == Schip.SoortSchip.TORPEDOBOOTJAGER){
//                    for (int i = schip.getY(); i > schip.getY() - 3; i--) {
//                        Schepen[schip.getX()][i] = true;
//                    }
//                }
//                else if (schip.getSoort() == Schip.SoortSchip.SLAGSCHIP){
//                    for (int i = schip.getY(); i > schip.getY() - 4; i--) {
//                        Schepen[schip.getX()][i] = true;
//                    }
//                }
//                else if (schip.getSoort() == Schip.SoortSchip.VLIEGDEKSCHIP){
//                    for (int i = schip.getY(); i > schip.getY() - 5; i--) {
//                        Schepen[schip.getX()][i] = true;
//                    }
//                }
//            }
//            else{
//                System.out.println("geen plaats op true gezet");
//            }
//
//            for (int i = 0; i < Schepen.length; i++) {
//                for (int j = 0; j < Schepen.length; j++) {
//                    System.out.print(Schepen[i][j] + " ");
//                }
//                System.out.println();
//            }
//            geplaatsteSchepen++;


    @Override
    public String toString() {
        return String.format("het spel is op ronde %d",0);
        //0 vervangen door ronde teller is voor later
    }
}
