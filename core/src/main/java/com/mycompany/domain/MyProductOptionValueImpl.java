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

import org.broadleafcommerce.core.catalog.domain.ProductOptionValue;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.broadleafcommerce.core.pricing.domain.PriceAdjustment;
import org.broadleafcommerce.pricelist.domain.catalog.PriceListProductOptionValue;
import org.broadleafcommerce.pricelist.domain.catalog.PriceListProductOptionValueImpl;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import java.util.Map;



/**
 * @author Andre Azzolini (apazzolini)
 */
@Entity
public class MyProductOptionValueImpl extends ProductOptionValueImpl implements ProductOptionValue,  PriceListProductOptionValue {
    private static final long serialVersionUID = -1849002347743308131L;
    
    @Embedded
    protected PriceListProductOptionValueImpl embeddablePriceList = new PriceListProductOptionValueImpl();

    @Override
    public Map<String, PriceAdjustment> getPriceAdjustmentMap() {
        return embeddablePriceList.getPriceAdjustmentMap();
    }

    @Override
    public void setPriceAdjustmentMap(Map<String, PriceAdjustment> priceAdjustmentMap) {
        embeddablePriceList.setPriceAdjustmentMap(priceAdjustmentMap);
    }
    
}
