package com.xsh.chain;

public interface MyFilter {
	
	void doFilter(Request request, Response response, FilterChain chain);
}
