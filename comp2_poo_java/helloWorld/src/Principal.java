import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        System.out.println("Hello, World!" + "\n" + "Thank you, next in line..."); //w/ java will create a string object 

        System.out.println("Name: ");
        Scanner Scan = new Scanner(System.in);
        String name = Scan.nextLine();
        System.out.println("Age: ");
        int age = Scan.nextInt(); // will capture the next integer

        System.out.printf("Hello, %s! How are you? Is that true you're %d years old? \n", name, age);
    }
}