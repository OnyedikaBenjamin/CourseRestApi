package org.bbl.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TopicsController {
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics (){          // Provided we've annotated the class as a rest controller, whatever we return is going to be converted to json and sent back as the http response.
        return topicService.getTopics();
    }
    @RequestMapping("/topics/{id}")        // where id is a variable;
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }
    @RequestMapping(method = RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }


}
