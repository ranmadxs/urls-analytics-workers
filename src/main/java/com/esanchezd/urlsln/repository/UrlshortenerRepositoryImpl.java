package com.esanchezd.urlsln.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.esanchezd.urlsln.entity.Urlshortener;


@Repository
public class UrlshortenerRepositoryImpl implements UrlshortenerRepository{

    private static final Logger LOG = LoggerFactory.getLogger(UrlshortenerRepositoryImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;	
	
	@Override
	public Urlshortener getUrlshortener(String id, Boolean isActive) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id).and("isActive").is(isActive));
        Urlshortener urlshortener = mongoTemplate.findOne(query, Urlshortener.class);
        return urlshortener;
	}

}
