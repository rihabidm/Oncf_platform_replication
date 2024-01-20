package codes;

public class RedData {
    private String card;
    private String code;
    private int pourcentage;

    public RedData(String card, String code, int pourcentage) {
        this.card = card;
        this.code = code;
        this.pourcentage = pourcentage;
    }

    public String getCard() {
        return card;
    }

    public String getCode() {
        return code;
    }
    public int getPourcentage() {
        return pourcentage;
    }
}