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
    int MAX_Schepen = 5;
    int geplaatsteSchepen = 0;

    //zeeslag uitwerken
    public void uitwerking() {
        Scanner scanner = new Scanner(System.in);
        Speler speler = new Speler();
        System.out.print("wat is uw naam?: ");
        speler.setNaam(scanner.nextLine());
        System.out.println("Hallo " + speler.getNaam());

        //Start

        while (geplaatsteSchepen < MAX_Schepen) {
            Schip schip = new Schip();
            System.out.println("waar staat Schip 1? (x-waarde): ");
            schip.setX(scanner.nextInt());
            System.out.println("waar staat Schip 1? (y-waarde): ");
            schip.setY(scanner.nextInt());
            System.out.println("welk soort schip wil je plaatsen? (PATROUILLESCHIP(2), TORPEDOBOOTJAGER(4), SLAGSCHIP(5), VLIEGDEKSCHIP(6)): ");
            int welkSchip = scanner.nextInt();
            switch (welkSchip) {
                case 1: schip.setSoort(Schip.SoortSchip.PATROUILLESCHIP); break;
                case 2: schip.setSoort(Schip.SoortSchip.TORPEDOBOOTJAGER); break;
                case 3: schip.setSoort(Schip.SoortSchip.SLAGSCHIP); break;
                case 4: schip.setSoort(Schip.SoortSchip.VLIEGDEKSCHIP); break;
            }
            System.out.println("gekozen schip: " + schip.getSoort());

            System.out.println("in welke richting moet het schip staan? (N, O, Z of W): ");
            int welkeRichting = scanner.nextInt();
            switch(welkeRichting) {
                case 1: schip.setRichting(Schip.Richting.NOORD); break;
                case 2: schip.setRichting(Schip.Richting.OOST); break;
                case 3: schip.setRichting(Schip.Richting.ZUID); break;
                case 4: schip.setRichting(Schip.Richting.WEST); break;
            }
            System.out.println("gekozen richting: " + schip.getRichting());
            System.out.println("x waarde: " + schip.getX());
            System.out.println("y waarde: " + schip.getY());

            boolean[][] Schepen = new boolean[10][10];



            //bij richting noord
            if (schip.getRichting() == Schip.Richting.NOORD) {
                if (schip.getSoort() == Schip.SoortSchip.PATROUILLESCHIP){
                    for (int i = schip.getX(); i > schip.getX() - 2; i--) {
                        Schepen[i][schip.getY()] = true;
                    }
                }
                else if (schip.getSoort() == Schip.SoortSchip.TORPEDOBOOTJAGER){
                    for (int i = schip.getX(); i > schip.getX() - 3; i--) {
                        Schepen[i][schip.getY()] = true;
                    }
                }
                else if (schip.getSoort() == Schip.SoortSchip.SLAGSCHIP){
                    for (int i = schip.getX(); i > schip.getX() - 4; i--) {
                        Schepen[i][schip.getY()] = true;
                    }
                }
                else if (schip.getSoort() == Schip.SoortSchip.VLIEGDEKSCHIP){
                    for (int i = schip.getX(); i > schip.getX() - 5; i--) {
                        Schepen[i][schip.getY()] = true;
                    }
                }
            }



            //bij richting oost
            else if (schip.getRichting() == Schip.Richting.OOST) {
                if (schip.getSoort() == Schip.SoortSchip.PATROUILLESCHIP){
                    for (int i = schip.getY(); i < schip.getY() + 2; i++) {
                        Schepen[schip.getX()][i] = true;
                    }
                }
                else if (schip.getSoort() == Schip.SoortSchip.TORPEDOBOOTJAGER){
                    for (int i = schip.getY(); i < schip.getY() + 3; i++) {
                        Schepen[schip.getX()][i] = true;
                    }
                }
                else if (schip.getSoort() == Schip.SoortSchip.SLAGSCHIP){
                    for (int i = schip.getY(); i < schip.getY() + 4; i++) {
                        Schepen[schip.getX()][i] = true;
                    }
                }
                else if (schip.getSoort() == Schip.SoortSchip.VLIEGDEKSCHIP){
                    for (int i = schip.getY(); i < schip.getY() + 5; i++) {
                        Schepen[schip.getX()][i] = true;
                    }
                }
            }



            //bij richting zuid
            else if (schip.getRichting() == Schip.Richting.NOORD) {
                if (schip.getSoort() == Schip.SoortSchip.PATROUILLESCHIP){
                    for (int i = schip.getX(); i < schip.getX() + 2; i++) {
                        Schepen[i][schip.getY()] = true;
                    }
                }
                else if (schip.getSoort() == Schip.SoortSchip.TORPEDOBOOTJAGER){
                    for (int i = schip.getX(); i < schip.getX() + 3; i++) {
                        Schepen[i][schip.getY()] = true;
                    }
                }
                else if (schip.getSoort() == Schip.SoortSchip.SLAGSCHIP){
                    for (int i = schip.getX(); i < schip.getX() + 4; i++) {
                        Schepen[i][schip.getY()] = true;
                    }
                }
                else if (schip.getSoort() == Schip.SoortSchip.VLIEGDEKSCHIP){
                    for (int i = schip.getX(); i < schip.getX() + 5; i++) {
                        Schepen[i][schip.getY()] = true;
                    }
                }
            }



            //bij richting west
            else if (schip.getRichting() == Schip.Richting.OOST) {
                if (schip.getSoort() == Schip.SoortSchip.PATROUILLESCHIP){
                    for (int i = schip.getY(); i > schip.getY() - 2; i--) {
                        Schepen[schip.getX()][i] = true;
                    }
                }
                else if (schip.getSoort() == Schip.SoortSchip.TORPEDOBOOTJAGER){
                    for (int i = schip.getY(); i > schip.getY() - 3; i--) {
                        Schepen[schip.getX()][i] = true;
                    }
                }
                else if (schip.getSoort() == Schip.SoortSchip.SLAGSCHIP){
                    for (int i = schip.getY(); i > schip.getY() - 4; i--) {
                        Schepen[schip.getX()][i] = true;
                    }
                }
                else if (schip.getSoort() == Schip.SoortSchip.VLIEGDEKSCHIP){
                    for (int i = schip.getY(); i > schip.getY() - 5; i--) {
                        Schepen[schip.getX()][i] = true;
                    }
                }
            }
            else{
                System.out.println("geen plaats op true gezet");
            }

            for (int i = 0; i < Schepen.length; i++) {
                for (int j = 0; j < Schepen.length; j++) {
                    System.out.print(Schepen[i][j] + " ");
                }
                System.out.println();
            }
            geplaatsteSchepen++;
        }
    }
}
