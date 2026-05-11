import java.util.ArrayList;

public class FoodStation {

    private String ner;
    private ArrayList<String> menu;
    private ArrayList<Integer> uneNuud;
    private int niitOrlogo;

    public FoodStation(String ner) {
        this.ner = ner;
        this.menu = new ArrayList<>();
        this.uneNuud = new ArrayList<>();
        this.niitOrlogo = 0;
    }

    public void tsesNemeh(String hool, int une) {
        menu.add(hool);
        uneNuud.add(une);
    }

    public String zahialga(String hool) {
        int idx = menu.indexOf(hool);
        if (idx == -1) {
            return "❌ Цэсэнд байхгүй";
        }
        niitOrlogo += uneNuud.get(idx);
        return "✅ " + hool + " бэлтгэж байна";
    }

    public String hamgiinHvnstei() {
        if (menu.isEmpty()) {
            return "Цэс хоосон";
        }
        int max = uneNuud.get(0);
        int maxIdx = 0;
        for (int i = 1; i < uneNuud.size(); i++) {
            int u = uneNuud.get(i);
            if (u > max) {
                max = u;
                maxIdx = i;
            }
        }
        return menu.get(maxIdx);
    }

    @Override
    public String toString() {
        return "🍜 " + ner + " | Цэс: " + menu.size() + " хоол | Орлого: " + niitOrlogo + "₮";
    }
}
