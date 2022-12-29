package org.bbl.topics;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Our business service layers are Singletons.
@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring-Boot", "Spring Description"),  // we used the Array.asList method to create this list in-line
            new Topic("java", "Core-Java", "Core-Java Description"),  //  and also used the constructor of the topic class to create new topic objects.
            new Topic("python", "Django", "Django Description")
    ));
    public List<Topic> getTopics() {
        return topics;
    }
    public Topic getTopic(String id) {
        Topic theTopic = null;                      // Using a for-each loop.
        for (Topic element : topics) {
            if (element.getId().contains(id)) {
                theTopic = element;
            }
        }
        return theTopic;    //--- Using Lambda ---  return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }
    public void addTopic(Topic topic) {
        topics.add(topic);
    }
    public String updateTopic(String id, Topic newTopic) {
       for(int i=0; i < topics.size(); i++) {
           if (topics.get(i).getId().equals(id)){
               topics.set(i, newTopic);}}return "Topic updated successfully";}
    public String deleteTopic(String id) {
        for (int i = 0; i < topics.size(); i++) {        // --- Using Lambda ___ topics.removeIf(t -> t.getId().equals(id));
            if (topics.get(i).getId().equals(id)) {
                topics.remove(i);
            }
        }
        return "Topic deleted successfully";
    }
}