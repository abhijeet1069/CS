package interfacesAsTypes.animalPOJO;

import interfacesAsTypes.animalTypes.Fish;

public class PufferFish implements Fish{

	@Override
	public String getName() {
		return "Puffer Fish";
	}

	@Override
	public String fact() {
		return "Puffer fish can puff themselves when they sense danger";
	}
	
	@Override
	public String toString() {
		return "Puffer Fish [Name= " + getName() + ", Fact= " + fact() + "]";
	}

}
