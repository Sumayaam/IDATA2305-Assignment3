import java.util.*;

/**
 * FCFS class extends Process and represents a process with First Come First Serve (FCFS) scheduling
 * algorithm
 */
public class FCFS extends Process {

    public FCFS(int pid, int arrivalTime, int burstTime) {
        super(pid, arrivalTime, burstTime);
    }

    /**
     * First Come First Serve (FCFS) Scheduling Algorithm
     * @param processes The list of processes
     */
    public static void run(List<FCFS> processes) {
        // Sort processes by arrival time (FCFS)
        processes.sort(Comparator.comparingInt(Process::getArrivalTime));

        int currentTime = 0, totalWaitingTime = 0, totalTurnaroundTime = 0;
        StringBuilder ganttChart = new StringBuilder("\nGantt Chart:\n|");

        System.out.println("\nFirst Come First Serve (FCFS) Scheduling Results:");
        System.out.println("PID\tArrival\tBurst\tCompletion\tTurnaround\tWaiting");

        for (FCFS process : processes) {
            if (currentTime < process.getArrivalTime()) {
                currentTime = process.getArrivalTime(); // If CPU is ready, move to process arrival time
            }

            int completionTime = currentTime + process.getBurstTime();
            int turnaroundTime = completionTime - process.getArrivalTime();
            int waitingTime = turnaroundTime - process.getBurstTime();

            process.setCompletionTime(completionTime);
            process.setTurnaroundTime(turnaroundTime);
            process.setWaitingTime(waitingTime);

            totalWaitingTime += waitingTime;
            totalTurnaroundTime += turnaroundTime;
            currentTime = completionTime; // Move current time forward

            System.out.println(process.getPid() + "\t" + process.getArrivalTime() + "\t" + process.getBurstTime() +
              "\t" + completionTime + "\t\t" + turnaroundTime + "\t\t" + waitingTime);

            ganttChart.append(" P").append(process.getPid()).append(" |");
        }

        // Print Gantt Chart and Average times
        System.out.println(ganttChart);
        System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / processes.size());
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / processes.size());
    }
}
