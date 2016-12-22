package com.company;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by denisizmailov on 22/12/2016.
 */
public class PlaginManager {
    private final String root;

    public PlaginManager(String root) {
        this.root = root;
    }

    public Class<?> loadPlugin(String dirName, String className) {
        URL[] path = null;
        try {
            path = new URL[]{new URL("file://" + root + "/" + dirName)};
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
        PluginLoader pluginLoader = new PluginLoader(path, className);
        try {
            return pluginLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }
}
