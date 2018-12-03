package hw2;

public class StringReverse {

    StringBuilder sb = new StringBuilder();
    MyStackArrayListD<Character> charStack = new MyStackArrayListD<>();

//    public String reverse(String s){
////        for (int i = s.length() - 1; i >= 0; i--) sb.append(s.charAt(i));
////        return sb.toString();
////    }

    public String reverse(String s){
        sb.delete(0, sb.length());
        for (int i = 0; i < s.length(); i++) charStack.push(s.charAt(i));
        for (int i = 0; i < s.length(); i++) sb.append(charStack.pop());
        return sb.toString();
    }
}
