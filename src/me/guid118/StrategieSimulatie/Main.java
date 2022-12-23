package me.guid118.StrategieSimulatie;




import me.guid118.StrategieSimulatie.Files.Config;
import me.guid118.StrategieSimulatie.Files.Output;
import me.guid118.StrategieSimulatie.utils.OrderedProperties;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


import static me.guid118.StrategieSimulatie.Files.Output.*;
import static me.guid118.StrategieSimulatie.Rondetijd.rondetijd;

public class Main {


    public static double Softrondetijd;
    public static double maxsoftgebruiks;
    public static double maxsoftgebruik;
    public static double maxsoftrondens;
    public static double softdegradatie;

    public static double Mediumrondetijd;
    public static double maxmediumgebruiks;
    public static double maxmediumgebruik;
    public static double maxmediumrondens;
    public static double mediumdegradatie;

    public static double Hardrondetijd;
    public static double maxhardgebruiks;
    public static double maxhardgebruik;
    public static double maxhardrondens;
    public static double harddegradatie;

    static double startbrandstof = 3;
    static double brandstofperronde;

    static double multiplier;

    static int pitstopronde;
    static int pitstopronde1;
    static int pitstopronde2;
    public static double pitstoptijd;
    public static int minpitstops;
    public static int maxpitstops;
    public static int totronde;

    public static int maxptiteration;
    public static int maxpt1iteration;
    public static int maxpt2iteration;
    public static double totalrt;

    public static String race;
    public static double maxracetijd;

    public static int simulated;
    public static OrderedProperties prop = new OrderedProperties();



    public static void main(String[] args) {

        Config.CreateFile();
        System.out.println("welke race moet gesimuleerd worden?");
        Scanner sc = new Scanner(System.in);
        race = sc.nextLine();
        Config.getvalues();
        Output.CreateFile();
        for (int pitstops = minpitstops; pitstops <= maxpitstops; pitstops++){
            strategie(pitstops);
        }

        Write();
        System.exit(1);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }



    private static String bandentype(int type, int versie){
        String bandentype = null;
        if (versie == 0) {
            if (type == 3) {
                bandentype = "Hard-";
            } else if (type == 4) {
                bandentype = "Medium-";
            } else if (type == 5) {
                bandentype = "Soft-";
            }
        }
        if (versie == 1) {
            if (type == 3) {
                bandentype = "Hard";
            } else if (type == 4) {
                bandentype = "Medium";
            } else if (type == 5) {
                bandentype = "Soft";
            }
        }
        return bandentype;
    }

    private static void simulatie(int sbiteration, int ebiteration) {
    simulated++;
    totalrt = 0;
    for (int ronde = 0; ronde <= totronde; ronde++) {
        if (ronde <= pitstopronde) {
            totalrt += rondetijd(ronde, sbiteration, ronde);
        } else {
            totalrt += rondetijd(ronde, ebiteration, ronde - pitstopronde);
        }
    }
    totalrt += pitstoptijd;
    totalrt = round(totalrt,2);
    if (totalrt <= maxracetijd) {
        String bandentype1 = bandentype(sbiteration, 0);
        String bandentype2 = bandentype(ebiteration, 1);
        String bandentype = bandentype1+bandentype2;
        Save(bandentype + "\t" + pitstopronde + "\t" + "\t" + "\t" + totalrt + "\t" + Risicoberekening.risico(pitstopronde, sbiteration, ebiteration) );
        }
    }

    private static void simulatie(int sbiteration, int mbiteration, int ebiteration){
        simulated++;
        totalrt = 0;
        for (int ronde = 0; ronde <= totronde; ronde++) {
            if (ronde <= pitstopronde) {
                totalrt += rondetijd(ronde, sbiteration, ronde);
            } else if (ronde <= pitstopronde1) {
                totalrt += rondetijd(ronde, mbiteration, ronde - pitstopronde);
            } else {
                totalrt += rondetijd(ronde, ebiteration, ronde - pitstopronde1);
            }
        }
        totalrt += pitstoptijd;
        totalrt = round(totalrt,2);
        if (totalrt <= maxracetijd) {
            String bandentype1 = bandentype(sbiteration, 0);
            String bandentype2 = bandentype(mbiteration, 0);
            String bandentype3 = bandentype(mbiteration, 1);
            String bandentype = bandentype1+bandentype2+bandentype3;
            Save(bandentype + "\t" + pitstopronde + "\t" + pitstopronde1 + "\t" + "\t" + totalrt + "\t" + Risicoberekening.risico(pitstopronde, pitstopronde1, sbiteration, mbiteration, ebiteration) );
        }
    }


    private static void simulatie(int sbiteration, int mbiteration, int ebiteration, int eebiteration){
        simulated++;
        totalrt = 0;
        for (int ronde = 0; ronde <= totronde; ronde++) {
            if (ronde <= pitstopronde) {
                totalrt += rondetijd(ronde, sbiteration, ronde);
            } else if (ronde <= pitstopronde1) {
                totalrt += rondetijd(ronde, mbiteration, ronde - pitstopronde);
            } else if (ronde <= pitstopronde2){
                totalrt += rondetijd(ronde, ebiteration, ronde - pitstopronde1);
            } else {
                totalrt += rondetijd(ronde, eebiteration, ronde - pitstopronde2);
            }
        }
        totalrt += pitstoptijd;
        totalrt = round(totalrt,2);
        if (totalrt <= maxracetijd) {
            String bandentype1 = bandentype(sbiteration, 0);
            String bandentype2 = bandentype(mbiteration, 0);
            String bandentype3 = bandentype(ebiteration, 0);
            String bandentype4 = bandentype(eebiteration, 1);
            String bandentype = bandentype1+bandentype2+bandentype3+bandentype4;
            Save(bandentype + "\t" + pitstopronde + "\t" + pitstopronde1 + "\t" + pitstopronde2 + "\t" + totalrt + "\t" + Risicoberekening.risico(pitstopronde, pitstopronde1, pitstopronde2, sbiteration, mbiteration, ebiteration, eebiteration) );
        }
    }


    private static void strategie(int pitstops) {
        if (pitstops == 1) {
            for (int sbiteration = 3; sbiteration <= 5; sbiteration++) {
                for (int ebiteration = 3; ebiteration <= 5; ebiteration++) {
                    if (sbiteration == ebiteration) {
                        continue;
                    }
                    pitstopronde = 1;
                    for (int ptiteration = 0; ptiteration <= maxptiteration && ptiteration <= totronde; ptiteration++, pitstopronde++) {
                        if(Risicoberekening.risico(pitstopronde, sbiteration, ebiteration).equalsIgnoreCase("Klapband!")) {continue;}
                        simulatie(sbiteration,ebiteration);
                    }
                }
            }
        } else if (pitstops == 2) {
            for (int sbiteration = 3; sbiteration <= 5; sbiteration++) {
                for (int mbiteration = 3; mbiteration <= 5; mbiteration++) {
                    for (int ebiteration = 3; ebiteration <= 5; ebiteration++) {
                        if (sbiteration == mbiteration && sbiteration == ebiteration) {
                            continue;
                        }
                        pitstopronde = 1;
                        for (int ptiteration = 0; ptiteration <= maxptiteration && ptiteration <= totronde; ptiteration++, pitstopronde++) {
                            pitstopronde1 = 2;
                            for (int pt1iteration = 0; pt1iteration <= maxpt1iteration && pt1iteration <= totronde; pt1iteration++, pitstopronde1++) {
                                if (pitstopronde >= pitstopronde1) {
                                    continue;
                                }
                                if(Risicoberekening.risico(pitstopronde, pitstopronde1, sbiteration, mbiteration, ebiteration).equalsIgnoreCase("Klapband!")) {continue;}
                                simulatie(sbiteration,mbiteration,ebiteration);
                            }
                        }
                    }
                }

            }
        } else if (pitstops == 3) {
            for (int sbiteration = 3; sbiteration <= 5; sbiteration++) {
                for (int mbiteration = 3; mbiteration <= 5; mbiteration++) {
                    for (int ebiteration = 3; ebiteration <= 5; ebiteration++) {
                        for (int eebiteration = 3; eebiteration <= 5; eebiteration++) {
                            if (sbiteration == mbiteration && ebiteration == eebiteration) {
                                continue;
                            }
                            pitstopronde = 1;
                            for (int ptiteration = 0; ptiteration <= maxptiteration && ptiteration <= totronde; ptiteration++, pitstopronde++) {
                                pitstopronde1 = 2;
                                for (int pt1iteration = 0; pt1iteration <= maxpt1iteration && pt1iteration <= totronde; pt1iteration++, pitstopronde1++) {
                                    if (pitstopronde >= pitstopronde1) {continue;}
                                    pitstopronde2 = 3;
                                    for (int pt2iteration = 0; pt2iteration <= maxpt2iteration && pt2iteration <= totronde; pt2iteration++, pitstopronde2++) {
                                        if (pitstopronde1 >= pitstopronde2) {continue;}
                                        if (Risicoberekening.risico(pitstopronde, pitstopronde1, pitstopronde2, sbiteration, mbiteration, ebiteration, eebiteration).equalsIgnoreCase("Klapband!")){continue;}
                                        simulatie(sbiteration,mbiteration,ebiteration,eebiteration);
                                    }
                                }
                            }
                        }
                }
            }
        }
        }
    }
}