package br.edu.utfpr;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class SalesReader {

    private final List<Sale> sales;

    public SalesReader(String salesFile) {

        final var dataStream = ClassLoader.getSystemResourceAsStream(salesFile);

        if (dataStream == null) {
            throw new IllegalStateException("File not found or is empty");
        }

        final var builder = new CsvToBeanBuilder<Sale>(new InputStreamReader(dataStream, StandardCharsets.UTF_8));

        sales = builder
                .withType(Sale.class)
                .withSeparator(';')
                .build()
                .parse();
    }

    public BigDecimal totalOfCompletedSales() {

        return sales.stream()
                .filter(sale -> sale.getStatus() == Sale.Status.COMPLETED)
                .map(Sale::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal totalOfCancelledSales() {

        return sales.stream()
                .filter(sale -> sale.getStatus() == Sale.Status.CANCELLED)
                .map(Sale::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Optional<Sale> mostRecentCompletedSale() {

        return sales.stream()
                .filter(sale -> sale.getStatus() == Sale.Status.COMPLETED)
                .max(Comparator.comparing(Sale::getSaleDate));
    }

    public long daysBetweenFirstAndLastCancelledSale() {

       final Optional<LocalDate> firstCancelledSale = sales.stream()
                                                .filter(sale -> sale.getStatus() == Sale.Status.CANCELLED)
                                                .map(Sale::getSaleDate)
                                                .min(Comparator.naturalOrder());
       final Optional<LocalDate> lastCancelledSale = sales.stream()
                                                .filter(sale -> sale.getStatus() == Sale.Status.CANCELLED)
                                                .map(Sale::getSaleDate)
                                                .max(Comparator.naturalOrder());
        return (firstCancelledSale.isPresent() && lastCancelledSale.isPresent())?
                ChronoUnit.DAYS.between(firstCancelledSale.get(), lastCancelledSale.get()) :
                0;

    }

//    public BigDecimal totalCompletedSalesBySeller(String sellerName) {
//
//        return sales.stream()
//                .filter(sale -> sale.getStatus() == Sale.Status.COMPLETED && sale.getSeller().equals(sellerName))
//                .map(Sale::getValue)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//    }

    public long countAllSalesByManager(String managerName) {

        return sales.stream()
                .filter(sale -> sale.getManager().equals(managerName))
                .map(Sale::getValue)
                .count();
    }

    public BigDecimal totalSalesByStatusAndMonth(Sale.Status status, Month... months) {

        return sales.stream()
                .filter(sale -> sale.getStatus() == status && sale.getEstate().contains("PR") && Arrays.asList(months).contains(sale.getSaleDate().getMonth()))
                .map(Sale::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

//    public Map<String, Long> countCompletedSalesByDepartment() {
//
//        return sales.stream()
//                .filter(sale -> sale.getStatus() == Sale.Status.COMPLETED)
//                .collect(Collectors.groupingBy(Sale::getDepartment, Collectors.counting()));
//    }

    public Map<Integer, Map<String, Long>> countCompletedSalesByPaymentMethodAndGroupingByYear() {

        return sales.stream()
                .filter(sale -> sale.getStatus() == Sale.Status.COMPLETED)
                .collect(Collectors.groupingBy(
                        sale -> sale.getSaleDate().getYear(),
                            Collectors.groupingBy(Sale::getPaymentMethod,
                                    Collectors.counting()
                            )
                        )
                );
    }

    public Map<String, BigDecimal> top3BestSellers() {
        // TODO implementar
        return sales.stream()
                .filter(sale -> sale.getStatus() == Sale.Status.COMPLETED)
                .collect(Collectors.groupingBy(
                        Sale::getSeller,
                        Collectors.mapping(Sale::getValue, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))))
                .entrySet().stream()
                .sorted(Map.Entry.<String, BigDecimal>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (valor1, valor2) -> valor1,
                        LinkedHashMap::new)
                );
    }

    // Questoes Sobre Vendas - B4A2
    // 1
//    public Map<String, BigDecimal> top3BestSellers() {
//
//        return sales.stream()
//                .filter(sale -> sale.getStatus() == Sale.Status.COMPLETED)
//                .collect(Collectors.groupingBy(
//                        Sale::getSeller,
//                        Collectors.mapping(Sale::getValue, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))))
//                .entrySet().stream()
//                .sorted(Map.Entry.<String, BigDecimal>comparingByValue().reversed())
//                .limit(3)
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (valor1, valor2) -> valor1,
//                        LinkedHashMap::new)
//                );
//    }

    //2 Qual o total de vendas caso os seguintes filtros fossem utilizados:
    // vendas completas, no estado do paraná, nos meses de janeiro, junho e dezembro

//    public BigDecimal totalSalesByStatusAndMonth(Sale.Status status, Month... months) {
//
//        return sales.stream()
//                .filter(sale -> sale.getStatus() == status && sale.getEstate().contains("PR") && Arrays.asList(months).contains(sale.getSaleDate().getMonth()))
//                .map(Sale::getValue)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//    }

    //3
    public BigDecimal totalCompletedSalesBySeller(String sellerName) {

        return sales.stream()
                .filter(sale -> sale.getStatus() == Sale.Status.COMPLETED && sale.getSeller().equals("Rosângela Almeida"))
                .filter(sale -> sale.getSaleDate().isAfter(LocalDate.of(2012,05,12)) &&
                        sale.getSaleDate().isAfter(LocalDate.of(2012,07,29)))
                .map(Sale::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // 4 Em qual ano tivemos R$ 3.689.379.28 em vendas?
//    public Map<Integer, Long> countCompletedSalesByDepartment() {
//        BigDecimal v = BigDecimal.valueOf(3689379.28);
//
//        return sales.stream()
//                .filter(sale -> sale.getStatus() == Sale.Status.COMPLETED && sale.getValue().compareTo(v) == 0)
//                .collect(Collectors.groupingBy(sale -> sale.getSaleDate().getYear(), Collectors.counting()));
//    }

//    public Map<Integer, BigDecimal> countCompletedSalesByDepartment() {
//        BigDecimal v = BigDecimal.valueOf(3689379.28);
//
//        return sales.stream()
//                .filter(sale -> sale.getStatus() == Sale.Status.COMPLETED && sale.getValue().compareTo(v) == 0)
//                .collect(Collectors.groupingBy(
//                        sale -> sale.getSaleDate().getYear(),
//                        Collectors.reducing(BigDecimal.ZERO, Sale::getValue, BigDecimal::add)
//                ));
//    }

    public Optional<Integer> assert_findYearWithTotalSales(BigDecimal targetValue) {
        return sales.stream()
                .filter(sale -> sale.getStatus() == Sale.Status.COMPLETED)
                .collect(Collectors.groupingBy(
                        sale -> sale.getSaleDate().getYear(),
                        Collectors.reducing(BigDecimal.ZERO, Sale::getValue, BigDecimal::add)
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue().compareTo(targetValue) == 0)
                .map(Map.Entry::getKey)
                .findFirst();
    }


    // 5
//    public String managerWithMostCancellationsBetween2013And2014(List<Sale> sales) {
//        return sales.stream()
//                .filter(sale -> sale.getStatus() == Sale.Status.CANCELLED)
//                .filter(sale -> sale.getSaleDate().isAfter(LocalDate.of(2012, 12, 31)) &&
//                        sale.getSaleDate().isBefore(LocalDate.of(2015, 1, 1)))
//                .collect(Collectors.groupingBy(sale -> sale.getManager(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse(null);
//    }

}
