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

import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;

import com.broadleafcommerce.pricelist.domain.PriceList;
import com.broadleafcommerce.pricelist.domain.customer.PriceListCustomer;
import com.broadleafcommerce.pricelist.domain.customer.PriceListCustomerImpl;

import javax.persistence.Embedded;
import javax.persistence.Entity;



/**
 * @author Priyesh Patel
 */
@Entity
public class MyCustomerImpl extends CustomerImpl implements Customer,PriceListCustomer {
    private static final long serialVersionUID = -1849002347743308131L;
    
    @Embedded
    protected PriceListCustomerImpl embeddablePriceList = new PriceListCustomerImpl();

    @Override
    public PriceList getPriceList() {
        return embeddablePriceList.getPriceList();
    }

    @Override
    public void setPriceList(PriceList priceList) {
        embeddablePriceList.setPriceList(priceList);
    }
    
}
