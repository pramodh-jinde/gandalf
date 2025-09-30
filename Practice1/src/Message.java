import java.util.UUID;

public class Message {
    private String ID;
    private float currentPrice;
    private float marketTradeVolume;
    private float intraDayHighPrice;
    private double marketCap;

    public Message(float currentPrice, float marketTradeVolume, float intraDayHighPrice, double marketCap) {
        this.ID = UUID.randomUUID().toString();
        this.currentPrice = currentPrice;
        this.marketTradeVolume = marketTradeVolume;
        this.intraDayHighPrice = intraDayHighPrice;
        this.marketCap = marketCap;
    }

    public String getID() {
        return ID;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public float getMarketTradeVolume() {
        return marketTradeVolume;
    }

    public float getIntraDayHighPrice() {
        return intraDayHighPrice;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public String getJsonMessage() {
        return String.format(
            "{\"id\":\"%s\",\"currentPrice\":%.2f,\"marketTradeVolume\":%.2f,\"intraDayHighPrice\":%.2f,\"marketCap\":%.2f}",
            ID, currentPrice, marketTradeVolume, intraDayHighPrice, marketCap
        );
    }
    
    @Override
    public String toString() {
        return String.format(
            "BTC Data: Current Price: $%.2f, Volume: %.2f, Day High: $%.2f, Market Cap: $%.2f",
            currentPrice, marketTradeVolume, intraDayHighPrice, marketCap
        );
    }
}
