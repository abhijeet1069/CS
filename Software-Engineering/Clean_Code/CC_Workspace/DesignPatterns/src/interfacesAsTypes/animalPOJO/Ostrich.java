package interfacesAsTypes.animalPOJO;

import interfacesAsTypes.animalTypes.Bird;

public class Ostrich implements Bird{

	@Override
	public String getName() {
		return "Ostrich";
	}

	@Override
	public String fact() {
		return "Ostrich are the largest bird in the world";
	}

	@Override
	public String toString() {
		return "Ostrich [Name= " + getName() + ", Fact= " + fact() + "]";
	}
}
