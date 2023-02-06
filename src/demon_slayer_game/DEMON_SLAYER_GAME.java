package demon_slayer_game;

// Verktyg
import java.util.ArrayList;
import java.util.Scanner;

public class DEMON_SLAYER_GAME{
    // Spel variabler
    static Scanner sc = new Scanner(System.in);
    static boolean running = true;
    static String difficulty = "NORMAL";
    
    // Spelar variabler
    static ArrayList<String> playerNameList = new ArrayList<String>();
    static ArrayList<Integer> playerKillList = new ArrayList<Integer>();
    static double playerDifficultyMultiplier = 1.2;
   
    // Fiende variablar
    static double  enemyDiffficultyMultiplyer = 1.0;
    public static void main(String[] args){
        //En simpel main som är kärnan av spelet.
        clearScreen();
        System.out.println("                                                                       DEMON SLAYER: BATTLE");
        while (running) {
            System.out.println("\tSTART MENU");
            System.out.println("[1] BATTLE");
            System.out.println("[2] DIFFICULTY");
            System.out.println("[3] SCOREBOARD");
            System.out.print("INPUT: ");
            String input = sc.nextLine();
            
            //En if-sats för att kolla vad användaren la in som input.
            if (input.equals("1")) {
                text();
                attack();
                break;
            } else if (input.equals("2")) {
                difficulty();
                continue;
            } else if (input.equals("3")) {
                scoreboard();
            } else {
                //Dock självklart om användaren stoppar in random text och fel number så säger programet till och låter hen försöka igen.
                clearScreen();
                System.out.println("                                                                    !!PLEASE ENTER A VALID INPUT!!");
            }
        }
    }
    
    static void attack(){
        
    }
    
    static void playerAttack(){
        
    }
    
    static void enemyAttack(){
        
    }
    
    static void scoreboard(){
        
    }
    
    static void difficulty(){
        clearScreen();
        while(true) {
            System.out.println("WHAT DIFFICULTY DO YOU WANT?");
            System.out.println("[1] NORMAL");
            System.out.println("[2] HARD");
            System.out.print("INPUT: ");
            String input = sc.nextLine();
            //Vi läser in användarens input och utför det dom väljer
            if (input.equals("1")) {
                // I normal mode så kommer skadan för fienden x med 1 så ingen skillnad medans spelaren får en x 1.1 på sin attack.
                difficulty = "NORMAL";
                enemyDiffficultyMultiplyer = 1;
                playerDifficultyMultiplier = 1.1;
            } else if (input.equals("2")) {
                //Och åt andra hålet för hårt dock fienden får en bit extra för att hålla det intressant.
                difficulty = "HARD";
                enemyDiffficultyMultiplyer = 1.2;
                playerDifficultyMultiplier = 1;
            } else {
                //Själklart om användaren inte läger in rätt input så säger vi till hen och låter de köra om.
                clearScreen();
                System.out.println("                                                                    !!YOU ENTERD A INVALID INPUT!!");
                continue;
            }
            //En liten konfirmation som jag tyckte va coolt att ha för design och för att användaren ska veta extra nogrant om vad om har valt.
            System.out.println("\nDIFFICULTY SET TO: " + difficulty);
            System.out.print("PRESS ENTER TO CONTINUE");
            input = sc.nextLine();
            clearScreen();
            break;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    static void weaponStats(){
        //Programet informerar användaren så att de kan strategis använda sina attacker.
        clearScreen();
        System.out.println("LITE ATTACK:");
        System.out.println("    - 75% Hit, 10% Miss, 10% Crit");
        System.out.println("NORMAL ATTACK:");
        System.out.println("    - 65% Hit, 30% Miss, 5% Crit");
        System.out.println("HEAVY ATTACK:");
        System.out.println("    - 27.5% Hit, 70% Miss, 2.5% Crit");
        System.out.print("\nPRESS ENTER TO RETURN");
        sc.nextLine();
        clearScreen();
    }
    
    static void text(){
        //En simpel förklaring av spelet så att användaren vet vad hen gör och dens mål.
            clearScreen();
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out
                .println("                                                                                     INFO:");
        System.out.println(
                "                                                 WELCOME PLAYER, YOU HAVE ENTERED THE BATTLE ARENA WHERE YOU FIGHT UNTIL YOU DIE");
        System.out.println(
                "                                              EVERY ROUND YOU WILL FACE A NEW DEMON AND GET TO CHOSSE BETWEEN 3 ATTACKS TO KILL IT");
        System.out.println(
                "                                                 IF YOU SUCCESFULLY KILL THE DEMON YOU WILL BE REWARDED A AMOUNT OF HEALTH BACK");
        System.out.println(
                "                                                             THE LONGEST SURVIVING PLAYER IS THE ULTIMATE DEMON SLAYER ");
        System.out.println(
                "\n                                                                   PLEASE PRESS ENTER TO START YOUR BATTLE");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        sc.nextLine();
        clearScreen();
    }
    
    public static void clearScreen(){
        // Detta är för att hålla consolen en bit ren och inte överflödda med text.
        System.out.println("\n\n\n\n");
    }
}


