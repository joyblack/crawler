package com.zhaoyi.crawler.service;

import com.zhaoyi.crawler.dao.ChannelRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import scala.Tuple2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

// 处理爱奇艺的首页
@Service
public class AqyIndexHandlerService {
    @Value("${aiQiYi.indexUrl}")
    private String indexUrl;

    @Autowired
    private ChannelRepository repository;

    // 获取频道信息
    public void getChannel() throws IOException {
        System.out.println(indexUrl);
        Document doc = Jsoup.connect(indexUrl).get();
        // 获取类型容器节点
        Element element = doc.getElementById("block-C");
        // 输出所有类型
        Elements channels = element.select("a");

        HashMap<String, String> map = new HashMap<>();

        BufferedWriter writer = new BufferedWriter(new FileWriter("channel.txt"));
        for (Element channel : channels) {
            try {
                writer.write(channel.text() + " http:" + channel.attr("href")  + "\r\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        writer.flush();
        writer.close();
    }

    // 获取首页电影信息

    /**
     * <a href="//www.iqiyi.com/v_19rr2srld0.html" class="qy-mod-link" title="亡命救赎" target="_blank" rseat="706082_最新上线内容1">
     * <img src="//pic6.iqiyipic.com/image/20190111/3f/e3/v_120486505_m_601_m8_260_360.jpg" class="qy-mod-cover fadeOutIn-enter-active" style="animation-delay: 0.668725s;" rseat="706082_最新上线内容1" data-lazy-id="lazyImageID29">
     * <img src="//pic0.iqiyipic.com/common/20171106/ac/1b/vip_100000_v_601_0_21.png" srcset="//pic0.iqiyipic.com/common/20171106/ac/1b/vip_100000_v_601_0_38.png 2x" </div>
     * </a>
     */
    public void getMovieInfoInChannel(){
        try {
            String url = repository.getChannel("电影").getUrl();
            System.out.println(url);
            Document doc = Jsoup.connect(url).get();
            System.out.println(doc.title());
            Elements elements = doc.select("img");
            for (Element element : elements) {
                Element parent = element.parent();
                if(parent.is("a")){
                    System.out.println("-----------------");
                    System.out.println("The movie info:");
                    System.out.println("Movie title:" + parent.attr("title"));
                    System.out.println("Movie Type:" + parent.attr("rseat"));
                    System.out.println("Movie href:" + parent.attr("href"));
                    System.out.println("Img src:" + element.attr("src"));
                    System.out.println("href");
                }else{
                    System.out.println("not movie img:" + parent.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 获取所有电影列表类型信息
    public void getAllMovieListType(){
        String url = "http://list.iqiyi.com/www/1/----------------iqiyi--.html";
        try {
            Document doc = Jsoup.connect(url).get();

            Elements elements = doc.select("div[class*=mod_sear_list]");
            System.out.println("预期7，总共获取了:" + elements.size());
            // 去除掉第一个和最后一个，一个是channel，一个是以人物为中的类型。
            int size = elements.size() - 1;
            for (int i = 1; i < size; i++) {
                Element smallType = elements.get(i);
                System.out.println(smallType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllMovie(){
        try {
            String url = "https://list.iqiyi.com/www/1/-------------24-[page]-1-iqiyi--.html";
            Integer page = 1;
            Integer total = 30;
            while(page <= 1){
                Document doc = Jsoup.connect(url.replace("[page]", page.toString())).get();
                Elements fatherNode = doc.getElementsByClass("wrapper-piclist");
                System.out.println("wait 1:" + fatherNode.size());
                Elements imgs = fatherNode.select("img");
                for (Element img : imgs) {
                    Element a = img.parent();
                    if(a.is("a")){
                        // movie photo
                        System.out.println("img url:" + img.attr("src"));
                        String title = a.attr("title");
                        System.out.println("movie title is: " + title);
                        System.out.println("movie address: " + a.attr("href"));

                        Document docDetail = Jsoup.connect("https://www.iqiyi.com/v_19rr2srld0.html").get();
                        BufferedWriter writer = new BufferedWriter(new FileWriter("detail.html"));
                        writer.write(docDetail.toString());
                        writer.flush();
                        writer.close();
                    }
                }

                page ++;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void clickIntroduce(){

    }
}
