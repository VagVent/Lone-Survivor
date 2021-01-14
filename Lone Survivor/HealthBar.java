import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * HealthBar of the Hero's life.
 * 
 * @author Vangelis Ventoulis
 * @version 
 */
public class HealthBar extends Actor
{
    private int health = 100;
    private int healthBarWidth = 100;
    private int healthBarHeight = 10;
    
    // division the width of healthbar with the value of the Hero's health to the normal division 
    // change of graphic
    private int pixelsPerHealthPoint = (int)healthBarWidth / health;
    
    public HealthBar() 
    {
        update();
    }
    
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        update();
    }
    
    /**
     * Method to update the graphic of healthbar.
     */
    private void update() 
    {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage healthBarImage = getImage();
        healthBarImage.setColor(Color.WHITE);
        healthBarImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        healthBarImage.setColor(Color.RED);
        healthBarImage.fillRect(1, 1, health * pixelsPerHealthPoint, healthBarHeight);
    }
    
    /**
     * Method to count on the damage of the zombies' hit to the hero.
     */
    public void loseHealth(int strength)
    {
        health = health - strength;
    }
    
    /**
     * Getter of the health's value.
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * Overwrite to stay in the same position the graphic of the healbar when the Hero is moving.
     */
    public void setLocation(int x, int y) 
    {

    }
}
