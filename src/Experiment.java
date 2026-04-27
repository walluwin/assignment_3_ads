import java.util.Arrays;

public class Experiment {
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        int[] copy = Arrays.copyOf(arr, arr.length);

        long startTime = System.nanoTime();
        if (type.equals("basic")) {
            sorter.basicSort(copy);
        } else {
            sorter.advancedSort(copy);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public long measureSearchTime(int[] arr, int target) {
        long startTime = System.nanoTime();
        searcher.search(arr, target);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};

        System.out.println("Результаты экспериментов");
        System.out.printf("%-15s | %-10s | %-15s | %-15s%n", "Тип данных", "Размер", "Bubble (нс)", "Merge (нс)");

        for (int size : sizes) {
            int[] randomArray = sorter.generateRandomArray(size);
            long basicTime = measureSortTime(randomArray, "basic");
            long advancedTime = measureSortTime(randomArray, "advanced");
            System.out.printf("%-15s | %-10d | %-15d | %-15d%n", "Random", size, basicTime, advancedTime);

            int[] sortedArray = Arrays.copyOf(randomArray, randomArray.length);
            Arrays.sort(sortedArray);

            long basicTimeSorted = measureSortTime(sortedArray, "basic");
            long advancedTimeSorted = measureSortTime(sortedArray, "advanced");
            System.out.printf("%-15s | %-10d | %-15d | %-15d%n", "Sorted", size, basicTimeSorted, advancedTimeSorted);
        }

        System.out.println("\nТест поиска (Linear Search)");
        int[] searchArray = sorter.generateRandomArray(1000);
        long searchTime = measureSearchTime(searchArray, -1);
        System.out.println("Время линейного поиска для 1000 элементов: " + searchTime + " нс");
    }
}
