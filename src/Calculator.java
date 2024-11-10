import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        System.out.println ("welcome to Davyd's Calculator!"); 
        System.out.println ("instructions:just insert your number, then indicate your operation and then insert your second number.");
        System.out.println ("once you got the answer, you can either continue by inserting another operation and second number");
        System.out.println ("or you can insert \"renew\" and start over with new numbers.");
        System.out.println ("once you're done just insert \"done\" for the program to end.");
        System.out.println ("possible operations consist of:");
        System.out.println ("addition by inserting +");
        System.out.println ("multiplication by inserting *");
        System.out.println ("subtraction by inserting -");
        System.out.println ("division by inserting /");  
        System.out.println ("squareroot by sqrt");
        System.out.println ("absolute value by abs"); 
        System.out.println ("exponention by pow"); 

        double firstInteger = scanner.nextDouble(); 
        scanner.nextLine();
        String op; 
        op = scanner.nextLine();
        firstInteger = calc(firstInteger, op); 
        System.out.println( "answer:" + firstInteger); 
        while (true) { 
            op = scanner.nextLine(); 
            if (op.equals("done")) {
                break; 
            } else if (op.equals("renew")) {
                firstInteger = scanner.nextDouble(); 
                scanner.nextLine();
                op = scanner.nextLine(); 
            } 
            firstInteger = calc(firstInteger, op); 
            System.out.println( "answer:" + firstInteger); 
        }

        scanner.close();
    }

    public static double calc (double x, String op){
        double y; 
        Scanner scanner = new Scanner(System.in); 
        if (op.equals("+")) {
            y = scanner.nextDouble(); 
            scanner.nextLine();
            scanner.close();
            return x+y; 
        }
        else if (op.equals("*")) {
            y = scanner.nextDouble(); 
            scanner.nextLine();
            scanner.close();
            return x*y; 
        }
        else if (op.equals("-")) {
            y = scanner.nextDouble(); 
            scanner.nextLine();
            scanner.close();
            return x-y;
        }
        else if (op.equals("/")) {
            y = scanner.nextDouble(); 
            scanner.nextLine();
            scanner.close();
            if (y == 0) {
                System.out.println ("Error, please renew"); 
                return 0; 
            }
            return x/y;
        }
        else if (op.equals("sqrt")){
            scanner.close();
            return sqrt(x); 
        }
        else if (op.equals("abs")){
            scanner.close(); 
            return abs(x); 
        }
        else if (op.equals("pow")){
            System.out.println ("be careful! your exponent must be a natural number!");
            y = scanner.nextDouble(); 
            scanner.close(); 
            return pow(x,y); 
        }
        else {
            scanner.close();
            return 0;
        } 
    }

    public static double sqrt (double x) {
        if (x < 0) {
            System.out.println ("Error, please renew"); 
            return (double)0; 
        }
        double initialGuess = x/2.0; 
        double accuracy = 1e-10; 
        while (abs(initialGuess*initialGuess - x) > accuracy) {
            initialGuess = (initialGuess + x/initialGuess)/2.0;
        }
        return initialGuess;  
    }

    public static double abs(double x) {
        if (x < 0) return x * (-1);
        return x; 
    }

    public static double pow (double x, double y) {
        if (y == 0)return 1; 
        else if (y == 1)return x; 
        else if (y%2 == 0) {
            double result = pow (x, y/2); 
            return result*result; 
        }
        else {
            double result = pow (x, y-1); 
            return result*x; 
        } 
    }
}
