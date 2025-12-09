package ph.com.bpi.hello.M2_Act6;

public class Car extends Vehicle implements Refuelable {
public void refuel() {
	System.out.println("refuel car..." + this.getBrand());
}

public void startEngine() {
	System.out.println("start car..." + this.getBrand());
}


}
