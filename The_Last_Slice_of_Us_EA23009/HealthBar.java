import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    private int width, height;
    private Player myPlayer;
    
    public HealthBar(int width, int height, Player myPlayer)
    {
        this.width = width;
        this.height = height;
        this.myPlayer = myPlayer;
    }
    
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
    
    
    
    public void act()
    {
        draw();
    }
    
    public void draw()
    {
        GreenfootImage myImage = new GreenfootImage(width, height);
        myImage.setColor(Color.RED);
        //Draw a rectangle for the amount of health
        int healthLeft = (int)(myPlayer.getStatus()*width);
        myImage.fillRect(0,0,healthLeft,height);
        
        setImage(myImage);
        
    }
}
