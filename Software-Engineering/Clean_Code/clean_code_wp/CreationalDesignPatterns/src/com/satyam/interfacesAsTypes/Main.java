package com.satyam.interfacesAsTypes;

import com.satyam.interfacesAsTypes.animalPOJO.Elephant;
import com.satyam.interfacesAsTypes.animalPOJO.Ostrich;
import com.satyam.interfacesAsTypes.animalPOJO.PufferFish;

public class Main {
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		zoo.addFish(new PufferFish());
		zoo.addMammal(new Elephant());
		zoo.addBird(new Ostrich());
		zoo.showZoo();
	}
}
