//inherit from employeeList class
public class LocalEmployee extends Employee {

    public LocalEmployee(String name, double salary, String citizenship, int age) {
        super(name, salary, citizenship, age);
    }
    public double getSalary(){

        return salary * 0.8;
    }
}

