public class HikingJournal{

  public static void main(String[] args){

    // Sample testing code for HikingLog.java
    HikingLog Annie2020 = new HikingLog();
    Annie2020.addLast("Lake 22", 5.4, 1350, "07/18/2020");
    Annie2020.addLast("Mount Catherine", 3, 1330, "08/01/2020");
    Annie2020.addFirst("Little Si", 3.7, 1300, "07/04/2020");
    Annie2020.displayOldestToLatest();
    Annie2020.displayLatestToOldest();
    Annie2020.add("Gold Creek Pond", 1, 10, "07/19/2020", 1);
    Annie2020.displayOldestToLatest();
    Annie2020.deleteHike("Mount Catherine", "08/01/2020");
    Annie2020.displayOldestToLatest();
    
  }
}
