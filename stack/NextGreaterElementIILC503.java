package stack;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementIILC503 {

    public static int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> st=new Stack<>();
        // go around twice so the circular part is covered
        for(int i=0;i<2*n;i++){
            int curr=nums[i%n];
            while(!st.isEmpty() && nums[st.peek()]<curr){
                ans[st.pop()]=curr;
            }
            if(i<n){
                st.push(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
        int[] nums2={1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums2)));
    }
}
