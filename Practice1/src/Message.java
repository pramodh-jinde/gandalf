import java.util.Random;
import java.util.UUID;

public abstract class Message {
    String ID;
    float currentPrice;
    float marketTradeVolume;
    float intraDayHighPrice;

    public Message(float currentPrice, float marketTradeVolume, float intraDayHighPrice, double marketCap) {
        this.ID = UUID.randomUUID().toString();
        this.currentPrice = currentPrice;
        this.marketTradeVolume = marketTradeVolume;
        this.intraDayHighPrice = intraDayHighPrice;
        this.marketCap = marketCap;
    }

    double marketCap;



    public String getJsonMessage(){
        //
        return "";
    }
}
