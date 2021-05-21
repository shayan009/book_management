package com.shayan.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shayan.book.entity.BookModel;


@Repository
public interface BookDetailsEntityDao extends JpaRepository<BookModel, Integer> {


}
