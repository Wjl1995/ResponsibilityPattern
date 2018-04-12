package FilterChain;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

	private List<Filter>list = new ArrayList<Filter>();
	private int index;
	
	public FilterChain addFilter(Filter f)
	{
		list.add(f);
		return this;
	}

	@Override
	public void doFilter(InputMsg req, FilterChain chain) {
		// TODO Auto-generated method stub
		if (index == list.size())
			return;
		Filter f = list.get(index);
		index++;
		f.doFilter(req, chain);
	}
}
