import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GoToLevel2 is a class to transfer to 2nd level.
 * 
 * @author Vangleis Ventoulis
 * @version 16/1/2021
 */
public class GoToLevel2 extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    public GoToLevel2()
    {
                
    }

    /**
     * Create a scoreboard for the score.
     */
    public GoToLevel2(int score)
    {
        makeImage("Good Job!", "Score: ", score);
    }

    /**
     * Make the scoreboard image.
     */
    private void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(255,255,255, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        
        image.drawString(title, 70, 100);
        image.drawString(prefix + score, 80, 200);
        
        setImage(image);
    }    
}
