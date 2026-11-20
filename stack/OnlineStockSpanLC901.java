package stack;
import java.util.Stack;
class OnlineStockSpanLC901 {

    Stack<int[]> st;

    public OnlineStockSpanLC901() {
        st=new Stack<>();
    }

    public int next(int price) {
        int span=1;
        while(!st.isEmpty() && st.peek()[0]<=price){
            span+=st.pop()[1];
        }
        st.push(new int[]{price,span});
        return span;
    }
}
