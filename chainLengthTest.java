import java.text.*;
import java.util.*;

public class chainLengthTest {
    public static void main(String[] args) {
        int success = 0;
        double failure = 0;

        for (int k = 0; k < 100000; k++) {
            Prison myPrison = new Prison(100);

            // myPrison.printListAsMap();
            // System.out.println();

            int grandTotal = 0;
            boolean greaterThan50 = false;
            HashSet<Integer> visited = new HashSet();
            for (int i = 0; i < 100; i++) {
                if (visited.contains(i)) continue;

                // System.out.println();

                // List<Integer> path = new ArrayList();

                if (grandTotal > 50) {
                    break;
                }
                int total = 1;
                int current = i;

                // path.add(current);

                visited.add(current);
                while (myPrison.boxes.get(current) != i) {
                    current = myPrison.boxes.get(current);

                    // path.add(current);

                    visited.add(current);
                    total++;
                }

                // System.out.println(path);
                // System.out.println(path.size());

                if (total > 50) {
                    greaterThan50 = true;
                    break;
                }
                grandTotal += total;
            }

            if (greaterThan50) failure++;
            else success++;
        }

        System.out.println();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Success rate: " + formatter.format(success/(success+failure))); 

    }
}
