package se.su.ovning1;

import java.util.*;

public class Searcher implements SearchOperations {

	private static class RecordingYearComparator implements Comparator<Recording> {
		@Override
		public int compare(Recording a, Recording b) {
			return a.getYear() - b.getYear();
		}
	}

	private static Comparator<Recording> RECORDING_BY_YEAR = new RecordingYearComparator();

	private final Map<String, Set<Recording>> artistToRecordings = new HashMap<>();
	private final Map<String, Recording> titleToRecording = new HashMap<>();
	private final Set<Recording> allRecording = new HashSet<>();
	private final Map<String, Set<Recording>> genreToRecordings = new HashMap<>();

	private final SortedMap<Integer, Set<Recording>> yearToRecordings = new TreeMap();

	public Searcher(Collection<Recording> data) {
		for (Recording r : data) {
			Set<Recording> sameArtist = artistToRecordings.get(r.getArtist());
			if (sameArtist == null) {
				sameArtist = new HashSet();
				artistToRecordings.put(r.getArtist(), sameArtist);
			}
			sameArtist.add(r);
			titleToRecording.put(r.getTitle(), r);
			allRecording.add(r);

			for (String genre : r.getGenre()) {
				Set<Recording> sameGenre = genreToRecordings.get(genre);
				if (sameGenre == null) {
					sameGenre = new HashSet<>();
					genreToRecordings.put(genre, sameGenre);
				}
				sameGenre.add(r);
			}
			Set<Recording> sameYear = yearToRecordings.get(r.getYear());
			if (sameYear == null) {
				sameYear = new HashSet<>();
				yearToRecordings.put(r.getYear(), sameYear);
			}
			sameYear.add(r);

		}
	}

	public long numberOfArtists() {
		return artistToRecordings.size();
	}

	public long numberOfGenres() {
		return genreToRecordings.size();
	}

	public long numberOfTitles() {
		return titleToRecording.size();
	}

	public boolean doesArtistExist(String artist) {
		return artistToRecordings.containsKey(artist);
	}

	public Collection<String> getGenres() {
		return Collections.unmodifiableSet(genreToRecordings.keySet());
	}

	public Recording getRecordingByName(String title) {
		return titleToRecording.get(title);
	}

	public Collection<Recording> getRecordingsAfter(int year) {
		SortedMap<Integer, Set<Recording>> afterYear = yearToRecordings.tailMap(year);
		Set<Recording> allAfter = new HashSet<>();
		for(Set<Recording> currentYear : afterYear.values()){
			allAfter.addAll(currentYear);
		}
			return Collections.unmodifiableSet(allAfter);

	}

	public SortedSet<Recording> getRecordingsByArtistOrderedByYearAsc(String artist) {
		Set<Recording> sameArtist = artistToRecordings.get(artist);
		if (sameArtist == null) {
			return Collections.emptySortedSet();
		}
		SortedSet<Recording> sortedRecording = new TreeSet<>(RECORDING_BY_YEAR);
		sortedRecording.addAll(sameArtist);
		return Collections.unmodifiableSortedSet(sortedRecording);

	}

	public Collection<Recording> getRecordingsByGenre(String genre) {
		Set<Recording> sameGenre = genreToRecordings.get(genre);
		if (sameGenre == null) {
			return Collections.emptySet();
		}
		return Collections.unmodifiableSet(sameGenre);

	}

	public Collection<Recording> getRecordingsByGenreAndYear(String genre, int yearFrom, int yearTo) {
		Set<Recording> sameGenre = genreToRecordings.get(genre);
		Set<Recording> betweenYear = new HashSet<>();
		for (Recording r : sameGenre) {
			int year = r.getYear();
			if (year <= yearTo && year >= yearFrom) {
				betweenYear.add(r);
			}
		}
		return Collections.unmodifiableSet(betweenYear);
	}

	public Collection<Recording> offerHasNewRecordings(Collection<Recording> offered){ 
		Set<Recording> missing = new HashSet<>();
		for(Recording r : offered){
			if(!allRecording.contains(r)){
				missing.add(r);
			}
		}
		return Collections.unmodifiableSet(missing);
	}
		

}
