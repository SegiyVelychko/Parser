public interface Method {
    boolean isNumber(String token);
    boolean isFunction(String token);
    boolean isSeparator(String token);
    boolean isOpenBracket(String token);
    boolean isCloseBracket(String token);
    boolean isOperator(String token);
    byte getPrecedence(String token);
    byte getPriority(String token);
    double getVariable(String token);
    String replace(String expression);
}
