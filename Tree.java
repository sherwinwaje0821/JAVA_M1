package ph.com.bpi.hello.M2_Act1;

public class Tree {
    
    private double heightMeters;

    public void grow(double meters) {
        if (meters > 0) {
            heightMeters += meters;
        }
    }

}
