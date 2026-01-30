package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Selection Sort!!!");
        for (int outer = 0; outer < input.length - 1; outer++) {
            int bigIndex = 0; 
            // Inner loop is one shorter for every outer loop.
            // Each loop ensures that the largest item moves to the end.
            for (int inner = 1; inner <= input.length - outer - 1; inner++) {
                if(input[inner]>=input[bigIndex]){
                    bigIndex = inner; 
                }

                // If the two elements are out of order, swap them.
            } //if bigIndex, you need to swap, otherwise, not
            if(bigIndex != input.length-outer-1){
                int temp = input[bigIndex]; 
                input[bigIndex] = input[input.length-outer-1]; 
                input[input.length-outer-1] = temp; 
            }
        }
    }
}
