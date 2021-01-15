import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 1st Level
 * 
 * @author Vangelis Ventoulis
 * @version 
 */
public class Level_1_World extends World
{
    private static final int WIDE = 1000;   // width viewport
    private static final int HEIGHT = 600;  // height viewport
    
    private Hero hero;    
    private Scroller scroller;
    
    private Counter counter;    
    private HealthBar healthbar;
    
    /**
     * Constructor for objects of class MyWorld. 
     */
    public Level_1_World()
    {    
        // Create a new world with 3000x600 cells with a cell size of 1x1 pixels.
        super(WIDE, HEIGHT, 1, false);
        
        // Setup the background image of the 1st level.
        GreenfootImage backGround = new GreenfootImage("bg_level_1_3000x600.png");

        int backGroundWide = backGround.getWidth();  // scrolling image width
        int backGroundHigh = backGround.getHeight(); // scrolling image height
        
        // creates the Scroller object
        scroller = new Scroller(this, backGround, backGroundWide, backGroundHigh);
        
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        // add the ground of the 1st level
        Ground ground = new Ground();  
        addObject(ground,1501, 600);

        hero = new Hero();         // creates the actor to maintain view on        
        addObject(hero, 55, 500);  // add actor to world

        // add counter into the world
        counter = new Counter("Score: ");
        addObject(counter, 65, 25);

        // add Hero's healthbar into the world
        healthbar = new HealthBar();
        addObject(healthbar, 65, 60);

        /******************************************************************
         * 
         * Creation of the zombies at 1st level.
         * 
         *****************************************************************/

        Zombie_1 zombie_01 = new Zombie_1();
        addObject(zombie_01,612,500);

        Zombie_1 zombie_02 = new Zombie_1();
        addObject(zombie_02,712,500);

        Zombie_1 zombie_03 = new Zombie_1();
        addObject(zombie_03,919,500);

        Zombie_1 zombie_04 = new Zombie_1();
        addObject(zombie_04,1030,500);

        Zombie_1 zombie_05 = new Zombie_1();
        addObject(zombie_05,1112,500);

        Zombie_1 zombie_06 = new Zombie_1();
        addObject(zombie_06,1150,500);

        Zombie_1 zombie_07 = new Zombie_1();
        addObject(zombie_07,1250,500);

        Zombie_1 zombie_08 = new Zombie_1();
        addObject(zombie_08,1350,500);

        Zombie_1 zombie_09 = new Zombie_1();
        addObject(zombie_09,1850,500);

        Zombie_1 zombie_10 = new Zombie_1();
        addObject(zombie_10, 2050,500);

        Zombie_1 zombie_11 = new Zombie_1();
        addObject(zombie_11, 2150,500);

        Zombie_1 zombie_12 = new Zombie_1();
        addObject(zombie_12, 2350,500);

        Zombie_1 zombie_13 = new Zombie_1();
        addObject(zombie_13, 2550,500);

        Zombie_1 zombie_14 = new Zombie_1();
        addObject(zombie_14, 2750,500);

        Zombie_1 zombie_15 = new Zombie_1();
        addObject(zombie_15, 2850,500);

        /******************************************************************
         * 
         * End of the creation of the zombies.
         * 
         *****************************************************************/
    }
    
    /**
     * This method is called whenever the 'Act' or 'Run' button gets pressed
     * in the environment.
     */
    public void act()
    {
        if (hero != null)
        {
            scroll();
        }
    }
    
    /**
     * This method is to scroll the viewport. The center of the viewport is the Hero.
     */
    private void scroll() 
    {
        int dsx = hero.getX() - WIDE / 2;
        int dsy = hero.getY() - HEIGHT / 2;

        scroller.scroll(dsx, dsy);
    }
    
    /**
     * Method to add points at the counter.
     */
    public void addPointToCounter(int points)
    {
        counter.add(points);
    }

    /**
     * Getter of the value of the counter.
     */
    public int getCounter()
    {
        return counter.getValue();
    }
    
    /**
     * Getter of HealthBar.
     */
    public HealthBar getHealthBar()
    {
        return healthbar;
    }
    
    /**
     * Getter of the value of Hero's health.
     */
    public int getHealth()
    {
        return healthbar.getHealth();
    }
}
