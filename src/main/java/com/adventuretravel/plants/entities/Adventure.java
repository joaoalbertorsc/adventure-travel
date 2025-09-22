package com.adventuretravel.plants.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADVENTURES")
@Schema(description = "Representa uma aventura de viagem registrada no sistema.")
public class Adventure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único da aventura.", example = "1")
    private Integer id;

    @Column(name = "DATE")
    @Schema(description = "Data em que a aventura ocorreu.", example = "02/03/2018")
    private String date;

    @Column(name = "COUNTRY")
    @Schema(description = "País onde a aventura ocorreu.", example = "Brazil")
    private String country;

    @Column(name = "CITY")
    @Schema(description = "Cidade onde a aventura ocorreu.", example = "Rio de Janeiro")
    private String city;

    @Column(name = "STATE")
    @Schema(description = "Estado onde a aventura ocorreu.", example = "RJ")
    private String state;

    @Column(name = "NUM_PHOTOS")
    @Schema(description = "Número de fotos tiradas durante a aventura.", example = "150")
    private Long numPhotos;

    @Column(name = "BLOG_COMPLETED")
    @Schema(description = "Indica se o post do blog sobre a aventura foi concluído.", example = "true")
    private Boolean blogCompleted;

    public Integer getId() {
        return this.id;
    }

    public String getDate() {
        return this.date;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public Long getNumPhotos() {
        return this.numPhotos;
    }

    public Boolean getBlogCompleted() {
        return this.blogCompleted;
    }

    public void setBlogCompleted(Boolean blogCompleted) {
        this.blogCompleted = blogCompleted;
    }

}