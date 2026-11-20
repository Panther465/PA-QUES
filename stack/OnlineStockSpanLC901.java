package stack;
import java.util.Stack;
class OnlineStockSpanLC901 {

    // {price, span}
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

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
