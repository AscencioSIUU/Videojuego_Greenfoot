import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Zombie extends Actor
{
    private GreenfootImage thisImage;
    private int size, health,speed = 2, damage = 1;
    private int value = 10;

    
    //crear primeros zombies
    public Zombie()
    {
        thisImage = new GreenfootImage("zombie.png");
        thisImage.scale(60,50);
        setImage(thisImage); 
        
        setRotation(Greenfoot.getRandomNumber(360));
        setState(50);
    }
    
    
    public void act()
    {
        move(speed);
        worldWrapper();
        ckeckContact();
    }
    
    public void setState(int size)
    {
        //GreenfootImage thisImage = getImage();
        //thisImage.scale(size, size);
        health = 2;
    }
    
    public int getHealth()
    {
        return health; 
    }
    public void setHeath(int health)
    {
        this.health = health;
    }
    
    public int getDamage()
    {
        return damage;
    }
    public void setDamage(int damage)
    {
        this.damage = damage;
    }
    
    public void worldWrapper()
    {
        if(getX() < 0)
        {
            setLocation(getWorld().getWidth(), getY());
        }
        else if(getX() > getWorld().getWidth())
        {
            setLocation(0, getY());
        }
        else if(getY() < 0)
        {
            setLocation(getX(), getWorld().getHeight());
        }
        else if(getY() > getWorld().getWidth())
        {
            setLocation(getX(), 0);
        }
    }
    
    public void ckeckContact()
    {
        //ckeck if zombie is in contact with bullet and then take damage
        if (isTouching(Bullet.class))
        {
            Bullet temBullet = (Bullet)getOneIntersectingObject(Bullet.class); //acces to the damage of the bullet class
            health -= temBullet.getDamage(); //decrement health
            removeTouching(Bullet.class);
        }
        if(health <= 0)
        {
            //adding to score when zombie is killed
            GameTLSOF myWorld = (GameTLSOF)getWorld();
            Scoreboard scoreboard = myWorld.getScoreboard();//acces to scoreboard by GameTLSOF
            scoreboard.update(value);
            
            getWorld().removeObject(this);
        }
    }
    
}
