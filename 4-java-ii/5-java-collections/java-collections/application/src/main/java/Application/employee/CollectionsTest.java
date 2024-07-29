package Application.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionsTest {

    public CollectionsTest(){
        test();
    }

    private void test(){
        final var employees = createEmployee();

        // Query findByDepartament
        System.out.println("=== FindBy Departament TEST-3 ===");
        employees.stream()
                .filter(employee -> employee.getDepartament().equals("HR"))
                        .forEach(System.out::println);
        System.out.println("=======================================");

        System.out.println("\n=== FindBy Total in Depertament TEST-3  =====");
           final var totalDept = employees.stream()
                           .filter(employee -> employee.getDepartament().equals("HR"))
                   .map(Employee::getName)
                   .peek(System.out::println)
                                   .count();

        System.out.println(totalDept);
        System.out.println("=======================================");

        System.out.println("\n=== FindBy Total Salary in Depertament TEST-3 ========");
        final var totalSalary3 = employees.stream().filter(employee -> employee.getDepartament().equals("Financial"))
                        .map(Employee::getSalary)
                                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total Salary: " + totalSalary3);
        System.out.println("=======================================");

        System.out.println("\n=== FindBy Match -> any employee from: Engineering TEST-3  ==========");
        final var anyEmployee = employees.stream().anyMatch(employee -> employee.departament().equals("Engineering"));

        System.out.println("Is there any employee at Departament Engineering: " + anyEmployee);
        System.out.println("=======================================");

        System.out.println("\n=== Create a List from Filter TEST-2 ==========");

        System.out.println("=======================================");


        System.out.println("List from Distinct() -> Paul TEST-2");
        //TODO

        System.out.println("=======================================");

        System.out.println("\n=== Orderer List DESC Salary TEST-2==========");

        System.out.println("=======================================");

        System.out.println("\n=== Orderer Limited List DESC Salary - 2 employees TEST-2==========");

        System.out.println("=======================================");






        System.out.println("\n\n---------------------------------------------");
        employees.stream()
                .filter(employee -> employee.getDepartament().equals("HR"))
                .forEach(System.out::println);
        System.out.println("======================");

        System.out.println("\n=== FindBy Total in Depertament  =====");
        final var total = employees.stream()
                        .filter(employee -> employee.getDepartament().equals("HR"))
                                .count();

        System.out.println("\tTotal employee at Departament HR: %s".formatted(total));
        System.out.println("=======================================");

        System.out.println("\n=== FindBy Total Salary in Depertament  ==========");
        final var totalSalary = employees.stream()
                        .filter(employee -> employee.getDepartament().equals("Engineering"))
                         .map(Employee::getSalary)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("\tTotal Salary employee at Departament Eng: %s", totalSalary).println();
        System.out.println("===================================================");

        System.out.println("\n=== FindBy Match -> any employee from: Security  ==========");
        final var anyFromDept = employees.stream()
                                    .anyMatch(employee -> employee.getDepartament().equals("Security"));
        System.out.println(anyFromDept);
        System.out.println("===================================================");

        System.out.println("\n=== Create a List from Filter  ==========");
        final var employeeFromDept = employees.stream()
                                              .filter(employee -> employee.getDepartament().equals("Law"))
                                              .collect(Collectors.toList());
        System.out.println("List from Filter -> Law: ");
        employeeFromDept.forEach(System.out::println);
        System.out.println("===================================================");

        System.out.println("List from Distinct() -> Kroos");
        final var justOneName = employees.stream()
                        .filter(employee -> employee.getName().equals("Kroos"))
                                .distinct()
                                        .count();
        System.out.println(justOneName);
        System.out.println("===================================================");

        System.out.println("\n=== Orderer List DESC Salary ==========");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);

        System.out.println("===================================================");

        System.out.println("\n=== Orderer Limited List DESC Salary - 2 employees ==========");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(2)
                .forEach(System.out::println);

        System.out.println("===================================================");

        // findAny()
        // findFirst()
        // takeWhile()
    }

    private List<Employee> createEmployee(){
        final List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Stll", LocalDate.of(1900, 2, 21), new BigDecimal(10500), "Law"));
        employees.add(new Employee("Felix", LocalDate.of(1900, 2, 21), new BigDecimal(8500), "Engineering"));
        employees.add(new Employee("Paul", LocalDate.of(1900, 2, 21), new BigDecimal(8500), "Engineering"));
        employees.add(new Employee("Anna", LocalDate.of(1900, 2, 21), new BigDecimal(2500), "Law"));
        employees.add(new Employee("Albert", LocalDate.of(1900, 2, 21), new BigDecimal(6499), "Engineering"));
        employees.add(new Employee("Mane", LocalDate.of(1900, 2, 21), new BigDecimal(2500), "Security"));
        employees.add(new Employee("Sane", LocalDate.of(1900, 2, 21), new BigDecimal(3500), "Financial"));
        employees.add(new Employee("Dito", LocalDate.of(1900, 2, 21), new BigDecimal(4500), "Research"));
        employees.add(new Employee("Kroos", LocalDate.of(1900, 2, 21), new BigDecimal(5500), "Engineering"));
        employees.add(new Employee("Schwarzenegger", LocalDate.of(1900, 2, 21), new BigDecimal(5500), "Engineering"));
        employees.add(new Employee("Joseph", LocalDate.of(1900, 2, 21), new BigDecimal(5500), "HR"));
        employees.add(new Employee("Olavo", LocalDate.of(1900, 2, 21), new BigDecimal(9799), "HR"));


        return employees;
    }

    public static void main(String[] args) {
        new CollectionsTest();
    }
}
