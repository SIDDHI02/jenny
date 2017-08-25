package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class TopicService 
{

	
@Autowired	
private TopicRepository topicrepository;
	
	
	/*static intialization block which initializes the topic to be*/
/*private List<Topic> topics =new ArrayList<>(Arrays.asList(
		new Topic("SPRING", "SPRING FRAMEWORK", "SPRING FRAMEWORK DECLARATION"),
		new Topic("JAVA", "CORE JAVA", "CORE JAVA DECLARATION"),
		new Topic("JAVASCRIPT", "JAVASCRIPT FRAMEWORK", "JAVASCRIPT FRAMEWORK DECLARATION")));
*/


/*create a method here*/
public List<Topic> getAllTopics()
{
	//return topics;
	List<Topic> topics= new ArrayList();
	topicrepository.findAll()
	.forEach(topics::add);
	return topics;
}




 public Topic getTopic(String id)
 {
 //it takes an string and returns the item from this list that has the topic that matches it.
//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
/*find first is used so that we can get  the very first topic*/
	 /*this is just a way to iterate over list of topics and match the id that 
	  * passed in with that and then just return the topic
	  */
	 
	return topicrepository.findOne(id);
 }
 
 
 
public void addTopic(Topic topic) {
	// TODO Auto-generated method stub
//	topics.add(topic);
	topicrepository.save(topic);
}



public void updateTopic(String id,Topic topic) {
	/*going to use for loop to loop through the list of topics*/
	/*for(int i=0;i<topics.size();i++)
	{
		Topic t=topics.get(i);
		if(t.getId().equals(id))
		{
			topics.set(i, topic);
			return;
		}
	}*/
	
	topicrepository.save(topic);
}
public void deleteTopic(String id) {
	//topics.removeIf(t -> t.getId().equals(id));
	
	topicrepository.delete(id);
	
}
}