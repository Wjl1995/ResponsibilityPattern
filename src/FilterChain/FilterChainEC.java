package FilterChain;

import java.util.Scanner;

public class FilterChainEC {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// ����������ַ���
		Scanner s = new Scanner(System.in); 
		String msg = s.nextLine(); 
		InputMsg req = new InputMsg();
		req.setRequest(msg);
		// ����������
		FilterChain ch = new FilterChain();
		SensitiveFilter senFilter = new SensitiveFilter();
		senFilter.addWord("ɽկ");
		senFilter.addWord("ˮ��");
		ch.addFilter(senFilter);
		FilterChain ch2 = new FilterChain();
		HTMLFilter htmlFilter = new HTMLFilter();
		htmlFilter.addWord("html");
		ch2.addFilter(htmlFilter);
		ch.addFilter(ch2);
		// ִ�й�����Ϊ
		ch.doFilter(req, ch);
		// ������˺��ַ���
		System.out.println(req.getRequest());
	}
}
