package Lection5.HW.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        List<Transaction> sortedTransactionsFor2011 = transactions.stream()
                .filter(it -> it.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();
        System.out.println(sortedTransactionsFor2011);

        // 2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        List<String> distinctCities = transactions.stream()
                .map(Transaction::getTrader)
                .map (Trader::getCity)
                .distinct()
                .toList();
        System.out.println(distinctCities);

        // 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        List<Trader> tradersFromCambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(it -> (it.getCity()).equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .toList();
        System.out.println(tradersFromCambridge);

        // 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        String tradersNames = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining(" "));
        System.out.println(tradersNames);

        //5. Выяснить, существует ли хоть один трейдер из Милана.
        Optional<Trader> traderFromMilan = transactions.stream()
                .map(Transaction::getTrader)
                .filter(it -> (it.getCity()).equals("Milan"))
                .findAny();
        System.out.println(traderFromMilan.isPresent());

        //6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        transactions.stream()
                .filter(transaction -> (transaction.getTrader().getCity().equals("Cambridge")))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //7. Какова максимальная сумма среди всех транзакций?
        Optional<Integer> maxTransactionValue = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo);
        System.out.println(maxTransactionValue);

        //8. Найти транзакцию с минимальной суммой.
        Optional<Integer> minTransactionValue = transactions.stream()
                .map(Transaction::getValue)
                .min(Integer::compareTo);
        System.out.println(minTransactionValue);

    }
}