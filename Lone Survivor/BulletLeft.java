import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * BulletLeft is for bullets that the Hero can shoot.
 * 
 * @author Vangelis Ventoulis
 * @version 
 */
public class BulletLeft extends Actor
{
    private final int BULLETSPEED = 25;
    private final int BULLETDAMAGE = 5;
    
    // the distance which the bullet can travel in the world
    private int bulletDistance = 10;
    
    public BulletLeft() 
    {
        // scale the image of the bullet to like to the real bullet
        getImage().scale(5, 2);
    }
    
    /**
     * Act - do whatever the BulletLeft wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        shootLeft();
    }

    /**
     * Method for checking the distance of the bullet that has traveled.
     */
    private void shootLeft() 
    {
        if (bulletDistance <= 0)
        {
            getWorld().removeObject(this);
        }
        
        else 
        {
            bulletDistance--;
            move(-BULLETSPEED);
        }
    }    
}
