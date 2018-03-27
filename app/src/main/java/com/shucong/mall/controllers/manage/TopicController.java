package com.shucong.mall.controllers.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.shucong.mall.utils.DataResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shucong.mall.mapper.TopicMapper;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shucong.mall.entity.Topic;
import java.util.Map;

@Controller("ManageTopicController")
@RequestMapping("manage/topic")
public class TopicController {

    private String  menu = "topics";

    @Autowired
    private TopicMapper topicMapper;

    @RequestMapping("")
    String list(Map<String, Object> model) {
        model.put("list", topicMapper.findAll());
        model.put("menu", this.menu);
        return "manage/topic/list";
    }

    @RequestMapping("/add")
    String add(Map<String, Object> model) {
        model.put("menu", this.menu);
        return "manage/topic/add";
    }

    @RequestMapping("/add/post")
    @ResponseBody
    DataResponse addPost(String name,String banner,String slogen) {
        if (name == null || name.trim().length() == 0) {
            return new DataResponse(1000, "name不能为空");
        }
        if (banner == null || banner.trim().length() == 0) {
            return new DataResponse(1000, "banner不能为空");
        }
        if (slogen == null || slogen.trim().length() == 0) {
            return new DataResponse(1000, "slogen不能为空");
        }

        Topic topic = new Topic();
        topic.setName(name);
        topic.setBanner(banner);
        topic.setSlogen(slogen);
        topicMapper.insert(topic);

        return new DataResponse(0, "添加成功");
    }

    @RequestMapping("/update")
    String update(Integer id,Map<String, Object> model) {
        Topic topic = topicMapper.findById(id);
        model.put("menu", this.menu);
        model.put("topic", topic);
        return "manage/topic/update";
    }

    @RequestMapping("/update/post")
    @ResponseBody
    DataResponse updatePost(Integer id,String name,String banner,String slogen) {
        if (name == null || name.trim().length() == 0) {
            return new DataResponse(1000, "name不能为空");
        }
        if (banner == null || banner.trim().length() == 0) {
            return new DataResponse(1000, "banner不能为空");
        }
        if (slogen == null || slogen.trim().length() == 0) {
            return new DataResponse(1000, "slogen不能为空");
        }

        Topic topic = new Topic();
        topic.setId(id);
        topic.setName(name);
        topic.setBanner(banner);
        topic.setSlogen(slogen);
        topicMapper.update(topic);
        return new DataResponse(0, "修改成功");
    }

    @RequestMapping("/delete")
    @ResponseBody
    DataResponse delete(Integer id) {
        try {
            topicMapper.deleteById(id);
            return new DataResponse(0, "删除成功");
        } catch (Exception ex) {
            return new DataResponse(1000, "删除失败：" +ex.getMessage());
        }
    }
}