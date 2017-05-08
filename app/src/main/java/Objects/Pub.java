package Objects;

/**
 * Created by Ofek on 23-Apr-17.
 */

public class Pub {
    String name;
    String address;
    String visitHours;
    int capacity;
    int age;
    //Image menu;        feature that need to be added.
    int rating;
    String phone;
    String desc;

    public Pub(){

    }
    public Pub(String Name,String Address,int Capacity,int Age,String VisitH){
        this.name=Name;
        this.address=Address;
        this.capacity=Capacity;
        this.age=Age;
        this.visitHours=VisitH;
        //this.menu=null;
        this.desc=" ";
        this.rating=0;
    }

    public String getName() {
        return name;
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

    public String getPhone() {
        return phone;
    }

    /*public Image getMenu() {
        return menu;
    }
*/
    public int getRating() {
        return rating;
    }

    public String getDesc() {
        return desc;
    }

    public String getVisitHours() {
        return visitHours;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

   /* public void setMenu(Image menu) {
        this.menu = menu;
    }
*/
    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setVisitHours(String visitHours) {

    }
}
