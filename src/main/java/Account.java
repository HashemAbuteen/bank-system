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

    public void setBalance( int clientId, double update ) {
        this.balance = balance + update;
        if(update>0) {
            Log log = new Log(new Date().toString(), clientId, "client balance updated – deposit", update);
            Logger.log(log);
        }
        else if(update < 0){
            Log log = new Log(new Date().toString(), clientId, "client balance updated – withdraw", update);
            Logger.log(log);
        }
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Account)obj).getId();
    }
}
