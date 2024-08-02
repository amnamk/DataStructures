package homework2;

public class Process implements Comparable<Process> {
    String name;
    int priority;
    int burstTime;
    int arrivalTime;
    int remainingTime;
    int finishTime;

    public Process(String name, int priority, int burstTime, int arrivalTime) {
        this.name = name;
        this.priority = priority;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.remainingTime = burstTime;
        this.finishTime = -1;
    }

    @Override
    public int compareTo(Process other) {
        if (this.priority != other.priority) {
            return Integer.compare(this.priority, other.priority);
        }
        return Integer.compare(this.arrivalTime, other.arrivalTime);
    }
}
