public class Automobile {

    private int idNumber;
    private float milesDriven;
    private int month;
    private int day;
    private int year;

    public Automobile(int _idNumber, float _milesDriven, int _month, int _day, int _year) {
        idNumber = _idNumber;
        milesDriven = _milesDriven;
        month = _month;
        day = _day;
        year = _year;
    }

    public int getIdNumber( ) {
        return idNumber;
    }

    public void setIdNumber(int _idNumber) {
        idNumber = _idNumber;
    }

    public float getMilesDriven( ) {
        return milesDriven;
    }

    public void setMilesDriven(float _milesDriven) {
        milesDriven = _milesDriven;
    }

    public String getDate( ) {
        return ""+month+"/"+day+"/"+year;
    }

    public void setDate(int _month, int _day, int _year) {
        month = _month;
        day = _day;
        year = _year;
    }

    public String toString( ) {
        String automobile = idNumber+"\n";
        automobile += milesDriven+"\n";
        automobile += ""+month+"/"+day+"/"+year+"\n";
        return automobile;
    }
}
