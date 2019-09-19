public class maxSubSum_1 {
/*
given possibly negative integers find the maximum sum,
note if all are negative then sum = 0

{-2,11,-4,13,-5,-2} = 20
 */

    public static int maxSubSumLinear(int[] a) {
        //calculates sum for whole array and compares to max sum
        int maxSum = 0, thisSum = 0;
        for (int j = 0; j < a.length; j++) {
            thisSum += a[j];
            if (thisSum > maxSum)//if negative then it overlooks it until it finds a positive
                maxSum = thisSum;

            else if (thisSum < 0)
                thisSum = 0;
        }
        return maxSum;
    }

    public static void main(String args[]){
        int [] arr = {3,-8,2,-1,9,-11,4,4};
        System.out.println(maxSubSumLinear(arr));

    }
}
