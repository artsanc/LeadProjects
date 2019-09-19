import java.util.Arrays;

public class Selection_Sort {

    private static void swap(int arr[], int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

     public static int[] selectionSort(int arr[]){//O(n^2)

         for(int i = 0; i < arr.length; i++){//loops through array
             int minValue = arr[i];
             int minIndex = i;

             for(int j = i; j < arr.length; j++){//loop to check for minimum value for each position
                 if(arr[j] < minValue){//checks for minimum
                     minValue = arr[j];
                     minIndex = j;
                 }
             }

             if(minValue < arr[i]){//when minimum is found swap
                 swap(arr, minIndex, i);
             }


         }
         return arr;
     }

    public static void main(String[] args){

        int arr[] = {4,5,2,6,9,7};
        Selection_Sort a = new Selection_Sort();
        System.out.println("Using Selection Sort: ");
        System.out.print(Arrays.toString(selectionSort(arr)));

    }
}
