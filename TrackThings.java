public class TrackThings {
    public String getText() {
        return text;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getMaxAccleration() {
        return maxAccleration;
    }

    public double getK_maxSpped() {
        return k_maxSpped;
    }

    public double getK_Acleration() {
        return k_Acleration;
    }

    private String text;
    private int maxSpeed;
    private double maxAccleration;
    private double k_maxSpped;
    private double k_Acleration;
    public TrackThings(String text,int maxSpeed,double maxAccleration,double k_maxSpped,double k_Acleration){
        this.text=text;
        this.maxSpeed=maxSpeed;
        this.maxAccleration=maxAccleration;
        this.k_maxSpped=k_maxSpped;
        this.k_Acleration=k_Acleration;
    }
}
