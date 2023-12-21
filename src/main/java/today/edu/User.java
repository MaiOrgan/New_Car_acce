package today.edu;
public class User
{
    public  String userName;
    public  String pass;
    public String birthDate;

    public User(String un, String pa,String bd) {
        // TODO Auto-generated constructor stub
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
    public void setPass(String pass) {
        this.pass = pass;
    }
}
