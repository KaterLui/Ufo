import GLOOP.*; 
public class Ufospiel {
    private GLKamera kamera;
    private GLLicht licht;
    private GLTastatur tastatur;
    private GLHimmel himmel;
    private Asteroid[] asteroid;
    private GLTafel tafel, stopWatchDisplay;
    int zeit = 0;
    int zeit1;
    private Clock stopWatch;


    private Ufo meinUfo;

    //[...]
    public Ufospiel() {
        kamera = new GLSchwenkkamera(800, 600);
        kamera.setzePosition(0, -500, 0.1);
        kamera.setzeScheitelrichtung(0, 90, 0);

        stopWatch = new Clock();
        stopWatchDisplay = new GLTafel(0, 50, 50, 50, 30);
        stopWatchDisplay.setzeAutodrehung(true);
        licht = new GLLicht();
        tastatur = new GLTastatur();
        himmel = new GLHimmel("src/img/Sterne.jpg");
        meinUfo = new Ufo();
        asteroid = new Asteroid[50];


        for (int i = 0; i < 50; i++) {
            asteroid[i] = new Asteroid(meinUfo);
        }

        bewege();

    }

    public void bewege() {
        while (!tastatur.esc()) {
            if (tastatur.links()) {
                meinUfo.bewegeLinks();
            }
            if (tastatur.rechts()) {
                meinUfo.bewegeRechts();
            }
            if (tastatur.oben()) {
                meinUfo.bewegeOben();
            }
            if (tastatur.unten()) {
                meinUfo.bewegeUnten();
            }
            if (tastatur.shift()) {
                meinUfo.bewegeVor();
            }
            if (tastatur.strg()) {
                meinUfo.bewegeHinten();
            }

            for (int i = 0; i < 50; i++) {
                asteroid[i].fallen();

            }
            //double pabstand= asteroid[i].gibAbstand()+1;
            if (tastatur.istGedrueckt('r')) {
                stopWatchDisplay.setzeText(stopWatch.stopWatchToString(false, true), 10);
            } else if (tastatur.istGedrueckt('t')) {
                stopWatchDisplay.setzeText(stopWatch.stopWatchToString(true, false), 10);
            } else {
                stopWatchDisplay.setzeText(stopWatch.stopWatchToString(false, false), 10);
            }
            Sys.warte();

        }
    }
}
