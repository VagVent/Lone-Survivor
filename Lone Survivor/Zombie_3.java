import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Zombie 3 class.
 * 
 * @author Vangelis Ventoulis
 * @version 17/1/2021
 */
public class Zombie_3 extends Enemy
{
    private int direction = -1;  // direction of zombie avatar to left. -1 is for left and 1 for right
    private int speed = 10;       // speed of the moving zombie
    private int walkSteps = 0;   // a counter to change direction
    private int health = 200;    // the health/life of the zombie
    private int points = 50;     // which gain the hero when he kills this zombie
    private int strength = 5;    // the hit strength of the zombie

    // store the images-asset of 3rd zombie
    private static final int NUM_OF_IMAGES = 12;
    private GreenfootImage[] rightImages = new GreenfootImage[NUM_OF_IMAGES];
    private GreenfootImage[] leftImages = new GreenfootImage[NUM_OF_IMAGES];
    private GreenfootImage[] rightImagesDying = new GreenfootImage[NUM_OF_IMAGES];
    private GreenfootImage[] leftImagesDying = new GreenfootImage[NUM_OF_IMAGES];
    private GreenfootImage[] rightImagesAttacking = new GreenfootImage[NUM_OF_IMAGES];
    private GreenfootImage[] leftImagesAttacking = new GreenfootImage[NUM_OF_IMAGES];

    private int currentImage = 0;  // variable to restart from the 1st image

    public Zombie_3() 
    {

        for (int i = 0; i < NUM_OF_IMAGES; i++) {
            rightImages[i] = new GreenfootImage ("Zombie_03_Walking_right_0" + i + ".png");
            leftImages[i] = new GreenfootImage ("Zombie_03_Walking_left_0" + i + ".png");
            rightImagesDying[i] = new GreenfootImage ("Zombie_03_Dying_right_0" + i + ".png");
            leftImagesDying[i] = new GreenfootImage ("Zombie_03_Dying_left_0" + i + ".png");
            rightImagesAttacking[i] = new GreenfootImage ("Zombie_03_Attacking_right_0" + i + ".png");
            leftImagesAttacking[i] = new GreenfootImage ("Zombie_03_Attacking_left_0" + i + ".png");
        }

        currentImage = 0;
        setImage(leftImages[currentImage]);
    }

    /**
     * Act - do whatever the Zombie_3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        walk();
        hitHero();
    }

    /**
     * Method for walking the zombie.
     */
    private void walk() 
    {
        if (walkSteps < 40) 
        {
            walkLeft();
        }
        else if (walkSteps >= 40 && walkSteps < 79) 
        {
            walkRight();            
        }
        else 
        {
            walkSteps = 0;
        }

        walkSteps++;
    }

    /**
     * Method for walking left.
     */
    private void walkLeft() 
    {
        move(-speed);
        switchImage(leftImages, NUM_OF_IMAGES);
        direction = -1;
    }

    /**
     * Method for walking right.
     */
    private void walkRight() 
    {
        move(speed);
        switchImage(rightImages, NUM_OF_IMAGES);
        direction = 1;
    }

    /**
     * Method to consume the damage of the bullet's hit.
     */
    public void hurt(int damage) 
    {
        health = health - damage;

        // sound of the zombie when it is hit by a bullet
        Greenfoot.playSound("blood_hitting_zombie.wav");

        if (direction == -1)
        {
            setImage("Zombie_03_Hitted_left_00.png");
        }

        else if (direction == 1) 
        {
            setImage("Zombie_03_Hitted_right_00.png");
        }

        if (health <= 0)
        {
            die();
        }
    }

    /**
     * Method for dead zombie.
     */
    private void die() 
    {
        // sound of the zombie when it is dying
        Greenfoot.playSound("zombie_01_dies.wav");
        
        if (direction == -1) 
        {
            switchImage(leftImagesDying, NUM_OF_IMAGES);
            setLocation(getX(), getY() + 3);
        }

        else if (direction == 1)
        {
            switchImage(rightImagesDying, NUM_OF_IMAGES);
            setLocation(getX(), getY() + 3);
        }
        
        // to adding the dead zombies' points to the counter
        Level_2_World world = (Level_2_World)getWorld();
        world.addPointToCounter(points);
        
        // remove the dead zombie of the world
        getWorld().removeObject(this);
    }

    /**
     * Method to check the attack to Hero when they intersecting.
     */
    private void hitHero() 
    {     
        Actor hero = (Hero) getOneIntersectingObject(Hero.class);

        if (hero != null)
        {
            Level_2_World world = (Level_2_World)getWorld();
            HealthBar healthbar = world.getHealthBar();
            healthbar.loseHealth(strength);
            
            if (direction == -1) 
            {
                switchImage(leftImagesAttacking, NUM_OF_IMAGES);
            }

            else  if (direction == 1) 
            {
                switchImage(rightImagesAttacking, NUM_OF_IMAGES);
            }            
        }        
    }
}
