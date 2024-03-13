package com.example.demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		Anne anne =(Anne) context.getBean("anne");
		System.out.println("Anne:");
        System.out.println("Name: " + anne.getName());
        System.out.println("Age: " + anne.getAge());
        
        Cocuk cocuk1 = anne.getCocuk1();
        System.out.println("\nCocuk 1:");
        System.out.println("Name: " + cocuk1.getName());
        System.out.println("Age: " + cocuk1.getAge());
        System.out.println("Kitap: " + cocuk1.getKitap().getName());

        // Display child2's information
        Cocuk cocuk2 = anne.getCocuk2();
        System.out.println("\nCocuk 2:");
        System.out.println("Name: " + cocuk2.getName());
        System.out.println("Age: " + cocuk2.getAge());
        System.out.println("Kitap: " + cocuk2.getKitap().getName());
		
	}

}
