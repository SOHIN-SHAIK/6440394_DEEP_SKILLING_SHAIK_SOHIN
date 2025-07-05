class Employee {
    String id, name, position;
    double salary;

    public Employee(String id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return id + " | " + name + " | " + position + " | $" + salary;
    }
}

public class EmployeeManagementSystem {
    Employee[] employees = new Employee[100];
    int count = 0;

    public void add(Employee emp) {
        employees[count++] = emp;
    }

    public Employee search(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].id.equals(id)) return employees[i];
        }
        return null;
    }

    public void delete(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].id.equals(id)) {
                employees[i] = employees[--count];
                return;
            }
        }
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.add(new Employee("E01", "Alice", "Manager", 90000));
        ems.add(new Employee("E02", "Bob", "Engineer", 70000));
        ems.display();
        ems.delete("E01");
        System.out.println("\nAfter Delete:");
        ems.display();
    }
}
