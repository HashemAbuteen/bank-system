public class LogTest {

    public static void main(String[] args) {
        testGetData();
    }

    static void testGetData(){
        Log log = new Log("123456",1234,"this is description",123456.123456789);
        System.out.println(log.getData());
    }
}
