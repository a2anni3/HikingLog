// Class HikeInfo represents an individual hike you've completed
class HikeInfo
{
    private String hikeName; // name of hike
    private double miles; // miles of hike (roundtrip)
    private int elevation; //elevation of hike
    private String date; //date of hike (MM/DD/YYYY)

    public HikeInfo next; // reference to next hike in HikeInfo hiking journal
    public HikeInfo prev; // reference to previous hike in HikeInfo hiking journal

    public HikeInfo(String hikeName, double miles, int elevation, String date, HikeInfo next, HikeInfo prev)
    {
        this.hikeName = hikeName;
        this.miles = miles;
        this.elevation = elevation;
        this.date = date;
        this.next = next;
        this.prev = prev;
    }

    public String gethikeName()
    {
      return this.hikeName;
    }

    public double getMiles()
    {
      return this.miles;
    }
    public int getElevation()
    {
      return this.elevation;
    }
    public String getDate()
    {
      return this.date;
    }
    
    public String toString()
    {
      return "("+ this.hikeName + " | " + this.miles + " MI | " + this.elevation + " FT | " + this.date + ")" ;
    }
 }

