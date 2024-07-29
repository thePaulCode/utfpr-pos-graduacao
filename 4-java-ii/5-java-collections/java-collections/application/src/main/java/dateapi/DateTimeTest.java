package dateapi;

import javax.swing.text.DateFormatter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class DateTimeTest {

    public DateTimeTest(){

        //test();
        testDateTime();
    }

    private void testDateTime(){
        final var currentDate = new Date(); // data e hora
        System.out.println(currentDate);

        final var currentDate2 = LocalDate.now(); // tem clareza na data de agora
        System.out.println(currentDate2);

        // fluent interface
        final var dataFev = LocalDate.now().plusDays(2).withMonth(2).atTime(13,05);
        System.out.println(dataFev);

        final var actualMonth = LocalDate.now().getMonth();
        System.out.println(actualMonth.getValue());

        final var actualTime = LocalDateTime.now();
        System.out.println(actualTime);

        ///final var combined = LocalDateTime.of(LocalDate.now(), actualTime);
        //System.out.println(combined);

        final var bithDate = LocalDateTime.now();

        System.out.println("Days to birthday: " + ChronoUnit.DAYS.between(LocalDate.now(), bithDate));


       // String text = bithDate.format()
        DateTimeFormatter formatter7 = DateTimeFormatter.ofPattern("dd MMM uuuu, HH:MM");
       final var text = bithDate.format(formatter7);
        System.out.println("\tData Formatada " + text);

       LocalDate formattedDate2 = LocalDate.parse(text, formatter7);
        System.out.println("Hora Brazil: " + formattedDate2);

        final var dataInicioOlimpiadas = LocalDate.of(2024, 07, 26);
        final var horaInicioOlimpiadas = LocalTime.of(19,30,00);
        final var inicioOlimpiadas = LocalDateTime.of(dataInicioOlimpiadas, horaInicioOlimpiadas);

        final var zoneFranca = ZoneId.of("Europe/Paris");
        final var inicioZoneFranca = ZonedDateTime.of(inicioOlimpiadas, zoneFranca);
        final var agoraFranca = ZonedDateTime.now(zoneFranca);

        final var diasParaOlimpiadas = ChronoUnit.DAYS.between(agoraFranca, inicioZoneFranca);
        final var horasParaOlimpiadas = ChronoUnit.HOURS.between(agoraFranca, inicioZoneFranca) % 24;
        final var minParaOlimpiadas = ChronoUnit.MINUTES.between(agoraFranca, inicioZoneFranca) % 60;
        final var secParaOlimpiadas = ChronoUnit.SECONDS.between(agoraFranca, inicioZoneFranca) % 60;

        final var dataLondrina = DateTimeFormatter.ofPattern("E d, H:m ");
        final var agoraLondrina = LocalDateTime.now();
        final var dataFormatadaLdn = agoraLondrina.format(dataLondrina);
        System.out.println("\nLondrina, "+ dataFormatadaLdn);
        System.out.println("\n\tFaltam " + diasParaOlimpiadas + "dias | " + horasParaOlimpiadas + "horas | "+ minParaOlimpiadas + "minutos | " + secParaOlimpiadas + "segundos para o inicio das Olimpíadas de Paris.");

        // banco de dados
        final var instant = Instant.now();

        //System.out.println("Instant " + instant);

//        public Map<String, BigDecimal> top3BestSellers() {
//            // TODO implementar
//            return sales.stream()
//                    .filter(sale -> sale.getStatus() == Sale.Status.COMPLETED)
//                    .collect(Collectors.groupingBy(
//                            Sale::getSeller,
//                            Collectors.mapping(Sale::getValue, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))))
//                    .entrySet().stream()
//                    .sorted(Map.Entry.<String, BigDecimal>comparingByValue().reversed())
//                    .limit(3);
////                .collect(Collectors.toMap(
////                        Map.Entry::getKey,
////                        Map.Entry::getValue,
////                        (valor1, valor2) -> valor1,
////                        LinkedHashMap::new)
////                );
//        }



    }

    private void test(){
        final var employees = createEmployee();

        // Query findByDepartament
        System.out.println("=== FindBy Departament TEST-2 ===");

        employees.stream()
                        .filter(employee -> employee.getDepartament().equals("Security"))
                                .forEach(System.out::println);

        System.out.println("=======================================");

        System.out.println("\n=== FindBy Total in Depertament TEST-2  =====");
        final var totalDepto = employees.stream()
                        .filter(employee -> employee.getDepartament().equals("Law"))
                                .count();
        System.out.println(totalDepto);
        System.out.println("=======================================");

        System.out.println("\n=== FindBy Total Salary in Depertament TEST-2 ========");
        final var totalSalaryDepto = employees.stream()
                        .filter(employee -> employee.getDepartament().equals("Security"))
                                .map(e -> e.getSalary())
                                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Salario total HR " + totalSalaryDepto);
        System.out.println("=======================================");

        System.out.println("\n=== FindBy Match -> any employee from: Enginieering TEST-2  ==========");
        final var anyMatchDepto = employees.stream()
                        .anyMatch(employee -> employee.getDepartament().equals("Enginieering"));
        System.out.println("Is there any employee at Departament Engenieering: " + anyMatchDepto);
        System.out.println("=======================================");

        System.out.println("\n=== Create a List from Filter TEST-2 ==========");
        employees.stream()
                .filter(employee -> employee.getDepartament().equals("Enginieering"))
                .map(e -> e.getName())
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("=======================================");


        System.out.println("List from Distinct() -> Paul TEST-2");
        //TODO
        final var justOneEmployee = employees.stream()
                                            .filter(employee -> employee.getName().equals("Paul"))
                                            .distinct()
                                            .count();
        System.out.println("Employee " + justOneEmployee);
        System.out.println("=======================================");

        System.out.println("\n=== Orderer List DESC Salary TEST-2==========");
        employees.stream()
                        .filter(employee -> employee.getDepartament().equals("HR"))
                                .sorted(Comparator.comparing(Employee::salary).reversed())
                .forEach(System.out::println);
        System.out.println("=======================================");

        System.out.println("\n=== Orderer Limited List DESC Salary - 2 employees TEST-2==========");
        employees.stream()
                        .filter( e -> e.getDepartament().equals("Enginieering"))
                                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                            .limit(2)
                            .distinct()
                                        .forEach(System.out::println);
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
                        .filter(employee -> employee.getDepartament().equals("Enginieering"))
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
        employees.add(new Employee("Felix", LocalDate.of(1900, 2, 21), new BigDecimal(8500), "Enginieering"));
        employees.add(new Employee("Paul", LocalDate.of(1900, 2, 21), new BigDecimal(8500), "Enginieering"));
        employees.add(new Employee("Anna", LocalDate.of(1900, 2, 21), new BigDecimal(2500), "Law"));
        employees.add(new Employee("Albert", LocalDate.of(1900, 2, 21), new BigDecimal(6499), "Enginieering"));
        employees.add(new Employee("Mane", LocalDate.of(1900, 2, 21), new BigDecimal(2500), "Security"));
        employees.add(new Employee("Sane", LocalDate.of(1900, 2, 21), new BigDecimal(3500), "Financial"));
        employees.add(new Employee("Dito", LocalDate.of(1900, 2, 21), new BigDecimal(4500), "Research"));
        employees.add(new Employee("Kroos", LocalDate.of(1900, 2, 21), new BigDecimal(5500), "Enginieering"));
        employees.add(new Employee("Schwarzenegger", LocalDate.of(1900, 2, 21), new BigDecimal(5500), "Enginieering"));
        employees.add(new Employee("Joseph", LocalDate.of(1900, 2, 21), new BigDecimal(5500), "HR"));
        employees.add(new Employee("Olavo", LocalDate.of(1900, 2, 21), new BigDecimal(9799), "HR"));


        return employees;
    }

    public static void main(String[] args) {
        new DateTimeTest();
    }
}
