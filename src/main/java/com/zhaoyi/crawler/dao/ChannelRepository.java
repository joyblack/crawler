package com.zhaoyi.crawler.dao;

import com.zhaoyi.crawler.bean.Channel;
import com.zhaoyi.crawler.bean.Channel;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ChannelRepository {
    // name - channel
    private static Map<String, Channel> channels = new HashMap<>();
    static {
//        try {
//            // load channel info
//            BufferedReader reader = new BufferedReader(new FileReader(ResourceUtils.getFile("classpath:static/channel.txt")));
//            String line = null;
//            int id = 0;
//            while((line = reader.readLine())!=null){
//                String[] words = line.split(" ");
//                channels.put(words[0], new Channel(++id,words[0], words[1]));
//            }
//            // print info
//            System.out.println("now load the channel info:");
//            System.out.println(channels.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public Collection<Channel>  getAll(){
        return channels.values();
    }

    public Channel getChannel(String name){
        return channels.get(name);
    }

}
