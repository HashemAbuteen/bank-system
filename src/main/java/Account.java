public class Account {
    private int id;
    private double balance;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(long timeStamp, int clientId, double update) {
        this.balance = balance + update;
        if(update>0) {
            Log log = new Log(timeStamp, clientId, "client balance updated – deposit", update);
        }
        else if(update < 0){
            Log log = new Log(timeStamp, clientId, "client balance updated – withdraw", update);
        }
    }
}
