import java.util.*;
public class ObserverPatternExample {
    interface Observer { void update(String symbol, double price); }
    interface Stock { void register(Observer o); void deregister(Observer o); void notifyAllObservers(); }
    static class StockMarket implements Stock {
        private final List<Observer> observers = new ArrayList<>(); private double price; private String symbol;
        StockMarket(String symbol){ this.symbol=symbol; }
        public void register(Observer o){ observers.add(o); }
        public void deregister(Observer o){ observers.remove(o); }
        public void setPrice(double p){ price=p; notifyAllObservers(); }
        public void notifyAllObservers(){ for(Observer o: observers) o.update(symbol, price); }
    }
    static class MobileApp implements Observer { public void update(String s, double p){ System.out.println("MobileApp: " + s + "="+p); } }
    static class WebApp implements Observer { public void update(String s, double p){ System.out.println("WebApp: " + s + "="+p); } }

    public static void main(String[] args){
        StockMarket sm = new StockMarket("ACME");
        MobileApp m = new MobileApp(); WebApp w = new WebApp();
        sm.register(m); sm.register(w);
        sm.setPrice(123.45);
        sm.setPrice(127.00);
    }
}
