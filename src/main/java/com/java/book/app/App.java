package com.java.book.app;

import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Mavenのサンプルプログラム。
 */
public class App {

    /** プロパティファイル */
    private static final String PROPERTY_FILE = "/book.properties";

    /**
     * エントリーポイント。
     */
    public static void main(String... args) {
        App app = new App();
        Properties properties = app.loadProperties(PROPERTY_FILE);
        app.printProperties(properties);
    }

    /**
     * プロパティファイルを読み込む。
     *
     * @param file プロパティファイルのパス
     * @return プロパティオブジェクト
     */
    protected Properties loadProperties(String file) {
        Properties properties = new Properties();
        try (Reader reader = new InputStreamReader(
                App.class.getResourceAsStream(file), StandardCharsets.UTF_8)) {
            properties.load(reader);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }

    /**
     * プロパティファイルの中身を表示する。
     *
     * @param properties プロパティオブジェクト
     */
    protected void printProperties(Properties properties) {
        if (properties != null) {
            Enumeration<?> names = properties.propertyNames();
            while (names.hasMoreElements()) {
                String name = String.valueOf(names.nextElement());
                String value = properties.getProperty(name);
                System.out.println(name + " : " + value);
            }
        }
    }

}
