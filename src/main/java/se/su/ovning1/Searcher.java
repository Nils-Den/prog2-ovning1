package se.su.ovning1;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;


public class Searcher implements SearchOperations{

	private HashMap<Integer, Recording> recordingMap = new HashMap<Integer, Recording>();
	private HashMap<Integer, Recording> recordingMapp = new HashMap<Integer, Recording>();
	private HashSet<String> recordingSet = new HashSet<String>();
	
	public Searcher(Collection<Recording> data) {
		HashMap<Integer, Recording> allRecordings = new HashMap<>();
		for (Recording recording : data) {
			allRecordings.put(recording.hashCode(), recording);
			
		}
		this.recordingMap = allRecordings; // Collection<Recording> togs bort från original kod
	}


	public long numberOfArtists() {
		HashSet<String> allArtists = new HashSet<String>();
		int count = 0;
		for (Recording recording : recordingMap.values()) {
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
		for (Recording recording : recordingMap.values()) {
			allTitles.add(recording.getTitle());
		} for (String elemenet : allTitles){
			count++;
		}
		return count;
	}

	public boolean doesArtistExist(String artist) {
		HashSet<String> allArtists = new HashSet<String>();
		for (Recording recording : recordingMap.values()) {
			allArtists.add(recording.getArtist());	
		}
			return allArtists.contains(artist);
	}

	public Collection<String> getGenres() {
		HashSet<String> allGenres = new HashSet<String>();
		for (Recording recording : recordingMap.values()) {
			allGenres.addAll(recording.getGenre());
		}
		return Collections.unmodifiableSet(allGenres);

	}

	public Recording getRecordingByName(String title) {
		for (Recording recording : recordingMap.values()) {
			if (recording.getTitle().equals(title)){
				return recording;
			}			
		}
			return null;
	}

	public Collection<Recording> getRecordingsAfter(int yearOne) {
		HashSet<Recording> recordsDuring = new HashSet<Recording>();
		for (Recording recording : recordingMap.values()) {
			if(recording.getYear() >= yearOne){
				recordsDuring.add(recording);
			}
		}
		return Collections.unmodifiableSet(recordsDuring);
	}

	public SortedSet<Recording> getRecordingsByArtistOrderedByYearAsc(String artist) {
		SortedSet<Recording> artistRecords = new TreeSet<Recording>(Comparator.comparingInt(Recording::getYear));
		for (Recording recording : recordingMap.values()) {
			if(recording.getArtist().equals(artist)){
				artistRecords.add(recording);
			}
		}
		return Collections.unmodifiableSortedSet(artistRecords);
		// INTE KLAR
	}

	public Collection<Recording> getRecordingsByGenre(String genre){
		HashSet<Recording> recordsByGenre = new HashSet<Recording>();
		for (Recording recording : recordingMap.values()) {
			if(recording.getGenre().contains(genre) ){
				recordsByGenre.add(recording);
			}
		}
		return Collections.unmodifiableSet(recordsByGenre);
	}

	public Collection<Recording> getRecordingsByGenreAndYear(String genre, int yearOne, int yearTwo){
		HashSet<Recording> recordsByGenreByYear = new HashSet<Recording>();
		for (Recording recording : recordingMap.values()) {
			if(recording.getGenre().contains(genre) && recording.getYear() >= yearOne && recording.getYear() <= yearTwo ){
				recordsByGenreByYear.add(recording);
			}
		}
		return Collections.unmodifiableSet(recordsByGenreByYear);
	}

	public Collection<Recording> offerHasNewRecordings(Collection<Recording> records){ //hette recordings förut
		HashSet<Recording> recordsByOffer = new HashSet<Recording>();
		for (Recording recording : records) {
			if(!recordingMap.values().contains(recording)){
				recordsByOffer.add(recording);
			}			
		}
		return Collections.unmodifiableSet(recordsByOffer);
	}

}
