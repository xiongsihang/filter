package com.xsh.chain;

public class SenFilter implements MyFilter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		// 对request的处理
		String requestBody = request.getRequestBody();
		requestBody.replaceAll("敏感", "不敏感");
		requestBody += "SenFilter";
		request.setRequestBody(requestBody);

		//调用下一个filter
		chain.doFilter(request, response, chain);

		// 对response的处理
		String responseBody = response.getResponseBody();
		responseBody += "SenFilter --";
		response.setResponseBody(responseBody);
	}

}
