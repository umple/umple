package cruise.factory;

import java.net.URL;
import java.net.URLClassLoader;

import cruise.ui.interfaces.UIGenerator;



public abstract class UIFactory {
	
	

	public static UIFactory instance(String factory) {
		try {
			
			Class factoryClass=Class.forName(factory, true, cruise.writer.UmpleProjectWriter.classLoader);

		//	Class factoryClass=	Class.forName(factory);
			return (UIFactory) factoryClass.newInstance();
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("Couldn't find the Factory class: " + factory);
		} catch (InstantiationException e) {
			throw new RuntimeException("Couldn't create UIFactory:" + factory);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Couldn't create UIFactory:" + factory);
		}
	}

	
	public abstract UIGenerator getUIGenerator();
}
