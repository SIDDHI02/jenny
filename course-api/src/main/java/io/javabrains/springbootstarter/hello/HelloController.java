package io.javabrains.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController //HelloController is spring controller but we want it to be a rest controller so we have to annotate it  

{
	@RequestMapping("/hello")
public String sayHi()
{
	return "hi";
}
}
