public class Main {
    public static MyListNode<Integer> search(MyListNode<Integer> L, int key) {
        while (L != null && L.data != key) {
            L = L.next;
        }
        return L;
    }
    public static void main(String[] args) {
        MyListNode<Integer> temp = new MyListNode<Integer>();
        temp.data = 3;
        temp.next = null;
        System.out.println("MyListNode<Integer> temp.data : " + temp.data);
    }
}