import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Enemy class contains the method switch image witch is used from all enemies avatar
 * classes Zombie.
 * 
 * @author Vangelis Ventoulis 
 * @version 
 */
public class Enemy extends Actor
{
    
    private int currentImage = 0;
      
    /**
     * Method for switching images asset.
     */
    public GreenfootImage[] switchImage(GreenfootImage[] table, int NUM_OF_IMAGES) 
    {
        currentImage = (currentImage + 1) % NUM_OF_IMAGES;
        setImage(table[currentImage]);
        return table;
    }
}
