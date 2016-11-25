package com.wildwolf.mygank.utils;

import android.util.Log;

import com.wildwolf.mygank.data.BlogData;
import com.wildwolf.mygank.data.CSDNData;
import com.wildwolf.mygank.data.CSDNLibData;
import com.wildwolf.mygank.data.GirlItemData;
import com.wildwolf.mygank.data.TestData;
import com.wildwolf.mygank.net.Api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

    public static List<TestData> parseTest(String s) {

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


    public static List<BlogData> parseTest2(String s) {
        Document document = Jsoup.parse(s);
//        Elements elements = document.select("div.pic");
        Elements elements = document.getElementsByClass("article_item");

        List<BlogData> list = new ArrayList<>();
        BlogData data;
        for (Element element : elements) {
            data = new BlogData();
            data.setTitle(element.select("h1").text());

            String href = element.select("a").attr("href");
            href = href.substring(href.indexOf("/"));
            data.setId(href);

            data.setSubtype(element.select("div.article_manage").text());
            data.setUrl(Api.URL_GET_BLOG + element.select("a").attr("href"));
            list.add(data);
        }

        return list;

    }

    public static List<BlogData> parseOtherBlog(String s) {
        Document document = Jsoup.parse(s);
        Elements elements = document.getElementsByClass("clearfix");

        List<BlogData> list = new ArrayList<>();
        BlogData data;
        for (Element element : elements) {
            data = new BlogData();
            data.setTitle(element.select("dd").select("h3.list_c_t").select("a").text());
//            data.setSubtype(element.select("dd").select("p.list_c_c").text().substring(0,15));
            String year = element.select("dt").select("div.date").select("span").text();
            String month = element.select("dt").select("div.date").select("em").text();
            String day = element.select("dt").select("div.date").select("div.date_b").text();

            data.setSubtype(year + "." + NumUtil.ChineseChangeToNumber(month) + "." + day);

            String href = element.select("dd").select("h3.list_c_t").select("a").attr("href");
            href = href.substring(href.indexOf("/"));
            data.setId(href);
            data.setUrl(Api.URL_GET_BLOG + element.select("dd").select("h3.list_c_t").select("a").attr("href"));

            list.add(data);
        }

        return list;
    }

    public static List<CSDNData> parseCSDN(String s) {
        Document document = Jsoup.parse(s);
//        Elements elements = document.select("div.pic");
        Elements elements = document.getElementsByClass("experts_list");

        List<CSDNData> list = new ArrayList<>();
        CSDNData data;
        for (Element element : elements) {
            data = new CSDNData();

            data.setName(element.select("dd").select("a.expert_name").text());
            String href = element.select("dt").select("a").attr("href");

            href = href.substring(href.lastIndexOf("/") + 1);
            data.setHref(href);

            data.setImgUrl(element.select("dt").select("img").attr("src"));
            data.setSubtype(element.select("div.address").text());

            data.setArticleCount(element.select("div.fl").select("b").text());
            data.setReadCount(element.select("div.fr").select("b").text());

            list.add(data);
        }

        return list;
    }

    public static List<CSDNLibData> parseCsdnLib(String s) {
        Document document = Jsoup.parse(s);

        Elements elements = document.getElementsByClass("whitebk");

        Log.e("TAG-e", elements.toString());

        List<CSDNLibData> list = new ArrayList<>();
        CSDNLibData data;
        for (Element element : elements) {
            data = new CSDNLibData();
            data.setHref(element.select("div.divtop").select("a.topphoto").attr("href"));
            data.setImgUrl(element.select("div.divtop").select("div.bannerimg").select("img").attr("src"));  //
            data.setIconUrl(element.select("div.divtop").select("a.topphoto").select("img").attr("src"));  //
            data.setName(element.select("div.divbottoms").select("a.title").text());
            list.add(data);
        }


        return list;
    }
//    public static List<CSDNLibData> parseCsdnLib2(String s) {
//        Document document = Jsoup.parse(s);
//
//        Elements elements2 = document.getElementsByClass("divbottoms");
//        CSDNLibData data ;
//        List<CSDNLibData> list = new ArrayList<>();
//        for (Element element : elements2) {
//            data = new CSDNLibData();
//            data.setName(element.select("a.title").text());
//            list.add(data);
//        }
//
//        return list;
//    }


}


