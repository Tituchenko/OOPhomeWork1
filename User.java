import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private double money;
    private Car car;
    private List<CarOnTrack> carOnTrackList;
    public User (float money,String name){
        this.money=money;
        this.name=name;
    }
    public int getSizeCarOnTrackList(){
        return carOnTrackList.size();
    }
    public double getFinishTime(int i){
        return carOnTrackList.get(i).getFinishTime();
    }
    public String getName(){
        return this.name;
    }
    public void setCar (Car car){
        this.car=car;
        this.money-=car.getPrice();
    }
    public Car getCar (){
        return this.car;
    }

    public double getMoney(){
        return this.money;
    }

    public void editMoney (double m){
        this.money+=m;
    }

    public void showCar(){
        car.getInfo();
    }
    public String getFromTo (int i){
        return carOnTrackList.get(i).getTrackFromTo();
    }
    public String getTextThings (int i){

        return carOnTrackList.get(i).getTextThing();
    }
    public double getMaxSpeedS (int i){
        return carOnTrackList.get(i).getRichMaxSpeedS();
    }
    public int getMaxSpeedOnTrack(int i){
        return carOnTrackList.get(i).getMaxSpeed();
    }
    public int getSpeedOnFish(int i){
        return (int) carOnTrackList.get(i).getSpeedAtFinish();
    }
    public double getS (int i){
        return carOnTrackList.get(i).getS();
    }
    public void goTrack(List<Track> tracks){
        double startTime=0;
        carOnTrackList=new ArrayList<>();
        for (int i = 0; i < tracks.size(); i++) {
            Car curCar=car.getCarOnThings(tracks.get(i).getThigs());
            CarOnTrack cOT=new CarOnTrack(curCar,startTime,tracks.get(i));
            carOnTrackList.add(cOT);
            startTime=cOT.getFinishTime();
        }

    }

}
