package stack;
import java.util.Stack;

public class RemoveKDigitsLC402 {

    public static String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        for(char ch:num.toCharArray()){
            while(k>0 && !st.isEmpty() && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        for(char ch:st){
            if(sb.length()==0 && ch=='0') continue;
            sb.append(ch);
        }
        return sb.length()==0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219",3));
        System.out.println(removeKdigits("10200",1));
        System.out.println(removeKdigits("10",2));
    }
}
