public class CarOnTrack {
    private Car currentCar;
    private double startTime;
    private double richMaxSpeedTime;

    public double getSpeedAtFinish() {
        return speedAtFinish;
    }

    private double speedAtFinish;

    public double getRichMaxSpeedS() {
        if (richMaxSpeedTime==0){
            return 0;
        }
        return richMaxSpeedS;
    }

    private double richMaxSpeedS;
    private Track track;

    public int getMaxSpeed(){
        return (int) currentCar.getMaxVelocity();
    }
    public String getTextThing(){
        return track.getThigsText();
    }

    public String getTrackFromTo() {
        return track.getFrom()+" - "+track.getDestanation();
    }
    public double getS(){
        return track.getS();
    }
    public double getFinishTime() {
        return finishTime;
    }

    private double finishTime;
// Получить ускорение
    private double getA(Car car){
        /*
        чтобы ускорение хоть как то сказывалось домножим его на 60*10
        (как будто 4,2с =4,2*60*10=42 минуты чтобы достичь 100 км/ч)
         */
        return (100*60*60)/ (car.getAccelerat100()*60*10);
    }
    private double getMaxSpeedDestanation(Car car){
        /*
        При V_0=0
        V=a*t
        t=V/a
        s=(a*t^2)/2=(a*(V/a)^2)/2=(V^2/(2*a))
*/
        return Math.pow(car.getMaxVelocity(),2)/(2* getA(car));

    }
    // время для достижения максимальной скорости в секундах
    private double getMaxSpeedTime(Car car){
        /*
        При V_0=0
        V=a*t
        t=V/a
         */
        return car.getMaxVelocity()/getA(car)*60*60;
    }
    //Время для проезда расстояния s в секундах с постоянной скоростью
    private double getTimeToFinishWithConstantV (Car car,double s){
        return s/car.getMaxVelocity()*60*60;
    }
    private double getSpeedAtFinishWithAccelation(Car car,double time){
        return getA(car)*time/(60*60);
    }
    //Время для проезда расстояния s в секундах с ускорением
    private double getTimeToFinishWithAcceleration (Car car,double s){
                /*
        При V_0=0
        V=a*t
        t=V/a
        s=(a*t^2)/2
        t=sqrt((2*s)/a)
*/
        return Math.sqrt((2*s)/ getA(car))*60*60;
    }
    public CarOnTrack (Car car,double startTime,Track track){
        this.track=track;
        this.currentCar=car;
        this.startTime=startTime;
        this.richMaxSpeedS=getMaxSpeedDestanation(car);
        if (this.richMaxSpeedS<=track.getS()){
            this.richMaxSpeedTime=getMaxSpeedTime(car)+startTime;
            this.finishTime=getTimeToFinishWithConstantV(car,track.getS()-this.richMaxSpeedS)+this.richMaxSpeedTime;
            this.speedAtFinish=car.getMaxVelocity();
        } else {
            this.richMaxSpeedTime=0;
            double timeToFinih=getTimeToFinishWithAcceleration(car,track.getS());
            this.finishTime=timeToFinih+startTime;
            this.speedAtFinish=getSpeedAtFinishWithAccelation(car,timeToFinih);

        }
    }
}
