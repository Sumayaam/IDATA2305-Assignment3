/**
 * Represents a process in the system.
 */
public class Process {
  private int pid;
  private int arrivalTime;
  private int burstTime;
  private int priority; // Needed for Preemptive Priority Scheduling
  private int completionTime;
  private int turnaroundTime;
  private int waitingTime;

  /**
   * Constructor for First Come First Serve (FCFS)
   *
   * @param pid        The process ID
   * @param arrivalTime The arrival time of the process
   * @param burstTime   The burst time of the process
   */
  public Process(int pid, int arrivalTime, int burstTime) {
    this.pid = pid;
    this.arrivalTime = arrivalTime;
    this.burstTime = burstTime;
    this.priority = -1; // Default value (not used in FCFS)
  }

  /**
   * Constructor for Preemptive Priority Scheduling
   *
   * @param pid        The process ID
   * @param arrivalTime The arrival time of the process
   * @param burstTime   The burst time of the process
   * @param priority    The priority of the process
   */
  public Process(int pid, int arrivalTime, int burstTime, int priority) {
    this.pid = pid;
    this.arrivalTime = arrivalTime;
    this.burstTime = burstTime;
    this.priority = priority;
  }


  public int getPid() {
    return pid;
  }

  public int getArrivalTime() {
    return arrivalTime;
  }

  public int getBurstTime() {
    return burstTime;
  }

  public int getPriority() {
    return priority;
  }

  public int getCompletionTime() {
    return completionTime;
  }

  public void setCompletionTime(int completionTime) {
    this.completionTime = completionTime;
  }

  public int getTurnaroundTime() {
    return turnaroundTime;
  }

  public void setTurnaroundTime(int turnaroundTime) {
    this.turnaroundTime = turnaroundTime;
  }

  public int getWaitingTime() {
    return waitingTime;
  }

  public void setWaitingTime(int waitingTime) {
    this.waitingTime = waitingTime;
  }
}
