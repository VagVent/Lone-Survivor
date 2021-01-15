import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * BulletRight is for bullets that the Hero can shoot.
 * 
 * @author Vangelis Ventoulis 
 * @version 
 */
public class BulletRight extends Actor
{
    private final int BULLETSPEED = 25;
    private final int BULLETDAMAGE = 5;
    
    // the distance which the bullet can travel in the world
    private int bulletDistance = 10;
    
    public BulletRight() 
    {
        // scale the image of the bullet to like to the real bullet
        getImage().scale(5, 2);
    }
    
    /**
     * Act - do whatever the BulletRight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        shootRight();
    }

    /**
     * Method for checking the distance of the bullet that has traveled.
     */
    private void shootRight()
    {
        if (bulletDistance <= 0)
        {
            getWorld().removeObject(this);
        }

        else 
        {
            bulletDistance--;
            move(BULLETSPEED);
            checkEnemyHit();
        }
    }
    
    /**
     * Method to check if the bullet hits a zombie..
     */
    private void checkEnemyHit()
    {
        Zombie_1 zombie1 = (Zombie_1) getOneIntersectingObject(Zombie_1.class);

        if (zombie1 != null)
        {            
            zombie1.hurt(BULLETDAMAGE);
            getWorld().removeObject(this);
        }
    }  
}
