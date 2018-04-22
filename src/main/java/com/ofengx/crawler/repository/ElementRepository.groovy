package com.ofengx.crawler.repository

import com.ofengx.crawler.model.Element
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "element", path = "element")
interface ElementRepository extends PagingAndSortingRepository<Element, Long> {

}