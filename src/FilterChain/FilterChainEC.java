package FilterChain;

import java.util.Scanner;

public class FilterChainEC {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// 出入待过滤字符串
		Scanner s = new Scanner(System.in); 
		String msg = s.nextLine(); 
		InputMsg req = new InputMsg();
		req.setRequest(msg);
		// 构建过滤链
		FilterChain ch = new FilterChain();
		SensitiveFilter senFilter = new SensitiveFilter();
		senFilter.addWord("山寨");
		senFilter.addWord("水货");
		ch.addFilter(senFilter);
		FilterChain ch2 = new FilterChain();
		HTMLFilter htmlFilter = new HTMLFilter();
		htmlFilter.addWord("html");
		ch2.addFilter(htmlFilter);
		ch.addFilter(ch2);
		// 执行过滤行为
		ch.doFilter(req, ch);
		// 输出过滤后字符串
		System.out.println(req.getRequest());
	}
}
