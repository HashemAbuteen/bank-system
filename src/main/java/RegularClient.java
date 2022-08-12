public class RegularClient extends Client{
    private static final double  COMMISION_RATE = 0.3;
    private static final double  INTREST_RATE = 0.001;

    public RegularClient(int id, String name, double balance) {
        super(id, name, balance,COMMISION_RATE,INTREST_RATE);
    }

    @Override
    public String toString() {
        return "RegularClient - " +getId();
    }
}
