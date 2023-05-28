import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameTLSOF extends World
{
    private Scoreboard scoreboard;
    
    /**
     * Constructor for objects of class GameTLSOF.
     * 
     */
    public GameTLSOF()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(952, 536, 1, false); 
        prepare();
    }
    
    private void prepare()
    {
        Player player = new Player();
        addObject(player,294,242);
        player.setLocation(288,284);

        Zombie zombie = new Zombie();
        addObject(zombie,722,172);
        Zombie zombie2 = new Zombie();
        addObject(zombie2,782,356);
        zombie2.setLocation(727,362);
        
        
        //add health bar
        HealthBar healthBar = new HealthBar(100,10,player);
        addObject(healthBar, healthBar.getWidth()/2, healthBar.getHeight()/2);
        
        //add scoreboard
        scoreboard = new Scoreboard(0);
        addObject(scoreboard, getWidth()/2, scoreboard.getImage().getHeight()/2);
    }
    
    public Scoreboard getScoreboard()
    {
        return scoreboard;
    }
}
