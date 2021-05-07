package com.te.springbootecomm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.te.springbootecomm.bean.ItemInfoBean;

public interface ItemDAO {
	public ItemInfoBean getItemData(Integer id);

	public boolean addItem(ItemInfoBean itemInfoBean);

	public boolean updateItem(ItemInfoBean infoBean);

	public boolean deleteItem(Integer id);

	public List<ItemInfoBean> getAllItemDetails();


}
