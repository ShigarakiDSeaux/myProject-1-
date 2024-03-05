import java.util.Objects;

public class Tablet {
    private int number;
    private String brand;
    private String id;
    private String operational;
    private String charger;
    private String condition;
    private String location;

    public Tablet(){
        this(Integer.MAX_VALUE, "Tablet", "Serial#","Y","Y","Scratched", "Location");
    }

    public Tablet(int number, String brand, String id, String operational, String charger, String condition, String location) {
        if (number < 0) {
            throw new IllegalArgumentException();}
        this.number = number;
        this.brand = brand;
        this.id = id;
        this.operational = operational;
        this.charger = charger;
        this.condition = condition;
        this.location = location;


    }

    public String toString(){
        return  "Tablet Info" + "\n" + "Number: " + number + "\n" +
                "Brand: " + brand + "\n" +
                "ID: " + id + "\n" +
                "Operational: " + operational + "\n" +
                "Charger: " + charger + "\n" +
                "Condition: " + condition + "\n" +
                "Location: " + location +  "\n";

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

    public String getOperational(){
        return operational;
    }

    public String getCharger(){
        return condition;
    }

    public String getCondition(){
        return condition;
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

    public void setOperational(){
        this.operational = operational;
    }

    public void setCharger(){
        this.charger = charger;
    }

    public void setCondition(){
        this.condition = condition;
    }

    public void setLocation() {
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

        Tablet t = (Tablet)o;
        return number == t.number && brand.equals(t.brand) && id.equals(t.id) && operational.equals(t.operational) && charger.equals(t.charger) && condition.equals(t.condition) && location.equals(t.location);


    }

    @Override
    public int hashCode(){
        return Objects.hash("Number:" + number + "Brand:" + brand + "ID:" +  id + "Operational:" + operational + "Charger" + charger + "Location:" + location);
    }







}
