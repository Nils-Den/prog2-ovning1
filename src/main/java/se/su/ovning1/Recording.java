package se.su.ovning1;
import java.util.Collection;
import java.util.Set;
import java.util.Objects;

public class Recording extends Object implements Comparable<Recording>{
	private final int year;
	private final String artist;
	private final String title;
	private final String type;
	private final Set<String> genre;

	public Recording(String title, String artist, int year, String type, Set<String> genre) {
		this.title = title;
		this.year = year;
		this.artist = artist;
		this.type = type;
		this.genre = genre;
	}
	@Override
	public boolean equals(Object other){
		if(this==other){
			return true;
		}
		if (other instanceof Recording){
			Recording recording = (Recording) other;
			return this.title == recording.title && this.artist==recording.artist && this.year==recording.year;
		} else {return false;}
	}
	@Override
	public int hashCode(){
		return Objects.hash(title, artist, year);
	}
	public String getArtist() {
		return artist;
	}
	@Override
	public int compareTo(Recording other){
		if (year > other.year){
			return 1;
		}else if(year < other.year){
			return -1;
		}else if (title.compareTo(other.title) > 0){
			return 1;
		}else if (title.compareTo(other.title) < 0){
			return -1;
		}else if (artist.compareTo(other.artist) > 0){
			return 1;
		}else if (artist.compareTo(other.artist) < 0){
			return -1;
		}else{
			return 0;
		}
	}

	public Collection<String> getGenre() {
		return genre;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return String.format("{ %s | %s | %s | %d | %s }", artist, title, genre, year, type);
	}
}
