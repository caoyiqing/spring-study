package com.cyq.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.cyq.aop.IdempotentRetry;
import com.cyq.model.Order;
import com.cyq.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@IdempotentRetry
	@Override
	public Integer addOrder() {
		System.out.println(this + " 新增订单操作....");
//		int i = 1 / 0;
//		System.out.println("----------------异常");
		this.getOrder();
		return 0;
	}

	@Override
	public Order getOrder() {
		Order order = new Order();
		order.setOrderNum("order:" + Math.random());
		order.setCreateDate(new Date());
		return order;
	}

}
