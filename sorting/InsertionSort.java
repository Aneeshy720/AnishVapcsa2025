package sorting;

public class InsertionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Insertion Sort!!!");

        for (int outer = 0; outer < input.length - 1; outer++) {
            int temp = input[0];  
            // Inner loop is one shorter for every outer loop.
            // Each loop ensures that the largest item moves to the end.
            for (int inner = 1; inner <= input.length - outer - 1; inner++) {
                // If the two elements are out of order, swap them.
                if(input[inner]>=temp){
                    input[inner-1]=temp; 
                    temp=input[inner]; 
                }
                else{
                    input[inner-1] = input[inner]; 
                }
            }
            input[input.length-outer-1] = temp;
        }
    }
}
