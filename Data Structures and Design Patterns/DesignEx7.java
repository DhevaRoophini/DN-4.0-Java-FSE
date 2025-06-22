import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stock);
}

interface Stock {
    void register(Observer o);

    void deregister(Observer o);

    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockData;

    public void register(Observer o) {
        observers.add(o);
    }

    public void deregister(Observer o) {
        observers.remove(o);
    }

    public void setStockData(String data) {
        this.stockData = data;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockData);
        }
    }
}

class MobileApp implements Observer {
    public void update(String stock) {
        System.out.println("MobileApp: Stock updated - " + stock);
    }
}

public class DesignEx7 {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Observer mob = new MobileApp();
        market.register(mob);
        market.setStockData("AAPL: 150");
    }
}
