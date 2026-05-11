import java.util.ArrayList;

public class CommSystem {

    private String stationNer;
    private ArrayList<String> log;
    private int signalHvch;
    private boolean offline;

    public CommSystem(String stationNer) {
        this.stationNer = stationNer;
        this.log = new ArrayList<>();
        this.signalHvch = 100;
        this.offline = false;
    }

    public String ilgeeh(String hvleenAvagch, String mesg) {
        if (offline) {
            return "📡 Офлайн!";
        }
        signalHvch -= 5;
        if (signalHvch < 10) {
            offline = true;
        }
        log.add("→ " + hvleenAvagch + ": " + mesg);
        return "Илгээлээ: " + hvleenAvagch;
    }

    public void hvleenAvah(String ilgeegch, String mesg) {
        log.add("← " + ilgeegch + ": " + mesg);
    }

    public void signalSergemjuuleh() {
        signalHvch = 100;
        offline = false;
    }

    public String logHarah(int n) {
        if (log.isEmpty()) {
            return "";
        }
        int take = Math.min(n, log.size());
        int start = log.size() - take;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < log.size(); i++) {
            if (i > start) {
                sb.append('\n');
            }
            sb.append(log.get(i));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        String mode = offline ? "OFFLINE" : "ONLINE";
        return "📡 " + stationNer + " [" + mode + "] Signal: " + signalHvch + "% | Лог: " + log.size() + " мессеж";
    }
}
