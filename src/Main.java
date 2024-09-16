import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //Display the option and ensure user input is between 1 to 3
    public static int displayOption() {
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Enter Name");
            System.out.println("2. List of Employees");
            System.out.println("3. Edit Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Quit");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Option: ");
            int option = sc.nextInt();
            if (option >= 1 && option <= 5) {
                return option;
            } else {
                System.out.println("Invalid Option.");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<>();
        do {
            int option = displayOption();
            if (option == 1) {
                addNewEmployee(employeeList);
            }
            if (option == 2) {
                displayAllEmployees(employeeList);
            }
            if (option == 3) {
                editEmployee(employeeList);
            }
            if (option ==4){
                deleteEmployee(employeeList);
            }
            if (option ==5){
                break;
            }
        } while (true);


    }

   public static void displayAllEmployees(ArrayList<Employee> employeeList) {
       System.out.println("List of Employees");
       for (Employee e : employeeList) {
           System.out.println("Name: " + e.getName());
           if (e instanceof LocalEmployee){
               System.out.println("Salary (Local Employee): " + e.getSalary());
           } else{
               System.out.println("Salary (Foreign Employee): " + e.getSalary());
           }
           System.out.println("Citizenship: " + e.getCitizenship());
           System.out.println("Age: " + e.getAge());
           System.out.println();
       }
   }

   public static void addNewEmployee(ArrayList<Employee> employeeList){
       System.out.println("Employee Details");
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter Name: ");
       String name = sc.nextLine();
       System.out.print("Enter Salary: ");
       double salary = sc.nextDouble();
       System.out.print("Enter Citizenship: ");
       sc.nextLine();//to get rid of the buffered \n
       String citizenship = sc.nextLine();
       System.out.print("Enter Age: ");
       int age = sc.nextInt();
       if(citizenship.equals("Singaporean")){
           LocalEmployee newLocalEmployee = new LocalEmployee(name, salary, citizenship, age);
           employeeList.add(newLocalEmployee);
       }else {
           Employee newEmployee = new Employee(name, salary, citizenship, age);
           employeeList.add(newEmployee);
       }
   }

   public static void editEmployee(ArrayList<Employee> employeeList){
        // Ask user to select which employee to edit
       for (int i =0; i<employeeList.size(); i++) {
           System.out.println(i +":" + employeeList.get(i).getName());
       }

       Scanner sc = new Scanner(System.in);
       System.out.println("Enter index to edit: ");
       int employeeIndex = sc.nextInt();

       // Ask user to input the new value
       Employee employeeToEdit = employeeList.get(employeeIndex);
       employeeToEdit.edit();
   }

   public static void deleteEmployee(ArrayList<Employee> employeeList){
       // Display employee list
        for (int i =0; i<employeeList.size(); i++) {
           System.out.println(i +":" + employeeList.get(i).getName());
   }
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter employee index to delete: ");
       int employeeIndex = sc.nextInt();

        //validate the input
       if(employeeIndex >=0 && employeeIndex<employeeList.size()){
            // remove employee from the list
           Employee deletedEmployee = employeeList.remove(employeeIndex);
           System.out.println("Deleted Employee: " + deletedEmployee.getName());
       }else{
           System.out.println("Invalid index entered");
        }
   }
}