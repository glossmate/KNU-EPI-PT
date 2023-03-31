import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<T_DATA> t = new TreeSet<>();
        try {
            T_DATA first_element = t.first();
            System.out.println(
                    String.format(
                            "1ST NODE of empty tree is %s",
                            first_element.str_val
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        t.add(new T_DATA("H"));
        t.add(new T_DATA("G"));
        t.add(new T_DATA("L"));
        t.add(new T_DATA("W"));
        t.add(new T_DATA("P"));
        for (Iterator<T_DATA> it = t.iterator(); it.hasNext(); ) {
            T_DATA k = it.next();
            System.out.print(k.str_val + ", ");
        }
        System.out.println();
        for (Iterator<T_DATA> it = t.descendingIterator(); it.hasNext(); ) {
            T_DATA k = it.next();
            System.out.print(k.str_val + ", ");
        }
        System.out.println();
    }
}