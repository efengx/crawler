package com.ofengx.crawler.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String imgName;


    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getImgName() {
        return imgName
    }

    void setImgName(String imgName) {
        this.imgName = imgName
    }
}
