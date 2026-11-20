package stack;
import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollisionLC735 {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int a:asteroids){
            boolean alive=true;
            while(alive && a<0 && !st.isEmpty() && st.peek()>0){
                if(st.peek()<-a){
                    st.pop();
                    continue;
                }
                if(st.peek()==-a){
                    st.pop();
                }
                alive=false;
            }
            if(alive){
                st.push(a);
            }
        }
        int[] ans=new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5,10,-5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8,-8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10,2,-5})));
    }
}
