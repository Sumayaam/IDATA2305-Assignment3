import java.util.*;

/**
 * Implements the Preemptive Priority Scheduling Algorithm.
 */
public class PreemptivePriority {
    public void execute(List<PriorityProcess> processes) {
        int currentTime = 0, completedProcesses = 0;
        int totalWaitingTime = 0, totalTurnaroundTime = 0;

        while (completedProcesses < processes.size()) {
            int highestPriorityIndex = -1;
            int highestPriority = Integer.MAX_VALUE;

            for (int i = 0; i < processes.size(); i++) {
                PriorityProcess process = processes.get(i);
                if (process.arrivalTime <= currentTime && !process.isCompleted && process.getPriority() < highestPriority) {
                    highestPriority = process.getPriority();
                    highestPriorityIndex = i;
                }
            }

            if (highestPriorityIndex == -1) {
                currentTime++; // CPU is idle
            } else {
                PriorityProcess process = processes.get(highestPriorityIndex);
                process.remainingTime--; // Execute for 1 time unit

                if (process.remainingTime == 0) {
                    process.completionTime = currentTime + 1;
                    process.turnaroundTime = process.completionTime - process.arrivalTime;
                    process.waitingTime = process.turnaroundTime - process.burstTime;

                    totalWaitingTime += process.waitingTime;
                    totalTurnaroundTime += process.turnaroundTime;
                    process.isCompleted = true;
                    completedProcesses++;
                }
                currentTime++;
            }
        }

        // Print results
        System.out.println("\nProcess\tArrival\tBurst\tPriority\tCompletion\tTurnaround\tWaiting");
        for (PriorityProcess process : processes) {
            System.out.println(process.getPid() + "\t" + process.getArrivalTime() + "\t" +
                    process.getBurstTime() + "\t" + process.getPriority() + "\t\t" +
                    process.completionTime + "\t\t" + process.turnaroundTime + "\t\t" + process.waitingTime);
        }

        System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / processes.size());
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / processes.size());
    }
}

