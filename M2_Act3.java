package ph.com.bpi.hello.M2_Act3;


public class M2_Act3 {
    public static void main(String[] args) {

         Car car1 = new Car();
         car1.setModel("Toyota");
         car1.setMileage(10.5);
         
         car1.Drive(10);
         
         Car car2 = new Car("Mitsubishi",20.5);
         car2.Drive(20);
         
    }
}
