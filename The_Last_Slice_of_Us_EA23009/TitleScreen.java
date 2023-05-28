import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    private GreenfootSound soundtrack = new GreenfootSound("JacksonLastSliceofUs.mp3");
    
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(952, 536, 1, false); 
        prepare();
    }
    
    private void prepare()
    {
        GreenfootImage logo = new GreenfootImage("logo_theLastSliceofUs.png");
        Picture logoPic = new Picture(logo);
        addObject(logoPic, getWidth()/2, 268);
        Play play = new Play();
        addObject(play,103,112);
        play.setLocation(137,122);

        Exit exit = new Exit();
        addObject(exit,135,295);
        exit.setLocation(134,464);

        Options options = new Options();
        addObject(options,114,214);
        options.setLocation(170,396);
        
    }
    
    public void started()
    {
        soundtrack.play();
    }
    
    public void stopped()
    {
        soundtrack.stop();
    }
}
