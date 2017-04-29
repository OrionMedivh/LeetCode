public class Pow {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        double i = myPow(x, n/2);
        return i*i*myPow(x, n%2);
    }
}