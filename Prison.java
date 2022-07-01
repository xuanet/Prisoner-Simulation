import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Prison {

    int size;
    ArrayList<Integer> boxes;

    public Prison(int n) {
        size = n;
        boxes = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            boxes.add(i);
        }
        Collections.shuffle(boxes);
    }

    public void printList() {
        System.out.println(boxes);
    }

    public void printListAsMap() {
        HashMap<Integer, Integer> myMap = new HashMap();
        for (int k = 0; k < size; k++) {
            myMap.put(k, boxes.get(k));
        }
        System.out.println(myMap);
        
    }
}