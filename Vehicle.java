package ph.com.bpi.hello.M2_Act6;

public abstract class Vehicle {
	int numberOfWheels;
	String brand; 

abstract void startEngine();

void destroy() {
	System.out.println("destroying..." + this.getBrand());
}

public int getNumberOfWheels() {
	return numberOfWheels;
}

public void setNumberOfWheels(int numberOfWheels) {
	this.numberOfWheels = numberOfWheels;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand=brand;
}
}
