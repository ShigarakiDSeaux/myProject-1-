import java.util.Objects;
public class Sense {
    private int number;
    private String condition;
    private String location;

    public Sense(){
        this(Integer.MAX_VALUE,"works", "StemFest Tote");
    }

    public Sense(int number, String condition, String location){
        if(number < 0){
            throw new IllegalArgumentException();
        }
        this.number = number;
        this.condition = condition;
        this.location = location;

    }
    public int getNumber(){
        return number;
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

    public void setCondition(String condition){
        this.condition = condition;
    }

    public void setLocation(String location){
        this.location = location;
    }
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if(o == null || this.getClass() != o.getClass()){
            return false;
        }

        Sense s = (Sense) o;
        return number == s.number && condition.equals(s.condition) && location.equals(s.location);
    }

    @Override
    public int hashCode(){
        return Objects.hash("ID: " + number + "Condition: " + condition + "Location: " + location);
    }

}
