import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Zombie 2 class.
 * 
 * @author Vangelis Ventoulis 
 * @version 16/1/2021
 */
public class Zombie_2 extends Enemy
{
    private int direction = -1; // direction of zombie avatar to left. -1 is for left and 1 for right
    private int speed = 5;      // speed of the moving zombie
    private int walkSteps = 0;  // a counter to change direction

    // store the images-asset of 1st zombie
    private static final int NUM_OF_IMAGES = 12;
    private GreenfootImage[] rightImages = new GreenfootImage[NUM_OF_IMAGES];
    private GreenfootImage[] leftImages = new GreenfootImage[NUM_OF_IMAGES];

    private int currentImage; // variable to restart from the 1st image

    public Zombie_2() 
    {

        for (int i = 0; i < NUM_OF_IMAGES; i++) 
        {
            rightImages[i] = new GreenfootImage ("Zombie_02_Walking_right_0" + i + ".png");
            leftImages[i] = new GreenfootImage ("Zombie_02_Walking_left_0" + i + ".png");
        }

        currentImage = 0;
        setImage(leftImages[currentImage]);
    }

    /**
     * Act - do whatever the Zombie_2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        walk();
    }

    /**
     * Method for walking the zombie.
     */
     private void walk() 
    {
        if (walkSteps < 40) {
            walkLeft();
        }
        else if (walkSteps >= 40 && walkSteps < 79) {
            walkRight();            
        }
        else {
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
}
