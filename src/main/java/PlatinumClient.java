public class PlatinumClient extends Client{
    private static final double  COMMISION_RATE = 0.1;
    private static final double  INTREST_RATE = 0.005;
    public PlatinumClient(int id, String name, double balance) {
        super(id, name, balance,COMMISION_RATE,INTREST_RATE);
    }

    @Override
    public String toString() {
        return "PlatinumClient -" + this.getId();
    }
}
