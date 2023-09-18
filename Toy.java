

public class Toy implements Comparable<Toy> {

    private int id;
    private final String name;
    private int count;
    private int weight;



    public Toy(String name, int count, int weight) {
        this.name = name;
        this.count = count;
        this.weight = weight;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getWeight() {
        return weight;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public int compareTo(Toy other) {
        // Сравниваем объекты на основе их веса(приоритета)
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", weight=" + weight +
                '}';
    }
}
