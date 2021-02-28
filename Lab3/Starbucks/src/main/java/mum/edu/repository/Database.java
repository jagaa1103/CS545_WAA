package mum.edu.repository;

import mum.edu.model.Coffee;
import mum.edu.model.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Database {
	private static List<User> users = new ArrayList<>();
	private static List<Coffee> advice = new ArrayList<>();
	static {
		addUser("Dave", "111");
		addUser("Steve", "222");
		addUser("Ralph", "333");

		addCoffee("Sumatra", "dark");
		addCoffee("Verona", "dark");
		addCoffee("French Roast", "dark");

		addCoffee("Breakfast Blend", "medium");
		addCoffee("Colombia", "medium");
		addCoffee("Yukon", "medium");
		addCoffee("Pike Place", "medium");
		addCoffee("House Blend", "medium");

		addCoffee("Willow", "light");
		addCoffee("Aria", "light");
		addCoffee("Bright Sky", "light");
		addCoffee("Veranda", "light");

	}
	
	public boolean checkUser(User user) {
		for (User u : users) {
			if(u.isEqual(user)) return true;
		}
		return false;
	}
	public List<String> getAdvice(String roast) {
		List<String> list = new ArrayList<>();
		for (Coffee coffee: advice) {
			if (coffee.getRoast().equals(roast)) list.add(coffee.getName());
		}
		return list;
	}


	public static void addUser(String name, String password){
		users.add(new User(name, password));
	}

	public static void addCoffee(String name, String roast) {
		advice.add(new Coffee(name, roast));
	}
}
