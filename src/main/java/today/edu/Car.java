package today.edu;

public class Car {
    public String carName;
    public String categorie;
    public int price;
    public int availab;
    public String descr;

    public Car(String N, String C, int P, int A, String D){
        carName =N;
        categorie=C;
        price=P;
        availab=A;
        descr=D;
    }
    public Car(){
        carName ="";
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

    public String getCarName() {
        return carName;
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
