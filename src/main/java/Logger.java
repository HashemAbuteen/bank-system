public class Logger {
    /*
    * hold a DB driver for future use
    */
    private String driverName = "";

    public Logger(String driverName) {
        this.driverName = driverName;
    }
    /*
    * accepts a Log object and stores it in the Log DB
    */
    public static void log(Log log){
        System.out.println(log.toString());
    }

    /*
     *  empty for now
     */
    public Log[] getLogs(){
        return null;
    }


}
