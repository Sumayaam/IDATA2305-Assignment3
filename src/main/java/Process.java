/**
 * Represents a process in the system.
 */
public class Process {
  int pid;
  int arrivalTime;
  int burstTime;
  int completionTime;
  int turnaroundTime;
  int waitingTime;

  /**
   * Creates a new process.
   *
   * @param pid The process ID
   * @param arrivalTime The arrival time of the process
   * @param burstTime The burst time of the process
   */
    public Process(int pid, int arrivalTime, int burstTime) {
      this.pid = pid;
      this.arrivalTime = arrivalTime;
      this.burstTime = burstTime;
    }

    /**
     * Returns the process ID.
     *
     * @return The process ID
     */
    public int getPid() {
      return pid;
    }

    /**
     * Returns the arrival time of the process.
     *
     * @return The arrival time of the process
     */
    public int getArrivalTime() {
      return arrivalTime;
    }

    /**
     * Returns the burst time of the process.
     *
     * @return The burst time of the process
     */
    public int getBurstTime() {
      return burstTime;
    }

}

