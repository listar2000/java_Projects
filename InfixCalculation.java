import java.util.Arrays;  
import java.util.HashMap;  
import java.util.Map;  
import java.util.Stack;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
import java.util.Scanner;

public class InfixCalculation {

    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("input a string of expression");
            String str = change(sc.nextLine());
            System.out.println(str);
            System.out.println("answer is: "+suffix_to_value(infix_to_suffix(str)));
        }
    }
    
    public static Map<String, Integer> priority = new HashMap<>();
    static {
        priority.put("*", 2);
        priority.put("/", 2);
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("", -1);
    }

    public static String change(String expression) {
        return expression.replace(" ","");
    }

    public static String[] ops = {"+","-","*","/"};

    public static Pattern pattern = Pattern.compile("\\d+.?\\d?");

    public static Stack<String> stack = new Stack<>();

    private static String infix_to_suffix(String expression) {
        stack.clear();
        StringBuffer infix = new StringBuffer(expression);
        StringBuffer suffix = new StringBuffer();
        String element = "";
        String tmp = "";

        while (infix.length() > 0) {
            element = popNextElement(infix);

            if (isNum(element)) {
                suffix.append(element).append(" ");
            }
            else if (")".equals(element)) {
                tmp = stack.pop();
                while (!"(".equals(element)) {
                    //double security
                    if (stack.size() == 0)
                        break;
                    suffix.append(tmp).append(" ");
                    tmp = stack.pop();
                }
            }
            else if ("(".equals(element) || priority.get(element) > priority.get(getNextOperator())) {
                stack.push(element);
            }
            else {
                //这里可能会出问题
                while (priority.get(element) <= priority.get(getNextOperator())) {
                    tmp = stack.pop();
                    suffix.append(tmp).append(" ");
                }
                stack.push(element);
            }
        }

        while (stack.size() > 0) {
            suffix.append(stack.pop()).append(" ");
        }

        return suffix.toString();
    }

    private static String suffix_to_value(String expression) {
        String [] suffix = expression.split(" ");
        stack.clear();
        double num1 = 0, num2 = 0;
        String tmp = "";

        for (int i = 0; i < suffix.length; i++) {
            if (isNum(suffix[i])) {
                stack.push(suffix[i]);
            }
            else {
                num2 = Double.parseDouble(stack.pop());
                num1 = Double.parseDouble(stack.pop());
                tmp = calculate(num1, num2, suffix[i]);
                if (tmp.equals("error"))
                    throw new RuntimeException("cannot be divided by zero 0");
                stack.push(tmp);
            }
        }
        return stack.pop();
    }

    private static String calculate(double num1, double num2, String op) {

        double result = 0;
        switch(op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0)
                    return "error";
                result = num1 / num2;
                break;
            default:
                break;
        }
        return String.valueOf(result);
    }

    private static String popNextElement(StringBuffer buffer) {
        StringBuffer result = new StringBuffer();
        char c = buffer.charAt(0);
        buffer.deleteCharAt(0);
        result.append(c);

        if (isNum(c)) {
            while(buffer.length() > 0 && isNum(c = buffer.charAt(0))) {
                buffer.deleteCharAt(0);
                result.append(c);
            }
        }
        return result.toString();
    }

    private static String getNextOperator() {
        String tmp = "";
        for(int i = stack.size()-1; i >= 0; i--) {
            tmp = stack.get(i);
            if ("(".equals(tmp))
                break;
            if (isOperator(tmp))
                return tmp;
        }
        return "";
    }

    private static boolean isNum(String str) {
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    private static boolean isNum(char c) {
        return (c <= '9' && c >= '0') || c == '.';
    }

    private static boolean isOperator(String str) {
        for (String op: ops) {
            if (op.equals(str))
                return true;
        }
        return false;
    }
}
