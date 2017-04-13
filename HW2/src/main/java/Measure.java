import java.util.function.Supplier;

/**
 * Измерение размера объектов.
 */
public class Measure {

    public static final int SIZE = 100;
    public static final int NUMBER_OF_EXPERIENCES = 5;

    /**
     * Вычисляет размер объекта.
     *
     * @return размер объекта
     */
    public long getObjectSize(Supplier<Object> supplier) throws InterruptedException {

        long sumObjectSize = 0;

        for (int i = 0; i < NUMBER_OF_EXPERIENCES; i++) {
            long sizeObject = getObjectSizeAtOnePass(supplier);
            sumObjectSize += sizeObject;
        }

        long objectSize = Math.round(1. * sumObjectSize / NUMBER_OF_EXPERIENCES);
        return objectSize;
    }

    private long getObjectSizeAtOnePass(Supplier<Object> supplier) throws InterruptedException {
        Object[] array = new Object[SIZE];

        long before = getUsedMemory();

        for (int j = 0; j < SIZE; j++) {
            array[j] = supplier.get();
        }

        long after = getUsedMemory();

        return Math.round(1. * (after - before) / SIZE);
    }

    private void gc() {
        try {
            System.gc();
            Thread.sleep(100);

            System.runFinalization();
            Thread.sleep(100);

            System.gc();
            Thread.sleep(100);

            System.runFinalization();
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    private long getUsedMemory(){
        gc();
        long totalMemory = Runtime.getRuntime().totalMemory();
        gc();
        long freeMemory = Runtime.getRuntime().freeMemory();
        return (totalMemory - freeMemory);
    }
}
