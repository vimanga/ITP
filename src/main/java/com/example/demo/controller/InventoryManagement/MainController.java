package com.example.demo.controller.InventoryManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.InventoryManagament.Inventory;

@SuppressWarnings("hiding")
@Controller
public class MainController<Inventory> {

	
	
	@RequestMapping("dform")
	public String AddDevice() 
		{
			return "/InventoryManagement/DeviceRegistration";
		}
	
	@RequestMapping("iform")
	public String AddInventory() 
		{
			return "InventoryManagement/InventoryForm";
		}
	
	
	
	@RequestMapping("updatein")
	public String UpdateInventory() 
		{
			return "/InventoryManagement/UpdateInventory";
		}
	
	
	
	@RequestMapping("viewinventory")
	public String ViewInventory() 
		{
			return "/InventoryManagement/ViewInventory";
		}

	@RequestMapping("viewdevice")
	public String ViewDevice() 
		{
			return "/InventoryManagement/ViewDevice";
		}
	
	@RequestMapping("updatedev")
	public String UpdateDevice() 
		{
			return "/InventoryManagement/UpdateDevice";
		}
	
	@RequestMapping("invdash")
	public String InventoryDashboard() 
		{
			return "/InventoryManagement/InventoryDashboard";
		}
	
	
}
