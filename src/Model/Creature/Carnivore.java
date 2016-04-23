package Model.Creature;

import Model.Animal;
import Model.Universe;

@Deprecated
public abstract class Carnivore extends Animal {
    Carnivore(Universe universe, int x, int y, float currentAge) {
        super(universe, x, y, currentAge);
    }
}