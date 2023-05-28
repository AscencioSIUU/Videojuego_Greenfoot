import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int speed_, health, maxHealth;
    private int changeControls = 0;
    private boolean triggerReleased; // servira para evitar spam de bullet
    private GreenfootImage thisImage;
    
    private boolean dmgTaken = false;
    private int dmgTakenTimer = 0;
    private final int MAX_TRANS = 255;
    public Player()
    {
        speed_ = 3;
        maxHealth = 5;
        health = maxHealth;
        triggerReleased = true;
        
        thisImage = new GreenfootImage("player.png");
        thisImage.scale(150,130);
        setImage(thisImage);
    }
    
    public int getSpeed()
    {
        return speed_;
    }
    
    public void setSpeed(int s)
    {
        speed_ = s;
    }
    
    public int getHeath()
    {
        return health;
    }
    public void setHeath(int health)
    {
        this.health = health;
    }
    public double getStatus()
    {
        return (double)health/maxHealth; 
    }
    
    public void act()
    {
        processKeys();
        trackMouse();
        ckeckContact();
    }
    
    public void processKeys()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            setLocation( getX() - speed_, getY() );
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            setLocation( getX() + speed_, getY() );
        }
        
        if(Greenfoot.isKeyDown("w"))
        {
            setLocation( getX(), getY() - speed_ );
        }
        else if(Greenfoot.isKeyDown("s"))
        {
            setLocation( getX(), getY() + speed_ );
        }
        
        if(Greenfoot.isKeyDown("space"))
        {
            shoot();
            triggerReleased = false; //bullet dejara de disparar hasta soltar el boton
        }
        else if (!Greenfoot.isKeyDown("space")) 
        {
            triggerReleased = true; // bullet se podrá volver a disparar
        }   
    }
    
    public void trackMouse()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if(mi != null) //programa crashea sin esto
        {
            turnTowards(mi.getX(), mi.getY() );
        }
    }
    
    public void shoot()
    {
        if(triggerReleased)
        {
            Bullet bullet = new Bullet(5);
            bullet.setRotation(getRotation());
            getWorld().addObject(bullet,getX(),getY());
            triggerReleased = false;
        }
    }
    public void ckeckContact()
    {
        //ckeck if zombie is in contact with bullet and then take damage
        if (isTouching(Zombie.class) && dmgTaken == false)
        {
            Zombie temZombie = (Zombie)getOneIntersectingObject(Zombie.class); //acces to the damage of the bullet class
            health -= temZombie.getDamage(); //decrement health
            
            dmgTaken = true;
            dmgTakenTimer = 100;
            changeTransparency(MAX_TRANS/2);
        }
        if (dmgTaken == true)
        {
            dmgTakenTimer --;
            if(dmgTakenTimer <= 0)
            {
                dmgTaken = false;
                changeTransparency(MAX_TRANS);
            }
        }
        if(health <= 0)
        {
            Greenfoot.stop();
        }
    }
    public void changeTransparency(int transparency)
    {
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency(transparency);
    }
}
