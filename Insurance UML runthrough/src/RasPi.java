import java.util.Objects;

public class RasPi {
    private int number;
    private String type;
    private String sd;
    private String location;
    private String hatComp;


    public RasPi(){
        this(Integer.MAX_VALUE,"pi0","sd","tote","yes");
    }

    public RasPi(int number, String type, String sd, String location, String hatComp){
        if (number < 0){
            throw new IllegalArgumentException();
        }

        this.number = number;
        this.type = type;
        this.sd = sd;
        this.location = location;
        this.hatComp = hatComp;

    }

    public String toString(){
        return "PI info " + "\n" +  "Number: " +  number + "\n" + "Type: " + type + "\n" + "SD Card: " + sd +  "\n" + "Location: " + location + "\n" + "Hat Comp: " + hatComp;
    }

    public int getNumber(){
        return number;
    }

    public String getType(){
        return type;
    }

    public String getSD(){
        return sd;
    }

    public String getLocation(){
        return location;
    }

    public String getHatComp(){
        return hatComp;
    }

    public void setNumber( int number){
        this.number = number;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setSd(String sd){
        this.sd = sd;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void setHatComp(String hatComp){
        this.hatComp = hatComp;
    }
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if(o == null || this.getClass() != o.getClass()){
            return false;
        }
        RasPi r =( RasPi )o;
        return number == r.number && type.equals(r.type) && sd.equals(r.sd) && location.equals(r.location) && hatComp.equals(r.hatComp);
    }

    @Override
    public int hashCode(){
        return Objects.hash("Number: " + number + "Type: "+ type+ "SD: "+ sd+ "Location: " + location + "Hat Comp: " + hatComp);
    }
}
