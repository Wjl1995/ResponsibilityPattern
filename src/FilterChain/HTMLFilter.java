package FilterChain;

import java.util.ArrayList;
import java.util.List;

public class HTMLFilter implements Filter {

	private String standarHTML = "HTML";
	private List<String> wrongHTMLList = new ArrayList<String>();
	
	@Override
	public void doFilter(InputMsg req, FilterChain chain) {
		// TODO Auto-generated method stub
		if (wrongHTMLList.isEmpty())
			return;
		for (String word:wrongHTMLList)
		{
			req.setRequest(req.getRequest().replace(word, standarHTML));
		}
		chain.doFilter(req, chain);
	}

	public String getStandarHTML() {
		return standarHTML;
	}

	public void setStandarHTML(String standarHTML) {
		this.standarHTML = standarHTML;
	}


	public List<String> getWrongHTMLList() {
		return wrongHTMLList;
	}


	public void setWrongHTMLList(List<String> wrongHTMLList) {
		this.wrongHTMLList = wrongHTMLList;
	}
	
	public void deleteWord(String word)
	{
		if (word != null)
			wrongHTMLList.remove(word);
	}
	
	public void addWord(String word)
	{
		if (word != null)
			wrongHTMLList.add(word);
	}

}
