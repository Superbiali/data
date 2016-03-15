package lyl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class wordcount {

	public static void main(String arg[]) {

		Map<String, Integer> map = new HashMap<String, Integer>();// 用于统计各个单词的个数
		String sentence = "Word is case insensitive, i.e. “file”, “FILE” and “File” are considered the same word.";
		sentence = sentence.toLowerCase();
		StringTokenizer token = new StringTokenizer(sentence); // 将字符串分解成一个个的标记

		while (token.hasMoreTokens()) {
			String word = token.nextToken(", “”?.!:\"\"''\n"); // 单词用这些分隔符 分开
			int count;
			if (map.containsKey(word)) // HashMap不允许重复的key，用这个特性，去统计单词的个数
			{
				count = map.get(word);
				map.put(word, count + 1); // 如果已有这个单词则设置它的数量加1
			} else
				map.put(word, 1); // 如果没有这个单词则新填入数量为1
		}
		sort(map); // 调用函数并输出
	}

	public static void sort(Map<String, Integer> map) {
		List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(
				map.entrySet());
		for (int i = 0; i < infoIds.size(); i++) { // 输出
			Entry<String, Integer> id = infoIds.get(i);
			if (id.getKey().length() >= 4) // 字符大于等于4输出
			{
				System.out.println(id.getKey() + ":" + id.getValue());
			}

		}

	}
}
