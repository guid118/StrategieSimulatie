package me.guid118.StrategieSimulatie;


import static me.guid118.StrategieSimulatie.Main.*;

public class Risicoberekening {

    static int bandronde;
    static int bandronde1;
    static int bandronde2;
    static int bandronde3;
    static double hriskbandronde;


    public static String risico(int pitstopronde, int sbiteration, int ebiteration) {
        double risk;
        double risk1;
        String risico;
        bandronde = pitstopronde;
        bandronde1 = totronde - pitstopronde;

        double a = 0.005 * (totronde / 2) + 0.75;
        double multipliera = a;
        double multiplierb = 0.005 * (pitstopronde) + a;


        double maxsoftrondena = maxsoftrondens*multipliera;
        double maxmediumrondena = maxmediumrondens*multipliera;
        double maxhardrondena = maxhardrondens*multipliera;

        double maxsoftrondenb = maxsoftrondens*multiplierb;
        double maxmediumrondenb = maxmediumrondens*multiplierb;
        double maxhardrondenb = maxhardrondens*multiplierb;


        if (sbiteration == 5)
            risk = (double) bandronde / maxsoftrondena;
        else if (sbiteration ==4)
            risk = (double) bandronde / maxmediumrondena;
        else if (sbiteration == 3)
            risk = (double) bandronde / maxhardrondena;
        else
            risk = (double) bandronde / totronde;

        if (ebiteration == 5)
            risk1 = (double) bandronde1 / maxsoftrondenb;
        else if (ebiteration ==4)
            risk1 = (double) bandronde1 / maxmediumrondenb;
        else if (ebiteration == 3)
            risk1 = (double) bandronde1 / maxhardrondenb;
        else
            risk1 = (double) bandronde1 / totronde;

        double hriskbandronde = Math.max(risk, risk1);

        if (hriskbandronde <= 0.80){
            risico = "laag";
        } else if (hriskbandronde <= 0.9) {
            risico = "gemiddeld";
        } else if (hriskbandronde <= 0.95) {
            risico = "hoog";
        } else if (hriskbandronde <= 0.9999){
            risico = "zeer hoog";
        } else {
            risico = "Klapband!";
        }
        return risico;
    }

    public static String risico(int pitstopronde, int pitstopronde1, int sbiteration, int mbiteration, int ebiteration) {
        double risk = 0;
        double risk1 = 0;
        double risk2 = 0;
        String risico;

        bandronde = pitstopronde;
        bandronde1 = pitstopronde1 - pitstopronde;
        bandronde2 = totronde - pitstopronde1;

        double a = 0.005 * (totronde / 2) + 0.75;
        double multipliera = 0.005 * (0) + a;
        double multiplierb = 0.005 * (pitstopronde) + a;
        double multiplierc = 0.005 * (pitstopronde1) + a;

        double maxsoftrondena = maxsoftrondens*multipliera;
        double maxmediumrondena = maxmediumrondens*multipliera;
        double maxhardrondena = maxhardrondens*multipliera;

        double maxsoftrondenb = maxsoftrondens*multiplierb;
        double maxmediumrondenb = maxmediumrondens*multiplierb;
        double maxhardrondenb = maxhardrondens*multiplierb;

        double maxsoftrondenc = maxsoftrondens*multiplierc;
        double maxmediumrondenc = maxmediumrondens*multiplierc;
        double maxhardrondenc = maxhardrondens*multiplierc;

        if (sbiteration == 5) {
            risk = (double) bandronde / maxsoftrondena;
        } else if (sbiteration == 4) {
            risk = (double) bandronde / maxmediumrondena;
        } else if (sbiteration == 3) {
            risk = (double) bandronde / maxhardrondena;
        }
        if (mbiteration == 5) {
            risk1 = (double) bandronde1 / maxsoftrondenb;
        } else if (mbiteration == 4) {
            risk1 = (double) bandronde1 / maxmediumrondenb;
        } else if (mbiteration == 3) {
            risk1 = (double) bandronde1 / maxhardrondenb;
        }
        if (ebiteration == 5) {
            risk2 = (double) bandronde2 / maxsoftrondenc;
        } else if (ebiteration == 4) {
            risk2 = (double) bandronde2 / maxmediumrondenc;
        } else if (ebiteration == 3) {
            risk2 = (double) bandronde2 / maxhardrondenc;
        }

        hriskbandronde = Math.max(risk, risk1);
        double hriskbandronde1 = Math.max(hriskbandronde, risk2);

        if (hriskbandronde1 <= 0.80){
            risico = "laag";
        } else if (hriskbandronde1 <= 0.9) {
            risico = "gemiddeld";
        } else if (hriskbandronde1 <= 0.95) {
            risico = "hoog";
        } else if (hriskbandronde1 <= 0.9999){
            risico = "zeer hoog";
        } else {
            risico = "Klapband!";
        }

        return risico;
    }
    public static String risico(int pitstopronde, int pitstopronde1, int pitstopronde2, int sbiteration, int mbiteration, int ebiteration, int eebiteration) {
        double risk = 0;
        double risk1 = 0;
        double risk2 = 0;
        double risk3 = 0;
        String risico;

        bandronde = pitstopronde;
        bandronde1 = pitstopronde1 - pitstopronde;
        bandronde2 = pitstopronde2 - pitstopronde1;
        bandronde3 = totronde - pitstopronde2;

        double a = 0.005 * (totronde / 2) + 0.75;
        double multipliera = 0.005 * (0) + a;
        double multiplierb = 0.005 * pitstopronde + a;
        double multiplierc = 0.005 * pitstopronde1 + a;
        double multiplierd = 0.005 * pitstopronde2 + a;

        double maxsoftrondena = maxsoftrondens*multipliera;
        double maxmediumrondena = maxmediumrondens*multipliera;
        double maxhardrondena = maxhardrondens*multipliera;

        double maxsoftrondenb = maxsoftrondens*multiplierb;
        double maxmediumrondenb = maxmediumrondens*multiplierb;
        double maxhardrondenb = maxhardrondens*multiplierb;

        double maxsoftrondenc = maxsoftrondens*multiplierc;
        double maxmediumrondenc = maxmediumrondens*multiplierc;
        double maxhardrondenc = maxhardrondens*multiplierc;

        double maxsoftrondend = maxsoftrondens*multiplierd;
        double maxmediumrondend = maxmediumrondens*multiplierd;
        double maxhardrondend = maxhardrondens*multiplierd;

        //TODO Infinity?
        if (sbiteration == 5) {
            risk = (double) bandronde / maxsoftrondena;
        } else if (sbiteration == 4) {
            risk = (double) bandronde / maxmediumrondena;
        } else if (sbiteration == 3) {
            risk = (double) bandronde / maxhardrondena;
        }
        if (mbiteration == 5) {
            risk1 = (double) bandronde1 / maxsoftrondenb;
        } else if (mbiteration == 4) {
            risk1 = (double) bandronde1 / maxmediumrondenb;
        } else if (mbiteration == 3) {
            risk1 = (double) bandronde1 / maxhardrondenb;
        }
        if (ebiteration == 5) {
            risk2 = (double) bandronde2 / maxsoftrondenc;
        } else if (ebiteration == 4) {
            risk2 = (double) bandronde2 / maxmediumrondenc;
        } else if (ebiteration == 3) {
            risk2 = (double) bandronde2 / maxhardrondenc;
        }
        if (eebiteration == 5) {
            risk3 = (double) bandronde3 / maxsoftrondend;
        } else if (eebiteration == 4) {
            risk3 = (double) bandronde3 / maxmediumrondend;
        } else if (eebiteration == 3) {
            risk3 = (double) bandronde3 / maxhardrondend;
        }

        hriskbandronde = Math.max(risk, risk1);
        double hriskbandronde1 = Math.max(risk2, risk3);
        double hriskbandronde2 = Math.max(hriskbandronde, hriskbandronde1);

        if (hriskbandronde2 <= 0.80){
            risico = "laag";
        } else if (hriskbandronde2 <= 0.9) {
            risico = "gemiddeld";
        } else if (hriskbandronde2 <= 0.95) {
            risico = "hoog";
        } else if (hriskbandronde2 <= 0.9999){
            risico = "zeer hoog";
        } else {
            risico = "Klapband!";
        }
        return risico;
    }



}
