import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void printLinkedListInReverse(MyListNode<Integer> head) {
        Deque<Integer> nodes = new LinkedList<>();
        while (head != null) {
            nodes.addFirst(head.data);
            head = head.next;
        }
        while (!nodes.isEmpty()){
            System.out.println(nodes.poll());
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}