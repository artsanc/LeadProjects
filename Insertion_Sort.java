import java.util.*;
public class Insertion_Sort {


        public static int[] insertionSort(int[] arr){//worst case O(n^2)

            for(int i = 1; i < arr.length; i++){
                int key = arr[i];//focus point
                int j = i - 1;// previous item
                while(j >= 0 && key < arr[j]){//run while there are no more items to compare or the focus point
                    arr[j + 1] = arr[j];//swap positions one at a time
                    j--;
                }
                arr[j + 1] = key;
            }
            return arr;
        }

        public static void main(String[] args){

            int arr[] = {4,5,2,6,9,7};
            Insertion_Sort a = new Insertion_Sort();
            System.out.println("Using Insertion Sort: ");
            System.out.print(Arrays.toString(insertionSort(arr)));

        }
    }
