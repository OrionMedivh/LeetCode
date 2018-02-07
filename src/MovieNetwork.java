import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MovieNetwork {
	public static class Movie {
		private int movieId;
		private float rating;
		private ArrayList<Movie> similarMovies;

		public Movie(int movieId, float rating) {
			this.movieId = movieId;
			this.rating = rating;
			similarMovies = new ArrayList<>();
		}

		public int getId() {
			return movieId;
		}

		public float getRating() {
			return rating;
		}

		public void addSimilarMovie(Movie movie) {
			similarMovies.add(movie);
		}

		public List<Movie> getSimilarMovies() {
			return similarMovies;
		}
	}

	/*
	 * Implement a function to return top rated movies in the network of movies
	 * reachable from the current movie eg: A(Rating 1.2) / \ B(2.4) C(3.6) \ /
	 * D(4.8) In the above example edges represent similarity and the number is
	 * rating. getMovieRecommendations(A,2) should return C and D (sorting order
	 * doesn't matter so it can also return D and C)
	 * getMovieRecommendations(A,4) should return A, B, C, D (it can also return
	 * these in any order eg: B,C,D,A) getMovieRecommendations(A,1) should
	 * return D. Note distance from A to D doesn't matter, return the highest
	 * rated.
	 * 
	 * @param movie
	 * 
	 * @param numTopRatedSimilarMovies number of movies we want to return
	 * 
	 * @return List of top rated similar movies
	 */

	public static Set<Movie> getMovieRecommendations(Movie movie, int N) {
		Set<Movie> res = new HashSet<>();
		Set<Movie> visited = new HashSet<>();
		PriorityQueue<Movie> pq = new PriorityQueue<>(N,
				(movie1, movie2) -> Float.compare(movie1.getRating(), movie2.getRating()));
		Queue<Movie> q = new LinkedList<>();
		visited.add(movie);
		q.offer(movie);
		while (!q.isEmpty()) {
			Movie cur = q.poll();
			for (Movie similarMovie : cur.getSimilarMovies()) {
				if (visited.contains(similarMovie)) {
					continue;
				}
				q.offer(similarMovie);
				visited.add(similarMovie);
				pq.offer(similarMovie);
				if (pq.size() > N) {
					pq.poll();
				}
			}
		}
		for (Movie m : pq) {
			res.add(m);
		}
		return res;
	}

	public static void main(String[] args) {
		Movie m1 = new Movie(1, 6.2f);
		Movie m2 = new Movie(2, 3.6f);
		Movie m3 = new Movie(3, 2.4f);
		Movie m4 = new Movie(4, 9.8f);
		Movie m5 = new Movie(5, 5.1f);
		Movie m6 = new Movie(6, 8.4f);
		Movie m7 = new Movie(7, 8.4f);
		Movie m8 = new Movie(8, 8.0f);
		m1.addSimilarMovie(m2);
		m1.addSimilarMovie(m3);
		m1.addSimilarMovie(m4);
		m2.addSimilarMovie(m5);
		m2.addSimilarMovie(m1);
		m3.addSimilarMovie(m1);
		m3.addSimilarMovie(m5);
		m4.addSimilarMovie(m6);
		m4.addSimilarMovie(m7);
		m4.addSimilarMovie(m1);
		m5.addSimilarMovie(m2);
		m5.addSimilarMovie(m3);
		m6.addSimilarMovie(m4);
		m7.addSimilarMovie(m6);
		m7.addSimilarMovie(m4);
		m6.addSimilarMovie(m7);
		m7.addSimilarMovie(m8);
		m8.addSimilarMovie(m7);
		// Solution s = new Solution();
		Set<Movie> result = getMovieRecommendations(m4, 5);
		for (Movie m : result) {
			System.out.println(m.getId());
		}
	}
}