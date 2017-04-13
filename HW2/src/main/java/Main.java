import java.util.function.Supplier;

/**
 * Измеряет размер объектов.
 * Created by alina on 09.04.17.
 */
public class Main {

    public static final int MAX_SIZE = 1_000;
    public static final int STEP = 250;

    public static void main(String... args) throws InterruptedException {
        Measure measure = new Measure();
        Supplier<Object> objectSupplier = () -> new Object();
        System.out.println("Размер объекта = " + measure.getObjectSize(objectSupplier));

        Supplier<Object> stringSupplier = () -> new String();
        System.out.println("Размер пустой строки = " + measure.getObjectSize(stringSupplier));

        Supplier<Object> emptyArraySupplier = () -> new Object[0];
        System.out.println("Размер пустого контейнера = " + measure.getObjectSize(emptyArraySupplier));


        System.out.println("Зависимость пустого контейнера от числа элементов: ");
        for (int i = STEP; i <= MAX_SIZE; i = i + STEP) {
            final int size = i;
            Supplier<Object> fullArraySupplier = () -> new Object[size];
            System.out.println("Количество элементов: " + i + "  -- размер: " + measure.getObjectSize(fullArraySupplier));
        }

    }

}

