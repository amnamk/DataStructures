package homework2;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    public static void scheduleAndRun(ArrayList<Process> processes) {
        int currentTime = 0;
        ProcessQueue processQueue = new ProcessQueue();
        List<Process> allProcesses = new ArrayList<>(processes);
        List<String> output = new ArrayList<>();

        while (!allProcesses.isEmpty() || !processQueue.isEmpty()) {
            for (Process process : new ArrayList<>(allProcesses)) {
                if (process.arrivalTime <= currentTime) {
                    processQueue.addProcess(process);
                    allProcesses.remove(process);
                }
            }

            //runna sljedeci proces u queue
            Process currentProcess = processQueue.runNextProcess();
            if (currentProcess != null) {
                output.add("t = " + " " + currentTime + " " + " " + "| " + currentProcess.name );
                currentProcess.remainingTime--;

                if (currentProcess.remainingTime > 0) {
                    processQueue.addProcess(currentProcess);
                } else {
                    currentProcess.finishTime = currentTime + 1;
                }
            } else {
                output.add("t = " + " " + currentTime + " " +  " " + "| " + "No process ");
            }

            currentTime++;
        }


        for (String line : output) {
            System.out.println(line);
        }


        System.out.println("Total time : " + currentTime);


    }



    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 2, 4, 1));
        processes.add(new Process("P2", 1, 1, 2));
        processes.add(new Process("P3", 3, 2, 8));

        scheduleAndRun(processes);
    }
}

