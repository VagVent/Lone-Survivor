import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hero class is for the player at the game.
 * 
 * @author Vangelis Ventoulis
 * @version (13/1/2021)
 */
public class Hero extends Actor
{
    private int speed = 10;           // speed of the Hero's move
    private int direction = 1;        // diraction=1 to right, diraction=-1 to left
    private int acceleration = 4;     // acceleration of gravity
    private int jumpStrength = 30;    
    private int vSpeed = 0;           // the speed of hero when he is jumpping
    
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
        checkFall();
    }    
    
    /**
     * Check of keys press to move Hero.
     */
    private void checkKeys()
    {
        // press right arrow to move right
        if (Greenfoot.isKeyDown("right")) 
        {
            moveRight();
            switchImage(rightImages);
            direction = 1;
        }
        
        // press left arrow to move left
        if (Greenfoot.isKeyDown("left"))
        {
            moveLeft();
            switchImage(leftImages);
            direction = -1;
        }
        
        // press up arrow to jump
        if (Greenfoot.isKeyDown("up"))
        {
            // jump only if Hero is on ground
            if (onGround())
            {
                jump();
            }

        }
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
    
    /**
     * Move Hero at right way when press the right arrow.
     */
    private void moveRight() 
    {
        move(speed);
    }

    /**
     * Move Hero at left way when press the left arrow.
     */
    private void moveLeft()
    {
        move(-speed);
    }
    
    /**
     * Hero can jump 
     */
    private void jump()
    {
        vSpeed = -jumpStrength;
        fall();
    }
    
    /**
     * Check if Hero is on ground.
     */
    private boolean onGround() 
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Ground.class);        
        return under != null;
    }
    
    /**
     * Check if Hero falls to add speed of gravity acceleration.
     */
    private void checkFall() 
    {
        if (onGround())
        {
            vSpeed = 0;            
        }  

        else 
        {
            fall();
        }
    }
    
    /**
     * Fall Hero after the jump with gravity acceleration.
     */
    private void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
    }
}
