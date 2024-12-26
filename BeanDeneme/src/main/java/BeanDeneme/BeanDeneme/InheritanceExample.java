package BeanDeneme.BeanDeneme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class InheritanceExample {
	public static void main(String[] args) {
		SpringApplication.run(InheritanceExample.class, args);
		ApplicationContext context=new ClassPathXmlApplicationContext("inheritanceBeans.xml");
		Parent parent=(Parent) context.getBean("parentBean");
		System.out.println("parent:"+parent);
		
		Child child1=(Child) context.getBean("child1");
		System.out.println("child1:"+child1);
		
		Child child2=(Child) context.getBean("child2");
		System.out.println("child2:"+child2);
//		
//		Child child3=(Child) context.getBean("child3");
//		System.out.println("child3:"+child3);
//		
	}
}
