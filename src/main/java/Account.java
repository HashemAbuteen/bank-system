import java.util.Date;

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

    public void setBalance( int clientId, double update , Logger logger) {
        this.balance = balance + update;
        if(update>0) {
            Log log = new Log(new Date().toString(), clientId, "client balance updated – deposit", update);
            logger.log(log);
        }
        else if(update < 0){
            Log log = new Log(new Date().toString(), clientId, "client balance updated – withdraw", update);
            logger.log(log);
        }
    }
}
