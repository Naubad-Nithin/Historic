
package com.historic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Content implements Serializable{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("period")
    @Expose
    private String period;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("references")
    @Expose
    private String references;
    @SerializedName("keys")
    @Expose
    private String keys;
    @SerializedName("bookmark")
    @Expose
    private Integer bookmark;
    @SerializedName("excerpt")
    @Expose
    private String excerpt;
    @SerializedName("image")
    @Expose
    private String image;

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 
     * @param fullName
     *     The full_name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 
     * @return
     *     The period
     */
    public String getPeriod() {
        return period;
    }

    /**
     * 
     * @param period
     *     The period
     */
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * 
     * @return
     *     The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The references
     */
    public String getReferences() {
        return references;
    }

    /**
     * 
     * @param references
     *     The references
     */
    public void setReferences(String references) {
        this.references = references;
    }

    /**
     * 
     * @return
     *     The keys
     */
    public String getKeys() {
        return keys;
    }

    /**
     * 
     * @param keys
     *     The keys
     */
    public void setKeys(String keys) {
        this.keys = keys;
    }

    /**
     * 
     * @return
     *     The bookmark
     */
    public Integer getBookmark() {
        return bookmark;
    }

    /**
     * 
     * @param bookmark
     *     The bookmark
     */
    public void setBookmark(Integer bookmark) {
        this.bookmark = bookmark;
    }

    /**
     * 
     * @return
     *     The excerpt
     */
    public String getExcerpt() {
        return excerpt;
    }

    /**
     * 
     * @param excerpt
     *     The excerpt
     */
    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    /**
     * 
     * @return
     *     The image
     */
    public String getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(String image) {
        this.image = image;
    }

//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }

}
