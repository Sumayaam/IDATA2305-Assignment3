import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Implements the First Come First Serve (FCFS) scheduling algorithm.
 */
public class FCFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        List<Process> processes = new ArrayList<>();

        // Taking input for processes
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Process ID, Arrival Time, and Burst Time for Process " + (i + 1) + ": ");
            int pid = scanner.nextInt();
            int arrivalTime = scanner.nextInt();
            int burstTime = scanner.nextInt();
            processes.add(new Process(pid, arrivalTime, burstTime));
        }

        // Sort processes by arrival time (FCFS)
        processes.sort((p1, p2) -> Integer.compare(p1.getArrivalTime(), p2.getArrivalTime()));

        int currentTime = 0, totalWaitingTime = 0, totalTurnaroundTime = 0;

        System.out.println("\nProcess\tArrival\tBurst\tCompletion\tTurnaround\tWaiting");

        for (Process process : processes) {
            if (currentTime < process.getArrivalTime()) {
                currentTime = process.getArrivalTime(); // If CPU is idle, wait for process
            }

            int completionTime = currentTime + process.getBurstTime();
            int turnaroundTime = completionTime - process.getArrivalTime();
            int waitingTime = turnaroundTime - process.getBurstTime();

            totalWaitingTime += waitingTime;
            totalTurnaroundTime += turnaroundTime;
            currentTime = completionTime; // Move current time forward

            System.out.println(process.getPid() + "\t" + process.getArrivalTime() + "\t" + process.getBurstTime() +
                    "\t" + completionTime + "\t\t" + turnaroundTime + "\t\t" + waitingTime);
        }

        // Print Average Waiting Time and Turnaround Time
        System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / n);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / n);
    }
}
