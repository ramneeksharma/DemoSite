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

import org.broadleafcommerce.core.catalog.domain.SkuBundleItem;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl;

import com.broadleafcommerce.pricelist.domain.SkuBundleItemPriceData;
import com.broadleafcommerce.pricelist.domain.catalog.PriceListSkuBundleItem;
import com.broadleafcommerce.pricelist.domain.catalog.PriceListSkuBundleItemImpl;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import java.util.Map;



/**
 * @author Andre Azzolini (apazzolini)
 */
@Entity
public class MySkuBundleItemImpl extends SkuBundleItemImpl implements SkuBundleItem, PriceListSkuBundleItem {
    private static final long serialVersionUID = -1849002347743308131L;
    
    @Embedded
    protected PriceListSkuBundleItemImpl embeddablePriceList = new PriceListSkuBundleItemImpl();

    @Override
    public Map<String, SkuBundleItemPriceData> getPriceDataMap() {
        return embeddablePriceList.getPriceDataMap();
    }

    @Override
    public void setPriceDataMap(Map<String, SkuBundleItemPriceData> priceDataMap) {
        embeddablePriceList.setPriceDataMap(priceDataMap);
    }
    
}
