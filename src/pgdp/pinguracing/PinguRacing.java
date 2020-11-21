package pgdp.pinguracing;

import static pgdp.MiniJava.*; //Diesen Import nicht löschen! Do not delete this import!
import static pgdp.MiniJava.readInt;

public class PinguRacing {
    public static void main(String[] args) {

        //Declaration of variables.
        int pos_a = readInt("Alan Startposition:");
        int pos_b = readInt("Bjarne Startposition:");
        int t_dauer = readInt("Renndauer:");
        int []t = new int[10000000];
        int ges_a = 0;
        int ges_b = 0;
        int i = 0;


        //Error message.
        while (t_dauer < 0){
            t_dauer = readInt("Bitte keine negative Zahl eingeben:");}

        //Race.
        while (t_dauer>i) {
            t[i] = i;
                //Conditions for the first half of the race.
                if (t[i]<t_dauer/2) {
                    //Tetraphobia.
                    if (pos_a %5 == 4 && pos_a %2 ==0){
                        ges_a = ges_a/2 + 1;
                            //Condition of max speed an no negative speed.
                            if (ges_a>128 || ges_a < 0){
                                ges_a = 0;}
                        pos_a += ges_a;}
                    //Normal increase/decrease of speed.
                    else{
                        ges_a = (ges_a + 7);
                            if (ges_a>128|| ges_a < 0){
                                ges_a = 0;}
                        pos_a += ges_a;}
                    //Triskaidekaphobia.
                    if (pos_b % 13 == 0 && pos_b!=0){
                        ges_b = (ges_b* 2) + 1;
                            if (ges_b>128|| ges_b < 0){
                                ges_b = 0;}
                        pos_b += ges_b;}
                    //Normal increase/decrease of speed.
                    else{
                        ges_b = ges_b+3;
                            if (ges_b>128|| ges_b < 0){
                                ges_b = 0;}
                        pos_b += ges_b;}

                //Conditions for the second half of the race.
                }else {
                    //3/5 and 4/5 of the time condition for Alan.
                    if ((t[i] >= 0.5 * t_dauer) && (t[i] <= 0.8 * t_dauer)) {
                        ges_a = ges_a / 4;//No need for max and negative speed condition,
                        pos_a += ges_a;   //since it is a division operation.
                    //Normal increase/decrease of speed.
                    } else {
                        ges_a++;
                            if (ges_a>128|| ges_a < 0){
                                ges_a = 0;}
                        pos_a += ges_a;
                    }
                    //Last 13 seconds of the race condition for Bjarne.
                    if (t[i] >= t_dauer - 13) {
                        ges_b = ges_b / 2;
                        pos_b += ges_b;
                    //Normal increase/decrease of speed.
                    } else {
                        ges_b--;
                            if (ges_b>128 || ges_b < 0){
                                ges_b = 0;}
                        pos_b += ges_b;
                    }
                }
            //Results of each individual second.
            write("t = " + t[i] + "\nAlan Position = "+ pos_a+"; Geschwindigkeit = " + ges_a +
            "\nBjarne Position = "+ pos_b+"; Geschwindigkeit = " + ges_b);
            i++;
        }
        //Winner Penguin.
        if (pos_a > pos_b)
            write("Alan gewinnt!");
        if (pos_a < pos_b)
            write("Bjarne gewinnt!");
        if (pos_a == pos_b)
            write("Unentschieden!");

    }
}
