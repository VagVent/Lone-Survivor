import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GameOver class is for making a window interface when the Hero dies.
 * 
 * @author Vangelis Ventoulis
 * @version 17/1/2021
 */
public class GameOver extends Actor
{
	public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    
    public GameOver()
    {

    }
    
    /**
     * Create a score board for the final result.
     */
    public GameOver(int score)
    {
        makeImage("Game Over", "Score: ", score);
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
        image.drawString(prefix + score, 85, 200);
        setImage(image);
    }
}
