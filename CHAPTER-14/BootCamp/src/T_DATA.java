public class T_DATA implements Comparable<T_DATA> {
    String str_val;
    public T_DATA(String args_val) {
        str_val = args_val;
    }

    @Override
    public int compareTo(T_DATA o) {
        return str_val.compareTo(o.str_val);
    }
}
