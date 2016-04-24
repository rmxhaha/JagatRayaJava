package Model;


import Model.BulletType.*;
import Model.Player;
import Model.Boss;

import Utility.IntPair;

import java.util.Random;
import java.util.Vector;
import java.util.stream.Collectors;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;

public class Universe extends JPanel {
    private Vector<Organism> mList;
    private Vector<Race> rList;
    private int maxOrganismPerCell;
    private AssetLoader assetLoader;
    int gwidth, gheight;
    
    public int getWidth(){
        return gwidth;
    }
    public int getHeight(){
        return gheight;
    }
    
    /**
    private int getWidth(){
        return width;
    }
     * \brief Universe Constructor
     * \param board board of the Universe simulation
     * \param m maximum number of Organism per cell
     */
    public Universe(int width, int height, int m) throws Exception {
		assetLoader = new AssetLoader();
        maxOrganismPerCell = m;
        mList = new Vector<>();
        rList = new Vector<>();
        
        gwidth = width;
        gheight = height;
        
        if (maxOrganismPerCell < 1) throw new Exception("MaxOrganismPerCell must be more than 0");
    }

    /**
     * \brief add new organism to this Universe
     * <p>
     * \param m Organism* organism inside Universe
     * \return void
     */
    public void add(Organism m) {
        mList.add(m);
        killWeakestOrganismAt(m.getX(), m.getY());
    }

    /**
     * \brief notifyUniverse of a movement so Universe may notify to all organism where this notification is relevant
     * <p>
     * \param x the organism who moved
     * \return
     */
    public void notifyMovement(Organism o) {
        killWeakestOrganismAt(o.getX(), o.getY());
        Vector<Organism> pool = mList.stream()
                .filter(it -> o.getX() == it.getX() && o.getY() == it.getY())
                .collect(Collectors.toCollection(Vector::new));

        for (Organism it : pool) {
            if (it == o) continue;
            it.interact(o);
            if (o.isAlive())
                o.interact(it);
        }
    }

    /**
     * \brief Update all Organism inside the universe
     * <p>
     * \param dt delta time from previous update
     * \return void
     */
    public void update(float dt) {
        mList.stream()
                .filter(Organism::isAlive)
                .forEach(it -> it.update(dt));

    }
	
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        for( Organism it : mList ){
                int x = it.getX();
                int y = it.getY();

                if( it instanceof Boss )
                        g.drawImage(assetLoader.getBossImage(), x, y,85,127,null);
                else if( it instanceof Player )
                        g.drawImage(assetLoader.getPlayerImage(), x, y,65,125,null);
                else if( it instanceof SpiralBullet )
                        g.drawImage(assetLoader.getBulletImage(0), x, y, null );
                else if( it instanceof StraightBullet )
                        g.drawImage(assetLoader.getBulletImage(1), x, y, null );

        }
    }

    /**
     * \brief kill the weakest organism in x,y coordinate if that cell exceed N limits per cell
     * <p>
     * \param x coordinate
     * \param y coordinate
     * \return void
     */
    public void killWeakestOrganismAt(int x, int y) {
        Vector<Organism> pool = mList.stream()
                .filter(it -> x == it.getX() && y == it.getY())
                .collect(Collectors.toCollection(Vector::new));

        // 1 for himself not counted
        while (pool.size() > maxOrganismPerCell) {
            // kill the weakest regardless of interaction
            Organism weakest = pool.firstElement();
            for (Organism it : pool) {
                if (it.power() < weakest.power()) {
                    weakest = it;
                }
            }
            weakest.forceKill();
            pool.remove(weakest);
        }
    }

	
	public IntPair findNearest(int cx, int cy, Model.FilterFunction f){
		int nx = -1;
		int ny = -1;
		int nscore = 1000000000;
		
		for( Organism it : mList ){
			if( f.call(it) ){
				int dx = cx - it.getX();
				int dy = cy - it.getY();

				int dscore = dx*dx + dy*dy;
				if( dscore < nscore ){
					nx = it.getX();
					ny = it.getY();
					nscore = dscore;
				}
			}
		}
		
		return new IntPair(nx,ny);
	}

}