import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Options extends Buttons
{
    public Options()
    {
        GreenfootImage optButton = new GreenfootImage(230,70);
        Font adjustedFont = new Font(true, false, 50);
        optButton.setFont(adjustedFont);
        optButton.setColor(Color.WHITE);
        optButton.drawString("Opciones", 0, 50);
        setImage(optButton);
        
    }
    public void act()
    {
        checkMouse();
        checkClick(new ScreenOptions());
    }
}
