package gendermag2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* 
 * TASK
 * Create a generic class Song with 4 instance variables songData1, songData2, songData3 and songData4, 
 * so any data from your table can be used for any data field including the Song ID. 
 * Implement getters, setters, constructors and toString 
 */
public class Song<T, A, D, N>{
	
	//data types
	private T title;
	private A album;
	private D date;
	private N artist;
	
	//constructor 
	public Song(){
		
	}
	public Song(T title,A album, D date, N artist) {
	this.title=title;
	this.album=album;
	this.date=date;
	this.artist=artist;
	}
	//Getter and Setter
	public T getTitle() {
		return title;
	}
	public void setTitle(T title) {
		this.title = title;
	}
	public A getAlbum() {
		return album;
	}
	public void setAlbum(A album) {
		this.album = album;
	}
	public D getDate() {
		return date;
	}
	public void setDate(D date) {
		this.date = date;
	}
	public N getArtist() {
		return artist;
	}
	public void setArtist(N artist) {
		this.artist = artist;
	}
	@Override //ToString
	public String toString() {
		return  "\nTitle: " + title + 
				"\nAlbum: "  + album + 
				"\nDate: " + date + 
				"\nArtist: " + artist;
	}
	//generic method displayAllSongs() parameter a LinkedList of all Songs & will print first 3 songData of all songs in it.
	public static <E> void displayAllSongs(LinkedList<E> print) {
		for (E element:print) {
			//prints out info
			System.out.println(element+"\n");
		}
	}
	
	//Implement 2 readSongs(): First will return an array of Song objects from the .txt file
	public static Song[] readSongs1(String file)throws IOException {
	//Reader
	BufferedReader read = new BufferedReader(new FileReader(file));
	
	//create ArrayList to store song object
	List<Song> arrlist = new ArrayList<Song>();
	
	//create a string array
	String [] data;
	
	//This read each line
	String line = read.readLine();
	
	//While loop that will execute as long as the line variable is not null
    while (line != null) {
    data = line.split(",");
    //create object that holds an array
    Song mysong = new Song(data[0], data[1], data[2], data[3]);
    //adds mysong to the ArrayList
    arrlist.add(mysong);
    line = read.readLine();
    }
	//close file
	read.close();
		return arrlist.toArray(new Song[0]); //return array of song objects
	}
	
	//Second method will return a LinkedList of Song objects from the .txt
	public static LinkedList<Song>readSongs2(String file)throws IOException {
	//Reader
	BufferedReader read = new BufferedReader(new FileReader(file));
		
	//created linkedlist that will hold Song object
	LinkedList<Song> songlist = new LinkedList<Song>();
	
	//This read each line
	String line = read.readLine();
	
	//While loop that will execute as long as the line variable is not null
    while (line != null) {
    String [] data = line.split(",");
    Song mysong = new Song(data[0], data[1], data[2], data[3]);
    songlist.add(mysong);
    line = read.readLine();	
    }
	read.close();
		return songlist;//return Linkedlist of Song objects
	}

	//Implement two searchSongs (): First one will search Songs by their name from unsorted array.
	public static Song[] searchSongs(Song [] arr, String title) {
		//create ArrayList to store song object
		List<Song> arrlist = new ArrayList<Song>();
		for (Song mysong:arr) {
		if (mysong.getTitle().equals(title)) {
		arrlist.add(mysong);
		}
	}
		return arrlist.toArray(new Song[0]);//return array
	}
	//Second one will search Songs by year (first) and then by name (second) from unsorted List
	public static ArrayList<Song> searchSongs (ArrayList<Song>arr, String year, String title) {
		//create ArrayList to store song object
		ArrayList<Song> arrlist = new ArrayList<Song>();
		for (Song mysong:arr) {
		if (mysong.getDate().equals(year)&&mysong.getTitle().equals(title)) {
		arrlist.add(mysong);	
		}
	}
		return arrlist;//return list 
	}
	
	//Implement two SongComparators: First one will compare songs by their name from unsorted array
	public class SongComparators implements Comparator<Song>{
		@Override
		public int compare(Song s1, Song s2) {
	        return ((File) s1.getTitle()).compareTo((File) s2.getTitle());
		}
	}
	//second will compare songs by year (first) and then by their name (second) from unsorted List
	

	

	

	
	/*
 You need to implement only one comparator for it (use comparing, then
Comparing syntax).
	 */
	
	
	//main method
	public static void main(String[] args) {
		
		//testing readSong() method array & LinkedList
		try {
			Song[] songsArray = Song.readSongs1("/Users/marsanto/git/repository2/Cps_2232/src/gendermag2/Songs.txt");
		    for (Song a: songsArray) {
		    	System.out.println(a.toString());
		    }
		    LinkedList<Song> songsList = Song.readSongs2("/Users/marsanto/git/repository2/Cps_2232/src/gendermag2/Songs.txt");
		    for (Song b:songsList) {
		    	System.out.println(b.toString());
		    }
		} catch (IOException e) {
		    System.out.println("Error reading songs file: " + e.getMessage());
	
		}
		//testing 
		LinkedList<Song> songlist = new LinkedList<Song>();
		songlist.add(new Song("Despecha", "MOTOMAMI", "April 1, 2023", "Rosalia"));
		songlist.add(new Song("Adore You", "Fine Line", "January 13, 2023", "Harry Style"));
		songlist.add(new Song("Todo De Ti", "Todo De ti", "January 12, 2023", "Rauw Alejandro"));
		
		//print
		displayAllSongs(songlist);
	
	}
}
