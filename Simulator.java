import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    
    int size;
    int trials;
    double completeSuccess;
    double total;

    public Simulator(int size, int trials) {
        this.size = size;
        this.trials = trials;
    }

    public void runSimulation() {
        for (int k = 0; k < trials; k++) {

            Prison myPrison = new Prison(size);

            // myPrison.printListAsMap();
            // System.out.println();

            boolean hasFailed = false;

            for (int i = 0; i < size; i++) {

                // List<Integer> path = new ArrayList();
                // path.add(i);

                boolean stop = true;
                int steps = 1;
                int currentBox = i;
                if (myPrison.boxes.get(i) == i) {
                    continue;
                }
                while (steps < size/2) {
                    steps++;
                    currentBox = myPrison.boxes.get(currentBox);

                    // path.add(currentBox);

                    if (currentBox == i) {
                        stop = false;
                        break;
                    }
                }

                // System.out.println(path);
                // System.out.println();

                if (stop) {
                    hasFailed = true;
                    break;
                }
            }

            if (!hasFailed) {
                completeSuccess++;
            }
            total++;
        }
    }

    public static void main(String[] args) {
       
        int numberOfPrisoners = 100;
        int numberOfTrials = 10000;

        Simulator simulation = new Simulator(numberOfPrisoners, numberOfTrials);
        simulation.runSimulation();

        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Success rate: " + formatter.format(simulation.completeSuccess/simulation.total));
    }
}
