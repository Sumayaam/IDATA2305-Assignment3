import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CPUScheduling {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Input for Priority Scheduling
    System.out.print("Enter number of processes: ");
    int n = scanner.nextInt();

    List<PriorityProcess> priorityProcesses = new ArrayList<>();

    System.out.println("\nEnter process details one by one:");

    for (int i = 0; i < n; i++) {
      System.out.println("\nProcess " + (i + 1));

      System.out.print("Enter Process ID: ");
      int pid = scanner.nextInt();

      System.out.print("Enter Arrival Time: ");
      int arrivalTime = scanner.nextInt();

      System.out.print("Enter Burst Time: ");
      int burstTime = scanner.nextInt();

      System.out.print("Enter Priority: ");
      int priority = scanner.nextInt();

      priorityProcesses.add(new PriorityProcess(pid, arrivalTime, burstTime, priority));
    }

    // Run Preemptive Priority Scheduling
    PriorityProcess.run(priorityProcesses);

    scanner.close();
  }
}
