package designPatterns.creational.factoryMethod;

public class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        if ("car".equalsIgnoreCase(type)) {
            return new Car();
        } else if ("bike".equalsIgnoreCase(type)) {
            return new Bike();
        } else {
            throw new IllegalArgumentException("Unknown type");
        }
    }
}
