package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	SupplierDAO supplierDAO;
	
	boolean flag = true;

	//All Request mapping functions
	
	@RequestMapping("/supplier")
	public String showSupplier(Model m) {
		List<Supplier> listSupplier = supplierDAO.gettingSupplier();
		m.addAttribute("listSupplier", listSupplier);

		for (Supplier supplier : listSupplier) {
			System.out.println(supplier.getSupplierName() + ",");
		}
		flag = false;
		return "Supplier";
	}

	@RequestMapping(value = "/InsertSupplier", method = RequestMethod.POST)
	public String insertSupplierData(@RequestParam("suppname") String suppname, @RequestParam("suppaddress") String suppaddress,
			Model m) {
		Supplier supplier = new Supplier();
		supplier.setSupplierName(suppname);
		supplier.setSupplierAddress(suppaddress);

		supplierDAO.addingSupplier(supplier);

		List<Supplier> listSupplier = supplierDAO.gettingSupplier();
		m.addAttribute("listSupplier", listSupplier);
		flag = false;
		return "Supplier";
	}

	@RequestMapping("/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.gettingSupplier(supplierId);
		
		supplierDAO.deletingSupplier(supplier);
		
		List<Supplier> listSupplier=supplierDAO.gettingSupplier();
		m.addAttribute("listSupplier",listSupplier);
		flag=false;
		return "Supplier";
	}

	@RequestMapping("/updateSupplier/{supplierId}")
	public String updateSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.gettingSupplier(supplierId);
		
		
		List<Supplier> listSupplier=supplierDAO.gettingSupplier();
		m.addAttribute("listSupplier",listSupplier);
		m.addAttribute("supplierInfo",supplier);
		
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updateSupplierInDB(@RequestParam("suppid") int supplierId,@RequestParam("suppname") String supplierName,@RequestParam("suppaddress") String supplierAddress,Model m)
	{
		Supplier supplier=supplierDAO.gettingSupplier(supplierId);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddress(supplierAddress);
		
		supplierDAO.updatingSupplier(supplier);
		List<Supplier> listSupplier=supplierDAO.gettingSupplier();
		m.addAttribute("listSupplier",listSupplier);
		
		return "Supplier";
	}

	//end of request mapping function

	
}
