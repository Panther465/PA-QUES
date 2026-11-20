package stack;
import java.util.Stack;

public class EvaluateRPNLC150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String t:tokens){
            if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")){
                int b=st.pop();
                int a=st.pop();
                switch(t){
                    case "+": st.push(a+b); break;
                    case "-": st.push(a-b); break;
                    case "*": st.push(a*b); break;
                    default: st.push(a/b);
                }
            }
            else{
                st.push(Integer.parseInt(t));
            }
        }
        return st.pop();
    }
}
