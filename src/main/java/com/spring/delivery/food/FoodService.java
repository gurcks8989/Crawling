package com.spring.delivery.food;


import java.util.List ;

public interface FoodService {
	public int insertFood(FoodVO vo);
	public int deleteFood(int seq) ;
	public int updateFood(FoodVO vo);
	public FoodVO getFood(int seq);
	public List<FoodVO> getFoodList() ;
}
