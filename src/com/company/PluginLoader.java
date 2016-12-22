package com.company;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by denisizmailov on 22/12/2016.
 */
public class PluginLoader extends URLClassLoader {
    private String className;

    public PluginLoader(URL[] urls, String className) {
        super(urls);
        this.className = className;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals(className)) {
            Class<?> c = findClass(name);
            return c;
        }
        return super.loadClass(name);
    }
}
