import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Actor
{
    private int speed;
    private int damage;
    private GreenfootImage thisImage;
    private boolean collided;
    
    public Bullet(int speed)
    {
        this.speed = speed;
        this.damage = 1;
        this.collided = false;
        
        thisImage = new GreenfootImage("bullet.png");
        thisImage.scale(60,50);
        setImage(thisImage);
    }
    
    public int getDamage()
    {
        return damage;
    }
    public int getSpeed()
    {
        return speed;
    }
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    public void act() 
    {
        move(speed);
        checkBoundaries();
    }

    private void checkBoundaries() 
    {
        GreenfootImage img = getImage();
        int width = img.getWidth();
        int height = img.getHeight();
        
        World livesIn = getWorld();
        
        int left = getX() - width/2;
        int right = getX() + width/2;
        int top = getY() - height/2;
        int bottom = getY() + height/2;
        
        if(left <= 0)
        {
            livesIn.removeObject(this);
        }
        else if(right >= livesIn.getWidth())
        {
            livesIn.removeObject(this);
        }
        else if(top <= 0)
        {
            livesIn.removeObject(this);
        }
        else if(bottom >= livesIn.getHeight())
        {
            livesIn.removeObject(this);
        } 
    }
    
}   

