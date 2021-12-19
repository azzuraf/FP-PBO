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
    private GameForm gf;
    private int score;
    private int level = 1;
    private int scorePerLevel = 3;
    
    private int pause = 1000;
    private int speedupPerLevel = 100;
    
    public GameThread(GameArea ga, GameForm gf)
    {
        this.ga = ga;
        this.gf = gf;
        
        gf.updateScore(score);
        gf.updateLevel(level);
    }
    
    
    @Override
    public void run() {
        while(1 == 1)//infinite loop
        {
            ga.spawnBlock();
            while (ga.moveBlockDown() == true) {
                try {
                    Thread.sleep(pause);
                }
                catch (InterruptedException ex) {
                    return;
                }   
            }
            
            if(ga.isBlockOutOfBounds())
            {
                //game over
                Tetris.gameOver(score);
                break;
            }
            
            ga.moveBlockToBackground();
            score += ga.clearLines();
            gf.updateScore(score);
            
            int lvl = score/scorePerLevel+1;
            if(lvl > level)
            {
                level = lvl;
                gf.updateLevel(level);
                pause -= speedupPerLevel;
            }
        }
        
    }
}
