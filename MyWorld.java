import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private OZDWStatBar stat;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        stat = new OZDWStatBar();
        addObject(stat, getWidth() / 2, getHeight() / 2);
    }
    
    private int val = 50;
    private int val2 = 100;
    private boolean keyPressed = false;
    public void act()
    {
        // Use these keys to manipulate the values for the rectangular and circular bars (A, D for rectangular, W, S, for circular)
        if (Greenfoot.isKeyDown("A")) {val--;}
        else if (Greenfoot.isKeyDown("D")) {val++;}
        if (Greenfoot.isKeyDown("S")) {val2--;}
        else if (Greenfoot.isKeyDown("W")) {val2++;}
        
        // Use this to set the value in the rectangular bar
        if (Greenfoot.isKeyDown("G")) 
        {
            val = stat.getMaxHpValue() / 2;
        }
        
        // Use this to set the value in the circular bar
        if (Greenfoot.isKeyDown("F")) 
        {
            val2 = stat.getMaxChargeValue() / 2;
        }
        
        // Use this to update the maximum value in the rectangular bar
        if (Greenfoot.isKeyDown("E"))
        {
            if (!keyPressed)
            {
                stat.update(true, val, stat.getMaxHpValue() + 10);
                keyPressed = true;
            }
        }
        else 
        {
            keyPressed = false;
        }
        
        // Use this to update the maximum value in the circular bar
        if (Greenfoot.isKeyDown("R") && !keyPressed)
        {
            if (!keyPressed)
            {
                stat.update(false, val, stat.getMaxChargeValue() + 10);
                keyPressed = true;
            }
        }
        else 
        {
            keyPressed = false;
        }
        stat.update(true, val);
        stat.update(false, val2);
    }
}
