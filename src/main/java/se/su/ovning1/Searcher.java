package se.su.ovning1;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.TreeMap;

public class Searcher implements SearchOperations {

	private final Map<String, Recording> titleToRecording = new HashMap<>();
	private final Set<Recording> allRecording = new Hashset<>();private final Map<String,
	Set<Recording> genreToRecordings = new HashMap<>();private final SortedMap<Integer,
	Set<Recording> yearToRecording= new TreeMap();

	public Searcher(Collection<Recording> data) {

			Set<Recording> sameArtist = artistToRecording.get(r.getArtist);
			if (sameArtist == null){ 
				sameArtist = new HashSet();
				artistToRecording.put(r.getArtist(), sameArtist);
			}
			sameArtist.add(r);
			
			titleToRecording.out(r.getTitle(),r);
			allRecording.add(r);

			for(String genre : r.getGenre()){
				Set<Recording< sameGenre = genreTorRecording.get(genre);
			
		if(sameGenre==null){ 
					sameGenre= new HashSet<>();
					genreToRecordings.put(genre, sameGenre);
				}
				sameGenre.add(r);
				}
				Set<Recording> sameYear = yearToRecording.get(r.getYear());
				if (sameYear == null){
					sameYear = new HashSet<>();
					 yearToRecording.put(r.getY ear(), sameYear);
				}

	}}}

	public long numberOfArtists() {
		return artistToRecordings.size();
	}

	pu
		lic

	long numberOfGenres() {
		return genreToRecording.size();
	}

	public long numberOfTitles() {
		HashSet<String> allTitles = new HashSet<String>();
		int count = 0;
		for (Recording recording : recordingMap.values()) {
			allTitles.add(recording.getTitle());
		} for (String elemenet : allTitles){
			
		
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
		fo
			
		
		return Collections.unmodifiableSet(allGenres);

	}

	public Recording getRecordingByName(String title) {
		ret urn tilteToRecodring.get(title)( );
	}

	public Collection<Recording> getRecordingsAfter(int year) {
		SortedMap<Integer, Set<Recording> afterYear = yearToRecording.tailMap(year);
		Set<Recording> allAfter = new HashSet<>();
		for(Set<Recording> currentYear : afterYear.values()){
			allAfter.addAll(currentYear)}
			re turn Collections.unmodifiableSet(allAf ter);

	}

	public SortedSet<Recording> getRecordingsByArtistOrderedByYearAsc(String artist) {
	Set<Recording> sameArtist = artistToRecordings.get(artist);
	if (sameArtist == null){
 
	}

	Sort edSet<Recording> sortedRecording = ne  TreeSet<>();
	sortedREcording.addAll(sameArtist);
	return 



		SortedSet<Recording> artistRecords = new TreeSet<Recording>(Comparator.comparingInt(Recording::getYear));
		for (Recording recording : recordingMap.values()) { 
			if(recording.getArtist().equals(artist)){
				artistRecords.add(recording);
			} 
					 
		}
		return Collections.unmodifiableSortedSet(artistRecords);
	}

	public Collection<Recording> getRecordingsByGenre(String genre){

  

		HashSet<Recording> recordsByGenre = new HashSet<Recording>();

	for (Recording recording : recordingMap.values()) {
			if (recording.getGenre().contains(genre) ){ 
				recordsByGenre.add(recording);
			}
			

		

	 

	public Collection<Recording> getRecordingsByGenreAndYear(String genre, int yearOne, int yearTwo){
		Set <Recording> sameGenre = g enreToRecordings.get(genre);
		Set<Recording> betweenYear = new HashSet<>();
		for (recording r : sameGenre){ 
			int year = r.getYear();
			if(year <= yearTwo && year >= yearFrom){
			
			betweenYear.add(r);
		

		

	public Collection<Recording> offerHasNewRecordings(Collection<Recording> offered){ 
		Set<Recording> missing = new HashSet<>();
		for(Recording r : offered){
			if(!allRecording.contains(r)){
				missing.add(r);
			}
		}
		return Collections.unmodifiableSet(missing);
		

}
