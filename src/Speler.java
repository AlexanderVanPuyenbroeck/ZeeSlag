/**
 * Alexander Van Puyenbroeck
 * 17/12/2021
 * 14
 * 30
 */
public class Speler {
    private String naam;
    private SpeelVeld speelVeld;
    private RadarVeld radar;

    public Speler() {
    }

    public Speler(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public String setNaam(String naam) {
        this.naam = naam;
        return naam;
    }

    public SpeelVeld getSpeelVeld() {
        return speelVeld;
    }


    public RadarVeld getRadar() {
        return radar;
    }
}
