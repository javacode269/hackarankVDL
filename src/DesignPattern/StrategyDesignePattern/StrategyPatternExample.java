package DesignPattern.StrategyDesignePattern;
import java.util.ArrayList;
import java.util.List;


public class StrategyPatternExample {

    public static void main(String[] args) {

        SortedList sortedList = new SortedList();
        sortedList.add("Java Core");
        sortedList.add("Java Design Pattern");
        sortedList.add("Java Library");
        sortedList.add("Java Framework");

        sortedList.setSortStrategy(new QuickSort());
        sortedList.sort();
        System.out.println(sortedList);

        sortedList.setSortStrategy(new MergeSort());
        sortedList.sort();
        System.out.println(sortedList);
    }
}

class SortedList {

    private SortStrategy strategy;
    private List<String> items = new ArrayList<>();

    public void setSortStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void add(String name) {
        items.add(name);
    }

    public void sort() {
        strategy.sort(items);
    }
}
