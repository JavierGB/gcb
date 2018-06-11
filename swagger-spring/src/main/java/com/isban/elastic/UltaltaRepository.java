package com.isban.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import io.swagger.model.Ultalta;

public interface UltaltaRepository extends  ElasticsearchRepository<Ultalta, String> {

	
	
}
