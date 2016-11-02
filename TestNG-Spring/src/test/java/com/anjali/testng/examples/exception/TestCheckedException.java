package com.anjali.testng.examples.exception;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.anjali.testng.project.order.Order;
import com.anjali.testng.project.order.OrderBo;
import com.anjali.testng.project.order.OrderNotFoundException;
import com.anjali.testng.project.order.OrderSaveException;
import com.anjali.testng.project.order.OrderUpdateException;

public class TestCheckedException {

	OrderBo orderBo;
	Order data;

	@BeforeTest
	void setup() {
		orderBo = new OrderBo();

		data = new Order();
		data.setId(1);
		data.setCreatedBy("mkyong");
	}

	@Test(expectedExceptions = OrderSaveException.class)
	public void throwIfOrderIsNull() throws OrderSaveException {
		orderBo.save(null);
	}

	/*
	 * Example : Multiple expected exceptions
	 * Test is success if either of the exception is throws
	 */
	@Test(expectedExceptions = { OrderUpdateException.class, OrderNotFoundException.class })
	public void throwIfOrderIsNotExists() throws OrderUpdateException, OrderNotFoundException {
		orderBo.update(data);
	}
	
}