package com.mycat.micro.view.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Desc:
 * <p/>Date: 2017/4/27
 * <br/>Time: 14:13
 * <br/>User: gaozhiwen
 */
@Component
public class SpringContextUtil
{
	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext()
	{
		return applicationContext;
	}

	@EventListener
	public void setApplicationContext(ContextRefreshedEvent event)
	{
		applicationContext = event.getApplicationContext();
	}

	public static <T> T getBean(Class<T> clazz)
	{
		return applicationContext.getBean(clazz);
	}

	public static Object getBean(String name)
	{
		return applicationContext.getBean(name);
	}
}
