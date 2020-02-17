import java.util.Stack;
import static java.lang.StrictMath.*;
public class RPNToAnswer extends ExprToRPN {
    public double answer(Stack<String> stackEXP) {
        double a, b;
        Stack<Double> stackAnswer = new Stack<>();
        String operand = "";
        while (!stackEXP.empty()) {
            if (isNumber(stackEXP.peek())) {
                operand += stackEXP.pop();
                if (operand.equals(VARIABLE)) {
                    stackAnswer.push(getVariable(operand));
                } else if (operand.equals("pi")) stackAnswer.push(Math.PI);
                else if (operand.equals("e")) stackAnswer.push(Math.E);
                else
                    stackAnswer.push(Double.parseDouble(operand));
                operand = "";
            }
            if (!stackEXP.empty() && !isNumber(stackEXP.peek()) && !isOpenBracket(stackEXP.peek()) && !isCloseBracket(stackEXP.peek()) && !isFunction(stackEXP.peek())) {
                a = stackAnswer.pop();
                if (!stackEXP.empty())
                {
                b = stackAnswer.pop();
                switch (stackEXP.pop()) {
                    case "+":
                        stackAnswer.push(b + a);
                        break;
                    case "-":
                        stackAnswer.push(b - a);
                        break;
                    case "*":
                        stackAnswer.push(b * a);
                        break;
                    case "/":
                        try {
                            stackAnswer.push(b / a);
                            break;
                        } catch (Exception ex) {
                            ex.getLocalizedMessage();
                        }
                    case "^":
                        stackAnswer.push(Math.pow(b, a));
                }
                    while (!stack.empty())
                    {
                        switch (stack.pop())
                        {
                            case "sin": stackAnswer.push(sin(stackAnswer.pop()));
                        }
                    }
                }else
                    {
                        stackAnswer.push(a);
                    }
            } else if (!stackEXP.empty() && isFunction(stackEXP.peek())) stack.push(stackEXP.pop());
            else if (!stackAnswer.empty()){
                a = stackAnswer.pop();
                while (!stack.empty())
                {
                    switch (stack.pop())
                    {
                        case "sin": stackAnswer.push(sin(a));
                    }
                }
            }


        }


        return stackAnswer.pop();
    }
}
