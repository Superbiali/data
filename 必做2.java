package lyl;

import java.util.*; 
import java.util.Map.Entry;
import java.io.*; 
public class wordsRate {
	private static BufferedWriter bw;
	private static BufferedReader infile;
	public static void main(String[] args) throws Exception {

		infile = new BufferedReader(new FileReader("E:\\A_Tale_of_Two_Cities.txt"));
		String string;
		String file = null;
		while ((string = infile.readLine()) != null) {
			file += string;
		}
		file = file.toLowerCase();
		file = file.replaceAll("[^A-Za-z]", " ");
		file = file.replaceAll("\\s+", " ");
		String words[];
		words = file.split("\\s+");
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			String key = words[i];
			if (hashMap.get(key) != null) {
				int value = ((Integer) hashMap.get(key)).intValue();
				value++;
				hashMap.put(key, new Integer(value));
			} else {
				hashMap.put(key, new Integer(1));
			}
		}
		Map<String, Object> treeMap = new TreeMap<String, Object>(hashMap);
		new TreeMap<String, Object>(hashMap);
		bw = new BufferedWriter(new FileWriter("result.txt")); 

Iterator<Entry<String, Object>> iter = treeMap.entrySet().iterator(); 
		//定义两个新的数组ss1和ss2，数组长度就是hashMap的长度，里面放分别是hashMap的value和key
		String ss1[]=new String[treeMap.size()];;
		int ss2[]=new int[treeMap.size()];
		int i=0;
		while (iter.hasNext()) { 
		@SuppressWarnings("rawtypes")
		Map.Entry entry = (Map.Entry) iter.next(); 
		int val = (Integer)entry.getValue(); 
		String key =(String) entry.getKey(); 
		ss1[i]=key;
		ss2[i]=val;
		i++;
		} 
		//下面将ss1数组进行排序,并将其与ss2数组的内容相对应起来
		int sValue=0;
		String sKey="";
		for(int j=0;j<ss2.length;j++){
			for(int k=0;k<i;k++){
				if(ss2[j]>ss2[k]){
					sValue=ss2[j];
					sKey=ss1[j];
					ss2[j]=ss2[k];
					ss1[j]=ss1[k];
					ss2[k]=sValue;
					ss1[k]=sKey;
				}
			}
		}
		for(int j=0;j<ss2.length;j++){
			System.out.println(ss1[j]+"="+ss2[j]);
			bw.write(ss1[j]+"="+ss2[j]); 
			bw.newLine(); 
			bw.flush(); 
		}
	}
}
