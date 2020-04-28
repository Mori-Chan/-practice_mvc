package examples.component.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import examples.entity.ProductModel;

@Repository
public class DataAccessObjectSample {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public DataAccessObjectSample(){ super(); }

	@Transactional(readOnly=true)
	public ProductModel getProduct(){
		String sql = "SELECT * FROM t_product WHERE id = ?";
		String id = "pen";

		Object[] args = new Object[] {id};
		ProductModel productModel = this.jdbcTemplate.queryForObject(sql, args, new RowMapper4productModel());
		return productModel;
	}

//
//	@Transactional　エラーになる。
//	public void entryProduct(){
//		String sql = "insert into t_product(id, name, price) values(?, ?, ?)";
//
//		String id = "moca";
//		String name = "moca cafee";
//		int price = 1000;
//		Object[] args = new Object[] {id, name, new Integer(price)};
//
//		int n = this.jdbcTemplate.update(sql, args);
//		System.out.println("n=" + String.valueOf(n));
//		throw new IllegalArgumentException(id + "/" + name);
//	}


	@Transactional
	public void entryProduct(){
		String sql = "insert into t_product(id, name, price) values(?, ?, ?)";

		String id = "pc";
		String name = "Personal Computer";
		int price = 100000;
		Object[] args = new Object[] {id, name, new Integer(price)};

		int n = this.jdbcTemplate.update(sql, args);
		System.out.println("n=" + String.valueOf(n));
	}


	@Transactional(readOnly=true)
	public List<ProductModel> getProducts(){
		String sql = "SELECT id, name, price FROM t_product order by price";
		RowMapper<ProductModel> mapper = new BeanPropertyRowMapper<ProductModel>(ProductModel.class);

		Object[] args = new Object[] {};
		List<ProductModel> productList = this.jdbcTemplate.query(sql, args, mapper);
		return productList;
	}


	private static class RowMapper4productModel implements RowMapper<ProductModel>{
		public RowMapper4productModel(){
			super();
		}
		public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException{
			ProductModel productModel = new ProductModel();
			productModel.setId(rs.getString("id"));
			productModel.setName(rs.getString("name"));
			productModel.setPrice(rs.getInt("price"));
			return productModel;
		}
	}
}

