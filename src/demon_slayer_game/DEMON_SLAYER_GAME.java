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
    static int totalEnemyDamage;
    
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
        //VI tar in spelar namn så att vi kan spara dom i en lista för mn scoreboard.
        clearScreen();
        System.out.print("ENTER YOUR PLAYERNAME: ");
        String playerName = sc.nextLine();
        playerNameList.add(playerName);
        clearScreen();

        //Denna boolean är lite extra vara ser bättre ut att ha running så att om man kollar på koden så förstår man att allt inom den här while loopen är vad som körs.
        boolean running = true;
        
        //Variabler som behövs vara i denna metod.
        int enemyNameListIndex = -1;
        String[] enemyNameList = { "Muzan Kibutsuji", "Akaza", "Doma", "Gyutaro", "Daki", "Rui", "Enmu","Swamp demon", "Yahaba", "Susamaru", "Nakime", "Kyogai", "Erisu" };
        int enemyHealth = 125;
        int playerHealth = 150;
        String enemyName;
        int gameRound = 0;
        int playerKills = 0;

        while(running){
            /* Vi börjar denna variable med -1 utanför loopen så att varje gång vi börjar om loopen så kommer vi ändra index numret i namn lsitan 
            * så att vi får ett nytt namn. Detta också för spel rundan.
            */ 
            enemyNameListIndex++;
            gameRound++;
            enemyName = enemyNameList[enemyNameListIndex];

            //Informerar andvändaren om lit fakta
            System.out.println("ROUND " + gameRound);
            System.out.println(playerName + " VS " + enemyName);
            System.out.println("LETS FIGHT!");

            while (true) {
                System.out.println("\nCHOSSE ACTION:");
                System.out.println("[1] ATTACK");
                System.out.println("[2] WEAPON STATS");
                System.out.println("[3] EXIT");
                System.out.print("INPUT: ");
                //Läser in igen inputen av andvämndaren 
                String input = sc.nextLine();
                if (input.equals("1")) {
                    clearScreen();
                    break;
                } else if (input.equals("2")) {
                    weaponStats();
                } else if (input.equals("3")) {
                    playerKillList.add(playerKills);
                    main(null);
                } else {
                    clearScreen();
                    System.out.println(
                            "                                                                    !!YOU ENTERD A INVALID INPUT!!");
                    continue;
                }
            }   

            while(true){ 
                // Vi anropar playerAttack metoden och från det så drar vi ut enemy health
                enemyHealth = playerAttack(enemyHealth, enemyName);
    
                //Nu så kollar vi enemy hälsa är noll altså den dog, och du gör det som behövs.
                if (enemyHealth <= 0) {
                    System.out.println("!!YOU DEFETED " + enemyName + "!!");
                    playerKills++;
                    //Beroende på svårigehst nivån som var vald så ger vi tillbaka ett viss anatl hälsa.
                    if (difficulty == "HARD") {
                        playerHealth = (int) Math.ceil(playerHealth + totalEnemyDamage * 0.85);
                    } else {
                        playerHealth = (int) Math.ceil(playerHealth + totalEnemyDamage * 0.75);
                    }
                    //reset:ar denna variable så att gamal data sparas kvar och blir vara större o större.
                    totalEnemyDamage = 0;
                    //Dessutom så tar vi hp tillbaka till sin orginal så att den nya enemyn får tillbaka fulla hp som den ska ha.
                    enemyHealth = 125;
                    
                    System.out.println("YOU HAVE REGAIN HEALTH TO: " + playerHealth);
                    System.out.print("PRESS ENTER TO PROCCEDE TO THE NEXT DEMON");
                    sc.nextLine();
                    clearScreen();
                    break; 
                //Om enemy hälsa är över 0 så fortsätter vi till enemys chans att attackera oss.
                } else {
                    System.out.print("PRESS ENTER FOR DEMONS TURN");
                    sc.nextLine();
                    clearScreen();
                }
                
                //Nu kör vi motsåndrens attack så att den ska skada oss, och vi drar ut spelarens hp för att det är den som blir förändrad i metoden.
                playerHealth = enemyAttack(playerHealth, enemyName);

                //Efter att motståndaren kör så ska vi kolla om dens attack dödade oss.
                if (playerHealth <= 0) {
                    //OM vi dog så säger vi det till spelaren och av vem.
                    System.out.println("\nYOU GOT KILLED BY " + enemyName);
                    //Och då när vi dör så skickar vi hur många kills vi fick in i en array lista.
                    playerKillList.add(playerKills);
                    
                    //Simpel return till menun för att fortsätta.
                    System.out.print("PRESS ENTER TO RETURN TO GAME MENU");
                    sc.nextLine();
    
                    clearScreen();
                    main(null);
                } else {
                    //Om spelaren inte dör så informerar vi hur mycket hp den hara kvar
                    System.out.println("YOUR HP IS NOW: " + playerHealth);
                    System.out.print("\nPRESS ENTER FOR YOUR TURN");
                    sc.nextLine();
                    clearScreen();
                    
                    //Detta meddelande kommer visas när spelaren attackerar så att de inte behöver komma ihåg själv hp:en av dom och enemy
                    //Då kan spelaren strategis göra nästa attack.
                    System.out.println(enemyName + "'s HP: " + enemyHealth);
                    System.out.println("YOUR HP: " + playerHealth);
                }
            }
        }
    }
    
    static int playerAttack(int enemyHealth, String enemyName){
        weaponStats();
        
        return 0;
    }
    
    static int enemyAttack(int playerHealth, String enemyName){
        return 0;
    }
    
    
    
   
    static void scoreboard(){
        
    }
    
    static void difficulty(){
        clearScreen();
        while(true){
            System.out.println("WHAT DIFFICULTY DO YOU WANT?");
            System.out.println("[1] NORMAL");
            System.out.println("[2] HARD");
            System.out.print("INPUT: ");
            //Vi läser in användarens input och utför det dom väljer
            String input = sc.nextLine();
            if (input.equals("1")) {
                 // I normal mode så kommer skadan för fienden x med 1 så ingen skillnad medans spelaren får en x 1.1 på sin attack.
                difficulty = "NORMAL";
                enemyDiffficultyMultiplyer = 1;
                playerDifficultyMultiplier = 1.2;
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
       System.out.print("\033[H\033[2J");
    }
}


