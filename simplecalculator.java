package SimpleCalculator;
import java.util.Scanner;
public class SimpleCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        Scanner scanner = new Scanner(System.in);

		        System.out.println("Simple Calculator");
		        System.out.println("Operations:");
		        System.out.println("6. Addition");
		        System.out.println("7. Subtraction");
		        System.out.println("8. Multiplication");
		        System.out.println("9. Division");

		        System.out.print("Enter the operation number (6/7/8/9): ");
		        int choice = scanner.nextInt();

		        if (choice >= 6 && choice <= 9) {
		            System.out.print("Enter the first number: ");
		            double num1 = scanner.nextDouble();

		            System.out.print("Enter the second number: ");
		            double num2 = scanner.nextDouble();

		            double result;

		            switch (choice) {
		                case 6:
		                    result = add(num1, num2);
		                    System.out.println(num1 + " + " + num2 + " = " + result);
		                    break;
		                case 7:
		                    result = subtract(num1, num2);
		                    System.out.println(num1 + " - " + num2 + " = " + result);
		                    break;
		                case 8:
		                    result = multiply(num1, num2);
		                    System.out.println(num1 + " * " + num2 + " = " + result);
		                    break;
		                case 9:
		                    result = divide(num1, num2);
		                    System.out.println(num1 + " / " + num2 + " = " + result);
		                    break;
		            }
		        } else {
		            System.out.println("Invalid choice. Please choose a valid operation.");
		        }

		        scanner.close();
		    }

		    private static double add(double x, double y) {
		        return x + y;
                
		    }

		    private static double subtract(double x, double y) {
		        return x - y;
		    }

		    private static double multiply(double x, double y) {
		        return x * y;
		    }

		    private static double divide(double x, double y) {
		        if (y != 0) {
		            return x / y;
		        } else {
		            System.out.println("Cannot divide by zero");
		            return Double.NaN; // NaN (Not a Number) indicates an undefined result
		        }
		    }
		
	