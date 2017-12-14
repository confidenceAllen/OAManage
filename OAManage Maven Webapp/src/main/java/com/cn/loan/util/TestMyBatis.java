package com.cn.loan.util;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.cn.loan.pojo.BillBoard;
import com.cn.loan.service.BillBoardService;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	
    private final BillBoardService billBoardService;

    @Autowired
    public TestMyBatis(BillBoardService billBoardService) {
        this.billBoardService = billBoardService;
    }

	@Test
	public void test(){
		BillBoard billBoard = new BillBoard();
		billBoard.setId(1);
		billBoard.setTitle("22");
		billBoard.setSortIndex(1);
		billBoard.setUrl("33");
		billBoardService.insert(billBoard);
	}
	
}
