/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adinda
 */
public class GameThread extends Thread
{
    //Multithreading is a Java feature that allows
    //concurrent execution of two or more parts of a
    //program for maximum utilization of CPU
    private GameArea ga;
    
    public GameThread(GameArea ga)
    {
        this.ga = ga;
    }
    
    
    @Override
    public void run() {
        while(1 == 1)//infinite loop
        {
            ga.spawnBlock();
            while (ga.moveBlockDown() == true) {
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
        }
        
    }
}
