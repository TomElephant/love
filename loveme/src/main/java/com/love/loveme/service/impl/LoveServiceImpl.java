package com.love.loveme.service.impl;

import com.love.loveme.service.LoveService;
import com.love.loveme.vo.Lover;
import com.love.loveme.vo.ResultLove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zlx
 * @ClassName LoveServiceImpl.java
 * @Description TODO
 * @createTime 2021年11月05日 17:01:00
 */
@Service
public class LoveServiceImpl implements LoveService {
    @Autowired
    private RedisTemplate redisTemplate;
    private static final String POP_KEY = "redisLove";

    private static volatile List<Map<String,Lover>> TOTAL_LOVER = new CopyOnWriteArrayList<>();


    @Override
    public ResultLove getMyLove() {
        Map<String, Object> resultMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        HashMap<String, Lover> loveMap = new HashMap<>();


        try {
            Long size = redisTemplate.opsForSet().size(POP_KEY);
            if (size<2) {
                list.add("所有人配对完毕");
                resultMap.put("currentLove", list);
                resultMap.put("totalLove", TOTAL_LOVER);
                resultMap.put("type", 0);
                return ResultLove.success(resultMap);
            }
            Lover lover1 = (Lover)redisTemplate.opsForSet().pop(POP_KEY);
            Lover lover2 = (Lover)redisTemplate.opsForSet().pop(POP_KEY);
            list.add(lover1.getName());
            list.add(lover2.getName());
            loveMap.put("lover1", lover1);
            loveMap.put("lover2", lover2);
            TOTAL_LOVER.add(loveMap);

        } catch (Exception e) {
            list.add("所有人配对完毕");
            resultMap.put("currentLove", list);
            resultMap.put("totalLove", TOTAL_LOVER);
            resultMap.put("type", 0);
            return ResultLove.success(resultMap);

        }
        resultMap.put("currentLove", list);
        resultMap.put("totalLove", TOTAL_LOVER);
        resultMap.put("type", 1);

        return ResultLove.success(resultMap);


    }

    @Override
    public Boolean initLove() {
        TOTAL_LOVER.clear();
        String all = "艾登,st,ZZ,aldo,虎哥,轰轰,浩轩,柯柯,pat,楠楠,清水,曼特宁,艾伦,阿阿," +
                "橘猫,柠檬,ETHAN,菩提,楼姐,小灰灰,小夫,心配,渣德,coco,爪爪,梦来,小木,张太,马姐," +
                "夫人,侃,娜娜,映南,阿猫,王阿姨,Marcos,荷包蛋,洋洋,洛奇,润玉,点点";

        String[] splitAll = all.split(",");

        for (int i = 0; i < splitAll.length; i++) {
            Lover lover = new Lover();
            lover.setName(splitAll[i]);
            lover.setAttribute("0");
            redisTemplate.opsForSet().add(POP_KEY,lover);
        }
        return true;



    }
}
