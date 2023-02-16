import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private double money;
    private Car car;
    public List<CarOnTrack> carOnTrackList;
    public User (float money,String name){
        this.money=money;
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setCar (Car car){
        this.car=car;
        this.money-=car.price;
    }
    public Car getCar (Car car){
        return this.car;
    }

    public double getMoney(){
        return this.money;
    }

    public void editMoney (float m){
        this.money+=m;
    }
    private Car getEditedCar (TrackThings things){
        int newMaxSpeed;
        double newMaxAccleration;
        if (things.maxSpeed!=0){
            newMaxSpeed= things.maxSpeed;
        } else {
            newMaxSpeed=(int)this.car.maxVelocity;
        }
        if (things.maxAccleration!=0){
            newMaxAccleration= things.maxAccleration;
        } else {
            newMaxAccleration=this.car.accelerat100;
        }
        return new Car(this.car.model,this.car.year,this.car.price,this.car.color,this.car.power,
                newMaxSpeed* things.k_maxSpped,newMaxAccleration* things.k_Acleration);
    }
public void showCar(){
        car.getInfo();
}
    public void goTrack(List<Track> tracks){
        double startTime=0;
        carOnTrackList=new ArrayList<>();
        for (int i = 0; i < tracks.size(); i++) {
            CarOnTrack cOT=new CarOnTrack(car,startTime,tracks.get(i).s);
            carOnTrackList.add(cOT);
            startTime=cOT.finishTime;
        }

    }

}
