package interfacesAsTypes;

import java.util.ArrayList;
import java.util.List;

import interfacesAsTypes.animalTypes.Bird;
import interfacesAsTypes.animalTypes.Fish;
import interfacesAsTypes.animalTypes.Mammal;

public class Zoo {
	List<Bird> birds;
	List<Fish> fishes;
	List<Mammal> mammals;
	
	Zoo(){
		birds = new ArrayList<Bird>();
		fishes = new ArrayList<Fish>();
		mammals = new ArrayList<Mammal>();
	}
	
	public void addBird(Bird bird) {
		birds.add(bird);
	}
	
	public void addFish(Fish fish) {
		fishes.add(fish);
	}
	
	public void addMammal(Mammal mammal) {
		mammals.add(mammal);
	}
	
	public void showZoo() {
		System.out.println("Welcome to Wa-Zoo");
		System.out.println(fishes);
		System.out.println(birds);
		System.out.println(mammals);
	}
}
