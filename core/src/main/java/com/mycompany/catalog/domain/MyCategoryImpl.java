package com.mycompany.catalog.domain;

import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.seo.domain.catalog.SeoMetaData;
import org.broadleafcommerce.seo.domain.catalog.SeoMetaDataImpl;
import org.broadleafcommerce.seo.domain.catalog.TwitterData;
import org.broadleafcommerce.seo.domain.catalog.TwitterDataImpl;

import javax.annotation.Nullable;
import javax.persistence.*;

/**
 * @author Jerry Ocanas (jocanas)
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "SEO_CATEGORY")
public class MyCategoryImpl extends CategoryImpl implements Category, SeoMetaData, TwitterData {

    private static final long serialVersionUID = 1L;

    @Embedded
    protected SeoMetaDataImpl seoMetaData = new SeoMetaDataImpl();

    @Embedded
    protected TwitterDataImpl twitterData = new TwitterDataImpl();

    protected void initializeSeoMetaData(){
        if(seoMetaData == null){
            seoMetaData = new SeoMetaDataImpl();
        }
    }

    protected void initializeTwitterData(){
        if(twitterData == null){
            twitterData = new TwitterDataImpl();
        }
    }

    @Override
    @Nullable
    public String getMetaDescription() {
        initializeSeoMetaData();
        return seoMetaData.getMetaDescription() != null ? seoMetaData.getMetaDescription() : super.getDescription();
    }

    @Override
    public void setMetaDescription(@Nullable String metaDescription) {
        initializeSeoMetaData();
        seoMetaData.setMetaDescription(metaDescription);
    }

    @Override
    @Nullable
    public String getMetaKeywords() {
        initializeSeoMetaData();
        return seoMetaData.getMetaKeywords();
    }

    @Override
    public void setMetaKeywords(@Nullable String metaKeywords) {
        initializeSeoMetaData();
        seoMetaData.setMetaKeywords(metaKeywords);
    }

    @Override
    @Nullable
    public String getMetaRobot() {
        initializeSeoMetaData();
        return seoMetaData.getMetaRobot();
    }

    @Override
    public void setMetaRobot(@Nullable String metaRobot) {
        initializeSeoMetaData();
        seoMetaData.setMetaRobot(metaRobot);
    }

    @Override
    @Nullable
    public String getTitleFragment() {
        initializeSeoMetaData();
        return seoMetaData.getTitleFragment();
    }

    @Override
    public void setTitleFragment(@Nullable String titleFragment) {
        initializeSeoMetaData();
        seoMetaData.setTitleFragment(titleFragment);
    }

    @Override
    public String getTwitterSite() {
        initializeTwitterData();
        return twitterData.getTwitterSite();
    }

    @Override
    public void setTwitterSite(@Nullable String twitterSite) {
        initializeTwitterData();
        twitterData.setTwitterSite(twitterSite);
    }

    @Override
    public String getTwitterCreator() {
        initializeTwitterData();
        return twitterData.getTwitterCreator();
    }

    @Override
    public void setTwitterCreator(@Nullable String twitterCreator) {
        initializeTwitterData();
        twitterData.setTwitterCreator(twitterCreator);
    }

    @Override
    @Nullable
    public String getTwitterCard() {
        initializeTwitterData();
        return twitterData.getTwitterCard();
    }

    @Override
    public void setTwitterCard(@Nullable String twitterCard) {
        initializeTwitterData();
        twitterData.setTwitterCard(twitterCard);
    }

    @Override
    @Nullable
    public String getTwitterUrl() {
        initializeTwitterData();
        return twitterData.getTwitterUrl() != null ? twitterData.getTwitterUrl() : super.getUrl();
    }

    @Override
    public void setTwitterUrl(@Nullable String twitterUrl) {
        initializeTwitterData();
        twitterData.setTwitterUrl(twitterUrl);
    }

    @Override
    @Nullable
    public String getTwitterTitle() {
        initializeTwitterData();
        return twitterData.getTwitterTitle();
    }

    @Override
    public void setTwitterTitle(@Nullable String twitterTitle) {
        initializeTwitterData();
        twitterData.setTwitterTitle(twitterTitle);
    }

    @Override
    @Nullable
    public String getTwitterDescription() {
        initializeTwitterData();
        return twitterData.getTwitterDescription();
    }

    @Override
    public void setTwitterDescription(@Nullable String twitterDescription) {
        initializeTwitterData();
        twitterData.setTwitterDescription(twitterDescription);
    }

    @Override
    @Nullable
    public String getTwitterImage() {
        initializeTwitterData();
        return twitterData.getTwitterImage();
    }

    @Override
    public void setTwitterImage(@Nullable String twitterImage) {
        initializeTwitterData();
        twitterData.setTwitterImage(twitterImage);
    }
}
