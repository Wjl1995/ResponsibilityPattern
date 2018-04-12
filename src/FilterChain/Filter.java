package FilterChain;

public interface Filter {

	public void doFilter(InputMsg req, FilterChain chain);
	
}
