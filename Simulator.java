import java.text.*;
import java.util.*;

public class Simulator {
    
    int numPrisoners;
    int numTrials;
    double countSuccess;
    

    public Simulator(int size, int trials) {
        numPrisoners = size;
        numTrials = trials;
    }

    public void runSimulation() {
        int maxBoxOpened = numPrisoners/2;
        Prison myPrison = new Prison(numPrisoners);                 // creating prison (randomized boxes)
        for (int k = 0; k < numTrials; k++) {                       // for each trial

            myPrison.shufflePrison();                               // randomizes prison

            // myPrison.printListAsMap();
            // System.out.println();

            HashSet<Integer> visited = new HashSet();               // stores boxes already opened, will skip over in the for loop
            int totalSuccessfulPrisoners = 0;                       // tracks number of prisoners in verified cycles
            boolean stepsGreaterThanMaxBoxOpened = false;

            for (int i = 0; i < numPrisoners; i++) {
                if (visited.contains(i)) continue;                  // cycle already verified, skip to next prisoner
                if (totalSuccessfulPrisoners > maxBoxOpened) break; 

                // List<Integer> path = new ArrayList();
                // path.add(i);

                int current = i;                                    // prisoner starts by opening box with his number as an index
                int steps = 1;                                      // tracks number of boxes opened by current prisoner 

                while (myPrison.boxes.get(current) != i) {
                    current = myPrison.boxes.get(current);           // next box to be opened
                    visited.add(current);
                    steps++;
                }

                if (steps > maxBoxOpened) {
                    stepsGreaterThanMaxBoxOpened = true;
                    break;
                }

                totalSuccessfulPrisoners += steps;
            }
            if (stepsGreaterThanMaxBoxOpened) continue;
            else countSuccess++;
        }
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

       
        int numberOfPrisoners = 100;
        int numberOfTrials = 100000;

        Simulator simulation = new Simulator(numberOfPrisoners, numberOfTrials);
        simulation.runSimulation();

        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Success rate: " + formatter.format(simulation.countSuccess/simulation.numTrials));
    
        long endTime = System.currentTimeMillis();
        NumberFormat timeFormatter = new DecimalFormat("#0.000");
        System.out.print("\nExecution time is " + timeFormatter.format((endTime - startTime) / 1000d) + " seconds");
    }
}
