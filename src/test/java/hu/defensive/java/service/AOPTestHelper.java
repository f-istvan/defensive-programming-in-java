package hu.defensive.java.service;

import hu.defensive.java.aspects.MyGuard;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class AOPTestHelper {

	public static <T> T createAOPProxy(final T target) {
		final AspectJProxyFactory factory = new AspectJProxyFactory(target);
		factory.setProxyTargetClass(true);
		factory.addAspect(new MyGuard());
		return factory.getProxy();
	}

}
