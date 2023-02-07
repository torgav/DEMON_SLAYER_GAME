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
        while(true){
            //playerAttack variables
            int randomNum = (int) (Math.random() * 1001);
            int playerMove;
            int playerAttackDamage = 0;

            //Player attack choice
            System.out.println("\nCHOSSE YOUR ATTACK:");
            System.out.println("[1] LITE ATTACK       [2] NORMAL ATTACK       [3] HEAVY ATTACK");
            System.out.print("INPUT:");

            //try ctach to prevent any errors occuring if the player inputs the wrong type of data.
            try {
                String input = sc.nextLine();
                playerMove = Integer.parseInt(input);
                clearScreen();
            } catch (Exception e) {
                clearScreen();
                System.out.println(
                        "                                                                    !!YOU ENTERD A INVALID INPUT!!");
                continue;
            }
            clearScreen();
            
            //Jag andvänder en switch case för att ta in de bestämde inputsen.
            switch (playerMove) {
                case 1:
                    System.out.println("YOU CHOSSE: LITE ATTACK");
                    //Med random num så har jag gjort det i procent med decimaler för att skapa chanserna av attackerna.
                    //Att träffa för denna attack så har du 75% chans att träffa
                    if (randomNum < 750) {
                        //För att kalkylera skadan så sätter jag 15 för standard skadan och gångrar det med svårighets faktorn som kan öka skadan.
                        //Vi skriver int framför föratt om produkten vlir en decimal så gör vi om den till en int, alltså en typ konvertering.
                        playerAttackDamage = (int) (15 * playerDifficultyMultiplier);
                        System.out.println("YOU DEALT: " + playerAttackDamage + " DAMAGE");
                        break;
                    } else if (randomNum >= 750 && randomNum <= 850) {
                        //I denna finns det 10% chans att missa
                        playerAttackDamage = 0;
                        System.out.println("YOUR ATTACK MISSED");
                        break;
                    } else if (randomNum > 850) {
                        //och i denna finns det en  15% chans för att få en crit chans.
                        //Då gör vi standrad skadan större och gångrar den med svårighets.
                        playerAttackDamage = (int) Math.ceil(22.5 * playerDifficultyMultiplier);
                        System.out.println("YOU GOT A CRIT! YOU DEALT: " + playerAttackDamage + " DAMAGE");
                        break;
                    }
                case 2:
                    System.out.println("YOU CHOSSE: NORMAL ATTACK");
                    //Här finns det en 65% chans att träffa 
                    //Också samma förklaring för allt här.
                    if (randomNum < 650) {
                        playerAttackDamage = (int) (30 * playerDifficultyMultiplier);
                        System.out.println("YOU DEALT: " + playerAttackDamage + " DAMAGE");
                        break;
                    } else if (randomNum >= 650 && randomNum <= 950) {
                        //30%
                        playerAttackDamage = 0;
                        System.out.println("YOUR ATTACK MISSED");
                        break;
                    } else if (randomNum > 950) {
                        //5%
                        playerAttackDamage = (int) Math.ceil(45 * playerDifficultyMultiplier);
                        System.out.println("YOU GOT A CRIT! YOU DEALT: " + playerAttackDamage + " DAMAGE");
                        break;
                    }
                case 3:
                    System.out.println("YOU CHOSSE: HEAVY ATTACK");
                    if (randomNum < 275) {
                        //27.5%
                        playerAttackDamage = (int) (45 * playerDifficultyMultiplier);
                        System.out.println("YOU DEALT: " + playerAttackDamage + " DAMAGE");
                        break;
                    } else if (randomNum >= 275 && randomNum <= 975) {
                        //70%
                        playerAttackDamage = 0;
                        System.out.println("YOUR ATTACK MISSED");
                        break;
                    } else if (randomNum > 975) {
                        //2.5%
                        playerAttackDamage = (int) Math.ceil(67.5 * playerDifficultyMultiplier);
                        System.out.println("YOU GOT A CRIT! YOU DEALT: " + playerAttackDamage + " DAMAGE");
                    }
                    break;
                default:
                    //Detta är en till typfel om användaren i början skriver in ett nummer men det är inte skriven i denna switch case så 
                    //kommer andvändraen få en fel meddelande och försöka igen.
                    clearScreen();
                    System.out.println(
                            "                                                                    !!YOU ENTERD A INVALID INPUT!!");
                    continue;
            }
            //Ändrar hälsan på enemy 
            enemyHealth = enemyHealth - playerAttackDamage;
            //Detta stoppar att hp ska gå minus som ser vara dåligt ut så vi kollar vilket nummer är större och läger den i variabeln.
            enemyHealth = Math.max(0, enemyHealth);

            System.out.println(enemyName + "'s health is now: " + enemyHealth + "\n");
            break;
        }
        return enemyHealth;
        
       
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


