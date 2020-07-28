/* This class represents a HikingLog of HikeInfos, similar to a hiking journal!
 * 
 * Uses HikeInfo.java
 */
/* For flexible navigation, the HikingLog is implemented as a Circular Doubly Linked List 
 * where each HikeInfo has a link to both the next and the prev episodes in the list.
 */

import java.util.*;

public class HikingLog
{
   private HikeInfo head;
   private int size;

   public HikingLog()
   {
      head = null;
      size = 0;
   }

   public boolean isEmpty()
   {
     return head == null;
   }

   // Make sure that "size" is updated properly in other methods to
   // always reflect the correct number of HikeInfos in the current Hiking Log
   public int getSize()
   {
     return this.size;
   }

   public void displayOldestToLatest()
   {
     String output = "[BEGIN] ";
     HikeInfo current = head;
     double totalMiles = current.getMiles();
     int totalElevation = current.getElevation();
     while( current.next != head ){
       output += current + " -> ";
       current = current.next;
       totalMiles += current.getMiles();
       totalElevation += current.getElevation();
     }
     output += current + " [END]\n";
     System.out.println(output);
     String totalM = String.format("%.02f", totalMiles); //only show up to 2 decimal places
     System.out.println("Total Miles Hiked: " + totalM + " | Total Elevation Climbed: " + totalElevation);
   }

   public void displayLatestToOldest()
   {
	   if (isEmpty()) {
		   throw new RuntimeException("ERROR: Empty Hiking Log, can't display");
	   }
	   double totalMiles = 0;
	   int totalElevation = 0;
	   String output = "[END] ";
	   if(!isEmpty()) { //only works if Hiking Log isn't empty
	   HikeInfo current = head.prev; //starts at last hike
	   totalMiles = current.getMiles();
	   totalElevation = current.getElevation();
	   while( current != head ){ //uses prev to go through the Hiking Log backwards
	     output += current + " -> ";
	     current = current.prev;
	     totalMiles += current.getMiles();
	       totalElevation += current.getElevation();
	   }
	   output += current;
	     }
	   output += " [BEGIN]\n";
	   System.out.println(output); 
	   String totalM = String.format("%.02f", totalMiles); //only show up to 2 decimal places
	   System.out.println("Total Miles Hiked: " + totalM + " | Total Elevation Climbed: " + totalElevation);
   }

   // Add a new HikeInfo at the beginning of the HikingLog
   public void addFirst(String hikeName, double miles, int elevation, String date) {
	   if (isEmpty()) { //if HikingLog is empty
		   head = new HikeInfo(hikeName, miles, elevation, date, head, head); //create new Episode
		   head.next = head; //create links since previous line of code makes it link to null
		   head.prev = head;
	   } else {
	   HikeInfo current = new HikeInfo(hikeName, miles, elevation, date, head, head.prev); //create new HikeInfo
	   HikeInfo last = head.prev; //the last HikeInfo in HikingLog
	   head.prev = current; //link old head to new head
	   last.next = current; //link last hike to new First hike
	   head = current; //name the new hike to be the head
	   }
	   size++; //increase HikingLog size
   }

   // Add a new HikeInfo at the end of the HikingLog
   public void addLast(String hikeName, double miles, int elevation, String date) {
	   if(isEmpty()) { //if HikingLog is empty, just do addFirst
		  addFirst(hikeName, miles, elevation, date);
	   } else {
		   HikeInfo current = head.prev; //go to last HikeInfo
		   HikeInfo newLast =  new HikeInfo(hikeName, miles, elevation, date, head, current); //creates new last HikeInfo
		   current.next = newLast; //link to new HikeInfo
		   head.prev = newLast;	
		   size++; //increase HikingLog size
   }   
   }

   // Add a new HikeInfo at the given index, assuming that index zero corresponds to the first node
   public void add(String hikeName, double miles, int elevation, String date, int index ) {
	   if (index <= getSize() && index >= 0) { //only works if we can access the index
		   if(index == 0) { //if we want to add to the front, just use addFirst
			   addFirst(hikeName, miles, elevation, date);
		   } else {
	   HikeInfo current = head;
   for (int i = 0; i < index; i++) { //get to the index we want
	   current = current.next;
   }
   HikeInfo previous = current.prev; //get previous HikeInfo
   previous.next = new HikeInfo(hikeName, miles, elevation, date, current, previous); //change the links to point to new HikeInfo
   current.prev = previous.next; 
   size++; //increase size by 1
		   }
	   } else { //error if out of bounds
		   throw new IndexOutOfBoundsException("ERROR: Index out of Bounds");
	   }
   }

   // Delete the Episode that has the given "title"
   // You can assume there will be no duplicate titles in any Playlist
   public void deleteHike(String hikeName, String date) {
	   if(isEmpty()) { //Error if empty HikingLog
		   throw new RuntimeException("ERROR: Empty Hiking Log, can't delete");
		 }
	   //if the only HikeInfo is the one we need to delete
	   if(head.gethikeName().equals(hikeName) && head.getDate().equals(date) && getSize()==1) {
		   head = null;
		   size--; //decrease size
	   } else {
	   //if hikeName is first element
	   if(head.gethikeName().equals(hikeName) && head.getDate().equals(date)) {
		   head = head.next; //new head will be the next one
	   }
	   HikeInfo current = head; 
	   HikeInfo lastEp = head.prev;
   while (current!=lastEp && !current.gethikeName().equals(hikeName) && !current.getDate().equals(date)) { //goes till the last ep or if title matches
  	 current = current.next;
   }
   HikeInfo previous = current.prev;
   if (current==lastEp && !current.gethikeName().equals(hikeName) && !current.getDate().equals(date)) { //Error if HikeInfo doesn't exist
  	 throw new NoSuchElementException("ERROR: Episode Not Found");
   }
   previous.next = current.next; //skip over the one we remove
   previous.next.prev = previous;
   size--; //decrease size
}
   }

} // End of HikingLog class

