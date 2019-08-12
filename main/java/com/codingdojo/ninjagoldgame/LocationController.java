package com.codingdojo.ninjagoldgame;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LocationController {
	
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		
		// initial visit - all values will be null
		if(session.getAttribute("ninjaGold")== null) {
			// set gold to start at zero value
			session.setAttribute("ninjaGold", 0);
			// create new hashmap for activities logs
			session.setAttribute("activitiesLog", new HashMap<String, String>());

		}
		return "index.jsp";
	}
	
	
	// create random number generator helper method
	public int getRandom(int min, int max) {
		Random r = new Random();
		int rand = r.nextInt((max-min)+1) + min;
		return rand;
	}
	
	
	@RequestMapping(value="/director", method=RequestMethod.POST)
	public String director(HttpSession session, Model model, @RequestParam(value="location") String location, @RequestParam(value="min") String min, @RequestParam(value="max") String max) {
		
		
		// create timestamp
		String timeStamp = new SimpleDateFormat("MMMMM dd yyyy HH:mm:ss a").format(new java.util.Date());
		
		// if farm
		if(location.equals("farm")) {
			
			//Integer min1 = (Integer) session.getAttribute("min");
			//Integer max1 = (Integer) session.getAttribute("max");
			//System.out.println(min1);
			//System.out.println(max1);
			
			// get random min / max
			Integer rand = getRandom(10, 20);
			// get current gold level
			Integer ninjaGold = (Integer) session.getAttribute("ninjaGold");
			// add random gold to current gold
			session.setAttribute("ninjaGold", ninjaGold + rand);
			// add to hashmap log
			@SuppressWarnings("unchecked")
			Map<String, String> activitiesLog = (HashMap<String, String>) session.getAttribute("activitiesLog");
			activitiesLog.put("You entered a farm and earned " + rand + " gold coins.", timeStamp);
			
		} else if (location.equals("cave")) {
			
			Integer rand = getRandom(5, 10);
			Integer ninjaGold = (Integer) session.getAttribute("ninjaGold");
			session.setAttribute("ninjaGold", ninjaGold + rand);
			@SuppressWarnings("unchecked")
			Map<String, String> activitiesLog = (HashMap<String, String>) session.getAttribute("activitiesLog");
			activitiesLog.put("You entered a cave and earned " + rand + " gold coins.", timeStamp);
		
		} else if (location.equals("house")) {
			
			Integer rand = getRandom(2, 5);
			Integer ninjaGold = (Integer) session.getAttribute("ninjaGold");
			session.setAttribute("ninjaGold", ninjaGold + rand);
			@SuppressWarnings("unchecked")
			Map<String, String> activitiesLog = (HashMap<String, String>) session.getAttribute("activitiesLog");
			activitiesLog.put("You entered a house and earned " + rand + " gold coins.", timeStamp);
		
		} else if (location.equals("casino")) {
			
			// get random win/lose number
			int odds = getRandom(0, 1);
			
			// if odds is WIN (1)
			if(odds == 1) {
				
				Integer rand = getRandom(0, 50);
				Integer ninjaGold = (Integer) session.getAttribute("ninjaGold");
				session.setAttribute("ninjaGold", ninjaGold + rand);
				@SuppressWarnings("unchecked")
				Map<String, String> activitiesLog = (HashMap<String, String>) session.getAttribute("activitiesLog");
				activitiesLog.put("You entered a casino and earned " + rand + " gold coins.", timeStamp);
			
			// if odds is LOSE (0)
			} else  {
				
				Integer rand = getRandom(-50, 0);
				Integer ninjaGold = (Integer) session.getAttribute("ninjaGold");
				session.setAttribute("ninjaGold", ninjaGold + rand);
				@SuppressWarnings("unchecked")
				Map<String, String> activitiesLog = (HashMap<String, String>) session.getAttribute("activitiesLog");
				activitiesLog.put("You entered a casino and lost " + rand + " gold coins. Ouch!!!", timeStamp);
			}

		}
		return "redirect:/";
	}


}
