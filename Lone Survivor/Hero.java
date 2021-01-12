import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hero class is for the player at the game.
 * 
 * @author Vangelis Ventoulis
 * @version (13/1/2021)
 */
public class Hero extends Actor
{
    private int speed = 10;         // speed of the Hero's move
    private int direction = 1;      // diraction=1 to right, diraction=-1 to left
    
    // Arrays with asset of Hero
    private static final int NUM_OF_IMAGES = 7;
    private GreenfootImage[] rightImages;
    private GreenfootImage[] leftImages;   
    private int currentImage;
    
    // constructor
    public Hero()
    {

        rightImages = new GreenfootImage[NUM_OF_IMAGES];
        leftImages = new GreenfootImage[NUM_OF_IMAGES];

        for (int i = 0; i < NUM_OF_IMAGES; i++) 
        {
            rightImages[i] = new GreenfootImage ("walk_right_0" + i + ".png");
            leftImages[i] = new GreenfootImage ("walk_left_0" + i + ".png");
        }

        currentImage = 0;
        setImage(rightImages[currentImage]);        
    }
    
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
    }    
    
    /**
     * Check of keys press to move Hero.
     */
    private void checkKeys()
    {

        if (Greenfoot.isKeyDown("right")) 
        {
            moveRight();
            switchImage(rightImages);
            direction = 1;
        }

        if (Greenfoot.isKeyDown("left"))
        {
            moveLeft();
            switchImage(leftImages);
            direction = -1;
        }
        
    }
    
    /**
     * Move Hero at right way when press the right arrow.
     */
    private void moveRight() 
    {
        //Greenfoot.playSound("walking1_man_sort.wav");
        move(speed);
    }

    /**
     * Move Hero at left way when press the left arrow.
     */
    private void moveLeft()
    {
        //Greenfoot.playSound("walking1_man_sort.wav");
        move(-speed);
    }
    
    /**
     * Switch the pictures of Hero's asset.
     */
    private GreenfootImage[] switchImage(GreenfootImage[] table)
    {
        currentImage = (currentImage + 1) % NUM_OF_IMAGES;
        setImage(table[currentImage]);
        return table;
    }
}
