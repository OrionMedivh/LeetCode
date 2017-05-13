import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//    Input: numbers are users, characters are contacts. Group users by contacts
//    1- {x,y,z}
//    2-{x}
//    3-{a,b}
//    4-{y, z}
//    5-{b}
//    6-{m}
//    7-{t,b}
//    Output: [1,2,4] [3,5,7], [6] 

// union find

public class MergeContacts {
	public List<List<Integer>> groupContacts(List<List<String>> contact) {
		HashMap<String, Integer> emailToPerson = new HashMap<>();
		HashMap<Integer, Integer> personToRoot = new HashMap<>();
		for (int person = 1; person <= contact.size(); person++) {
			personToRoot.put(person, person);
			int curRoot = person;
			for (String email : contact.get(person)) {
				if (!emailToPerson.containsKey(email)) {
					// if current email hasn't been mapped to a root yet
					emailToPerson.put(email, person);
					continue;
				}
				int newRoot = emailToPerson.get(email);
				// get the root that this email mapped to
				newRoot = findRoot(personToRoot, newRoot);
				// get the oldest root that curr email's root mapped to
				if (newRoot != curRoot) {
					personToRoot.put(curRoot, newRoot);
					curRoot = newRoot;
				}
			}
		}
		HashMap<Integer, List<Integer>> groups = new HashMap<>();
		List<List<Integer>> result = new ArrayList<>();
		for (int person : personToRoot.keySet()) {
			int root = findRoot(personToRoot, person);
			if (!groups.containsKey(root)) {
				groups.put(root, new ArrayList<Integer>());
			}
			groups.get(root).add(person);
		}
		for (int group : groups.keySet()) {
			result.add(groups.get(group));
		}
		return result;
	}

	private int findRoot(HashMap<Integer, Integer> personToRoot, int root) {
		while (personToRoot.get(root) != root) {
			root = personToRoot.get(root);
		}
		return root;
	}
}
