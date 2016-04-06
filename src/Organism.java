import java.util.Random;

abstract class Organism {
	protected static Random randomGenerator = new Random();

    protected float currentAge; // current age
    protected boolean is_dead = false;
    protected int x, y;
    protected Universe universe;

    /**
     * \brief Organism Constructor
     * <p>
     * \param universe Universe it belong in
     * \return Organism
     */
    public Organism(Universe universe, int x, int y, float currentAge) {
        this.x = x;
        this.currentAge = currentAge;
        this.y = y;
        this.universe = universe;
    }

    /**
     * \brief X location of the organism
     * \return
     */
    public int getX() {
        return x;
    }

    protected void setX(int _x) {
        x = _x;
    }

    /**
     * \brief Y location of the organism
     * \return int
     */
    public int getY() {
        return y;
    }

    protected void setY(int _y) {
        y = _y;
    }

    /**
     * \brief true if organism is dead
     * \return bool
     */
    public float getCurrentAge() {
        return currentAge;
    }

    protected void setCurrentAge(float age) {
        currentAge = age;
    }

    public boolean isDead() {
        return is_dead;
    }

    /**
     * \brief true if organism is alive
     * \return bool
     */
    public boolean isAlive() {
        return !is_dead;
    }

    /**
     * \brief ch is a character of the organism it represents
     * \return char of the organism it represent
     */
    public abstract char ch();

    /**
     * \brief age is maximum age before the organism it represents die because of old
     * \return int of the maximum age
     */
    public abstract int age();

    /**
     * \brief power is power of the organism it represents
     * \return int of power the organism it represent
     */
    public abstract int power();

    /**
     * \brief do the organism behaviour if reach time.
     * \param dt delta time for doing the organism behaviour
     */
    public void update(float dt) {
        currentAge += dt;

        if (currentAge > age())
            forceKill();
    } // delta time in milliseconds

    /**
     * \brief interaction between organism
     * \param organism which this organism will interact with
     */
    public abstract void interact(Organism o);

    /**
     * \brief kill the organism
     */
    public void forceKill() {
        is_dead = true;
        universe.board.DelEl(ch(), x, y);
    }

}