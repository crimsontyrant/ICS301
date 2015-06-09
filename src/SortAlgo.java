import hsa.*;
import java.util.Random;

//change name of class here
public class SortAlgo {

    public static Console c;
    public static int nums[]=new int[100];
    
    public static void main(String args[])
    {
        c = new Console();
        Random r = new Random();
        //fill array with 100 random numbers
        for (int i = 0; i < nums.length; i++) {
            nums[i]=r.nextInt(1000) + 1;
            c.print(nums[i],4);
        }
        c.println("Now to sort... Press any key!");
        c.getChar();
        c.println("------------------------------\n\n");
        sort();
        for (int i = 0; i < nums.length; i++) {
            c.print(nums[i], 4);
        }
        
    }
    
    public static void sort(){
        for (int i = 0; i < nums.length; i++) {
            int small = findsmallest(i);
            swap(i,small);
        }
    }
    
    public static void swap(int loc1, int loc2){
        int temp=nums[loc1];
        nums[loc1]=nums[loc2];
        nums[loc2]=temp;
    }
   
    public static int findsmallest(int start){
        int smallest = nums[start];
        int smallestspot = start;
        for (int i = start+1; i < nums.length; i++) {
            if (nums[i] < smallest){
                smallest=nums[i];
                smallestspot=i;
            }
        }
        return smallestspot;
    }
    
}
