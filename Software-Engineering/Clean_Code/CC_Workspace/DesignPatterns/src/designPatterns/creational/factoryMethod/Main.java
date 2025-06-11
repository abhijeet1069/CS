package designPatterns.creational.factoryMethod;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.createVehicle("car");
        vehicle.start();  // Output: Car started
    }
}
