package stringorarray;

public class Sqrt {
    public float sqrt(float x) {
        if (x<=1) return 1;
        float mid = (x)/2;
        while(true) {
            if(mid * mid - x > .01) {
                mid = mid/2;
            } else if(mid * mid - x < 0) {
                mid = 2*mid + mid/2;
            } else {
                return mid;
            }
        }
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.sqrt(5));
    }
}
