import java.text.ParseException;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;
public class ExprToRPN extends Methods{
    public Stack<String> parseString(String expression) throws ParseException
    {
        stackOperation.clear();
        stackEXP.clear();
        stack.clear();
        int priority;
        expression =replace(expression);
        if (expression.charAt(0) =='-')
        {
            expression = "0"+expression;
        }
        StringTokenizer stringToken = new StringTokenizer(expression,OPERATION+"( )",true);
        while (stringToken.hasMoreTokens())
        {
            String token = stringToken.nextToken();
            priority = getPriority(token);
            if (isNumber(token) || isFunction(token))
            {
                stack.push(token);
                stackEXP.push(stack.pop());
            }
            else if (isOpenBracket(token))
            {
                stackOperation.push(token);
            }
           else if (!isCloseBracket(token) && !isOpenBracket(token) && !isNumber(token))
           {
               while (!stackOperation.empty())
               {
                   if (getPriority(stackOperation.peek())>=priority)
                   {
                       stackEXP.push(stackOperation.pop());
                   }
                   else break;
               }
               stackOperation.push(token);
           }
           else if (isCloseBracket(token))
            {
                while (getPriority(stackOperation.peek())!=2)
                {

                    stackEXP.push(stackOperation.pop());
                }
                stackOperation.pop();
            }
        }
        while (!stackOperation.empty()) stackEXP.push(stackOperation.pop());
        Collections.reverse(stackEXP);
        return stackEXP;
    }
}
