import java.text.ParseException;
import java.util.Scanner;

public class Main extends ExprToRPN {
    public static void main(String[] args) throws ParseException {
        ExprToRPN expr = new ExprToRPN();
        RPNToAnswer answer = new RPNToAnswer();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите выражение:");
        System.out.print("=> ");
       String example = scan.nextLine();
        System.out.println(answer.answer(expr.parseString(example)));
        System.out.printf(""+(Math.sin(60)*Math.sin(20)));
     }
}
