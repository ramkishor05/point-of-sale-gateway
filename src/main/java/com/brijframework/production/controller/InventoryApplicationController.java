package com.brijframework.production.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.production.dto.cust.UICustProductionApp;
import com.brijframework.production.dto.cust.UICustProductionAppDetail;
import com.brijframework.production.service.cust.CustProductionAppService;

@RestController
@RequestMapping("cust/production/app")
public class InventoryApplicationController {

	@Autowired
	CustProductionAppService inventoryApplicationService;
	
	@PostMapping
	public UICustProductionApp addInventory(@RequestBody UICustProductionApp inventoryApplication) {
		return inventoryApplicationService.saveInventoryApp(inventoryApplication);
	}
	
	@GetMapping("/{appId}")
	public UICustProductionApp getInventory(@PathVariable("appId") long appId) {
		return inventoryApplicationService.getInventoryApp(appId);
	}
	
	@GetMapping("/{appId}/detail")
	public UICustProductionAppDetail getInventoryDetail(@PathVariable("appId") long appId) {
		return inventoryApplicationService.getInventoryAppDetail(appId);
	}
	
	
}
