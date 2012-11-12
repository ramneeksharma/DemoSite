package com.mycompany.catalog.domain;

import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
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
@Table(name = "SEO_PRODUCT")
public class MyProductImpl extends ProductImpl implements Product, SeoMetaData, TwitterData {

    private static final long serialVersionUID = 1L;

    @Embedded
    protected SeoMetaDataImpl seoMetaData = new SeoMetaDataImpl();

    @Embedded
    protected TwitterDataImpl twitterData = new TwitterDataImpl();

    public SeoMetaDataImpl getSeoMetaData() {
        return seoMetaData;
    }

    public void setSeoMetaData(SeoMetaDataImpl seoMetaData) {
        this.seoMetaData = seoMetaData;
    }

    public TwitterDataImpl getTwitterData() {
        return twitterData;
    }

    public void setTwitterData(TwitterDataImpl twitterData) {
        this.twitterData = twitterData;
    }

    @Override
    @Nullable
    public String getMetaDescription() {
        return seoMetaData.getMetaDescription();
    }

    @Override
    public void setMetaDescription(@Nullable String metaDescription) {
        seoMetaData.setMetaDescription(metaDescription);
    }

    @Override
    @Nullable
    public String getMetaKeywords() {
        return seoMetaData.getMetaKeywords();
    }

    @Override
    public void setMetaKeywords(@Nullable String metaKeywords) {
        seoMetaData.setMetaKeywords(metaKeywords);
    }

    @Override
    @Nullable
    public String getMetaRobot() {
        return seoMetaData.getMetaRobot();
    }

    @Override
    public void setMetaRobot(@Nullable String metaRobot) {
        seoMetaData.setMetaRobot(metaRobot);
    }

    @Override
    @Nullable
    public String getTitleFragment() {
        return seoMetaData.getTitleFragment();
    }

    @Override
    public void setTitleFragment(@Nullable String titleFragment) {
        seoMetaData.setTitleFragment(titleFragment);
    }

    @Override
    public String getTwitterSite() {
        return twitterData.getTwitterSite();
    }

    @Override
    public void setTwitterSite(@Nullable String twitterSite) {
        twitterData.setTwitterSite(twitterSite);
    }

    @Override
    public String getTwitterCreator() {
        return twitterData.getTwitterCreator();
    }

    @Override
    public void setTwitterCreator(@Nullable String twitterCreator) {
        twitterData.setTwitterCreator(twitterCreator);
    }

    @Override
    @Nullable
    public String getTwitterCard() {
        return twitterData.getTwitterCard();
    }

    @Override
    public void setTwitterCard(@Nullable String twitterCard) {
        twitterData.setTwitterCard(twitterCard);
    }

    @Override
    @Nullable
    public String getTwitterUrl() {
        return twitterData.getTwitterUrl();
    }

    @Override
    public void setTwitterUrl(@Nullable String twitterUrl) {
        twitterData.setTwitterUrl(twitterUrl);
    }

    @Override
    @Nullable
    public String getTwitterTitle() {
        return twitterData.getTwitterTitle();
    }

    @Override
    public void setTwitterTitle(@Nullable String twitterTitle) {
        twitterData.setTwitterTitle(twitterTitle);
    }

    @Override
    @Nullable
    public String getTwitterDescription() {
        return twitterData.getTwitterDescription();
    }

    @Override
    public void setTwitterDescription(@Nullable String twitterDescription) {
        twitterData.setTwitterDescription(twitterDescription);
    }

    @Override
    @Nullable
    public String getTwitterImage() {
        return twitterData.getTwitterImage();
    }

    @Override
    public void setTwitterImage(@Nullable String twitterImage) {
        twitterData.setTwitterImage(twitterImage);
    }
}
