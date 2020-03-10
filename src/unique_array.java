import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class unique_array {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int maxArraySize = 1;
        int startIndex = 0;

        HashMap<Integer, Integer> uniqueMap = new HashMap<>();

        int nextInt;
        int hit;
        for (int i = 0; i < N; i++) {
            nextInt = Integer.parseInt(tokens.nextToken());
            hit = uniqueMap.getOrDefault(nextInt, -1);
            if (hit != -1) {
                if (hit >= startIndex) {
                    int currentLength = i - startIndex;
                    if (currentLength > maxArraySize) {
                        maxArraySize = currentLength;
                    }
                    startIndex = hit + 1;
                }
            }
            uniqueMap.put(nextInt, i);
        }
        int potentialMax = N - startIndex;
        if (potentialMax > maxArraySize) {
            maxArraySize = potentialMax;
        }
        System.out.println(maxArraySize);
    }
}
