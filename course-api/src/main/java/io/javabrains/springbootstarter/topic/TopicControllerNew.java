package io.javabrains.springbootstarter.topic;


	

	import java.util.Arrays;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class TopicControllerNew 

	{
		
		
		/*it is not going to create instance everytime because it is acting as singleton it 
		it needs the instance that spring created,, you ask spring for that by creating a 
		private member variable*/
		/*you will declare that dependency using autowired*/
		
		@Autowired           /*is used to inject dependency*/
		private TopicService topicService;/*we need to tell spring to inject it.*/
		
		
		@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();
		

		
	}
		
		
		@RequestMapping("/topics/{id}") //map this method to be called when /topic/id is accessed
		/*how to map id part to this id that is passing to getTopic method*/
		
		public Topic getTopic(@PathVariable String id)  //Going to return only one topic
		{
		/*call a method on a business service and pull up that particular
			topic*/
			/*we don't have that method so we have to implement that first in TopicService.java*/
			return topicService.getTopic(id);
			
		} 
		
		@RequestMapping(method=RequestMethod.POST,value="/topics")
		public void addTopic(@RequestBody Topic topic) {
			
			topicService.addTopic(topic);
		}
		
		
		@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
		public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
			
			topicService.updateTopic(id, topic);
		}
		@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
		public void deleteTopic(@PathVariable String id) {
			
			topicService.deleteTopic(id);
		}
		
	}
	//SPRING MVC WILL CONVERT LIST OF TOPIC OBJECTS TO JSON

