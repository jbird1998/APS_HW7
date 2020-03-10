import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jacobs_ladder {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int[] rungs = new int[N + 1];
        int k = 0;

        rungs[0] = 0; // though I'm pretty sure that's what the array inits too
        for (int i = 1; i < N + 1; i++) {
            rungs[i] = Integer.parseInt(tokens.nextToken());
        }

        int dist;
        for (int i = N; i > 0; i--) {
            dist = rungs[i] - rungs[i - 1];
            if (dist > k) {
                k = dist;
            } else if (dist == k) {
                k++;
            }
        }

        System.out.println(k);
    }
}
