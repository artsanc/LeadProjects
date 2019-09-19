public class Fib_Linear_1 {
    //F(n-1) + F(n-2)

    public static long fib(int n){
        if(n<=2){
            return 1;
        }
        else{
            return fib(n-1) + fib(n-2);
        }//in exponential time (2^n) BADDDD
    }


    public static long fibLinear(int n){
        int prev =1;
        int prev2 = 1;
        for (int i = 2; i < n; i++) {
            int savePrev = prev;
            prev = prev2;
            prev2 = savePrev + prev2;
        }
        return prev;
        //Linear solution but less elegant O(n)
    }

}
