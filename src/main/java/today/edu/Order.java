package today.edu;

public class Order {
    private String uname;
    private String cname;
    private String date;

    public Order(String unamee, String cnamee, String datee){
        uname =  unamee;
        cname = cnamee;
        date = datee;
    }
    public String getUname(){return uname;}
    public String getCname(){return cname;}
    public String getDate(){return date;}
}
