package com.xsh.chain;

public class HTMLFilter implements MyFilter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		//对request的处理
		String requestBody = request.getRequestBody();
		requestBody.replaceAll("<", "[").replaceAll(">", "]");
		requestBody += "HTMLFilter";
		request.setRequestBody(requestBody);
		
		//调用下一个filter
		chain.doFilter(request, response, chain);
		
		//对response的处理
		String responseBody = response.getResponseBody();
		responseBody += "HTMLFilter --";
		response.setResponseBody(responseBody);
	}

}
