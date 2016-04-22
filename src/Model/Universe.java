package Model;

import Model.Creature.Rabbit;
import Model.Creature.Turtle;

import java.util.Random;
import java.util.Vector;
import java.util.stream.Collectors;

public class Universe {
    public Board board; // expose ?

    private Vector<Organism> mList;
    private Vector<Race> rList;
    private int maxOrganismPerCell;

    /**
     * \brief Universe Constructor
     * \param board board of the Universe simulation
     * \param m maximum number of Organism per cell
     */
    public Universe(Board board, int m) throws Exception {
        this.board = board;
        maxOrganismPerCell = m;
        mList = new Vector<>();
        rList = new Vector<>();
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

        rList.stream()
                .filter(it -> it.getState() != Race.State.RACE_END)
                .forEach(Race::updateRace);
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

    /**
     * \brief notify all Rabbit and Turtle when a race is announced
     * <p>
     * \param sx starting coordinate
     * \param sy starting coordinate
     * \param ex finish coordinate
     * \param ey finish coordinate
     * \return void
     */
    public void addRace() {
        Random rng = new Random();
        int sx = rng.nextInt(Integer.SIZE - 1) % board.GetH();
        int sy = rng.nextInt(Integer.SIZE - 1) % board.GetW();
        int ex = rng.nextInt(Integer.SIZE - 1) % board.GetH();
        Race Ra = new Race(sx, sy, ex, sy);
        rList.add(Ra);
        for (Organism it : mList) {
            if (it instanceof Rabbit) {
                Rabbit r = (Rabbit) it;
                r.triggerRace(Ra);
            } else if (it instanceof Turtle) {
                Turtle t = (Turtle) it;
                t.triggerRace(Ra);
            }
        }
    }

}