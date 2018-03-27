package com.shucong.mall.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import com.shucong.mall.utils.DataResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shucong.mall.mapper.TopicMapper;
import org.springframework.web.bind.annotation.RestController;
import com.shucong.mall.entity.Topic;
import java.util.List;

@RestController("ApiTopicController")
@RequestMapping("topic")
public class TopicController {

    @Autowired
    private TopicMapper topicMapper;

    @RequestMapping("list")
    DataResponse list(){
        return new DataResponse(0, "返回成功",topicMapper.findAll());
    }

    @RequestMapping("get")
    DataResponse get(int id){
        return new DataResponse(0, "返回成功",topicMapper.findById(id));
    }

    @RequestMapping("delete")
    DataResponse delete(int id){
        int result = topicMapper.deleteById(id);
        if(result>0) {
            return new DataResponse(0, "删除成功");
        } else {
            return new DataResponse(1, "删除失败");
        }
    }
}