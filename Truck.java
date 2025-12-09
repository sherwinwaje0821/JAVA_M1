package ph.com.bpi.hello.M2_Act6;

public class Truck extends Vehicle implements Refuelable {
	public void refuel() {
		System.out.println("refuel truck..." + this.getBrand());
	}

	public void startEngine() {
		System.out.println("start truck..." + this.getBrand());
	}

}
