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
        speelVeld= new SpeelVeld(this);
    }

    public Speler(String naam) {
        this.naam = naam;
        speelVeld= new SpeelVeld(this);
    }

    public String getNaam() {
        return naam;
    }

    public String setNaam(String naam) {
        this.naam = naam;
        return naam;
    }

    public void setRadar(RadarVeld radar) {
        this.radar = radar;
    }

    public SpeelVeld getSpeelVeld() {
        return speelVeld;
    }

    @Override
    public String toString() {
        return String.format("speler: %s",naam);
    }

    public RadarVeld getRadar() {
        return radar;
    }
}
