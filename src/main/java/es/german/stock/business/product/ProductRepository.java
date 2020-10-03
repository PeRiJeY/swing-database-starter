/*
 * The MIT License
 *
 * Copyright 2017 Nafaa Friaa (nafaa.friaa@isetjb.rnu.tn).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package es.german.stock.business.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import es.german.stock.business.base.HibernateUtil;
import es.german.stock.business.base.Repository;

/**
 * The Product repository implementation.
 *
 * @author Nafaa Friaa (nafaa.friaa@isetjb.rnu.tn)
 */
public class ProductRepository implements Repository<ProductBean> {
	final static Logger log = Logger.getLogger(ProductRepository.class);

	/**
	 * Find one item by id.
	 *
	 * @param id
	 * @return
	 */
	@Override
	public ProductBean find(long id) {
		log.debug("Start method...");

		Session session = HibernateUtil.getSessionFactory().openSession();
		ProductBean obj = session.find(ProductBean.class, id);

		log.debug("End method.");

		return obj;

	}

	/**
	 * Find all items.
	 *
	 * @return
	 */
	@Override
	public List<ProductBean> findAll() {
		log.debug("Start method...");

		List<ProductBean> products = new ArrayList<>();

		Session session = HibernateUtil.getSessionFactory().openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ProductBean> criteria = builder.createQuery(ProductBean.class);
		criteria.from(ProductBean.class);
		products = session.createQuery(criteria).getResultList();

		log.debug("End method.");

		return products;
	}

	/**
	 * Create new Object and return this new Object if success. Run only on tables
	 * with auto_increment id column.
	 *
	 * @param obj
	 * @return
	 */
	@Override
	public ProductBean create(ProductBean obj) {
		log.debug("Start method...");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// Add new Employee object
		ProductBean objectToReturn = new ProductBean();
		objectToReturn.setName(obj.getName());
		objectToReturn.setPrice(obj.getPrice());
		objectToReturn.setEnabled(obj.getEnabled());

		session.save(objectToReturn);

		session.getTransaction().commit();

		return objectToReturn;
	}

	/**
	 * Update a record.
	 *
	 * @param obj
	 * @return
	 */
	@Override
	public ProductBean update(ProductBean obj) {
		log.debug("Start method...");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.merge(obj);

		session.getTransaction().commit();

		log.debug("End method.");

		return obj;
	}

	/**
	 * Delete a single record.
	 *
	 * @param id
	 * @return the number of affected rows.
	 */
	@Override
	public int delete(long id) {
		log.debug("Start method...");

		int affectedRows = 0;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		ProductBean objToDelete = find(id);

		if (objToDelete != null) {
			session.beginTransaction();
			session.delete(objToDelete);			
			session.getTransaction().commit();
		}

		log.debug("End method.");

		return affectedRows;
	}

}
