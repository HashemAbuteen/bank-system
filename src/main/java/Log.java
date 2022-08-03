public class Log {

    private long timestamp;
    private int clientId;
    private String description;
    private double amount;

    public Log(long timestamp, int clientId, String description, double amount) {
        this.timestamp = timestamp;
        this.clientId = clientId;
        this.description = description;
        this.amount = amount;
    }

    public String getData(){
        return timestamp + " , client-" +clientId + " , " + description + " , " + amount ;
    }


}
