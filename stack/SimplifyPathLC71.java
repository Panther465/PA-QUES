package stack;
import java.util.Stack;

public class SimplifyPathLC71 {

    public static String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        String[] parts=path.split("/");
        for(String p:parts){
            if(p.equals("") || p.equals(".")) continue;
            if(p.equals("..")){
                if(!st.isEmpty()) st.pop();
            }
            else{
                st.push(p);
            }
        }
        if(st.isEmpty()) return "/";
        StringBuilder sb=new StringBuilder();
        for(String dir:st){
            sb.append("/").append(dir);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
    }
}
