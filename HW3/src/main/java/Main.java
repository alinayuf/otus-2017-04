import java.util.*;

/**
 * Created by alina on 20.04.17.
 */
public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<>();

        Collections.addAll(list, 1, 3, 4, 5, 2, 6);
        System.out.println(list);

        Collections.sort(list, ((o1, o2) -> o1 == o2 ? 0 : o1 > o2 ? -1 : 1));
        System.out.println(list);

        List<Integer> dest = new ArrayList<>(Collections.nCopies(list.size(), 0));
        Collections.copy(dest, list);
        System.out.println(dest);
    }
}
