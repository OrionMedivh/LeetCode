import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//return top K friends of friends that are not friends, order by number of common friends

public class FriendRecommendation {
	public class Person {
		int id;
		HashSet<Person> friends = new HashSet<>();
	}

	public List<Integer> friendRecommendation(Person person, int k) {
		int max = 0;
		List<Integer> res = new ArrayList<>();
		if (person == null) {
			return res;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (Person friend : person.friends) {
			for (Person recommend : friend.friends) {
				int id = recommend.id;
				if (person.friends.contains(id) || person.id == id) {
					continue; // already exits or it's self
				}
				map.put(id, map.getOrDefault(id, 0) + 1);
				max = Math.max(max, map.get(id)); // get the max frequency
			}
		}
		// bucket sort
		List<List<Integer>> buckets = new ArrayList<>();
		for (int i = 0; i <= max; i++) {
			buckets.add(new ArrayList<Integer>());
		}
		for (int key : map.keySet()) {
			buckets.get(map.get(key)).add(key);
			// add id to its frequency bucket
		}
		for (int i = buckets.size() - 1; i >= 0; i--) {
			for (int j = 0; j < buckets.get(i).size(); j++) {
				res.add(buckets.get(i).get(j));
				if (res.size() == k) {
					return res;
				}
			}
		}
		return res;
	}
}
