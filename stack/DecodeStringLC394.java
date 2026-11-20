package stack;
import java.util.Stack;

public class DecodeStringLC394 {

    public static String decodeString(String s) {
        Stack<Integer> countSt=new Stack<>();
        Stack<StringBuilder> strSt=new Stack<>();
        StringBuilder curr=new StringBuilder();
        int num=0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }
            else if(ch=='['){
                countSt.push(num);
                strSt.push(curr);
                curr=new StringBuilder();
                num=0;
            }
            else if(ch==']'){
                int k=countSt.pop();
                StringBuilder prev=strSt.pop();
                for(int i=0;i<k;i++){
                    prev.append(curr);
                }
                curr=prev;
            }
            else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
