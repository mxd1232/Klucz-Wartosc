import java.io.Serializable;
import java.util.Date;

public class Trip implements Serializable {

    //biuro turystyczne

    private static final long serialVersionUID = 1L;

    private String place;
    private int date;
    private double money;

    public Trip(String place, int date, double money) {
        this.place = place;
        this.date = date;
        this.money = money;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString(){
        return "Wycieczka do" + place + " w" + date + "o koszcie " + money;
    }
}
