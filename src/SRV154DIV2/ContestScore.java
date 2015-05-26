
package SRV154DIV2;

import java.util.*;


public class ContestScore {
	
	public void test() {
		String[] data = {};
		
		String[] result = this.sortResults(data);
		for (String line : result) {
			System.out.println(line);
		}
			 
	}
	
	public String[] sortResults(String[] data) {
		List<String> result = new ArrayList<String>();  
		
		if (data == null) {
			return new String[0];
		}
		
		if (data.length == 0) {
			return new String[0];
		}
		
		List<Group> groups = getGroups(data);
		getRankAndScore(groups);
		Collections.sort(groups, new CustomSort());
	
		for (Group g : groups) {
			String line = String.format("%s %d %.01f", g.name, g.rank, g.totalScore);
			result.add(line);
		}
		
		String[] output = new String[groups.size()];
		output = result.toArray(output);
		return output;
	}
	
	private void getRankAndScore(List<Group> groups) {
		int sz = groups.size();
		int scoreSz = groups.get(0).scores.size();
		
		for (int i = 0; i < sz; i++) {
			Group group = groups.get(i);
			for (int j = 0; j < scoreSz; j++) {
				float myScore = group.scores.get(j);
				group.rank += getRank(groups, i, j, myScore);
				group.totalScore += myScore;
			}
		}
	}
	
	private int getRank(List<Group> groups, int groupIdx, int idx, float r) {
		int rank = 1;
		
		for (int i = 0; i < groups.size(); i++) {
			if (groupIdx == i) continue;
			
			if (r < groups.get(i).scores.get(idx)) {
				rank ++;
			}
		}
		
		return rank;
	}
	
	private List<Group> getGroups(String[] data)  {
		List<Group> groups = new ArrayList<Group>();
		
		for (String line: data) {
			Group group = new Group();
			String[] tokens = line.split(" ");
			group.name = tokens[0];
			for (int i = 1; i < tokens.length; i++) {
				group.scores.add(Float.parseFloat(tokens[i]));
			}
			groups.add(group);
		}
		
		return groups;
	}
	
	public class CustomSort implements Comparator<Group> {

		@Override
		public int compare(Group g1, Group g2) {
			int result = Integer.compare(g1.rank, g2.rank);
			if (result == 0) {
				result = Float.compare(g2.totalScore, g1.totalScore);
				if (result == 0) {
					result = g1.name.compareTo(g2.name);
				}
			}
			return result;
		}		
	}

	
	public class Group {
		public String name;
		public ArrayList<Float> scores = new ArrayList<Float>();
		public List<Integer> ranks = new ArrayList<Integer>();
		public int rank = 0;
		public float totalScore = 0.0f;
	}

}

