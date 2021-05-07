package com.te.springbootecomm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.springbootecomm.bean.ItemInfoBean;
import com.te.springbootecomm.exc.ItemException;
@Repository
public class ItemDAOHibernateImpl implements ItemDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public ItemInfoBean getItemData(Integer id) {
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		EntityManager manager = factory.createEntityManager();
		ItemInfoBean bean = manager.find(ItemInfoBean.class, id);
		return bean;
	}
	@Override
	public boolean addItem(ItemInfoBean itemInfoBean) {
		try {
//			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(itemInfoBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateItem(ItemInfoBean infoBean) {
		try {
//			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			ItemInfoBean orgData = manager.find(ItemInfoBean.class, infoBean.getId());

			if (infoBean.getName() != null && infoBean.getName() != "") {
				orgData.setName(infoBean.getName());
			}
			if (infoBean.getId() != 0) {
				orgData.setId(infoBean.getId());
			}
			

			if (infoBean.getQuantity() != 0) {
				orgData.setQuantity(infoBean.getQuantity());
			}

			if (infoBean.getPrice() != 0 ) {
				orgData.setPrice(infoBean.getPrice());
			}

			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	}

	@Override
	public boolean deleteItem(Integer id) {
			
		try {
//			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			ItemInfoBean infoBean = manager.find(ItemInfoBean.class, id);
			manager.remove(infoBean);
			transaction.commit();
			return true;
		} catch (Exception e) {

			e.printStackTrace();

			throw new ItemException("The Data is not present");
		}
	}


	@Override
	public List<ItemInfoBean> getAllItemDetails() {
		
		List<ItemInfoBean> itemInfoBeans = null;

		try {
//			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();

			Query query =  manager.createQuery("from ItemInfoBean");

			itemInfoBeans =  query.getResultList();

		} catch (Exception e) {
			itemInfoBeans = null;
			e.printStackTrace();
		}

		return itemInfoBeans;
	}
}

