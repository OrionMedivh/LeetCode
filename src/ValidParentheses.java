import java.util.Stack;

public class ValidParentheses {
//    public boolean isValid(String s) {
//        if(s.length()==0) return true;
//        Stack<Character> stack=new Stack<Character>();
//        for (char c:s.toCharArray()){
//            if (c==')'){
//                if (stack.isEmpty() || stack.pop()!='(') return false;
//            }
//            if (c==']'){
//                if (stack.isEmpty() || stack.pop()!='[') return false;
//            }
//            if (c=='}'){
//                if (stack.isEmpty() || stack.pop()!='{') return false;
//            }
//            if (c=='(' || c=='[' || c=='{'){
//                stack.push(c);
//            }
//        }
//        if (!stack.isEmpty()){
//            return false;
//        }
//        return true;
//    } //old code
	
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for(char c:s.toCharArray()){
            switch(c){
                case '(':
                case '[':
                case '{':
                    st.push(c);
                    break;
                case ')':
                    if (st.size() > 0 && st.peek() == '(') st.pop();
                    else return false;
                    break;
                case ']':
                    if (st.size() > 0 && st.peek() == '[') st.pop();
                    else return false;
                    break;
                case '}':
                    if (st.size() > 0 && st.peek() == '{') st.pop();
                    else return false;
                    break;
            }
        }
        if (st.size() == 0)
        return true;
        return false;
    } // new code
}