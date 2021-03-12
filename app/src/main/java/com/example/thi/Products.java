package com.example.thi;

public class Products {
    private String search_image;
    private String styleid;
    private String brands_filter_facet;
    private String price;

    public Products(String search_image, String styleid, String brands_filter_facet, String price) {
        this.search_image = search_image;
        this.styleid = styleid;
        this.brands_filter_facet = brands_filter_facet;
        this.price = price;
    }

    public Products() {
    }

    public String getSearch_image() {
        return search_image;
    }

    public void setSearch_image(String search_image) {
        this.search_image = search_image;
    }

    public String getStyleid() {
        return styleid;
    }

    public void setStyleid(String styleid) {
        this.styleid = styleid;
    }

    public String getBrands_filter_facet() {
        return brands_filter_facet;
    }

    public void setBrands_filter_facet(String brands_filter_facet) {
        this.brands_filter_facet = brands_filter_facet;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
