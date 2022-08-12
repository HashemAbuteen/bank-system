public class GoldClient extends Client{
    private static final double  COMMISION_RATE = 0.2;
    private static final double  INTREST_RATE = 0.003;

    public GoldClient(int id, String name, double balance) {
        super(id, name, balance,COMMISION_RATE,INTREST_RATE);
    }

    @Override
    public String toString() {
        return "GoldClient -" + getId();
    }
}
