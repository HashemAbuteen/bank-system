import java.util.Date;

public class Client {
    final private String driverName = "";
    private int id;
    private String name;
    private double balance;
    private Account[] accounts = new Account[5];
    private double commissionRate = 0;
    private double intrestRate = 0;
    private Logger logger = new Logger(driverName);

    public Client(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addAccount(Account account){
        for(int i = 0 ; i < accounts.length ; i++){
            if(accounts[i] == null ){
                accounts[i] = account;
            }
        }
    }

    public Account getAccount(int id){
        if(id<accounts.length){
            return accounts[id];
        }
        else {
            return null;
        }
    }

    public void removeAccount(int id){
        if(accounts[id] != null){
            Account account = accounts[id];
            balance += account.getBalance();
            Log log  = new Log(new Date().toString() , this.id , "account update - closed" , account.getBalance() );
            accounts[id] = null;
            logger.log(log);
        }
    }

    public void deposit(double amount){
        balance += amount;
        balance -= commissionRate;
        Log log  = new Log(new Date().toString() , this.id , "client balance update - deposit" , amount - commissionRate );
        logger.log(log);
    }

    public void withdraw(double amount){
        balance -= amount;
        balance -= commissionRate;
        Log log  = new Log(new Date().toString() , this.id , "client balance update - withdraw" , amount + commissionRate );
        logger.log(log);
    }

    public void autoUpdateAccounts(){
        for(int i = 0 ; i < accounts.length ; i++){
            if(accounts[i]!=null){
                Account account = accounts[i];
                double amount = account.getBalance()*intrestRate;
                account.setBalance(this.id , amount, logger );
                Log log  = new Log(new Date().toString() , this.id , "bank auto account interest update" , amount );
                logger.log(log);
            }
        }

    }

    public double getFortune(){
        double fortune = this.balance;
        for(int i = 0 ; i < accounts.length ; i++) {
            if (accounts[i] != null) {
                fortune += accounts[i].getBalance();
            }
        }
        return fortune;
    }


}
