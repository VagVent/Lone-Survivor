import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 1st Level
 * 
 * @ version (31/5/2020)
 */
public class Level_1_World extends World
{
    private Hero hero;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Level_1_World()
    {    
        // Create a new world with 3000x600 cells with a cell size of 1x1 pixels.
        super(3000, 600, 1);
        
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        hero = new Hero();         //creates the actor to maintain view on        
        addObject(hero, 55, 500);  //add actor to world

        Ground ground = new Ground();
        addObject(ground,1501, 600);
    }
}
