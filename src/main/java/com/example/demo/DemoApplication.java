package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class DemoApplication {

    @Autowired
    ExpenseRepository repository;
     
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @RequestMapping(value="/all",method = RequestMethod.GET)
    public List<Expense> findAll(){
    	return (List<Expense>) repository.findAll();
    }
    @RequestMapping(value="/create",method = RequestMethod.POST,consumes = "application/json")
    public String create(@RequestBody Expense expense) {
    	repository.save(expense);
		return "update";
    	
    }
 
    public void run(String... args) throws Exception {
		
    		Expense exp = new Expense();
    		exp.setId(1);
    		exp.setEmail("priya@gmail.com");
    		exp.setName("priya");
    		repository.save(exp);
		 
         
        Iterable<Expense> iterator = repository.findAll();
         
        System.out.println("All expense items: ");
        iterator.forEach(item -> System.out.println(item));
		/*
		 * List<Expense> breakfast = repository.findByItem("breakfast");
		 * System.out.println("\nHow does my breakfast cost?: "); breakfast.forEach(item
		 * -> System.out.println(item));
		 * 
		 * List<Expense> expensiveItems = repository.listItemsWithPriceOver(200);
		 * System.out.println("\nExpensive Items: "); expensiveItems.forEach(item ->
		 * System.out.println(item));
		 */    
    }

}
