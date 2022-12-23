package me.guid118.StrategieSimulatie;



import static me.guid118.StrategieSimulatie.Main.*;

public class Rondetijd {
    static private double rondetijd;


    public static double rondetijd(int ronde, int bandentype, int bandronde) {
        if (bandentype == 5) {
            rondetijd = Softrondetijd;
        } else if (bandentype == 4) {
            rondetijd = Mediumrondetijd;
        } else if (bandentype == 3) {
            rondetijd = Hardrondetijd;
        } else {
            System.out.println("onbekend bandentype, Hard wordt gebruikt");
            rondetijd = Hardrondetijd;
        }
        rondetijd = rondetijd + Brandstof.Brandstoftijd(ronde) + Bandenslijtage.slijtage(ronde, bandronde, bandentype);
        return rondetijd;
    }
}
