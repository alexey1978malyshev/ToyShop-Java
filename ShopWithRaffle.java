import java.util.*;

public class ShopWithRaffle implements Comparable<Toy>, Comparator<Toy> {

    private final List<Toy> toys;

    private final int index; // для получения количества типов игрушек в магазине

    public ShopWithRaffle(List<Toy> toys) {
        this.toys = toys;
        index = toys.size();
    }

    public List<Toy> getToys() { return toys; }

    public ShopWithRaffle addToy(Toy toy){
        toys.add(toy);
        return this;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Toy o) {
        return 0;
    }


    @Override
    public int compare(Toy o1, Toy o2) {
        return 0;
    }

    public void toyRaffle(List<Toy> toys){
        PriorityQueue<Toy> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(toys);

        // Создаем генератор случайных чисел
        Random random = new Random();

        // Определяем сумму всех весов
        int totalWeight = priorityQueue.stream().mapToInt(Toy::getWeight).sum();

        // Извлекаем объекты с учетом вероятности их приоритета
        for (int i = 0; i < toys.size(); i++) {
            int randomNumber = random.nextInt(totalWeight); // Генерируем случайное число

            for (Toy t : priorityQueue) {
                // Вычитаем вес объекта из случайного числа и извлекаем объект,
                // если случайное число стало меньше или равно нулю
                randomNumber -= t.getWeight();
                if (randomNumber <= 0 && t.getCount() > 0) {
                    System.out.printf("Congratulations! You won a %s!",t.getName());
                    t.setCount(t.getCount()-1);

                    System.out.printf("There are %s %s left in the store !\n",t.getCount() ,t.getName());
                    priorityQueue.remove(t); // Удаляем из очереди

                    //this.toys.remove(t); // Удаляем из списка игрушек
                    break;
                }

            }
        }

    }


}
