package com.example.demo.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.model.User;


@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{
	   List<Cart>  findAllByUserOrderByCreatedDateDesc(User user);
	    Cart findById(int id);
		Cart findByProduct(Product p);

}
