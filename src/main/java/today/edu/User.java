package today.edu;
public class User
{
    private  String userName;
    private  String pass;
    private String birthDate;

    public User(String un, String pa,String bd) {
        userName =un;
        pass=pa;
        birthDate =bd;
    }
    public String getUserName() {
        return userName;
    }
    public String getPass() {
        return pass;
    }
    public String getB(){return birthDate;}
    public void setPass(String pass) {
        this.pass = pass;
    }
}
