package Objects;

/**
 * Created by Ofek on 23-Apr-17.
 */

public class Club {
    String name;
    String line;
    String address;
    int capacity;
    int age;
    int price;
    int rating;
    String desc;

    public Club(){

    }
    public Club(String Name,String Line, String Address,int Capacity,int Age,int Price){
        this.name=Name;
        this.line=Line;
        this.address=Address;
        this.capacity=Capacity;
        this.age=Age;
        this.price=Price;
        this.desc=" ";
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


    public int getCapacity() {
        return capacity;
    }

    public int getAge() {
        return age;
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

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setAge(int age) {
        this.age = age;
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

