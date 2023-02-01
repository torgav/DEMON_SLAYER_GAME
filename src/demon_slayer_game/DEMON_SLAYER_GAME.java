package demon_slayer_game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DEMON_SLAYER_GAME {
    static Scanner sc = new Scanner(System.in);
    static String playerName;
    static int playerHealth;
    static int enemyHealth;
    static int totalEnemyDamage;
    static int playerKills;
    static int totalPlayerKills = 0;
    static String[] enemyNameList = { "Muzan Kibutsuji", "Akaza", "Doma", "Gyutaro", "Daki", "Rui", "Enmu","Swamp demon", "Yahaba", "Susamaru", "Nakime", "Kyogai", "Erisu" };
    static ArrayList<String> playerName_list = new ArrayList<String>();
    static ArrayList<Integer> kills = new ArrayList<Integer>();
    static String difficulty = "NORMAL";
    static double enemyDiffficultyMultiplyer = 1;
    static double playerDifficultyMultiplier = 1.2;
    static int enemyNameListIndex = -1;
    static int gameRound = 1;
    
    public static void main(String[] args) {
        
    }
    static void GAMEMENU(){
        
    }
    static void DIFFICULTY(){
        
    }
    static void BATTLE(){
        
    }
    static void ATTACK(){
        
    }
    static void WEAPONSTATS(){
        
    }
    static void SCOREBOARD(){
        
    }
    public static void CLEARSCREEN(){
        System.out.print("\033[H\033[2J");
    }
    
    
}
