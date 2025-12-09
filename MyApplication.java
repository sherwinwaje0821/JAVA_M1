package ph.com.bpi.hello.M2_Act6;


public class MyApplication {

	/*
	 
	**Exercise 2 - Individual**

	1.  Create Interface “Refuelable”. Implementing classes should 
	be able to implement method “refuel()”.
	2.  Create Abstract Class “Vehicle”. Extending classes should 
	have attributes “numberOfWheels” and “brand” 
	and should have an abstract method “startEngine()”, it should 
	have a concrete method “void destroy()”.
	3.  Create two concrete classes “Car” and “Truck”. It must 
	implement “Refuelable” and extend “Vehicle”.
	4.  In your Main Application, create one Car and one Truck 
	and call the methods they inherited / implemented.
	5.  In your Main Application, create a method called 
	“destroyVehicle” that takes ONE parameter (either a Car or Truck) 
	and call their “destroy()” method.

	 
	 */
	public static void main(String[] args) {
		 
		Car carOne = new Car();
		carOne.setBrand("Car Toyota");
		carOne.setNumberOfWheels(4);
		
		Truck truckOne=new Truck();
		truckOne.setBrand("Truck Optimus");
		truckOne.setNumberOfWheels(6);
		
		carOne.startEngine();
		carOne.refuel();
		
		truckOne.startEngine();
		truckOne.refuel();
		
		destroyVehicle(carOne);
		destroyVehicle2(truckOne);
		
	}
	
	static void destroyVehicle(Car newCar) {
		newCar.destroy();
	}
	
	static void destroyVehicle2(Truck newTruck) {
		newTruck.destroy();
	}
}
