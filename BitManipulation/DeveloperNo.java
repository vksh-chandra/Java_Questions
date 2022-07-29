package BitManipulation;
import java.io.*;
import java.util.*;

/*
1. You are given N strings which represents N different skills related to I.T field.
2. You are working on a project and you want to hire a team of software developers for that project.
3. There are N applicants. Every applicant has mentioned his/her skills in resume.
4. You have to select the minimum number of developers such that for every required skill, there is 
     at least one person in the team who has that skill.
5. It is guaranteed that you can form a team which covers all the required skills.

*/

public class DeveloperNo {

	static ArrayList<Integer> sol = new ArrayList<>();

	public static void solution(int[] people, int nskills, int cp, ArrayList<Integer> onesol, int skills) {
		if(cp==people.length){
            //check for all skill s to 11111

		    if(skills== ((1<<nskills)-1)){
		        if(sol.size()==0 || onesol.size() < sol.size()){
		            sol = new ArrayList<>(onesol);
		        }
		    }
		    return;
		}
		
		solution(people, nskills, cp+1, onesol, skills);
		
		onesol.add(cp);
		solution(people, nskills, cp+1, onesol, (skills | people[cp]));
		onesol.remove(onesol.size()-1);
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashMap<String, Integer> smap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			smap.put(scn.next(), i);
		}
		
		int np = scn.nextInt();
		int[] people = new int[np];
		for (int i = 0; i < np; i++) {
			int personSkills = scn.nextInt();
			for (int j = 0; j < personSkills; j++) {
				String skill = scn.next();
				int snum = smap.get(skill);
                //switch on the given skill bit by using or operator.
				people[i] = people[i] | (1 << snum);
			}
		}

		solution(people, n, 0, new ArrayList<>(), 0);
		System.out.println(sol);
        scn.close();
	}
}