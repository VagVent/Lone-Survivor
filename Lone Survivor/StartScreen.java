import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Start screen of the game.
 * 
 * @author Vangelis Ventoulis
 * @version 17/1/2021
 */
public class StartScreen extends World
{
    public static final int WIDTH = 1000;   // width viewport
    public static final int HEIGHT = 600;   // height viewport

    public StartScreen()
    {    
        // Create a new world with 1000*600 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1);
    }

    /**
     * The method by which the player has to press the Enter button to start the 1st level.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.playSound("shot_gun_reload.wav");
            Greenfoot.setWorld(new Level_1_World());
        }
    }
}
