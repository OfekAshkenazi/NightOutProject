package Objects;

/**
 * Created by Ofek on 23-Apr-17.
 */

public class Club {
    String name;
    String line;
    String address;
    String publicity;
    int capacity;
    int menAge;
    int woAge;
    int price;
    int rating;
    String desc;

    public Club(){

    }
    public Club(String Name,String Line, String Address,String Publicity,int Capacity,int MenAge,int WoAge,int Price){
        this.name=Name;
        this.line=Line;
        this.address=Address;
        this.publicity=Publicity;
        this.capacity=Capacity;
        this.menAge=MenAge;
        this.woAge=WoAge;
        this.price=Price;
        this.desc="";
        this.rating=0;
    }

    public String getName() {
        return name;
    }

    public String getLine() {
        return line;
    }

    public String getAddress() {
        return address;
    }

    public String getPublicity() {
        return publicity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMenAge() {
        return menAge;
    }

    public int getWoAge() {
        return woAge;
    }

    public int getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public String getDesc() {
        return desc;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPublicity(String publicity) {
        this.publicity = publicity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setMenAge(int menAge) {
        this.menAge = menAge;
    }

    public void setWoAge(int woAge) {
        this.woAge = woAge;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

