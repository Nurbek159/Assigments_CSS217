package ex8;

import java.util.ArrayList;
import java.util.List;

class Stock {
    private String symbol;
    private double price;
    private List<Investor> investors;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        this.investors = new ArrayList<>();
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public void registerInvestor(Investor investor) {
        investors.add(investor);
    }

    public void unregisterInvestor(Investor investor) {
        investors.remove(investor);
    }

    public void updatePrice(double price) {
        this.price = price;
        notifyInvestors();
    }

    private void notifyInvestors() {
        for (Investor investor : investors) {
            investor.update(this, price);
        }
    }
}


class Investor {
    private String name;
    private List<Stock> stocks;

    public Investor(String name) {
        this.name = name;
        this.stocks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
        stock.registerInvestor(this);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
        stock.unregisterInvestor(this);
    }

    public void update(Stock stock, double price) {
        System.out.println("Investor " + name + ": The price of " + stock.getSymbol() + " has changed to " + price);
    }
}

// Main class
public class StockMarket {
    public static void main(String[] args) {

        Stock appleStock = new Stock("AAPL", 120.0);
        Stock googleStock = new Stock("GOOG", 2500.0);

        Investor john = new Investor("John");
        Investor jane = new Investor("Jane");

        john.addStock(appleStock);
        jane.addStock(appleStock);
        jane.addStock(googleStock);

        appleStock.updatePrice(125.0);
        googleStock.updatePrice(2600.0);

        jane.removeStock(appleStock);

        appleStock.updatePrice(130.0);
    }
}
