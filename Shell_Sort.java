import java.util.Arrays;

public class Shell_Sort {
    /* function to sort arr using shellSort */
    public static int shellSort(int arr[])
    {
        int n = arr.length;//gap

        for (int gap = n/2; gap > 0; gap /= 2)//breaks gap down by half n/2
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
        return 0;
    }

    static void printArray(int arr[])//prints array
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = {4,5,2,6,9,7};

        Shell_Sort a = new Shell_Sort();
        a.shellSort(arr);

        System.out.println("Array after sorting using Shell Sort");
        printArray(arr);
    }
}
