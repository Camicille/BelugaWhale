import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main World class
 * 
 * @author Chandler Clarke, Tyler Bakeman, Phil
 * @version 1.2
 */
public class MyWorld extends greenfoot.World
{
    //World dimensions
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    //Timers
    private int timerHouse, timerTrees, timerHealth, devTimer, actTimer;
    private static int WORLDSPEED, MAXHEALTH, HOUSETIMERMAX, HEALTHTIMERMAX, TREETIMERMAX;
    //Various Integers
    private int yCoord, score, health = 0;
    //Booleans
    private boolean isDevMenuOpen;
private int randpt1;// determine if Goldfish spawn
   private int randpt2;// side
   private int randY; // Y cordinate for Goldfish spawn
    public MyWorld()
    {    
        super(WIDTH, HEIGHT, 1, false); 
        //World init
        prepare();
        //Static Variables
        MAXHEALTH = 5;
        WORLDSPEED = 4;
        HEALTHTIMERMAX = 200;
        HOUSETIMERMAX = 20;
        TREETIMERMAX = 10;
        //Player stat init
        health = 5;
        score = 0;
    }

    public void act(){
        if (actTimer < 1){
            //runs starting countdown
            countdown();
        }
        itemSpawner();
        //manages timers
        timers();
        //displays score and health
        scoreKeeper();
        //Activates the dev panel (invisible on startup, click m to activate)
        devPanelManager();
        //Act timer manager
        actTimer++;
        randpt1 =Greenfoot.getRandomNumber(200);
        randpt2 =Greenfoot.getRandomNumber(100);
        randY= Greenfoot.getRandomNumber(100);

  if (randpt1 <1 && randpt2 >50 ){addObject(new Goldfish(), 600, randY +150);}
  else if (randpt1 <1 && randpt2 <50 ){addObject(new Goldfish2(), 0, randY +150);}
    }
    //Builds base world
    private void prepare(){
        setPaintOrder(Car.class, Health.class, House.class, StartLine.class);
        //player init
                        //addObject(new Car(), 160, 200);
        //road init
        addObject(new Road(), 600, 200);
        addObject(new Road(), 200, 200);
        addObject(new Road(), -260, 200);
        //starting area init
        addObject(new StartLine(), 200, 200);
        addObject(new Tree(),113,374);
        addObject(new Tree(),168,326);
        addObject(new Tree(),265,374);
        addObject(new Tree(),331,331);
        addObject(new Tree(),488,371);
        addObject(new Tree(),583,325);
        addObject(new Tree(),459,320);
        addObject(new Tree(),394,380);
        addObject(new Tree(),66,334);
        addObject(new House(),183,86);
        addObject(new House(),376,87);
        addObject(new House(),532,87);
        addObject(new House(),75,89);
    }
    //Spawns randomly generated objects
    public void itemSpawner(){
        if(timerHouse >= HOUSETIMERMAX && Greenfoot.getRandomNumber(100) < 2){
            addObject (new House(), 650, 87);
            timerHouse = 0;
        }
        if(timerTrees >= TREETIMERMAX && Greenfoot.getRandomNumber(100) < 5){
            yCoord = Greenfoot.getRandomNumber(80) + 310;
            addObject (new Tree(), 650, yCoord);
            timerTrees = 0;
        }
        if(timerHealth >= HEALTHTIMERMAX && Greenfoot.getRandomNumber(100) < 1){
            yCoord = Greenfoot.getRandomNumber(107) + 165;
            addObject (new Health(), 650, yCoord);
            timerHealth = 0;
        }
    }
    //Timer method that helps remove overlap between background objects.
    private void timers(){
        devTimer++;
        timerHouse++;
        timerTrees++;
        timerHealth++;
        //Timer Maximums
        if (timerTrees >= TREETIMERMAX)
            timerTrees= TREETIMERMAX;
        if (timerHouse >= HOUSETIMERMAX)
            timerHouse = HOUSETIMERMAX;
        if (devTimer >= 50)
            devTimer = 50;
        if (timerHealth >= HEALTHTIMERMAX)
            timerHealth = HEALTHTIMERMAX;
    }
    //Sets points
    public void addScore(int points){
        score = score + points;
    }
    //Sets health
    public void addHealth(int change){
        health = health + change;
        if (health > MAXHEALTH)
            health = MAXHEALTH;
    }
    //sends world speed to external classes
    public int getSpeed(){
        return WORLDSPEED;
    }

    private void scoreKeeper(){
        showText("Score: " + score, 100, 25);
        showText("Health: " + health, 500, 25);    
    }

    private void devPanelManager(){
        if (isDevMenuOpen == true){
            devPanel();
        } else{
            showText("", 100, 300);
            showText("", 300, 300);
            showText("", 500, 300);
        }
        if (devTimer >= 50 && Greenfoot.isKeyDown("m")){
            if(isDevMenuOpen == false){
                isDevMenuOpen = true;
                devTimer = 0;
            }else{
                isDevMenuOpen = false;
                devTimer = 0;
            }
        }
    }

    private void devPanel(){
        showText("Timer House: " + timerHouse , 100, 300);
        showText("Timer Trees: " + timerTrees , 300, 300);
        showText("Timer Health: " + timerHealth , 500, 300);
    }
    
    private void countdown(){
        showText("Starting in 3...", 300, 180);
        Greenfoot.delay(30);
        showText("Starting in 2...", 300, 180);
        Greenfoot.delay(30);
        showText("Starting in 1...", 300, 180);
        Greenfoot.delay(30);
        showText("", 300, 180);
    }
}
