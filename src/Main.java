public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        Searcher searcher = new Searcher();
        Experiment experiment = new Experiment();

        System.out.println("Система анализа алгоритмов сортировки и поиска");
        System.out.println("Выбранные алгоритмы:");
        System.out.println("- Простая сортировка: Bubble Sort");
        System.out.println("- Продвинутая сортировка: Merge Sort");
        System.out.println("- Поиск: Linear Search\n");

        experiment.runAllExperiments();
        System.out.println("\nЭксперименты завершены успешно.");
    }
}
