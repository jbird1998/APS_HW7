import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class aps_homework {

    public static void main(String[] args) throws IOException {
        // Read all tokens, convert to Integers, sort by accepted times, run through summations, output
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        int sTime;
        int aTime;
        Problem problem;
        PriorityQueue<Problem> queue = new PriorityQueue<>(10000, new comp());

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(reader.readLine());
            sTime = Integer.parseInt(tokens.nextToken());
            aTime = Integer.parseInt(tokens.nextToken());
            problem = new Problem(sTime, aTime);
            queue.offer(problem);
        }

        int runningStart = 0;
        int maxTime = 0;
        int newTime;
        while (!queue.isEmpty()) {
            problem = queue.poll();
            // System.out.println(problem);
            runningStart += problem.solveTime;
            newTime = runningStart + problem.acceptTime;
            if (newTime > maxTime) {
                maxTime = newTime;
            }
        }

        System.out.println(maxTime);
    }

    static class Problem {
        int solveTime;
        int acceptTime;

        Problem(int s, int a) {
            this.solveTime = s;
            this.acceptTime = a;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder(20);
            builder.append('(');
            builder.append(solveTime);
            builder.append(',');
            builder.append(' ');
            builder.append(acceptTime);
            builder.append(')');
            return builder.toString();
        }
    }

    static class comp implements Comparator<Problem> {

        @Override
        public int compare(Problem p1, Problem p2) {
            if (p1.acceptTime > p2.acceptTime) {
                return -1;
            } else if (p1.acceptTime < p2.acceptTime) {
                return 1;
            }
            return 0;
        }

    }
}
