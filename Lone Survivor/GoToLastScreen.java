import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The windows interface which appears when the player achives the goal of the 2nd level.
 * 
 * @author Vangelis Ventoulis
 * @version 17/1/2021
 */
public class GoToLastScreen extends Actor
{
	public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    /**
     * Create a score board for the final result.
     */
    public GoToLastScreen(int score)
    {
        makeImage("Congratulantions!", "Score: ", score);
    }
    
    /**
     * Make the score board image.
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
        
        image.drawString(title, 60, 100);
        
        image.drawString(prefix + score, 150, 200);
        
        setImage(image);
    }   
}
