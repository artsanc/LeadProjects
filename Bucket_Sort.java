import java.util.Arrays;

public class Bucket_Sort {

    public static int findMax(int[]arr){
        //helper find max function
        int maxVal = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (maxVal < arr[i]){
                maxVal = arr[i];
            }
        }
        return maxVal;
    }

    public static void bucketSort(int[] a) {
        int maxVal = findMax(a);//finds max value

        int [] bucket=new int[maxVal+1];//initialzes buckets

        for (int i=0; i<bucket.length; i++) {//makes inner buckets
            bucket[i]=0;
        }

        for (int i=0; i<a.length; i++) {//inserts bucket
            bucket[a[i]]++;
        }

        int outPos=0;
        for (int i=0; i<bucket.length; i++) {
            for (int j=0; j<bucket[i]; j++) {
                a[outPos++]=i;
            }
        }
    }


    public static void main(String[] args) {
        int [] data= {4,5,2,6,9,7};
        System.out.println("Max value = "+ findMax(data));

        bucketSort(data);
        System.out.println("After:  " + Arrays.toString(data));
    }
}
