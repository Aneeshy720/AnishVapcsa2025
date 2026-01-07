package warmup;

public class Main {

    public static void main(String[] args) {
        //problem 2
        int[] nums = new int[100]; 
        nums[0] = 0; 
        nums[1] = 1; 
        int sum = 0; 
        for(int i = 2; i<nums.length; i++){
            nums[i] = nums[i-1] + nums[i-2]; 
            if(nums[i]>4000000){
                break; 
            }
            if(nums[i]%2==0){
                sum = sum+nums[i]; 
            }
        }
        System.out.println("The sum of all the even number in fibonacci up till 4 million is: "+sum); 

        
        


    }
}
