package com.wildwolf.mygank.utils;

import android.util.Log;

import com.wildwolf.mygank.data.BlogData;
import com.wildwolf.mygank.data.GirlItemData;
import com.wildwolf.mygank.data.TestData;
import com.wildwolf.mygank.net.Api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class JsoupUtil {
    /**
     * 解析每一页妹子的数据
     *
     * @param response
     * @return
     */
    public static List<GirlItemData> parseGirls(String response) {
        Document document = Jsoup.parse(response);
        Elements elements = document.select("div[class=img_single] > a");
        List<GirlItemData> list = new ArrayList<>();
        GirlItemData data;
        for (Element element : elements) {
            data = new GirlItemData();
            data.setId(element.attr("href").substring(element.attr("href").lastIndexOf("/") + 1));
            data.setTitle(element.select("img").attr("title"));
            data.setUrl(element.select("img").attr("src"));
            list.add(data);
        }

        return list;
    }

    /**
     * 解析妹子数据的详情
     *
     * @param response
     * @return
     */
    public static List<String> parseGirlDetail(String response) {
        Document document = Jsoup.parse(response);
        Elements elements = document.select("div[class = topic-figure cc] > img");
        List<String> list = new ArrayList<>();
        for (Element element : elements) {
            list.add(element.select("img").attr("src"));
        }

        return list;
    }

    public static List<TestData> parseTest(String a) {

        String s = convertUnicode(a);
        Log.e("TAG - s", s);

        Document document = Jsoup.parse(s);
//        Elements elements = document.select("div.pic");
        Elements elements = document.getElementsByClass("article-list thumbnails");

        Log.e("TAG - elements", elements.toString());

        List<TestData> list = new ArrayList<>();
        TestData data;
        for (Element element : elements) {
            data = new TestData();
            data.setTitle(element.select("a").text());
            data.setId(element.select("a").attr("href"));
            data.setSubtype(element.select("div.a").text());
            data.setUrl(element.select("img").attr("src"));
            list.add(data);
        }

        return list;
    }

    private static String convertUnicode(String utfString) {
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;

        while((i=utfString.indexOf("\\u", pos)) != -1){
            sb.append(utfString.substring(pos, i));
            if(i+5 < utfString.length()){
                pos = i+6;
                sb.append((char)Integer.parseInt(utfString.substring(i+2, i+6), 16));
            }
        }

        return sb.toString();
    }



    public static List<BlogData> parseTest2(String s) {
        Document document = Jsoup.parse(s);
//        Elements elements = document.select("div.pic");
        Elements elements = document.getElementsByClass("article_item");

        Log.e("TAG - elements", elements.toString());

        List<BlogData> list = new ArrayList<>();
        BlogData data;
        for (Element element : elements) {
            data = new BlogData();
            data.setTitle(element.select("h1").text());
            data.setId(element.select("a").attr("href"));
            data.setSubtype(element.select("div.article_manage").text());
            data.setUrl(Api.URL_GET_BLOG + element.select("a").attr("href"));
            list.add(data);
        }

        return list;
    }
}


