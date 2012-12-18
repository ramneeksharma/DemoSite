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

import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;

import com.broadleafcommerce.pricelist.domain.offer.OfferRestrictedPriceList;
import com.broadleafcommerce.pricelist.domain.offer.PriceListOffer;
import com.broadleafcommerce.pricelist.domain.offer.PriceListOfferImpl;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import java.util.List;


/**
 * @author Andre Azzolini (apazzolini)
 */
@Entity
public class MyOfferImpl extends OfferImpl implements Offer, PriceListOffer {
    
    @Embedded
    protected PriceListOfferImpl embeddablePriceList = new PriceListOfferImpl();

    @Override
    public List<OfferRestrictedPriceList> getRestrictedPriceLists() {
        return embeddablePriceList.getRestrictedPriceLists();
    }

    @Override
    public void setRestrictedPriceLists(List<OfferRestrictedPriceList> restrictedPriceLists) {
        embeddablePriceList.setRestrictedPriceLists(restrictedPriceLists);
    }

}
