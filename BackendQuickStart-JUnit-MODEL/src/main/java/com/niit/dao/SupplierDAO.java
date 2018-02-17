package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDAO 
{
				public boolean addingSupplier(Supplier supplier);
				public boolean updatingSupplier(Supplier supplier);
				public Supplier gettingSupplier(int supplierId);
				public List<Supplier> gettingSupplier();
				public boolean deletingSupplier(Supplier supplier);		
}
