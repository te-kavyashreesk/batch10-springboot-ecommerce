package com.te.springbootecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springbootecomm.bean.ItemInfoBean;
import com.te.springbootecomm.dao.ItemDAO;
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	 ItemDAO dao;


	@Override
	public ItemInfoBean getItemData(Integer id) {
		// TODO Auto-generated method stub
		return dao.getItemData(id);
	}

	@Override
	public boolean addItem(ItemInfoBean itemInfoBean) {
		// TODO Auto-generated method stub
		return dao.addItem(itemInfoBean);
	}

	@Override
	public boolean updateItem(ItemInfoBean infoBean) {
		// TODO Auto-generated method stub
		return dao.updateItem(infoBean);
	}

	@Override
	public boolean deleteItem(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteItem(id);
	}

	@Override
	public List<ItemInfoBean> getAllItemDetails() {
		// TODO Auto-generated method stub
		return dao.getAllItemDetails();
	}

}
