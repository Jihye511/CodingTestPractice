import java.io.*;
import java.util.*;
class Main {
	static int n,m;
	static ArrayList<Integer> [] list;
	static float[] ave;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ave = new float[m+1];
		list = new ArrayList[m+1];
		for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
		for(int i =0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
		}
		float max =0;
		for(int i =0; i<=m; i++){
			int sum =0;
			for(int j =0; j<list[i].size(); j++){
				sum += list[i].get(j);
			}
			if(list[i].size() !=0){
				ave[i] = (float)(sum/(float)list[i].size());
				if(max<ave[i]){
					result = i;
					max = ave[i];
				}
			}
			
		}
		System.out.println(result);
	}
}