package demon_slayer_game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DEMON_SLAYER_GAME {
    //PLAYER VARIABLES
    static String playerName;
    static int playerHealth;
    static int playerKills;
    static int totalPlayerKills = 0;
    static double playerDifficultyMultiplier = 1.2;
    static ArrayList<String> playerName_list = new ArrayList<String>();
    static ArrayList<Integer> kills = new ArrayList<Integer>();
    
    //ENEMY VARIABLES
    static int enemyHealth;
    static int totalEnemyDamage;
    static double enemyDiffficultyMultiplyer = 1;
    static int enemyNameListIndex = -1;
    static String[] enemyNameList = { "Muzan Kibutsuji", "Akaza", "Doma", "Gyutaro", "Daki", "Rui", "Enmu","Swamp demon", "Yahaba", "Susamaru", "Nakime", "Kyogai", "Erisu" };

    //GAME VARIABLES
    static String difficulty = "NORMAL";
    static int gameRound = 1;
    static Scanner sc = new Scanner(System.in);
     
    public static void main(String[] args) {
        GAMEMENU();
    }
    
    static void GAMEMENU(){
        boolean running = true;
        System.out
                .println("                                                                       DEMON SLAYER: BATTLE");
        while (running) {
            System.out.println("\tSTART MENU");
            System.out.println("[1] BATTLE");
            System.out.println("[2] DIFFICULTY");
            System.out.println("[3] SCOREBOARD");
            System.out.print("INPUT: ");
            
            //Läser in användarens input och utför det
            String input = sc.nextLine();
            if (input.equals("1")) {
                BATTLE();
                ATTACK(1.0, 1.2);
                break;
            } else if (input.equals("2")) {
                DIFFICULTY();
                continue;
            } else if (input.equals("3")) {
                SCOREBOARD();
            } else {
                //Om et finns en datatyp fel så kommer koden returnera uppot så att användaren lägger in korrekt input.
                CLEARSCREEN();
                System.out.println(
                        "                                                                    !!PLEASE ENTER A VALID INPUT!!");
            }
        }
    }
    
    static void DIFFICULTY(){
        CLEARSCREEN();
        while (true) {
            //Vi håller en while loop så att om det finns något fel så kan användaren returnera uppot och gå göra det igen. 
            System.out.println("WHAT DIFFICULTY DO YOU WANT?");
            System.out.println("[1] NORMAL");
            System.out.println("[2] HARD");
            System.out.print("INPUT: ");
            String input = sc.nextLine();
            /*Jag anger variablerna till deras svårighetsnivå som kommer att påverka attack skadan.
            Genom att använda mig av parameter så skickar jag över datan från difficulty rakt in i attack metoden 
            där dom kommer att användas av
            */
            if (input.equals("1")) {
                difficulty = "NORMAL";
                //Iden är då att när spelaren kör normal gör enemies deras normal skada medans spelaren får en 1.2x mer damage för att göra det en bit enklare.
                ATTACK(1.0,1.2 );
                
            } else if (input.equals("2")) {
                difficulty = "HARD";
                // Dock är så har vi gjort det i motsat så att enemyn är starkare.
                ATTACK(1.2,1.0 );

            } else {
                CLEARSCREEN();
                System.out.println(
                        "                                                                    !!YOU ENTERD A INVALID INPUT!!");
                continue;
            }
            //Confirmation meddelande så att användaren känner isg alltid vid kontroll.
            
            System.out.println("\nDIFFICULTY SET TO: " + difficulty);
            System.out.print("PRESS ENTER TO CONTINUE");
            input = sc.nextLine();
            CLEARSCREEN();
            break;
        }
        
    }
    static void BATTLE(){
        
    }
    static void ATTACK(double enemyDiffficultyMultiplyer, double playerDifficultyMultiplier ){
        
        
        
    }
    static void WEAPONSTATS(){
        
    }
    static void SCOREBOARD(){
        
    }
    static void CLEARSCREEN(){
        System.out.print("\033[H\033[2J");
    }
}
