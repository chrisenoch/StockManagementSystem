package com.chris.enoch.shoeshop.demo;
/**
 * A class to show my skills in SQL.
 * @author chris
 *
 */
public class SQLDemo {
	
	/* MySQL Demo
	 * 
	 * The following queries work with the sample database. They show use of joins and multiple joins,
	 * along with the where, group by, having and order by clauses, as well as aliases,
	 * the distinct keyword, the length() function and the count() function.
	 * 
	 * NB: The product_id is stored as VARCHAR because some bar codes include letters.
	 * 
	 * The sample database (in the resources folder) shows examples of foreign keys in addition to composite keys.
	 * 
	 * Please refer to https://github.com/chrisenoch/onlineshop for examples of the Service-DAO pattern with Hibernate and JPA 
	 * as part of a complete application.
	 * 
	 * SHOES
			GET SHOE INFORMATION AND SUPPLIER ADDRESSES PER SHOE
			
			SELECT s.id, s.product_id, product_name, gender_adult_child, item_group_ref, price, s.type, colour_name, size, supplier.company_name
			, address_line_1, address_line_2, city, country_region, county_state_region_province, postcode, telephone_number FROM 
			shoe s INNER JOIN colour c on colour_id = c.id INNER JOIN size ON size_id = size.id INNER JOIN supplier_product sp
			ON s.product_id = sp.product_id INNER JOIN supplier  ON sp.supplier_id = supplier.id INNER JOIN supplier_address sa
			ON supplier.id = sa.supplier_id INNER JOIN address ON address_id = address.id ORDER BY length(s.product_id), s.product_id
			
			
	 *STOCK
			FIND TOTAL UNITS OF STOCK BY SHOP_ID
			
			SELECT count(*) from stock where shop_id = 1;
			
			
			
			GET NUMBER OF PRODUCTS IN STOCK BY PRODUCT_ID AND BY SHOP_ID
			
			SELECT shop_id, product_id_ref , COUNT(*) as number FROM shoe_shop.stock where shop_id=1 group by product_id_ref 
			order by length(product_id_ref), product_id_ref
			
			
			
			GET NUMBER OF PRODUCTS IN STOCK BY PRODUCT NAME AND BY SHOP WITH COLOUR INFORMATION AND WITH SIZES BETWEEN X AND Y
			
			SELECT product_id_ref, s.product_name, s.gender_adult_child, s.price, s.type, colour_name, size, COUNT(product_id_ref)
			as "Number in Stock" FROM shoe_shop.stock  inner join shoe s on product_id_ref = s.product_id inner join colour c on 
			s.colour_id = c.id inner join size on s.size_id = size.id where stock.shop_id=1 AND s.product_name="VansRetro"  
			group by product_id_ref having size BETWEEN 38 AND 41 order by length(product_id_ref), product_id_ref
			
			
			
			GET NUMBER OF PRODUCTS IN STOCK BY PRODUCT NAME AND BY SHOP WITH COLOUR INFORMATION AND WITH SIZES BETWEEN X AND Y – ONLY MEN
			
			Option One – state gender in having clause
			
			SELECT product_id_ref, s.product_name, s.gender_adult_child, s.price, s.type, colour_name, size, COUNT(product_id_ref) 
			as "Number in Stock"  FROM shoe_shop.stock  inner join shoe s on product_id_ref = s.product_id inner join
			colour c on s.colour_id = c.id inner join size on s.size_id = size.id where stock.shop_id=1 AND s.product_name="VansRetro"
			group by product_id_ref having size BETWEEN 38 AND 41 AND s.gender_adult_child="MALE"
			order by length(product_id_ref), product_id_ref
			
			
			Option Two – state gender in where clause
			 
			SELECT product_id_ref, s.product_name, s.gender_adult_child, s.price, s.type, colour_name, size, COUNT(product_id_ref) 
			as "Number in Stock"  FROM shoe_shop.stock  inner join shoe s on product_id_ref = s.product_id inner join
			colour c on s.colour_id = c.id inner join size on s.size_id = size.id where stock.shop_id=1 AND s.product_name="VansRetro" 
			AND s.gender_adult_child="MALE" group by product_id_ref having size BETWEEN 38 AND 41 
			order by length(product_id_ref), product_id_ref
			
			
			
			GET OVERVIEW OF PRODUCTS IN STOCK BY PRODUCT_NAME AND BY SHOP_ID WITH COLOUR AND SIZE INFORMATION
			
			SELECT product_id_ref, s.product_name, s.gender_adult_child, s.price, s.type, colour_name, size FROM shoe_shop.stock  inner join 
			shoe s on product_id_ref = s.product_id inner join colour c on s.colour_id = c.id inner join
			size on s.size_id = size.id where stock.shop_id=1 AND s.product_name="VansRetro"  group by product_id_ref
			order by length(product_id_ref), product_id_ref
			
			
			
			GET OVERVIEW OF PRODUCTS IN STOCK BY PRODUCT_NAME AND BY SHOP WITH COLOUR INFORMATION AND WITH SIZES BETWEEN X AND Y
			
			SELECT product_id_ref, s.product_name, s.gender_adult_child, s.price, s.type, colour_name, size FROM shoe_shop.stock  inner join 
			shoe s on product_id_ref = s.product_id inner join colour c on s.colour_id = c.id inner join
			size on s.size_id = size.id where stock.shop_id=1 AND s.product_name="VansRetro"  group by product_id_ref 
			having size BETWEEN 38 AND 41 order by length(product_id_ref), product_id_ref
			
			
			
			SUPPLIER
			GET SUPPLIER ADDRESS BY PRODUCT_ID 
			
			SELECT company_name, address_line_1, address_line_2, city, country_region, county_state_region_province, 
			postcode, telephone_number FROM supplier s inner join supplier_product sp on s.id = sp.supplier_id 
			inner join  supplier_address sa on sp.supplier_id  = sa.supplier_id inner join address on 
			sa.address_id = address.id where product_id= 410
			
			
					
			GET SUPPLIER ADDRESS BY COMPANY_NAME
			
			SELECT DISTINCT company_name, address_line_1, address_line_2, city, country_region, county_state_region_province, 
			postcode, telephone_number FROM supplier s inner join supplier_product sp on s.id = sp.supplier_id 
			inner join  supplier_address sa on sp.supplier_id  = sa.supplier_id inner join address on 
			sa.address_id = address.id where company_name= "Vans"


	 */
	
	
	

}
