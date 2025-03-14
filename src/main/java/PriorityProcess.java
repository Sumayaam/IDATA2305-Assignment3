import java.util.*;

/**
 * PriorityProcess class extends Process and represents a process with priority
 */

class PriorityProcess extends Process {
    private int remainingTime;

    public PriorityProcess(int pid, int arrivalTime, int burstTime, int priority) {
        super(pid, arrivalTime, burstTime, priority);
        this.remainingTime = burstTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int time) {
        this.remainingTime = time;
    }

    /**
     * Preemptive Priority Scheduling Algorithm
     * @param processes The list of processes
     */

    public static void run(List<PriorityProcess> processes) {
        int n = processes.size();
        processes.sort(Comparator.comparingInt(Process::getArrivalTime)); // Sort by arrival time

        int currentTime = 0, completed = 0;
        int totalWaitingTime = 0, totalTurnaroundTime = 0;

       // Priority Queue to store processes based on priority comparison.
        // Higher priority runs first

        PriorityQueue<PriorityProcess> queue = new PriorityQueue<>(Comparator.comparingInt(PriorityProcess::getPriority));
        List<PriorityProcess> remainingProcesses = new ArrayList<>(processes);

        System.out.println("\nPreemptive Priority Scheduling Results:");
        System.out.println("PID\tArrival\tBurst\tCompletion\tTurnaround\tWaiting");

        while (completed < n) {
            // Add processes to the queue that have arrived
            for (PriorityProcess p : remainingProcesses) {
                if (p.getArrivalTime() <= currentTime && !queue.contains(p) && p.getRemainingTime() > 0) {
                    queue.add(p);
                }
            }
             // if queue is empty, advance time and continue
            if (!queue.isEmpty()) {
                PriorityProcess currentProcess = queue.poll();
                currentProcess.setRemainingTime(currentProcess.getRemainingTime() - 1);
                currentTime++;
               // if process is finished, calculate times and print
                if (currentProcess.getRemainingTime() == 0) {
                    completed++;
                    int completionTime = currentTime;
                    int turnaroundTime = completionTime - currentProcess.getArrivalTime();
                    int waitingTime = turnaroundTime - currentProcess.getBurstTime();

                    currentProcess.setCompletionTime(completionTime);
                    currentProcess.setTurnaroundTime(turnaroundTime);
                    currentProcess.setWaitingTime(waitingTime);

                    totalWaitingTime += waitingTime;
                    totalTurnaroundTime += turnaroundTime;

                    System.out.println(currentProcess.getPid() + "\t" + currentProcess.getArrivalTime() + "\t" +
                      currentProcess.getBurstTime() + "\t" + completionTime + "\t\t" +
                      turnaroundTime + "\t\t" + waitingTime);
                } else {
                    queue.add(currentProcess); // If not finished, put it back
                }
            } else {
                currentTime++; // If no process is ready, advance time
            }
        }

        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / n);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / n);
    }
}
