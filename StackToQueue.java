import java.util.LinkedList;
import java.util.Stack;

public class StackToQueue {
    LinkedList <Integer> list = new LinkedList<>();
    Stack <Integer> s = new Stack<>();
    LinkedList <Integer> reverse = new LinkedList<>();

    public LinkedList <Integer> reverse(){

        for (int i = 0; i < list.size(); i++) {
            s.push(list.get(i));
        }

        while(!s.isEmpty()){
            reverse.add(s.pop());


        }
        list = reverse;
        return list;
    }

    public static void main (String args[]){
        StackToQueue q = new StackToQueue();
        q.list.add(4);
        q.list.add(3);
        q.list.add(2);
        q.list.add(1);

        System.out.println("Original " +q.list);

        System.out.println("New Reversed " + q.reverse());
    }




}
