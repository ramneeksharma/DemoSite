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

import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.pricelist.domain.PriceList;
import org.broadleafcommerce.pricelist.domain.order.PriceListOrder;
import org.broadleafcommerce.pricelist.domain.order.PriceListOrderImpl;

import javax.persistence.Embedded;
import javax.persistence.Entity;



/**
 * @author Andre Azzolini (apazzolini)
 */
@Entity
public class MyOrderImpl extends OrderImpl implements Order, PriceListOrder {
    private static final long serialVersionUID = -1849002347743308131L;
    
    @Embedded
    protected PriceListOrderImpl embeddablePriceList = new PriceListOrderImpl();

    @Override
    public PriceList getPriceList() {
        return embeddablePriceList.getPriceList();
    }

    @Override
    public void setPriceList(PriceList priceList) {
        embeddablePriceList.setPriceList(priceList);
    }
    
}
