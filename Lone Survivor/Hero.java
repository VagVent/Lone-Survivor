import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hero class is for the player at the game.
 * 
 * @author Vangelis Ventoulis
 * @version 
 */
public class Hero extends Actor
{
    // set the goal which the player has to do to go to the 2nd level.
    // the player has to kills 10 zombies.
    // Change fro 10 to 2 for testing.
    private final int GOALOFLEVEL1 = 2;

    private int speed = 10;           // speed of the Hero's move
    private int direction = 1;        // direction=1 to right, direction=-1 to left
    private int acceleration = 4;     // acceleration of gravity
    private int jumpStrength = 30;    
    private int vSpeed = 0;           // the speed of hero when he is jumpping
    
    // arrays with asset of Hero
    private static final int NUM_OF_IMAGES = 7;
    private GreenfootImage[] rightImages;
    private GreenfootImage[] leftImages;
    private GreenfootImage[] fireRightImages;
    private GreenfootImage[] fireLeftImages;
    
    private int currentImage;
    
    private int level;               // variable to store the current level
    
    public Hero()
    {
        level = 1;
        
        rightImages = new GreenfootImage[NUM_OF_IMAGES];
        leftImages = new GreenfootImage[NUM_OF_IMAGES];
        fireRightImages = new GreenfootImage[NUM_OF_IMAGES];
        fireLeftImages = new GreenfootImage[NUM_OF_IMAGES];

        for (int i = 0; i < NUM_OF_IMAGES; i++) 
        {
            rightImages[i] = new GreenfootImage ("walk_right_0" + i + ".png");
            leftImages[i] = new GreenfootImage ("walk_left_0" + i + ".png");
            fireRightImages[i] = new GreenfootImage ("attack_right_0" + i + ".png");
            fireLeftImages[i] = new GreenfootImage ("attack_left_0" + i + ".png");
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
        checkForNextLevel();
        gameOver();
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
        
        // space.equals(Greenfoot.getKey())) it is used to fire only when press and leave the 
        // spacebar
        if ("space".equals(Greenfoot.getKey()))
        {
            // sound of firing gun
            Greenfoot.playSound("m16_gun_oneshoot.wav");
            
            if (direction == 1)
            { 
                fireRight();
                switchImage(fireRightImages);
            }

            else if (direction == -1)
            {
                fireLeft();
                switchImage(fireLeftImages);
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
     * Hero can jump. 
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
    
    /**
     * Method by which the Hero can fire bullets to the left way.
     */
    private void fireLeft()
    {
        BulletLeft bulletLeft = new BulletLeft();
        // the subtraction of 48 cells at the X-axis and 14 cells at the Y-axis,
        // is for start fire the bullets at the height of the gun
        getWorld().addObject(bulletLeft, getX() - 48, getY() - 14);
    }
    
    /**
     * Method by which the Hero can fire bullets to the right way.
     */
    private void fireRight()
    {
        BulletRight bulletRight = new BulletRight();
        // the addition of 48 cells at the X-axis and the subtraction of 14 cells at the Y-axis,
        // is for start fire the bullets at the height of the gun
        getWorld().addObject(bulletRight, getX() + 48, getY() - 14);
    }

    /**
     * Method to go to the 2nd level.
     */
    public void checkForNextLevel()
    {
        if (level == 1 )
        {
            Level_1_World world1 = (Level_1_World)getWorld();
            
            int enemyKills1 = world1.getEnemyKills();
            int points = world1.getCounter();

            if (enemyKills1 >= GOALOFLEVEL1)
            {
                level = 2;
                
                // add the window interface
                world1.addObject(new GoToLevel2(world1.getCounter()),
                            world1.getWidth()/2, world1.getHeight()/2);
                // after 10sec will start the 2nd level
                Greenfoot.delay(10);
                // setup the 2nd level with the Hero and the points which he has gained
                Greenfoot.setWorld(new Level_2_World(this, points));            
            }
        }
    }

    /**
     * Method to appear the window interface when the Hero has died with
     * a game over message and the score.
     */
    private void gameOver()
    {
        if (level == 1 )
        {
            Level_1_World world1 = (Level_1_World)getWorld();
            
            int health = world1.getHealth();

            if (health <= 0)
            {
                Greenfoot.playSound("grunts_die_man.wav");
                
                // add the window interface
                world1.addObject(new GameOver(world1.getCounter()),
                        world1.getWidth()/2, world1.getHeight()/2);
                        
                Greenfoot.stop();
            }            
        }

        else if (level == 2 )
        {
            Level_2_World world2 = (Level_2_World)getWorld();
            
            int health = world2.getHealth();

            if (health <= 0)
            {
                Greenfoot.playSound("grunts_die_man.wav");
                
                // add the window interface
                world2.addObject(new GameOver(world2.getCounter()),
                        world2.getWidth()/2, world2.getHeight()/2);
                        
                Greenfoot.stop();
            }            
        }
    }
}
