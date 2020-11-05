package com.maggie.s4.transfer;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.maggie.s4.MyTestCase;
import com.maggie.s4.card.Card;

public class TransferTest extends MyTestCase{
	@Autowired
	private Bus bus;
	
	@Autowired
	private Subway subway;
	
	@Autowired
	private Taxi taxi;
	
	@Autowired
	private Card card;
	
	@Test
	public void test() throws Exception{	
		bus.takeBus(100, "bus bus bus");
		taxi.takeTaxi();
		subway.takeSubway();
	}

}
