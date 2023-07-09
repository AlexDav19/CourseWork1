
public class Main {
    public static void main(String[] args) {
        //Проверка методов
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Иванов Иван Иванович", 5, 55000);
        employeeBook.addEmployee("Димитров Дмитрий Дмитриевич", 3, 50000);
        employeeBook.addEmployee("Семенов Олег Викторович", 2, 79000);
        employeeBook.addEmployee("Кузнецов Владимир Михайлович", 3, 100000);
        employeeBook.addEmployee("Димитров Дмитрий Дмитриевич", 1, 15000);
        employeeBook.printAllEmployee();
        System.out.println("Всего на сотрудников тратится: " + employeeBook.getSumSalary());
        System.out.println("Средняя зарплата: " + employeeBook.getAverageSalary());
        employeeBook.deleteEmployee("Димитров Дмитрий Дмитриевич", 1);
        employeeBook.printAllEmployee();
        System.out.println("Всего на сотрудников тратится: " + employeeBook.getSumSalary());
        System.out.println("Средняя зарплата: " + employeeBook.getAverageSalary());
        employeeBook.findEmployee("Кузнецов Дмитрий Дмитриевич",4);
        employeeBook.findMinSalary();
        employeeBook.findMaxSalary();
        employeeBook.printNameAllEmployee();
        employeeBook.indexingSalary(10);
        employeeBook.printAllEmployee();
        employeeBook.findMinSalaryInDepartment(4);
        employeeBook.findMaxSalaryInDepartment(4);
        System.out.printf("Общая зарплата в отделе %s равна: %.2f%n", 1, employeeBook.getSumSalaryInDepartment(1));
        System.out.printf("Средняя зарплата в отделе %s равна: %.2f%n", 1, employeeBook.getAverageSalaryInDepartment(1));
        employeeBook.indexingSalaryInDepartment(2, 7);
        employeeBook.getAllEmployeeInDepartment(1);
        employeeBook.findSalaryUnder(75000);
        employeeBook.findSalaryOver(79000);
        employeeBook.setEmployees("Кузнецов Владимир Михайлович", 97000, 1);
        employeeBook.setEmployees("Кузнецов Владимир Михайлович", 2);
        employeeBook.printAllEmployee();
        employeeBook.findAllEmployeeInDepartment();
    }
}