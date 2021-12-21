import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Alexander Van Puyenbroeck
 * 21/12/2021
 * 11
 * 29
 */
public class Highscores {
    public static void main(String[] args) throws IOException {
        Speler speler;
        File file = new File("filename.txt");

        FileWriter file1 = new FileWriter("filename.txt");
        file1.write("hallo");
        file1.close();
    }
}


