package org.bbl.topics;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


// Our business service layers are Singletons.
@Service
public class TopicService {

    private List<Topic> topics = Arrays.asList(
             new Topic("spring", "Spring-Boot", "Spring Description"),  // we used the Array.asList method to create this list in-line
             new Topic("java", "Core-Java", "Core-Java Description"),  //  and also used the constructor of the topic class to create new topic objects.
             new Topic("python", "Django", "Django Description")
     );

    public List<Topic> getTopics(){return topics;}
    public Topic getTopic(String id) {
        Topic theTopic = null;                      // Using a for-each loop.
        for (Topic element : topics) {
            if (element.getId().contains(id)) {theTopic = element;}}
        return theTopic;}
    public void addTopic(Topic topic) {
        topics.add(topic);
    }
//     --- Using our for loop---

//     int indexToReturn = 0;
//        for(int i =0; i < topics.size(); i++){
//            if (topics.get(i).getId().equals(id)){
//                indexToReturn = i;
//            }
//        }
//        return topics.get(indexToReturn);

//        --- Using Lambda ---
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
}