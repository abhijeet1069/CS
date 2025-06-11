package interfacesAsTypes;

import interfacesAsTypes.animalPOJO.Elephant;
import interfacesAsTypes.animalPOJO.Ostrich;
import interfacesAsTypes.animalPOJO.PufferFish;

public class Main {
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		zoo.addFish(new PufferFish());
		zoo.addMammal(new Elephant());
		zoo.addBird(new Ostrich());
		zoo.showZoo();
	}
}
