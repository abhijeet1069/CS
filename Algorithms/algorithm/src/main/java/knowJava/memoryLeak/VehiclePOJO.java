package knowJava.memoryLeak;

public class VehiclePOJO {
	String name;
	String vehicleNumber;
	
	public VehiclePOJO(String name, String vehicleNumber) {
		this.name = name;
		this.vehicleNumber = vehicleNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	@Override
	public String toString() {
		return "VehiclePOJO [name=" + name + ", vehicleNumber=" + vehicleNumber + "]";
	}
}
