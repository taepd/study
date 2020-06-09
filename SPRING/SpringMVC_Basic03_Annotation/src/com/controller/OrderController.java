package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.OrderCommand;
import com.model.OrderItem;

/*
	/order/order.do
	요청 주소 하나 (method="GET" , method="POST")
	화면 : (GET)
	처리 : (POST)
*/
@Controller
@RequestMapping("/order/order.do")
public class OrderController {
		
	   @RequestMapping(method=RequestMethod.GET)
		public String form() {
			return "order/OrderForm";  //view 주소를 리턴
			//WEB-INF/views/order/OrderForm.jsp
			
		}
	   
	   @RequestMapping(method=RequestMethod.POST)
	   public String submit(OrderCommand ordercommand) {
		  System.out.println("ordercommand 의 주소값 : " + ordercommand );
		  System.out.println("ordercommand  : " + ordercommand.getOrderItem().size() );
		  
		  List<OrderItem> items = ordercommand.getOrderItem();
		  for(OrderItem item : items) {
			  System.out.println(item.toString());
		  }
  
		  //view forward >> key >> OrderCommand 이름을  >> orderCommand
		   return "order/OrderCommited";
	   }

	   /*
	     public String submit(OrderCommand ordercommand)
	     {
	     		   1 . OrderCommand ordercommand = new OrderCommand();
	     			List<OrderItem> list = new ....
	     			list.add(new OrderItem()) 
	     			     >>  orderItem[0].itemid = 1 ,
	     			     >>  orderItem[0].number = 2
	     			     >>  orderItem[0].remark = "주의"  
	     			     
	     			 list.add(new OrderItem()) 
	     			     >>  orderItem[1].itemid = 1 ,
	     			     >>  orderItem[1].number = 2
	     			     >>  orderItem[1].remark = "주의"  
	     			     
	     			 list.add(new OrderItem()) 
	     			     >>  orderItem[2].itemid = 1 ,
	     			     >>  orderItem[2].number = 2
	     			     >>  orderItem[2].remark = "주의"          
	     			         
	     		ordercommand.setOrderItem(list)
	     } 
	     
       */
}










