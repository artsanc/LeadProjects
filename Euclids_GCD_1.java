public class Euclids_GCD_1 {
    //gcd(M,N) = gcd(N, M mod N), if N  0

    public static long Euclids_GCD( long m, long n){
        while(n!= 0){
            long remainder = m%n;
            m = n;
            n = remainder;
        }
        return m;
    }
}
