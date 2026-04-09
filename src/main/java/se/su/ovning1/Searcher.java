package se.su.ovning1;
import java.util.Collection;
import java.util.Set;
import java.util.HashMap;
public class Searcher implements SearchOperations{

	private Collection<Recording> recordings = new HashMap<K,V>();

	public Searcher(Collection<Recording> data) {
		this.recordings = data;   //Collection<Recording>  togs bort från original kod
	}


	public long numberOfArtists (){return 0;}

public long numberOfGenres(){return 0;}
public long numberOfTitles();
public boolean doesArtistExist(String artist){return true;}
public Collection<String> getGenres();
public Recording getRecordingByName();  
public Collection<Recording> getRecordingsAfter(int yearOne, int yearTwo);
public Collection<Recording> getRecordingsByArtistOrderedByYearAsc(String artist); 
public Collection<Recording> getRecordingsByGenre(String genre);
public Collection<Recording> getRecordingsByGenreAndYear(String genre, int yearOne, int yearTwo); 
public Collection<Recording> offerHasNewRecordings(Collection<Recording> recordings); 
}

