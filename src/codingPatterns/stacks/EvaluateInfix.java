package codingPatterns.stacks;

import java.util.Stack;

/*
expr = 1+2*3-4
ans = 1+6-4 = 3

expr = (1+2)*3-4
ans = 5

expr = 12+3*4-((5+2)*3)/3+1
ans = 12+12-(7*3)/3 + 1
ans = 12+12-7+1
ans = 18

 */
public class EvaluateInfix {

    public static void main(String[] args) {
        String expr = "12+3*4-((5+2)*3)/3+1";
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();


        for(int i=0;i<expr.length();i++){
            char ch = expr.charAt(i);

            if(Character.isDigit(ch)){
                int num = 0;
                while(i<expr.length()&&Character.isDigit(expr.charAt(i))){
                    num = num*10 + (expr.charAt(i) - '0');
                    i++;
                }
                i--;
                operand.push(num);

            }

            else if(ch == '('){
                operator.push(ch);
            }

            else if(ch == ')'){
                while(operator.peek() != '('){
                    int num = doOpeartion(operand, operator);
                    operand.push(num);
                }
                operator.pop();
            }

            else if(isOpeartor(ch)){
                while (!operator.isEmpty()&&precedenceOf(ch) <= precedenceOf(operator.peek())){
                    int num = doOpeartion(operand, operator);
                    operand.push(num);
                }
                operator.push(ch);

            }
        }

        while(!operator.isEmpty()){
            int num = doOpeartion(operand, operator);
            operand.push(num);
        }

        System.out.println(operand.peek());
    }

    private static int precedenceOf(char ch) {

        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private static boolean isOpeartor(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int doOpeartion(Stack<Integer> operand, Stack<Character> operator){
        int num1 = operand.pop();
        int num2 = operand.pop();
        char ch = operator.pop();

        switch (ch){
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num2 * num1;
            case '/':
                return num2/num1;
        }

        return 0;
    }
}
