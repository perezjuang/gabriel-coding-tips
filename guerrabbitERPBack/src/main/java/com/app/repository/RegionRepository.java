package com.app.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Region;


@Repository
public interface RegionRepository extends CrudRepository <Region, Long> 
{
	  /* @EntityGraph(attributePaths = "soc")
	    List<Region> findFirst10ByOrderByNameAsc();

	    @Modifying
	    @Transactional
	    @Query("DELETE FROM Book b WHERE b.bookCategory.id = ?1")
	    void deleteInBulkByCategoryId(int categoryId);

	    @Transactional
	    void deleteByBookCategoryId(int categoryId);*/
}

/*
 * 
 * package com.hellokoding.jpa.book;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface BookRepository extends JpaRepository<Book, Integer>{
    @EntityGraph(attributePaths = "bookCategory")
    List<Book> findFirst10ByOrderByNameAsc();

    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.bookCategory.id = ?1")
    void deleteInBulkByCategoryId(int categoryId);

    @Transactional
    void deleteByBookCategoryId(int categoryId);
}

*/
