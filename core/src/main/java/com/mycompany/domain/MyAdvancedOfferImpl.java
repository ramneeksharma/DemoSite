/*
 * Copyright 2008-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mycompany.domain;

import org.broadleafcommerce.advancedoffer.domain.offer.AdvancedOfferImpl;
import org.broadleafcommerce.core.offer.domain.AdvancedOffer;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferTier;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import java.util.List;

/**
 * 
 */
@Entity
public class MyAdvancedOfferImpl extends OfferImpl implements Offer,AdvancedOffer {

    /**
     * 
     */
    private static final long serialVersionUID = 2355492500912197559L;
    @Embedded
    protected AdvancedOfferImpl embeddableAdvancedOffer=new AdvancedOfferImpl();

    @Override
    public List<OfferTier> getOfferTiers() {
        return embeddableAdvancedOffer.getOfferTiers();
    }

    @Override
    public void setOfferTiers(List<OfferTier> offerTiers) {
        embeddableAdvancedOffer.setOfferTiers(offerTiers);
    }

    @Override
    public boolean isTieredOffer() {
        return embeddableAdvancedOffer.isTieredOffer();
    }

    @Override
    public void setTieredOffer(boolean isTieredOffer) {
       embeddableAdvancedOffer.setTieredOffer(isTieredOffer);
        
    }

 
}
