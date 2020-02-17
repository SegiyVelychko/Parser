import java.util.Scanner;
import java.util.Stack;
class Methods implements Method  {
     final String[] FUNCTION = {"abs", "cos", "sin", "atan", "tan", "acos", "asin", "ctan", "actan", "sqrt", "exp", "log"};
     final String OPERATION = "+-*/^";
     final String SEPARATOR = ".";
     final String VARIABLE = "x";
     final String PI = "pi";
     final String E = "e";
     final double rtd = 180/Math.PI;
     Stack<String> stackOperation = new Stack();
     Stack<String> stackEXP = new Stack<>();
     Stack<String> stack = new Stack();
      String output ="";
    @Override
    public boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
        } catch (Exception ex) {
            if (token.equals(VARIABLE) || token.equals(PI) || token.equals(E)) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean isFunction(String token) {
        for (String temp: FUNCTION)
        {
            if(temp.equals(token))
                return true;
        }
        return false;
    }

    @Override
    public boolean isSeparator(String token) {
        return token.equals(SEPARATOR);
    }
    @Override
    public boolean isOpenBracket(String token) {
        return token.equals("(");
    }

    @Override
    public boolean isCloseBracket(String token) {
        return token.equals(")");
    }

    @Override
    public boolean isOperator(String token) {
        return OPERATION.contains(token);
    }

    @Override
    public byte getPrecedence(String token) {
        if (token.equals("+")|| (token.equals("-")))
            return 1;
        return 2;
    }

    @Override
    public byte getPriority(String token) {
        switch (token)
        {
            case "abs":
            case "sin":
            case "cos":
            case "tan":
            case "sqrt":
            case "ctan":
            case "exp":
            case "log":
            case "asin":
            case "acos":
            case "atan":
            case "actan": return 6;
            case "^":return 5;
            case "*":
            case "/": return 4;
            case "+":
            case "-": return 3;
            case "(":return 2;
            case ")":return 1;
        }
        return 0;
    }

    @Override
    public double getVariable(String token) {
        System.out.println("Введите значение x:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
    @Override
    public String replace (String expression)
    {
        return expression.replace(" ","").replace("(-","(0-").replace(".-",".0-").replace(",",".").replace(",-",".0-");//.replace("(","1*(");
    }
    //This function must be find result trigonometrics function
  /*  public double Trigonometrix (String type,double a)
    {
        switch (type)
        {
            case "sin": return  Math.sin(a)*rtd;
            case "cos": return Math.cos(a)*rtd;
            case "log": return  Math.log(a)*rtd;
            case "asin": return  Math.asin(a)*rtd;
            case "tan": return  Math.tan(a)*rtd;
            case "abs": return  Math.abs(a)*rtd;
            case "exp": return  Math.exp(a)*rtd;
            case "sqrt": return Math.sqrt(a)*rtd;
            case "acos": return Math.acos(a)*rtd;
            case "atan": return Math.atan(a)*rtd;
        }
        return 0;
    }*/
}
