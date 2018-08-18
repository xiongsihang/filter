package com.xsh.chain;

public class Main {
	
	public static void main(String[] args) {
		String msg = "大家好,<script>,被就业,敏感,一点都不好看";
		
		FilterChain filterChain = new FilterChain();
		filterChain.addFilter(new HTMLFilter()).addFilter(new SenFilter());
		
		Request request = new Request();
		request.setRequestBody(msg);
		Response response = new Response();
		filterChain.doFilter(request, response, filterChain);
		
		System.out.println("结果:　" + request.getRequestBody());
		System.out.println("结果:　" + response.getResponseBody());
	}
}
