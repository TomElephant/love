package com.love.loveme.service;


import com.love.loveme.vo.ResultLove;
import org.springframework.stereotype.Service;



/**
 * @author zlx
 * @ClassName LoveService.java
 * @Description TODO
 * @createTime 2021年11月05日 17:00:00
 */
@Service
public interface LoveService {


    ResultLove getMyLove();

    Boolean initLove();

}
