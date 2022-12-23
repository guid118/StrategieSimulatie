package me.guid118.StrategieSimulatie.Files;


import java.io.*;


import static me.guid118.StrategieSimulatie.Main.*;


public class Output {

    static File file;

    public static void CreateFile() {
        try {
            file = new File("Output_0.txt");
            File fileold = new File("Output_1.txt");
            if (!file.createNewFile()) {
                for (int i = 1; fileold.exists() && i <= 50; i++) {
                    fileold = new File("Output_" + i + ".txt");

                }
                file = fileold;
                file.createNewFile();
            }
            System.out.println("Output betstand wordt: " + file.getName());
        } catch (IOException e) {
            System.out.println("Er is een probleem opgetreden:");
            e.printStackTrace();
        }
        Save("Softrondetijd:\tMediumrondetijd:\tHardrondetijd\tpitstoptijd\tmaxpitstops\ttotale ronden");
        Save(Softrondetijd + "\t" + Mediumrondetijd + "\t" + Hardrondetijd + "\t" + pitstoptijd + "\t" + maxpitstops + "\t" + totronde);
        Save("volgorde bandentypes \t 1e pitstopronde \t 2e pitstopronde \t 3e pitstopronde \t totale race tijd (hoe kleiner hoe beter) \t risicofactor");
    }

    static String[] lines = new String[10000000];
    static int linenr = 0;

    public static void Save(String arg) {
        lines[linenr] = arg;
        linenr++;
    }


    public static void Write() {
        FileWriter fileWriter = null;
        String pathname = file.getName();
        try {
            File file = new File(pathname);
            fileWriter = new FileWriter(file);
            for (int i = 0; i <= lines.length - 1; i++) {
                if (lines[i] != null) {
                    fileWriter.write(lines[i] + "\n");
                }
            }
        } catch (IOException iOException) {
            System.out.println("Error : " + iOException.getMessage());
        } finally {
            System.out.println(simulated + " Strategieën gesimuleerd");
            System.out.println("waarvan " + (simulated-linenr) + " te traag waren");
            System.out.println(linenr + "resultaten opgeslagen in: " + file.getName());

            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException iOException) {
                    System.out.println("Error : " + iOException.getMessage());
                }
            }
        }
    }
}