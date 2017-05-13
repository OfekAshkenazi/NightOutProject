package Objects;

import java.io.Serializable;

/**
 * Created by Ofek on 23-Apr-17.
 */
@SuppressWarnings("serial")
public class Event implements Serializable {
    String type;
    String name;
    String address;
    String publicity;
    int capacity;
    int age;
    int price;
    String desc;

    public Event(){

    }
    public Event(String Type,String Name,String Address,String Publicity,int Capacity,int Age,int Price){
        this.type=Type;
        this.name=Name;
        this.address=Address;
        this.publicity=Publicity;
        this.capacity=Capacity;
        this.age=Age;
        this.price=Price;
        this.desc=" ";
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
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

    public int Age() {
        return this.age;
    }

    public int getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setAge(int Age) {
        this.age = Age;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

