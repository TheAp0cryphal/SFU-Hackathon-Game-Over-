package com.example.gameoversfu;


import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Layout {
    private static Layout instance;
    //List<List<Cell>> listOfCells = new ArrayList<>(5);
    Cell[][] cell = new Cell [5][5];
    String [][] s = new String [5][5];
    int i;
    int j;


    public Layout() {


        s[0][0] = "You are at SFU, a mountain of darkness. Below the permanent, heavy cloud cover, pregnant with rain, you stand at the bus stop you got off at and wonder what you should do. Ahead of you, two raccoons, the resident mascots of the mountain, slinker away towards the North and the East."; //east, south
        s[0][1] = "The racoon that came from the West, keeps walking, they look cute, but you are not sure whether they are friendly. You wonder whether it is best to keep your distance. You decide the racoon is female and call her Nellie. Nellie turns south and continues "; //east,west, south
        s[1][1] = "Suddenly, Nellie the racoon that came from the North begins running in the same direction: South. You wonder whether she noticed you and began running or there is something else going on. "; //north east, west south
        s[2][1] = "Nellie the racoon ran from The North and turned East. Still a short walk away, you see one of SFU’s four stream waste disposal bins, Nellie stops in front of it and stares at it with an almost expectant look."; //north, east, west, south
        s[2][2] = "Nellie jumps into one of the four-stream waste disposable bins. You know it is there for food, or is it? You investigate the bin and see Nellie rummaging for food in the mixed paper bin. You realize you have food you had to throw, but you know you cannot contaminate the wastepaper. What do you do? "; //options

        s[1][0] = "You follow the racoon that came from the North. Far ahead in the South you hear a low growling noise, something menacing is lurking, but is it close enough? "; // north, west, south
        s[2][0] = "The Northern racoon, just ahead. Curiosity triumphs and you wish to explore what is making the low, growling sound. You want to follow the sound despite your better judgement. It seems closer, yet far away towards the South. "; //north, west, south
        s[3][0] = "The racoon you followed from the North is no where to be seen, it seems it vanished. You feel on edge, maybe there is something sinister on this mountain. The sound is slowly getting louder and you wonder whether you made the correct decision."; //north, west, south
        s[4][0] = "You scream! The Northern racoon you followed races past you, not even caring you were standing there. The low growling is loud, and you see a shadowy mass closer in the trees to the East than you would have liked. Your curiosity however cannot be satiated."; //norht, west
        s[4][1] = "You approach the shadow, and you realize that shadow approached you too. From the trees – oh no! It’s a bear! You see some rocks in front of you and in your fear you wonder what to do with the menacing bear? "; //north, west, east

        s[3][1] = "At this moment you realize you are new here and no one knows you. Being the smart human you are, you realize it would be a good idea to go and get and ID. You see a map of the mountain to the East."; //north, east, west, south
        s[3][2] = "You see the map and see a building called MBC, a place you had heard would give you an ID. The map tells you to go South "; // north east west south
        s[4][2] = "The map in the North that told you to go South. Then you remember the map told you to go keep going East until you cannot go anymore, and there you will find MBC, the place for your ID, you feel like you are on a quest! "; //north east west
        s[4][3] = "Keeping the map you saw earlier from the West in mind, you decide going East was your best bet to get the ID from MBC. The quest for the ID is almost over."; // norht east west
        s[4][4] = "You get to the MBC building. You know you have to enter the building, follow the signs and get the ID. There are many different things to do as well, you can get food, go to the doctor, go to the bookstore, watch the never-ending construction which you were told was going to end soon, but you know it will not. What do you do? "; //north west

        s[3][4] = "What a lovely day it is, you think, as you see the grey clouds, it would be amazing to see the beautiful places in SFU. You remember hearing about a nice pond called the AQ pond. You see another map board to the West, how useful these are! "; //south west
        s[3][3] = "The map board you arrived at from the West tells you to go North first then head East. You realize you can see a lot of SFU as you walk, what a nice adventure! "; //north, east, west, south
        s[2][3] = "You are someone who follows the map diligently, the map you saw in the South. As you walk between the trees, you see the students, walking like they are busy, but in reality, they are just procrastinating. Determined you keep walking. "; //north south
        s[1][3] = "The map from the South told you about the pond and you start feeling a breeze. You see statues of Terry Fox and the famous Avocado. You know the pond is near, just to the East. "; //north east west south
        s[1][2] = "You get to the MBC building. You know you have to enter the building, follow the signs and get the ID. There are many different things to do as well, you can get food, go to the doctor, go to the bookstore, watch the never-ending construction which you were told was going to end soon, but you know it will not. What do you do? "; //north east west

        s[0][2] = "Professors are wonderful! After all they teach you, although sometimes you really are just teaching yourself. It’s always a good thing to attend office hours. You decide it would be a good idea to attend on of these. You see a map board to the West."; //east west
        s[0][3] = "The map form the East tells you that the professor you were looking to attend the office hours of is in the AQ, which is West and then South. "; //east, west south
        s[0][4] = "Being the diligent and obedient human being you are, you follow the Eastern map’s instructions, you are going on an adventure! "; //
        s[1][4] = "The trees rustle by, and more students are going around minding their own business, especially the ones studying business at Beedie, thinking they have business to handle but in reality, they don’t. You are almost to the office and see the door ahead of you to the South."; //
        s[2][4] = "At the office hours you realize you forgot to complete on of the assignments. The assignment was very important and doing it would have taught you a valid reason. You enter the door anyway, just to have a chat with the professor. "; //
        i = 0;
        j = 0;
        for(int i =0; i<5;i++)
        {
            for(int j=0; j<5; j++)
            {
                cell[i][j] = new Cell(i,j,s[i][j]);
            }
        }
    }
    boolean go_north() {
        if( (i-1) < 0 )  {
            return false;
        }
        else
            i--;

      //  System.out.println("You go North.");
        return true;
    }
    boolean go_south() {
        if( (i+1) > 4 )  {

            return false;
        }
        else
            i++;

       // System.out.println("You go South.");
        return true;
    }
    boolean go_west() {
        if( (j-1) < 0 )  {

            return false;
        }
        else
            j--;

       // System.out.println("You go East.");
        return true;
    }
    boolean go_east() {
        if( (j+1) > 4 )  {

            return false;
        }
        else
            j++;

      //  System.out.println("You go West.");
        return true;
    }
        public static Layout getInstance()
        {
            if(instance == null)
                instance = new Layout();
                return instance;
        }
        public String getString(int x, int y)
        {
            return s[x][y];
        }
}
