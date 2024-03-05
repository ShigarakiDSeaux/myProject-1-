import java.util.Objects;

public class Laptop {
    private int number;
    private String brand;
    private String id;
    private String location;




    public Laptop(){
        this(Integer.MAX_VALUE, "Laptop", "Device id", "Location");
    }

    public Laptop(int number, String brand, String id, String location){
        if( number < 0){
             throw new IllegalArgumentException();
        }
        this.number = number;
        this.brand = brand;
        this.id = id;
        this.location = location;
    }

    public String toString(){
        return  "Laptop Info" + "\n" + "Number:" + number +" , " + "Brand:" + brand + " , " + "ID:" + id + " , " + "Location:" + location;

    }

    public int getNumber(){
        return number;
    }

    public String getBrand(){
        return brand;
    }

    public String getId(){
        return id;
    }

    public String getLocation(){
        return location;

    }

    public void setNumber(int number){
        this.number = number;

    }

    public void setBrand(String brand){
        this.brand = brand;

    }

    public void setId(String id){
        this.id  = id;

    }

    public void setLocation(String location){
        this.location = location;

    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || this.getClass() != o.getClass()){
            return false;
        }

        Laptop l = (Laptop) o;
        return number == l.number && brand.equals(l.brand) && id.equals(l.id) && location.equals(l.location);
    }

    @Override
    public int hashCode(){
        return Objects.hash("Number:" + number + "Brand:" + brand + "ID:" +  id + "Location:" + location);
    }







}
