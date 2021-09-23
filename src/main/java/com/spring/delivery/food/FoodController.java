package com.spring.delivery.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 

@Controller
@RequestMapping(value="/food")
public class FoodController {
	
	@Autowired
	FoodService foodService;

	@RequestMapping(value="/korean", method = RequestMethod.POST)
	public String koreanfood() {
		return "food/korean";
	}
	
	@RequestMapping(value="/chicken", method = RequestMethod.POST)
	public String chicken() {
		return "food/chicken";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String foodlist(Model model) {
		model.addAttribute("list", foodService.getFoodList());
		return "list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addPost() {
		return "addpostform" ;
	}
	
	@RequestMapping(value="/addok", method = RequestMethod.POST)
	public String foodlist(FoodVO vo) {
		int i = foodService.insertFood(vo) ;
		if(i == 0)
			System.out.println("데이터 추가 실패");
		else
			System.out.println("데이터 추가 성공!!!");
			
		return "redirect:list" ;
	}
	
	@RequestMapping(value="/editform/{id}", method = RequestMethod.GET)
	public String editPost(@PathVariable("id") int id, Model model) {
		FoodVO foodVO = foodService.getFood(id); 
		model.addAttribute("u", foodVO);
		return "editform";
	}
	
	@RequestMapping(value="/editok", method = RequestMethod.POST)
	public String editPostOk(FoodVO vo) {
		if(foodService.updateFood(vo) == 0)
			System.out.println("데이터 수정 실패");
		else
			System.out.println("데이터 수정 성공!!!");
			
		return "redirect:list" ;
	}

	@RequestMapping(value="/deleteok/{id}", method = RequestMethod.GET)
	public String deletePostOk(@PathVariable("id") int id) {
		if(foodService.deleteFood(id) == 0)
			System.out.println("데이터 삭제 실패");
		else
			System.out.println("데이터 삭제 성공!!!");
			
		return "redirect:../list" ;
	}
	
	
	
	
}
