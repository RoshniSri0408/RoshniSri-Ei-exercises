import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(float shareMarketPrice);
}

// Subject interface
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
class GoldRate implements Observer {
    private float goldRate;

    @Override
    public void update(float shareMarketPrice) {
        // Simple formula to calculate gold rate based on share market price
        this.goldRate = shareMarketPrice * 2; // Example conversion formula
        display();
    }

    public void display() {
        System.out.println("Updated Gold Rate: " + goldRate);
    }
}
class ShareMarket implements Subject {
    private List<Observer> observers;
    private float shareMarketPrice;

    public ShareMarket() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(shareMarketPrice);
        }
    }

    public void setShareMarketPrice(float shareMarketPrice) {
        this.shareMarketPrice = shareMarketPrice;
        shareMarketPriceChanged();
    }

    private void shareMarketPriceChanged() {
        notifyObservers();
    }
}
public class Main {
    public static void main(String[] args) {
        ShareMarket shareMarket = new ShareMarket();
        GoldRate goldRate = new GoldRate();
        int share;
        shareMarket.registerObserver(goldRate);
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the share market price:");
        share=s.nextInt();
        // Simulate share market price changes
        shareMarket.setShareMarketPrice(share);
    }
}





