/**
 * Represents a process with priority for preemptive priority scheduling.
 */
public class PriorityProcess extends Process {
    int priority;
    int remainingTime;
    boolean isCompleted;

    public PriorityProcess(int pid, int arrivalTime, int burstTime, int priority) {
        super(pid, arrivalTime, burstTime);
        this.priority = priority;
        this.remainingTime = burstTime;
        this.isCompleted = false;
    }

    public int getPriority() { return priority; }
}
