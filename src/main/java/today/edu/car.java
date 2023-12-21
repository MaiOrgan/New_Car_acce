package today.edu;

public class Car {
    public String car_name;
    public String categorie;
    public int price;
    public int availab;
    public String descr;

    public Car(String N, String C, int P,int A, String D){
        car_name=N;
        categorie=C;
        price=P;
        availab=A;
        descr=D;
    }
    public Car(){
        car_name="";
        categorie="";
        price=0;
        availab=0;
        descr="";
    }

    public int getPrice() {
        return price;
    }

    public int getAvailab() {
        return availab;
    }

    public String getCar_name() {
        return car_name;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getDescr() {
        return descr;
    }

   public void setAvailab(int availab) {
        this.availab = availab;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
