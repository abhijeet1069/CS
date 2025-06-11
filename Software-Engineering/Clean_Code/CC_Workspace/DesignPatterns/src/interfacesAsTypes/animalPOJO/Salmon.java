package interfacesAsTypes.animalPOJO;

import interfacesAsTypes.animalTypes.Fish;

public class Salmon implements Fish{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Salmon";
	}

	@Override
	public String fact() {
		return "Salmons are great migrators and have good taste";
	}
	
	@Override
	public String toString() {
		return "Salmon [Name= " + getName() + ", Fact= " + fact() + "]";
	}

}
