package objects;
import java.util.ArrayList;
import java.util.Calendar;

public class Portfolio {

  private Calendar openDate = Calendar.getInstance();
  private Calendar closeDate = Calendar.getInstance(); 
  private double balance;
  private double networth;
  // composition!
  private ArrayList<Stock> stocks = new ArrayList<>();
  
  public Portfolio(double deposit) {
    this.balance = deposit;
    this.networth = 0.0;
  } // constructor

  //==============>>
  // GETTERS
  public String getOpenDate() {
    return this.openDate.toString();
  }
  public String getCloseDate() {
    return this.closeDate.toString();
  }
  public double getBalance() {
    return this.balance;
  }
  public double getNetworth() {
    // spidey sense if tingling...
    return this.networth;
  }
  public ArrayList<Stock> getStocks() {
    return this.stocks;
  }
  //==============>>
  // SETTERS
  public void setCloseDate() {
    this.closeDate = Calendar.getInstance();
  }
  public void addFunds(double amount) {
    if(amount > 0)
      this.balance += amount;
  } // addFunds()
  
  //=============>>
  // STOCKS
  public void addStock(Stock stock) {
    stocks.add(stock);
  } // addStock

  public void buyStock(Stock stock, int qty, double purchaseAmount) {
    // take the purchaseAmount out of our balance
    this.balance -= purchaseAmount;
    stock.setQty(qty); // sets the quantity
    stocks.add(stock); // appends our new stock
  } // buyStock()

  public void sellStock(int idx) {
    double price = stocks.get(idx).getPrice(); // get stock price
    int qty = stocks.get(idx).getQty(); // get the qty of that stock
    double amount = price * qty; // calc the total amount

    this.addFunds(amount); // adds the money from the stock to our balance
    stocks.remove(idx); // finally remove that stock
  } // sellStock

  public void closeAccount() {
    // TODO Auto-generated method stub
   // Sell all stocks in the portfolio
   for (int i = stocks.size() - 1; i >= 0; i--) {
        sellStock(i);
    }
      // Reset balance and net worth to zero
      balance = 0.0;
      networth = 0.0; 
  } // closeAccount

  public void withdrawFunds(double amount) {
    // TODO Auto-generated method stub
    if (amount <= 0) {
      System.out.println("Invalid withdrawal amount.");
      return;
    }

    if (amount > balance) {
        System.out.println("Insufficient funds.");
        return;
    }

    balance -= amount;
    System.out.printf("Withdrawal of $%.2f successful. New balance: $%.2f\n", amount, balance);
  } // withdrawFunds

} // class