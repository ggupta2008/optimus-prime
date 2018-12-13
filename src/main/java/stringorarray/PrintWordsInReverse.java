package stringorarray;

import ds.Stack;

public class PrintWordsInReverse {

    private static void wordReverse(String str)
    {
        Stack<String> stringStack = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <= str.length() - 1; i++) {
            if(str.charAt(i) == ' ') {
                stringStack.push(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            } else {
                stringBuffer.append(str.charAt(i));
            }
        }
        stringStack.push(stringBuffer.toString());

        while (!stringStack.isEmpty()) {
            System.out.print(stringStack.pop() + " ");
        }
    }

    public static void main(String[] args)
    {
        String str = "I AM A GEEK";
        wordReverse(str);
    }
}
