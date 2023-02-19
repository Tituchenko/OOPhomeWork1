import java.util.List;

public class Track {
    private String from;
    private String destanation;

    public TrackThings getThigs() {
        return thigs;
    }

    private TrackThings thigs;

    public double getS() {
        return s;
    }

    private double s;
    public Track ( String from,String destanation,TrackThings thigs,double s){
        this.from=from;
        this.destanation=destanation;
        this.thigs=thigs;
        this.s=s;

    }

    public String getThigsText() {
        return thigs.getText();
    }

    public String getFrom(){
        return this.from;
    }


    public String getDestanation() {
        return destanation;
    }
}
