package com.java.book.app;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Properties;
import org.junit.Test;

/**
* {@link App} のテストプログラム。
 */
public class AppTest {

    private App app = new App();

    /**
     * 2行のプロパティファイルを読み込む。<br>
     * 読み込まれた結果が正しいことを確認する。
     */
    @Test
    public void loadProperties_2行読み込み() {
        // 実行
        Properties properties = app.loadProperties("/book.properties");

        // 検証
        assertThat("book.nameの値", properties.getProperty("book.name"), is("Java本格入門"));
        assertThat("book.publisherの値", properties.getProperty("book.publisher"), is("技術評論社"));
    }

}
