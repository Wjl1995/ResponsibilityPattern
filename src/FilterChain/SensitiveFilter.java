package FilterChain;

import java.util.ArrayList;
import java.util.List;

public class SensitiveFilter implements Filter {

	private String standardWord = "*";
	private List<String> senWordList = new ArrayList<String>();
	
	public void deleteWord(String word)
	{
		if (word != null)
			senWordList.remove(word);
	}
	
	public void addWord(String word)
	{
		if (word != null)
			senWordList.add(word);
	}
	
	public List<String> getSenWordList() {
		return senWordList;
	}

	public void setSenWordList(List<String> senWordList) {
		this.senWordList = senWordList;
	}
	
	@Override
	public void doFilter(InputMsg req, FilterChain chain) {
		// TODO Auto-generated method stub
		if (senWordList.isEmpty())
			return;
		for (String word:senWordList)
		{
			int size = word.length();
			String newWord = "";
			for (int i=0; i<size; i++)
				newWord += standardWord;
			req.setRequest(req.getRequest().replace(word, newWord));
		}
		chain.doFilter(req, chain);
	}

	public String getStandardWord() {
		return standardWord;
	}

	public void setStandardWord(String standardWord) {
		this.standardWord = standardWord;
	}

}
