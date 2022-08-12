public class Log {

    private String timestamp;
    private int clientId;
    private String description;
    private double amount;

    public Log(String timestamp, int clientId, String description, double amount) {
        this.timestamp = timestamp;
        this.clientId = clientId;
        this.description = description;
        this.amount = amount;
    }
    @Override
    public String toString(){
        return timestamp + " , client-" +clientId + " , " + description + " , " + amount ;
    }


}
