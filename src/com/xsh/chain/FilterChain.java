package com.xsh.chain;

import java.util.List;
import java.util.ArrayList;

public class FilterChain implements MyFilter {
	
	private int index = 0;
	
	private List<MyFilter> filters = new ArrayList<>();
	
	public FilterChain addFilter(MyFilter filter) {
		filters.add(filter);
		return this;
	}
	
	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		if(index >= filters.size()) {
			return;
		}
		filters.get(index++).doFilter(request, response, chain);
	}
}
