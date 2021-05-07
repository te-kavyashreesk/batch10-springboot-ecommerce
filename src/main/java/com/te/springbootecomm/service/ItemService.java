package com.te.springbootecomm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.te.springbootecomm.bean.ItemInfoBean;

public interface ItemService {
			
		public ItemInfoBean getItemData(Integer id);

		public boolean addItem(ItemInfoBean itemInfoBean);

		public boolean updateItem(ItemInfoBean infoBean);

		public boolean deleteItem(Integer id);

		public List<ItemInfoBean> getAllItemDetails();
	}



