import java.util.Date;

public class Bank {
    private Client [] clients;
    private Logger logService ;
    private static Bank bank = null;
    private static float totalCommission ;
    /*TODO:  Account updated */


    private Bank() {
        clients = new Client[100];
    }

    public static Bank getBank(){
        if(bank == null){
            bank = new Bank();
        }
        return bank;

    }

    public float getBalance(){
        float balance = 0 ;
        for(Client client : clients){
            if(client!=null) balance+= client.getFortune();
        }
        return  balance;
    }

    public void addClient(Client client){
        for(int i= 0 ; i < clients.length ; i++){
            if(clients[i] == null){
                clients[i] = client;
                Logger.log(new Log(new Date().toString() , client.getId() , "Add client to the bank" , client.getFortune()));
                break;
            }
        }
    }

    public void removeClient(int id){
        for(Client client : clients){
            if(client.getId() == id){
                client = null;
                Logger.log(new Log(new Date().toString() , client.getId() , "Remove client to the bank" , client.getFortune()));
                break;
            }
        }
    }

    public void viewLogs(){
        /*TODO : PRINTS ALL LOGS IN THE LOGGER */
    }

    public void startAccountUpdater(){
        /*TODO : LATER */
    }

    public static void updateTotalCommission(double updatedCommission){
        totalCommission += updatedCommission;
    }

}
