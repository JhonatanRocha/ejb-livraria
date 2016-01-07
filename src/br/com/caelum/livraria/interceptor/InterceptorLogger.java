package br.com.caelum.livraria.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class InterceptorLogger {

	@AroundInvoke
	public Object intercept(InvocationContext invocationContext) throws Exception{
		
		long currentTimeMillis = System.currentTimeMillis();

		Object object = invocationContext.proceed();
		
		String nameMethod = invocationContext.getMethod().getName();
		String nameClass = invocationContext.getTarget().getClass().getSimpleName();
		
		System.out.println("Interceptou a classe: " + nameClass + " e chamou o método: " + nameMethod);
		  System.out.println("[INFO] Tempo gasto no acesso ao BD: "
	                + (System.currentTimeMillis() - currentTimeMillis) + "ms");
		
		return object;
	}
}
