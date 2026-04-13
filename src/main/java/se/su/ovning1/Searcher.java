package se.su.ovning1;

import java.util.Collection;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Searcher implements SearchOperations{

	private HashMap<Integer, Recording> recordings = new HashMap<Integer, Recording>();

	public Searcher(Collection<Recording> data) {
		HashMap<Integer, Recording> allRecordings = new HashMap<>();
		for (Recording recording : data) {
			allRecordings.put(recording.hashCode(), recording);
		}
		this.recordings = allRecordings; // Collection<Recording> togs bort från original kod
	}

	public long numberOfArtists() {
		HashSet<String> allArtists = new HashSet<String>();
		int count = 0;
		for (Recording recording : recordings.values()) {
			allArtists.add(recording.getArtist());
		} for (String elemenet : allArtists){
			count++;
		}
		return count;
	}

	public long numberOfGenres() {
		Collection<String> allGenres = getGenres();
		long count = 0;
		for(String genre : allGenres){
			count++;
		}
		return count;
	}

	public long numberOfTitles() {
		HashSet<String> allTitles = new HashSet<String>();
		int count = 0;
		for (Recording recording : recordings.values()) {
			allTitles.add(recording.getTitle());
		} for (String elemenet : allTitles){
			count++;
		}
		return count;
	}

	public boolean doesArtistExist(String artist) {
		HashSet<String> allArtists = new HashSet<String>();
		for (Recording recording : recordings.values()) {
			allArtists.add(recording.getArtist());	
		}
			return allArtists.contains(artist);
	}

	public Collection<String> getGenres() {
		HashSet<String> allGenres = new HashSet<String>();
		for (Recording recording : recordings.values()) {
			allGenres.addAll(recording.getGenre());
		}
		return allGenres;

	}

	public Recording getRecordingByName(String title) {
		for (Recording recording : recordings.values()) {
			if (recording.getTitle().equals(title)){
				return recording;
			}			
		}
			return null;
	}

	public Collection<Recording> getRecordingsAfter(int yearOne) {
		HashSet<Recording> recordsDuring = new HashSet<Recording>();
		for (Recording recording : recordings.values()) {
			recordsDuring.add(recording);
		}
		return recordsDuring;
		// INTE KLAR
	}

	public SortedSet<Recording> getRecordingsByArtistOrderedByYearAsc(String artist) {
		SortedSet<Recording> artistRecords = new TreeSet();
		for (Recording recording : recordings.values()) {
			artistRecords.add(recording);
		}
		return artistRecords;
		// INTE KLAR
	}

	public Collection<Recording> getRecordingsByGenre(String genre){
		HashSet<Recording> recordsByGenre = new HashSet<Recording>();
		for (Recording recording : recordings.values()) {
			recordsByGenre.add(recording);
		}
		return recordsByGenre;
		//INTE KLAR
	}

	public Collection<Recording> getRecordingsByGenreAndYear(String genre, int yearOne, int yearTwo){
		HashSet<Recording> recordsByGenreAndYear = new HashSet<Recording>();
		for (Recording recording : recordings.values()) {
			recordsByGenreAndYear.add(recording);
		}
		return recordsByGenreAndYear;
		//INTE KLAR
	}

	public Collection<Recording> offerHasNewRecordings(Collection<Recording> records){ //hette recordings förut
		HashSet<Recording> recordsByGenreAndYear = new HashSet<Recording>();
		for (Recording recording : recordings.values()) {
			recordsByGenreAndYear.add(recording);
		}
		return recordsByGenreAndYear;
		//INTE KLAR
	}

}
