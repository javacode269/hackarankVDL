package tiennv65.IO;
import java.util.Scanner;  // Import the Scanner class
public class ScannerTool {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object


        System.out.println("Enter username");
        String userName = scanner.nextLine();  // Read user input
        System.out.println("Username is: " + userName);  // Output user input


        System.out.println("Enter age: ");
        int ageNum = scanner.nextInt();  // Read user input
        System.out.println("Age is: " + ageNum);  // Output user input
        scanner.nextLine();



        int x = Integer.parseInt("10");
        System.out.println("Gia tri cua x la : " + x);
        System.out.println("Danh sach diem cua sinh vien: ");

        try {
            String line = scanner.nextLine();
            System.out.println(line);
            String [] diemarr = line.split(" ");
            int toan = Integer.parseInt(diemarr[0]);
            System.out.println("Diem toan"  + toan);
            int tiengAnh = Integer.parseInt(diemarr[1]);
            System.out.println("Diem tiengAnh"  + tiengAnh);
            int van = Integer.parseInt(diemarr[2]);
            System.out.println("Diem van"  + van);
        } catch(NumberFormatException e) {
            System.out.println(e.toString());
        };


    }
}
