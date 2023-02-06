package demon_slayer_game;

// Verktyg
import java.util.ArrayList;
import java.util.Scanner;

public class DEMON_SLAYER_GAME{
    // Spel variabler
    static Scanner sc = new Scanner(System.in);
    static boolean running = true;
    
    // Spelar variabler
    static ArrayList<String> playerNameList = new ArrayList<String>();
    static ArrayList<Integer> playerKillList = new ArrayList<Integer>();
   
    // Fiende variablar
    
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
    
    static void difficulty(){
        
    }
    
    static void scoreboard(){
        
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


