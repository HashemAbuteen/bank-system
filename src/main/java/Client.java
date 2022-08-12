import java.util.Date;

public abstract class Client {
    final private String driverName = "";
    private int id;
    private String name;
    private double balance;
    private Account[] accounts = new Account[5];
    final protected double commissionRate = 0;
    final protected double interestRate = 0;
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

    /** no log -- should break after adding -- does the index == clientId ?? **/
    public void addAccount(Account account){
        for(Account acc : accounts){
            if(acc == null){
                acc = account;
                Logger.log( new Log(new Date().toString() , this.id , "account added" , account.getBalance()));
                break;
            }
        }
    }

    public Account getAccount(int id){
        for(Account acc : accounts){
            if(acc != null && acc.getId() == id){
                return acc;
            }

        }
        return null;
    }

    public void removeAccount(Account account){
        for(Account acc : accounts){
            if(acc != null && acc.equals(account)) {
                acc = null;
                balance += acc.getBalance();
                Log log = new Log(new Date().toString(), this.id, "account update - closed", acc.getBalance());
                Logger.log(log);
                break;
            }
        }

    }

    public void deposit(double amount){
        balance += amount;
        double commission = amount*commissionRate;
        balance -= commission;
        Bank.updateTotalCommission(commission);
        Log log  = new Log(new Date().toString() , this.id , "client balance update - deposit" , amount - commission );
        Logger.log(log);
    }

    public void withdraw(double amount){
        balance -= amount;
        double commission = amount*commissionRate;
        balance -= commission;
        Bank.updateTotalCommission(commission);
        Log log  = new Log(new Date().toString() , this.id , "client balance update - withdraw" , amount + commission );
        Logger.log(log);
    }

    public void autoUpdateAccounts(){
        for(int i = 0 ; i < accounts.length ; i++){
            if(accounts[i]!=null){
                Account account = accounts[i];
                double amount = account.getBalance()* interestRate;
                account.setBalance(this.id , amount );
                Log log  = new Log(new Date().toString() , this.id , "bank auto account interest update" , amount );
                Logger.log(log);
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

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Client)obj).getId();
    }
}
