
import java.time.LocalDate;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Employee> data = Employee.getData();
        System.out.println("1-------------------------");
        data.stream()
                .filter(e -> e.getAge() > 30)
                .forEach(System.out::println);
        System.out.println("2-------------------------");
        data.stream()
                .map(Employee::getName)
                .toList()
                .forEach(System.out::println);
        System.out.println("3-------------------------");
        System.out.println(data.stream()
                .map(Employee::getSalary)
                .sorted()
                .toList()
                .getLast());

        System.out.println("4-------------------------");
        System.out.println(data.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum)/data.size());

        System.out.println("5-------------------------");
        data.stream()
                .sorted((a, b) -> a.getSurname().compareTo(b.getSurname()))
                .forEach(System.out::println);

        System.out.println("6-------------------------");
        data.stream()
                .filter(e -> e.getAge() > 25)
                .forEach(System.out::println);

        System.out.println("7-------------------------");
        data.stream()
                .filter(e -> e.getDepartment() == Department.IT)
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("8-------------------------");
        data.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((k, v) -> {
                    System.out.println(k);
                    v.forEach(System.out::println);
                });

        System.out.println("9-------------------------");
        data.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((k, v) -> {
                    System.out.println(k);
                    System.out.println(v.size());
                });

        System.out.println("10-------------------------");
        data.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((k, v) -> {
                    System.out.println(k);
                    System.out.println(v
                            .stream()
                            .map(Employee::getAge)
                            .reduce(0, Integer::sum)
                            / v.size()
                    );
                });

        System.out.println("11-------------------------");
        data.stream()
                .collect(Collectors.groupingBy(Employee::getIsEmployer))
                .forEach((k, v) -> {
                    System.out.println(k ? "Employers" : "Non-Employers");
                    System.out.println(v);
                });

        System.out.println("12-------------------------");
        System.out.println(data.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum));

        System.out.println("13-------------------------");
        System.out.println(data.stream()
                .map(Employee::getSalary)
                .min(Double::compare));

        System.out.println("14-------------------------");
        System.out.println(data.stream()
                .map(Employee::getSurname)
                .collect(Collectors.toSet()));

        System.out.println("15-------------------------");
        System.out.println(data.stream()
                .collect(Collectors.toMap(Employee::getName, Employee::getSalary)));

        System.out.println("16-------------------------");
        System.out.println(data.stream()
                .filter(Employee::getIsEmployer)
                .map(Employee::getName)
                .collect(Collectors.toList()));

        System.out.println("17-------------------------");
        System.out.println(data.stream()
                .map(e -> e.getName() + " " + e.getSurname())
                .collect(Collectors.toList()));

        System.out.println("18-------------------------");
        List<Employee> data2 = Employee.deepCopy();
        System.out.println(data2.stream()
                .peek(e -> e.setSalary(e.getSalary() * 1.1))
                .collect(Collectors.toList()));

        System.out.println("19-------------------------");
        System.out.println(data.stream()
                .filter(e-> e.getDepartment() == Department.IT)
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum));

        System.out.println("20-------------------------");
        data.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((k, v) -> {
                    System.out.println(k);
                    System.out.println(v.stream()
                            .map(Employee::getSalary)
                            .reduce(0.0, Double::sum));
                });

        System.out.println("21-------------------------");
        System.out.println(data.stream()
                .filter(e -> e.getSalary() >= Employee.getAverageSalary())
                .toList());

        System.out.println("22-------------------------");
        System.out.println(data.stream()
                .collect(Collectors.toMap(Employee::getId, Employee -> Employee)));

        System.out.println("23-------------------------");
        data.stream()
                .sorted((a, b) -> (int) (b.getSalary() - a.getSalary()))
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("24-------------------------");
        data.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((k, v) -> {
                    System.out.println(k);
                    System.out.println(v.stream().min((a, b) -> b.getAge() - a.getAge()).orElseThrow());

                });

        System.out.println("Another approach of 24-------------------------");
        System.out.println(data.stream()
                .collect(Collectors
                        .toMap(
                                Employee::getDepartment,
                                Employee::getSalary,
                                BinaryOperator.maxBy(Double::compare))
                ));

        System.out.println("25-------------------------");
        data.stream()
                .map( e-> e.getName() + ", " + e.getSurname())
                .forEach(System.out::println);

        System.out.println("26-------------------------");
        List<List<Employee>> data3 = data
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .values()
                .stream()
                .toList();
        System.out.println(data3.stream()
                .flatMap(List::stream)
                .toList()
        );

        System.out.println("27-------------------------");
        System.out.println(data.stream()
                .map(e-> LocalDate.now().getYear() - e.getStartDate().getYear())
                .toList());

        System.out.println("28-------------------------");
        System.out.println(data.stream()
                .max((a, b) -> (int) (b.getStartDate().getYear() - a.getStartDate().getYear()))
                .orElseThrow());

        System.out.println("29-------------------------");
        System.out.println(data.stream()
                .reduce(0.0, (a, b) -> a + b.getSalary(), Double::sum));

        System.out.println("30-------------------------");
        data.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((k, v) -> System.out.println(k + " " + v.size()));





    }
}
/*todo:
1. Filter employees by age greater than 30.
2. Get a list of employee names.
3. Find the employee with the highest salary.
4. Calculate the average salary of all employees.
5. List all employees sorted by their surname.
6. Check if all employees are older than 25.
7. Find the names of employees working in the IT department.
8. Group employees by department.
9. Count the number of employees in each department.
10. Find the average age of employees in each department.
11. Partition employees into employers and non-employers.
12. Get the total salary of all employees.
13. Find the employee with the lowest salary.
14. Get a list of the unique surnames of all employees.
15. Get a map of employee names to their respective salaries.
16. List the names of employees who are not employers.
17. Get a list of employees' full names (name + surname).
18. Increase the salary of all employees by 10% and collect the updated list.
19. Find the sum of the salaries of all employees in the IT department.
20. Group employees by department and calculate the total salary for each department.
21. List employees who have a salary greater than the average salary of all employees.
22. Convert the list of employees to a map where the key is the employee's ID and the value is the employee object.
23. Get the names of employees sorted by their salary in descending order.
24. Find the oldest employee in each department.
25. Merge the names and surnames of employees into a single string, separated by commas.
26. Flatten a list of lists of employees and collect the results.
27. Calculate the total number of years of experience for all employees (assume ‘startDate’ is the start of their employment).
28. Find the longest-serving employee.
29. Reduce the list of employees to get the combined salary of all employees.
30. Count the number of employees with each position.
*/
