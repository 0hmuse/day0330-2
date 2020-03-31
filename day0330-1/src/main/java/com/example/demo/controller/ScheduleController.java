package com.example.demo.controller;

import org.springframework.scheduling.annotation.Scheduled;

import com.example.demo.vo.EmpVo;

public class ScheduleController {

	@Scheduled(cron="0, 40, 12, 30, * , *, ?")
	public void pro(EmpVo e)
	{
		System.out.println(e.getEname() + "님" + " 이번달 수령액은" + (e.getSal()+e.getComm()) + "입니다");
	}
}
