package org.apache.cayenne.di.spi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class loader registry. Used for OSGi environment
 * @author fromano
 *
 */
public class ClassLoaderRegistry {

	private static Object mutex = new Object();
	private static List<ClassLoader> loaders = new ArrayList<ClassLoader>();
	
	public static void registerClassLoader(ClassLoader loader) {
		synchronized (mutex) {
			if (!loaders.contains(loader)) {
				loaders.add(loader);
			}
		}
	}
	
	public static List<ClassLoader> registeredClassLoaders() {
		synchronized (mutex) {
			return Collections.unmodifiableList(loaders);
		}
	}
	
}
