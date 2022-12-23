package me.guid118.StrategieSimulatie.Files;



import me.guid118.StrategieSimulatie.utils.OrderedProperties;

import java.io.*;


import static me.guid118.StrategieSimulatie.Main.*;

public class Config {

    static File file;
    static String configFilePath = "config.properties";

    public static void CreateFile() {
        try {
            file = new File(configFilePath);
            if (!file.exists()) {
                file.createNewFile();
                Config.setdefaults();
            }
            FileInputStream propsInput = new FileInputStream(configFilePath);
            prop.load(propsInput);
            setdefaults();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setdefaults() {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(configFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            OrderedProperties.putIfAbsent("Azerbaijan", "zie hieronder instellingen");

            OrderedProperties.putIfAbsent("AzerbaijanSoft", "");
            OrderedProperties.putIfAbsent("Azerbaijan.Banden.Soft.rondetijd", "107.4");
            OrderedProperties.putIfAbsent("Azerbaijan.Banden.Soft.Maxgebruik", "14");
            OrderedProperties.putIfAbsent("Azerbaijan.Banden.Soft.Maxronden", "25");
            OrderedProperties.putIfAbsent("Azerbaijan.Banden.Soft.degradatie", "0.16");

            OrderedProperties.putIfAbsent("AzerbaijanMedium", "");
            OrderedProperties.putIfAbsent("Azerbaijan.Banden.Medium.rondetijd", "107.6");
            OrderedProperties.putIfAbsent("Azerbaijan.Banden.Medium.Maxgebruik", "27");
            OrderedProperties.putIfAbsent("Azerbaijan.Banden.Medium.Maxronden", "33");
            OrderedProperties.putIfAbsent("Azerbaijan.Banden.Medium.degradatie", "0.1");

            OrderedProperties.putIfAbsent("AzerbaijanHard", "");
            OrderedProperties.putIfAbsent("Azerbaijan.Banden.Hard.rondetijd", "108.2");
            OrderedProperties.putIfAbsent("Azerbaijan.Banden.Hard.Maxgebruik", "38");
            OrderedProperties.putIfAbsent("Azerbaijan.Banden.Hard.Maxronden", "45");
            OrderedProperties.putIfAbsent("Azerbaijan.Banden.Hard.degradatie", "0.05");

            OrderedProperties.putIfAbsent("Azerbaijanother", "");
            OrderedProperties.putIfAbsent("Azerbaijan.other.pitstops.tijd", "23");
            OrderedProperties.putIfAbsent("Azerbaijan.other.pitstops.minimum", "1");
            OrderedProperties.putIfAbsent("Azerbaijan.other.pitstops.maximum", "2");
            OrderedProperties.putIfAbsent("Azerbaijan.other.bestanden.maxtotaletijd", "6085");

            OrderedProperties.putIfAbsent("===================", "===============");
            OrderedProperties.putIfAbsent("England", "zie hieronder instellingen");
            OrderedProperties.putIfAbsent("EnglandSoft", "");
            OrderedProperties.putIfAbsent("England.Banden.Soft.rondetijd", "93.15");
            OrderedProperties.putIfAbsent("England.Banden.Soft.Maxgebruik", "17");
            OrderedProperties.putIfAbsent("England.Banden.Soft.Maxronden", "25");
            OrderedProperties.putIfAbsent("England.Banden.Soft.degradatie", "0.16");

            OrderedProperties.putIfAbsent("EnglandMedium", "");
            OrderedProperties.putIfAbsent("England.Banden.Medium.rondetijd", "93.4");
            OrderedProperties.putIfAbsent("England.Banden.Medium.Maxgebruik", "28");
            OrderedProperties.putIfAbsent("England.Banden.Medium.Maxronden", "33");
            OrderedProperties.putIfAbsent("England.Banden.Medium.degradatie", "0.1");

            OrderedProperties.putIfAbsent("EnglandHard", "");
            OrderedProperties.putIfAbsent("England.Banden.Hard.rondetijd", "93.7");
            OrderedProperties.putIfAbsent("England.Banden.Hard.Maxgebruik", "36");
            OrderedProperties.putIfAbsent("England.Banden.Hard.Maxronden", "44");
            OrderedProperties.putIfAbsent("England.Banden.Hard.degradatie", "0.05");

            OrderedProperties.putIfAbsent("Englandother", "");
            OrderedProperties.putIfAbsent("England.other.pitstops.tijd", "23");
            OrderedProperties.putIfAbsent("England.other.pitstops.minimum", "1");
            OrderedProperties.putIfAbsent("England.other.pitstops.maximum", "2");
            OrderedProperties.putIfAbsent("England.other.bestanden.maxtotaletijd", "5625");

            OrderedProperties.putIfAbsent("==================", "================");
            OrderedProperties.putIfAbsent("Netherlands", "zie hieronder instellingen");
            OrderedProperties.putIfAbsent("NetherlandsSoft", "");
            OrderedProperties.putIfAbsent("Netherlands.Banden.Soft.rondetijd", "75.2");
            OrderedProperties.putIfAbsent("Netherlands.Banden.Soft.Maxgebruik", "18");
            OrderedProperties.putIfAbsent("Netherlands.Banden.Soft.Maxronden", "23");
            OrderedProperties.putIfAbsent("Netherlands.Banden.Soft.degradatie", "0.16");

            OrderedProperties.putIfAbsent("NetherlandsMedium", "");
            OrderedProperties.putIfAbsent("Netherlands.Banden.Medium.rondetijd", "75.6");
            OrderedProperties.putIfAbsent("Netherlands.Banden.Medium.Maxgebruik", "26");
            OrderedProperties.putIfAbsent("Netherlands.Banden.Medium.Maxronden", "34");
            OrderedProperties.putIfAbsent("Netherlands.Banden.Medium.degradatie", "0.1");

            OrderedProperties.putIfAbsent("NetherlandsHard", "");
            OrderedProperties.putIfAbsent("Netherlands.Banden.Hard.rondetijd", "75.7");
            OrderedProperties.putIfAbsent("Netherlands.Banden.Hard.Maxgebruik", "38");
            OrderedProperties.putIfAbsent("Netherlands.Banden.Hard.Maxronden", "45");
            OrderedProperties.putIfAbsent("Netherlands.Banden.Hard.degradatie", "0.05");

            OrderedProperties.putIfAbsent("Netherlandsother", "");
            OrderedProperties.putIfAbsent("Netherlands.other.pitstops.tijd", "23");
            OrderedProperties.putIfAbsent("Netherlands.other.pitstops.minimum", "1");
            OrderedProperties.putIfAbsent("Netherlands.other.pitstops.maximum", "3");
            OrderedProperties.putIfAbsent("Netherlands.other.bestanden.maxtotaletijd", "5775");
        try {
            prop.store(os, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getvalues() {
        if ((race.equalsIgnoreCase("Azerbaijan") || (race.equalsIgnoreCase("baku") || race.equalsIgnoreCase("Azerbeidzjan")))) {
            System.out.println("laden van data voor race: " + race);

            OrderedProperties.putIfAbsent("Azerbaijan", "zie hieronder instellingen");

            OrderedProperties.putIfAbsent("AzerbaijanSoft", "");
            Softrondetijd = Double.parseDouble(OrderedProperties.get("Azerbaijan.Banden.Soft.rondetijd"));
            maxsoftgebruiks = Double.parseDouble(OrderedProperties.get("Azerbaijan.Banden.Soft.Maxgebruik"));
            maxsoftrondens = Double.parseDouble(OrderedProperties.get("Azerbaijan.Banden.Soft.Maxronden"));
            softdegradatie = Double.parseDouble(OrderedProperties.get("Azerbaijan.Banden.Soft.degradatie"));
            OrderedProperties.putIfAbsent("AzerbaijanMedium", "");
            Mediumrondetijd = Double.parseDouble(OrderedProperties.get("Azerbaijan.Banden.Medium.rondetijd"));
            maxmediumgebruiks = Double.parseDouble(OrderedProperties.get("Azerbaijan.Banden.Medium.Maxgebruik"));
            maxmediumrondens = Double.parseDouble(OrderedProperties.get("Azerbaijan.Banden.Medium.Maxronden"));
            mediumdegradatie = Double.parseDouble(OrderedProperties.get("Azerbaijan.Banden.Medium.degradatie"));
            OrderedProperties.putIfAbsent("AzerbaijanHard", "");
            Hardrondetijd = Double.parseDouble(OrderedProperties.get("Azerbaijan.Banden.Hard.rondetijd"));
            maxhardgebruiks = Double.parseDouble(OrderedProperties.get("Azerbaijan.Banden.Hard.Maxgebruik"));
            maxhardrondens = Double.parseDouble(OrderedProperties.get("Azerbaijan.Banden.Hard.Maxronden"));
            harddegradatie = Double.parseDouble(OrderedProperties.get("Azerbaijan.Banden.Hard.degradatie"));
            OrderedProperties.putIfAbsent("Azerbaijanother", "");
            pitstoptijd = Double.parseDouble(OrderedProperties.get("Azerbaijan.other.pitstops.tijd"));
            minpitstops = Integer.parseInt(OrderedProperties.get("Azerbaijan.other.pitstops.minimum"));
            maxpitstops = Integer.parseInt(OrderedProperties.get("Azerbaijan.other.pitstops.maximum"));
            maxracetijd = Double.parseDouble(OrderedProperties.get("Azerbaijan.other.bestanden.maxtotaletijd"));

            totronde = 50;
            maxptiteration = totronde - 1;
            maxpt1iteration = totronde - 2;

        } else if ((race.equalsIgnoreCase("England") || (race.equalsIgnoreCase("Silverstone")) || (race.equalsIgnoreCase("Engeland")) || (race.equalsIgnoreCase("Great Britain")) || (race.equalsIgnoreCase("")))) {
            System.out.println("Loading data for race " + race);

            OrderedProperties.putIfAbsent("===================", "===============");
            OrderedProperties.putIfAbsent("England", "zie hieronder instellingen");
            OrderedProperties.putIfAbsent("EnglandSoft", "");
            Softrondetijd = Double.parseDouble(OrderedProperties.get("England.Banden.Soft.rondetijd"));
            maxsoftgebruiks = Double.parseDouble(OrderedProperties.get("England.Banden.Soft.Maxgebruik"));
            maxsoftrondens = Double.parseDouble(OrderedProperties.get("England.Banden.Soft.Maxronden"));
            softdegradatie = Double.parseDouble(OrderedProperties.get("England.Banden.Soft.degradatie"));
            OrderedProperties.putIfAbsent("EnglandMedium", "");
            Mediumrondetijd = Double.parseDouble(OrderedProperties.get("England.Banden.Medium.rondetijd"));
            maxmediumgebruiks = Double.parseDouble(OrderedProperties.get("England.Banden.Medium.Maxgebruik"));
            maxmediumrondens = Double.parseDouble(OrderedProperties.get("England.Banden.Medium.Maxronden"));
            mediumdegradatie = Double.parseDouble(OrderedProperties.get("England.Banden.Medium.degradatie"));
            OrderedProperties.putIfAbsent("EnglandHard", "");
            Hardrondetijd = Double.parseDouble(OrderedProperties.get("England.Banden.Hard.rondetijd"));
            maxhardgebruiks = Double.parseDouble(OrderedProperties.get("England.Banden.Hard.Maxgebruik"));
            maxhardrondens = Double.parseDouble(OrderedProperties.get("England.Banden.Hard.Maxronden"));
            harddegradatie = Double.parseDouble(OrderedProperties.get("England.Banden.Hard.degradatie"));
            OrderedProperties.putIfAbsent("Englandother", "");
            pitstoptijd = Double.parseDouble(OrderedProperties.get("England.other.pitstops.tijd"));
            minpitstops = Integer.parseInt(OrderedProperties.get("England.other.pitstops.minimum"));
            maxpitstops = Integer.parseInt(OrderedProperties.get("England.other.pitstops.maximum"));
            maxracetijd = Double.parseDouble(OrderedProperties.get("England.other.bestanden.maxtotaletijd"));

            totronde = 52;
            maxptiteration = totronde - 1;
            maxpt1iteration = totronde - 2;

        } else if ((race.equalsIgnoreCase("Netherlands") || (race.equalsIgnoreCase("Zandvoort")) || (race.equalsIgnoreCase("nederland")))) {
            System.out.println("Loading data for race " + race);
            OrderedProperties.putIfAbsent("==================", "================");
            OrderedProperties.putIfAbsent("Netherlands", "zie hieronder instellingen");
            OrderedProperties.putIfAbsent("NetherlandsSoft", "");
            Softrondetijd = Double.parseDouble(OrderedProperties.get("Netherlands.Banden.Soft.rondetijd"));
            maxsoftgebruiks = Double.parseDouble(OrderedProperties.get("Netherlands.Banden.Soft.Maxgebruik"));
            maxsoftrondens = Double.parseDouble(OrderedProperties.get("Netherlands.Banden.Soft.Maxronden"));
            softdegradatie = Double.parseDouble(OrderedProperties.get("Netherlands.Banden.Soft.degradatie"));
            OrderedProperties.putIfAbsent("NetherlandsMedium", "");
            Mediumrondetijd = Double.parseDouble(OrderedProperties.get("Netherlands.Banden.Medium.rondetijd"));
            maxmediumgebruiks = Double.parseDouble(OrderedProperties.get("Netherlands.Banden.Medium.Maxgebruik"));
            maxmediumrondens = Double.parseDouble(OrderedProperties.get("Netherlands.Banden.Medium.Maxronden"));
            mediumdegradatie = Double.parseDouble(OrderedProperties.get("Netherlands.Banden.Medium.degradatie"));
            OrderedProperties.putIfAbsent("NetherlandsHard", "");
            Hardrondetijd = Double.parseDouble(OrderedProperties.get("Netherlands.Banden.Hard.rondetijd"));
            maxhardgebruiks = Double.parseDouble(OrderedProperties.get("Netherlands.Banden.Hard.Maxgebruik"));
            maxhardrondens = Double.parseDouble(OrderedProperties.get("Netherlands.Banden.Hard.Maxronden"));
            harddegradatie = Double.parseDouble(OrderedProperties.get("Netherlands.Banden.Hard.degradatie"));
            OrderedProperties.putIfAbsent("Netherlandsother", "");
            pitstoptijd = Double.parseDouble(OrderedProperties.get("Netherlands.other.pitstops.tijd"));
            minpitstops = Integer.parseInt(OrderedProperties.get("Netherlands.other.pitstops.minimum"));
            maxpitstops = Integer.parseInt(OrderedProperties.get("Netherlands.other.pitstops.maximum"));
            maxracetijd = Double.parseDouble(OrderedProperties.get("Netherlands.other.bestanden.maxtotaletijd"));

            totronde = 72;
            maxptiteration = totronde - 1;
            maxpt1iteration = totronde - 2;
            maxpt2iteration = totronde - 3;

        } else {
            System.out.println("Race not recognized, please enter a valid race!");
            System.exit(0);
        }

    }



}