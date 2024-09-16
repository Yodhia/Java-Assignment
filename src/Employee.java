import java.util.Scanner;

public class Employee {
    // protected because is sharing with localEmployee
    protected String name;
    protected double salary;
    protected String citizenship;
    protected int age;

//    public void employeeList(){
//        this.name = "N/A";
//        this.salary = 0;
//        this.citizenship= "N/A";
//        this.age = 0;
//    }
    // overloaded constructor
    public Employee(String name, double salary, String citizenship, int age){
        this.name = name;
        this.salary = salary;
        this.citizenship = citizenship;
        this.age = age;
    }

   public String getName(){
       return this.name;
   }

   public double getSalary(){

        return salary;
   }

   public String getCitizenship(){
       return citizenship;
   }

   public int getAge() {
        return age;
   }

   public void setName(String name){

        this.name = name;
   }

   public void setSalary(double salary){

        this.salary = salary;
   }

   public void setCitizenship(String citizenship){

        this.citizenship = citizenship;
   }

   public void setAge(int age){

        this.age = age;
   }

   public void edit(){
        Scanner sc = new Scanner(System.in);
       System.out.println("Enter new name of the employee: ");
       String newName = sc.nextLine();
       setName(newName);

       System.out.println("Enter new salary of the employee: ");
       double newSalary = sc.nextDouble();
       sc.nextLine();

       setSalary(newSalary);



       System.out.println("Enter new age of the employee: ");
       int newAge = sc.nextInt();
       sc.nextLine();
       setAge(newAge);
   }

}
