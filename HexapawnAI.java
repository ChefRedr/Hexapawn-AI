import java.util.HashMap;

public class HexapawnAI {
    private HashMap<Integer, Integer[]> boardConfigurations = new HashMap<Integer, Integer[]>();

    class HexapawnMove {
        int from = 0;
        int to = 0;
        public void setFrom(int from) { this.from = from; }
        public void setTo(int to) { this.to = to; }
    }
}
