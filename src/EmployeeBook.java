public class EmployeeBook {
    private final Employee[] employees;
    public int size;
    public static int counterId;

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
            System.out.println(getEmployees()[i]);
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
    public int getMinSalaryId() { //Дополнительный метод для получения id сотрудника
        double minSalary = employees[0].getSalary();
        int id = 0;
        for (int i = 0; i < size - 1; i++) {
            if (minSalary > employees[i + 1].getSalary()) {
                minSalary = employees[i + 1].getSalary();
                id = employees[i + 1].getId();
            }
        }
        return id;
    }

    public void findMinSalary() {
        for (int i = 0; i < size; i++) {
            if (getMinSalaryId() == employees[i].getId()) {
                System.out.printf("Минимальная зарплата у сотрудника: %s из отдела %s и равна %.2f%n", employees[i].getName(),
                        employees[i].getDepartment(), employees[i].getSalary());
                return;
            }
        }
    }

    //Найти сотрудника с максимальной зарплатой.
    public int getMaxSalaryId() { //Дополнительный метод для получения id сотрудника
        double maxSalary = employees[0].getSalary();
        int id = 0;
        for (int i = 0; i < size - 1; i++) {
            if (maxSalary < employees[i + 1].getSalary()) {
                maxSalary = employees[i + 1].getSalary();
                id = employees[i + 1].getId();
            }
        }
        return id;
    }

    public void findMaxSalary() {
        for (int i = 0; i < size; i++) {
            if (getMaxSalaryId() == employees[i].getId()) {
                System.out.printf("Максимальная зарплата у сотрудника: %s из отдела %s и равна %.2f%n", employees[i].getName(),
                        employees[i].getDepartment(), employees[i].getSalary());
                return;
            }
        }
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
    //Сотрудника с минимальной зарплатой.
    public void findMinSalaryInDepartment(int department) {
        double minSalary = Integer.MAX_VALUE;
        int id = -1;
        for (int i = 0; i < size; i++) {
            if (department == employees[i].getDepartment() && minSalary > employees[i].getSalary()) {
                minSalary = employees[i].getSalary();
                id = i;
            }
        }
        if (id == -1) {
            System.out.println("В отделе нет сотрудников");
            return;
        }
        System.out.printf("Минимальная зарплата в отделе %s у сотрудника %s и равна: %.2f%n", department,
                employees[id].getName(), employees[id].getSalary());
    }

    //Сотрудника с максимальной зарплатой.
    public void findMaxSalaryInDepartment(int department) {
        double maxSalary = 0;
        int id = -1;
        for (int i = 0; i < size; i++) {
            if (department == employees[i].getDepartment() && maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
                id = i;
            }
        }
        if (id == -1) {
            System.out.println("В отделе нет сотрудников");
            return;
        }
        System.out.printf("Максимальная зарплата в отделе %s у сотрудника %s и равна: %.2f%n", department,
                employees[id].getName(), employees[id].getSalary());
    }

    //Сумму затрат на зарплату по отделу.
    public double getSumSalaryInDepartment(int department) {
        double sum = 0;
        int check = -1;
        for (int i = 0; i < size; i++) {
            if (department == employees[i].getDepartment()) {
                sum += employees[i].getSalary();
                check = i;
            }
        }
        if (check == -1) {
            return 0;
        }
        return sum;
    }

    //Среднюю зарплату по отделу
    public double getAverageSalaryInDepartment(int department) {
        int employee = 0;
        int check = -1;
        for (int i = 0; i < size; i++) {
            if (department == employees[i].getDepartment()) {
                employee++;
                check++;
            }
        }
        if (check == -1) {
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