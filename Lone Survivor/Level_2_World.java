import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 2nd Level.
 * 
 * @author Vangelis Ventoulis
 * @version 
 */
public class Level_2_World extends World
{
    private static final int WIDTH = 1000; // width viewport
    private static final int HEIGHT = 600; // height viewport

    private Hero hero;    
    private Scroller scroller;
    
    private Counter counter;    
    private HealthBar healthbar;

    /**
     * Constructor for objects of class Level_2_World.
     */
    public Level_2_World(Hero hero, int points)
    {    
        // create a new world with 1000*600 such as the viewport cells with a cell 
        // size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1, false);

        // Setup the background image of the 1st level.
        GreenfootImage backGround = new GreenfootImage("bg_Level2_4000x600.png");

        int backGroundWidth = backGround.getWidth();   // scrolling image width
        int backGroundHeigth = backGround.getHeight(); // scrolling image height

        this.hero = hero;

        // creates the Scroller object
        scroller = new Scroller(this, backGround, backGroundWidth, backGroundHeigth);

        // prepare the 2nd level with the Hero and the points which are gain at the
        // 1st level
        prepare(hero, points);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare(Hero hero, int points)
    {
        // add the road as the ground of the 2nd level
        Ground ground = new Ground();
        addObject(ground,1501, 600);
        ground.setImage("road.png");
        ground.getImage().scale(5000, 100);

        // add the Hero to world
        addObject(hero, 55, 500);

        // add the counter into the world
        counter = new Counter("Score: ");
        // set the value of the counter from the 1st level 
        counter.setValue(points);
        addObject(counter, 65, 25);

        // add Hero's healthbar into the world
        healthbar = new HealthBar();
        addObject(healthbar, 65, 60);

        /******************************************************************
         * 
         * Creation of the zombies at 2nd level.
         * 
         *****************************************************************/

        Zombie_2 zombie_01 = new Zombie_2();
        addObject(zombie_01,722,500);

        Zombie_3 zombie_03 = new Zombie_3();
        addObject(zombie_03,1379,500);

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
        int dsx = hero.getX() - WIDTH / 2;
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
     * Getter the value of how many zombies have been killed by the Hero.
     */
    public int getEnemyKills()
    {
        return counter.getEnemyKills();
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
