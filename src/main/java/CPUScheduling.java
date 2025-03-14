import java.util.*;

public class CPUScheduling {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter scheduling algorithm (1: FCFS, 2: Preemptive Priority): ");
    int choice = scanner.nextInt();

    System.out.print("Enter the number of processes: ");
    int n = scanner.nextInt();

    List<Process> processes = new ArrayList<>();

    System.out.println("\nEnter process details one by one:");

    for (int i = 0; i < n; i++) {
      System.out.println("\nProcess " + (i + 1));

      System.out.print("Enter Process ID: ");
      int pid = scanner.nextInt();

      System.out.print("Enter Arrival Time: ");
      int arrivalTime = scanner.nextInt();

      System.out.print("Enter Burst Time: ");
      int burstTime = scanner.nextInt();

      if (choice == 2) { // If Preemptive Priority Scheduling
        System.out.print("Enter Priority: ");
        int priority = scanner.nextInt();
        processes.add(new PriorityProcess(pid, arrivalTime, burstTime, priority));
      } else { // FCFS
        processes.add(new FCFS(pid, arrivalTime, burstTime));
      }
    }

    // Execute chosen scheduling algorithm
    if (choice == 2) {
      PriorityProcess.run((List<PriorityProcess>) (List<?>) processes); // Type cast needed
    } else {
      FCFS.run((List<FCFS>) (List<?>) processes); // Type cast needed
    }

    scanner.close();
  }
}
