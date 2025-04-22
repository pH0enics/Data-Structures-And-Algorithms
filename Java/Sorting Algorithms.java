import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] initialArray = {4, 5, 1, 0, 1, 2, 10, 9, 7, 7, 11, -10,   Integer.MAX_VALUE, Integer.MIN_VALUE, -2, 0};
        long startTime, endTime;
        
        // BUBBLE SORT------------------------------------------------
        int[] toBeBubbleSortedArray = Arrays.copyOf(initialArray, initialArray.length);
        startTime  = System.currentTimeMillis();
        bubbleSort(toBeBubbleSortedArray);
        endTime = System.currentTimeMillis();
        System.out.printf("Bubble sorted array- %s in time- %d\n", Arrays.toString(toBeBubbleSortedArray), endTime - startTime);
        
        // SELECTION SORT---------------------------------------------
        int[] toBeSelectionSortedArray = Arrays.copyOf(initialArray, initialArray.length);
        startTime  = System.currentTimeMillis();
        selectionSort(toBeSelectionSortedArray);
        endTime = System.currentTimeMillis();
        System.out.printf("Selection sorted array- %s in time- %d\n", Arrays.toString(toBeSelectionSortedArray), endTime - startTime);
        
        // MERGE SORT------------------------------------------------=
        int[] toBeMergeSortedArray = Arrays.copyOf(initialArray, initialArray.length);
        startTime = System.currentTimeMillis();
        int[] mergeSortedArray = mergeSort(toBeMergeSortedArray);
        endTime = System.currentTimeMillis();
        System.out.printf("Merge sorted array- %s in time- %d\n", Arrays.toString(mergeSortedArray), endTime - startTime);
    }
    
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[i]){
                    arr[i] += arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
                try{
                  Thread.sleep(10);
                } catch(Exception ignored){}
            }
        }
    }
    
    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] <  arr[minIndex]){
                    minIndex = j;
                }
                try{
                  Thread.sleep(10);
                } catch(Exception ignored){}
            }
            if(minIndex != i){
                arr[minIndex] += arr[i];
                arr[i] = arr[minIndex] - arr[i];
                arr[minIndex] = arr[minIndex] - arr[i];
            }
        }
    }
    
    public static void bucketSort(int[] arr){
      
    }
    
    public static void insertionSort(int[] arr){
      
    }
    
    public static void quickSort(int[] arr){
      
    }
    
    public static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int midIndex = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(arr, midIndex, arr.length));
        return mergeSortedArrays(left,right);
    }
    
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2){
        int len1 = arr1.length, len2 = arr2.length;
        int[] finalArr = new int[len1+len2];
        int pos1, pos2, posf;
        pos1 = pos2 = posf = 0;
        while(pos1 < len1 || pos2 < len2){
            if(pos1 == len1){
                finalArr[posf++] = arr2[pos2++];
                continue;
            } else if(pos2 == len2){
                finalArr[posf++] = arr1[pos1++];
                continue;
            }
            if(arr1[pos1] < arr2[pos2]){
                finalArr[posf++] = arr1[pos1++];  
            } else {
                finalArr[posf++] = arr2[pos2++];   
            }
            try{
              Thread.sleep(10);
            } catch(Exception ignored){}
        }
        return finalArr;
    }
}
