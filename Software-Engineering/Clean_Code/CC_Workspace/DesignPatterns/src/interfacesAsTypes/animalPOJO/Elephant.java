package interfacesAsTypes.animalPOJO;

import interfacesAsTypes.animalTypes.Mammal;

public class Elephant implements Mammal{

	@Override
	public String getName() {
		return "Elephant";
	}

	@Override
	public String fact() {
		return "Elephant are among largest mammals known for intelliegence"
				+ " and family bond";
	}

	@Override
	public String toString() {
		return "Elephant [Name= " + getName() + ", Fact= " + fact() + "]";
	}
}
