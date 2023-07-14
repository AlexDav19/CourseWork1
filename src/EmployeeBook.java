public class EmployeeBook {
    private final Employee[] employees;
    public int size;

    public Employee[] getEmployees() {
        return employees;
    }

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    //Добавление сотрудника
    public void addEmployee(String name, int department, double salary) {
        if (size >= employees.length) {
            System.out.println("Места нет");
        } else {
            Employee newEmployee = new Employee(name, department, salary);
            employees[size++] = newEmployee;
        }
    }

    //Удаление сотрудника
    public void deleteEmployee(String name, int department) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getName().equals(name) && employees[i].getDepartment() == department) {
                System.out.println(employees[i].getName() + " удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Такой сотрудник не найден");
    }

    //Получить список всех сотрудников со всеми имеющимися по ним данными
    public void printAllEmployee() {
        System.out.println("Наши сотрудники:");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }


    public void findEmployee(String name, int department) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getName().equals(name) && employees[i].getDepartment() == department) {
                System.out.println(employees[i]);
                return;
            }
        }
        System.out.println("Не найден");
    }

    //Посчитать сумму затрат на зарплаты в месяц.
    public double getSumSalary() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    //Найти сотрудника с минимальной зарплатой.
    public Employee findMinSalary() {
        Employee minSalaryemployee = employees[0];
        for (int i = 1; i < size; i++) {
            if (minSalaryemployee.getSalary() > employees[i].getSalary()) {
                minSalaryemployee = employees[i];
            }
        }
        return minSalaryemployee;
    }

    //Найти сотрудника с максимальной зарплатой.
    public Employee findMaxSalary() {
        Employee maxSalaryemployee = employees[0];
        for (int i = 1; i < size; i++) {
            if (maxSalaryemployee.getSalary() < employees[i].getSalary()) {
                maxSalaryemployee = employees[i];
            }
        }
        return maxSalaryemployee;
    }

    //Подсчитать среднее значение зарплат
    public double getAverageSalary() {
        return getSumSalary() / size;
    }

    //Получить Ф. И. О. всех сотрудников
    public void printNameAllEmployee() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].getName());
        }
    }

    //Проиндексировать зарплату
    public void indexingSalary(double percent) {
        for (int i = 0; i < size; i++) {
            employees[i].setSalary(employees[i].getSalary() * (1 + percent / 100));
        }
    }

    //Получить в качестве параметра номер отдела
    //Сотрудника с минимальной зарплатой в отделе.
    public Employee findMinSalaryInDepartment(int department) {
        Employee minSalaryemployee = null;
        for (int i = 0; i < size; i++) {
            if (department == employees[i].getDepartment() &&
                    (minSalaryemployee == null || minSalaryemployee.getSalary() < employees[i].getSalary())) {
                minSalaryemployee = employees[i];
            }
        }
        return minSalaryemployee;
    }

    //Сотрудника с максимальной зарплатой в отделе.
    public Employee findMaxSalaryInDepartment(int department) {
        Employee maxSalaryemployee = null;
        for (int i = 0; i < size; i++) {
            if (department == employees[i].getDepartment() &&
                    (maxSalaryemployee == null || maxSalaryemployee.getSalary() < employees[i].getSalary())) {
                maxSalaryemployee = employees[i];
            }
        }
        return maxSalaryemployee;
    }

    //Сумму затрат на зарплату по отделу.
    public double getSumSalaryInDepartment(int department) {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            if (department == employees[i].getDepartment()) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    //Среднюю зарплату по отделу
    public double getAverageSalaryInDepartment(int department) {
        int employee = 0;
        for (int i = 0; i < size; i++) {
            if (department == employees[i].getDepartment()) {
                employee++;
            }
        }
        if (employee == 0) {
            return 0;
        }
        return getSumSalaryInDepartment(department) / employee;
    }

    //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
    public void indexingSalaryInDepartment(int department, double percent) {
        for (int i = 0; i < size; i++) {
            if (department == employees[i].getDepartment()) {
                employees[i].setSalary(employees[i].getSalary() * (1 + percent / 100));
            }
        }
    }

    //Напечатать всех сотрудников отдела (все данные, кроме отдела).
    public void getAllEmployeeInDepartment(int department) {
        System.out.printf("Сотрудники отдела %s:%n", department);
        int check = -1;
        for (int i = 0; i < size; i++) {
            if (department == employees[i].getDepartment()) {
                System.out.printf("id %s Сотрудник %s с зарплатой %.2f%n",
                        employees[i].getId(), employees[i].getName(), employees[i].getSalary());
                check++;
            }
        }
        if (check == -1) {
            System.out.println("Сотрудников нет");
        }
    }

    //Получить в качестве параметра число и найти:
    //Всех сотрудников с зарплатой меньше числа
    public void findSalaryUnder(double number) {
        System.out.println("Сотрудники с зарплатой меньше " + number);
        int check = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() < number) {
                System.out.printf("%s. %s %.2f%n", employees[i].getId(), employees[i].getName(), employees[i].getSalary());
                check++;
            }
        }
        if (check == -1) {
            System.out.println("Нет сотрудников с зарплатой меньше " + number);
        }
    }

    //Всех сотрудников с зарплатой больше числа
    public void findSalaryOver(double number) {
        System.out.println("Сотрудники с зарплатой больше " + number);
        int check = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() >= number) {
                System.out.printf("%s. %s %.2f%n", employees[i].getId(), employees[i].getName(), employees[i].getSalary());
                check++;
            }
        }
        if (check == -1) {
            System.out.println("Нет сотрудников с зарплатой больше " + number);
        }
    }

    //Изменить зарплату и отдел
    public void setEmployees(String name, double salary, int department) {
        int check = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getName().equals(name)) {
                employees[i].setSalary(salary);
                employees[i].setDepartment(department);
                check++;
            }
        }
        if (check == -1) {
            System.out.println("Сотрудник не найден");
        }
    }

    //Изменить зарплату или отдел
    public void setEmployees(String name, int number) {
        int check = -1;
        if (number >= 1 && number <= 5) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getName().equals(name)) {
                    employees[i].setDepartment(number);
                    check++;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (employees[i].getName().equals(name)) {
                    employees[i].setSalary(number);
                    check++;
                }
            }
        }
        if (check == -1) {
            System.out.println("Сотрудник не найден");
        }
    }

    //Получить Ф. И. О. всех сотрудников по отделам
    public void findAllEmployeeInDepartment() {
        for (int i = 1; i <= 5; i++) {
            int check = -1;
            System.out.println("Отдел " + i + ":");
            for (int j = 0; j < size; j++) {
                if (employees[j].getDepartment() == i) {
                    System.out.println(employees[j].getName());
                    check++;
                }
            }
            if (check == -1) {
                System.out.println("Нет сотрудников");
            }
        }
    }
}