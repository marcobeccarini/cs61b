package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    static int MAX_ELEMENTS = 128000;
    static int NUMBEROFOPS = 10000;

    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        for(int N=1000; N <= MAX_ELEMENTS; N= N*2){
            SLList<Integer> List = new SLList<>();
            for (int i=0; i<N; i = i+1)
            {
                List.addLast(i);
            }
            Stopwatch sw = new Stopwatch();
            int opCountsCounter = 0;
            for(int i = 0; i<NUMBEROFOPS; i+=1 ){
                List.getLast();
                opCountsCounter +=1;
            }
            double timeInSeconds = sw.elapsedTime();
            Ns.addLast(List.size());
            times.addLast(timeInSeconds);
            opCounts.addLast(opCountsCounter);
        }

        printTimingTable(Ns, times, opCounts);
    }

}
