public class Main {
    public static void main(String[] args){
        int[] array = {8, 4, 3, 2, 1, 0};

        mergeSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void mergeSort(int[] array){
        int length = array.length;
        if (length <= 1){
            return;
        }

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; //leftArray
        int j = 0; //rightArray

        for (; i < length; i++) {
            if (i < middle) {
                leftArray[i] = array[i];
            }
            else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        mergeHelper(leftArray, rightArray, array);
    }

    private static void mergeHelper(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int i = 0, r = 0, l = 0;

        while(l < leftSize && r < rightSize){
            if (leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize) { 
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize) { 
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
