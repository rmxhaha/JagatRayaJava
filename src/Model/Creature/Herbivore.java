package Model.Creature;

import Model.Animal;
import Model.Universe;

@Deprecated
public abstract class Herbivore extends Animal {
    /**
     * \brief Herbivore Constructor
     * <p>
     * \param universe Universe it belong in
     * \return Herbivore
     */
    Herbivore(Universe u, int x, int y, float currentAge) {
        super(u, x, y, currentAge);
    }
}