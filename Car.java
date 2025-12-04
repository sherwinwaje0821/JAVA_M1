package ph.com.bpi.hello.M2_Act3;

public class Car {
private String model;
private double mileage;

public Car() {
	
}
public Car(String model,double mileage) {
	this.model=model;
	this.mileage=mileage;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model=model;
}

public double getMileage() {
	return mileage;
}

public void setMileage(double mileage) {
	this.mileage = mileage;
}

public void Drive(double kilometers) {
	this.mileage += kilometers;
	System.out.println("Driving... " + this.model 
			+ " " + kilometers + "km... " + 
	mileage + " mileage...");
}

}
