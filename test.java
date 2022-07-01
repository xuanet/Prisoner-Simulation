public class test {
    public static void main(String[] args) {
        Simulator simulation = new Simulator(100, 1);
        simulation.runSimulation();
        System.out.println(simulation.completeSuccess);
    }
}
