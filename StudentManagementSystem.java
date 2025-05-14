import java.util.Scanner;

public class StudentManagementSystem {

    static class Student {
        String name;
        int age;
        String id;

        Student(String name, int age, String id) {
            this.name = name;
            this.age = age;
            this.id = id;
        }

        void display() {
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100];
        int count = 0;

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    students[count++] = new Student(name, age, id);
                    System.out.println("Student Added Successfully.");
                }
                case 2 -> {
                    System.out.println("\n--- Student List ---");
                    for (int i = 0; i < count; i++) {
                        students[i].display();
                    }
                }
                case 3 -> {
                    System.out.print("Enter Student ID to Update: ");
                    String id = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (students[i].id.equals(id)) {
                            System.out.print("Enter New Name: ");
                            students[i].name = sc.nextLine();
                            System.out.print("Enter New Age: ");
                            students[i].age = sc.nextInt();
                            sc.nextLine();
                            found = true;
                            System.out.println("Student Updated Successfully.");
                        }
                    }
                    if (!found) System.out.println("Student Not Found.");
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid Option! Try Again.");
            }
        }
    }
}
