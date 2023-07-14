import java.util.Objects;

public class Employee {

    public static int counterId;
    private final int id;
    private final String name;
    private int department;
    private double salary;


    public Employee(String name, int department, double salary) {
        this.name = name;
        if (department < 1 || department > 5) {
            throw new RuntimeException("Нет такого отдела");
        }
        this.department = department;
        this.salary = salary;
        this.id = counterId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new RuntimeException("Нет такого отдела");
        }
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + ". Сотрудник " + name + " работает в отделе: " + department + " с зарплатой: " +
                String.format("%1$,.2f", salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && employee.salary == salary && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, salary);
    }
}