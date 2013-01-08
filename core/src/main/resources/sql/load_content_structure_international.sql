--
-- The Archetype is configured with "hibernate.hbm2ddl.auto" value="create-drop" in "persistence.xml".
--
-- This will cause hibernate to populate the database when the application is started by processing the files that
-- were configured in the hibernate.hbm2ddl.import_files property.
--
-- This file is responsible for loading international data the pricelist data in multiple currencies.  Implementers can exclude this file
-- to load their own international data.
--

--
-- Load currencies:  Your site will need currencies defined in order to use price lists.
-- i18n standard abbreviations should be used.
--
INSERT INTO BLC_CURRENCY(CURRENCY_CODE, FRIENDLY_NAME, DEFAULT_FLAG) VALUES('GBP', 'GB Pound', false);
INSERT INTO BLC_CURRENCY(CURRENCY_CODE, FRIENDLY_NAME, DEFAULT_FLAG) VALUES('MXN', 'Mexican Peso', false);
INSERT INTO BLC_CURRENCY(CURRENCY_CODE, FRIENDLY_NAME, DEFAULT_FLAG) VALUES('EUR', 'EURO Dollar', false);



--
-- Load Locales:  Your site must have at least one Locale with DEFAULT_FLAG set to TRUE
-- You can have as many locales as you like. Currency can be set  to null if none have
-- been defined. i18n standard abbreviations should be used.
--
INSERT INTO BLC_LOCALE (LOCALE_CODE, DEFAULT_FLAG, FRIENDLY_NAME, CURRENCY_CODE) VALUES ('es', FALSE, 'Spanish', 'EUR');
INSERT INTO BLC_LOCALE (LOCALE_CODE, DEFAULT_FLAG, FRIENDLY_NAME, CURRENCY_CODE) VALUES ('fr', FALSE, 'French', 'EUR');
INSERT INTO BLC_LOCALE (LOCALE_CODE, DEFAULT_FLAG, FRIENDLY_NAME, CURRENCY_CODE) VALUES ('en_GB', FALSE,'English (United Kingdom)', 'GBP');
INSERT INTO BLC_LOCALE (LOCALE_CODE, DEFAULT_FLAG, FRIENDLY_NAME, CURRENCY_CODE) VALUES ('es_MX', FALSE, 'Spanish (Mexico)', 'MXN');
INSERT INTO BLC_LOCALE (LOCALE_CODE, DEFAULT_FLAG, FRIENDLY_NAME, CURRENCY_CODE) VALUES ('es_ES', FALSE, 'Spanish (Spain)', 'EUR');
INSERT INTO BLC_LOCALE (LOCALE_CODE, DEFAULT_FLAG, FRIENDLY_NAME, CURRENCY_CODE) VALUES ('fr_FR', FALSE,'French (France)', 'EUR');

--
-- Load price lists:  Your site will need to define 'price list data' populated with the prices. This demo has based
-- the price lists on currencies, but your site could use areas (zip codes, etc) to define lists.
--
INSERT INTO BLC_PRICE_LIST (PRICE_LIST_ID,CURRENCY_CODE,FRIENDLY_NAME,PRICE_KEY) VALUES (2,'EUR','EUR Dollar','EUR');
INSERT INTO BLC_PRICE_LIST (PRICE_LIST_ID,CURRENCY_CODE,FRIENDLY_NAME,PRICE_KEY) VALUES (3,'GBP','GB Pound','GBP');
INSERT INTO BLC_PRICE_LIST (PRICE_LIST_ID,CURRENCY_CODE,FRIENDLY_NAME,PRICE_KEY) VALUES (4,'MXN','Mexican Peso','MXN');

--
-- The following items create page templates.   The key is to map a JSP template (TMPLT_PATH) to
-- a LOCALE_CODE.   In the example below, there is only one JSP template "basic".   The full
-- path to the template is .../WEB_INF/jsp/templates/basic.jsp.
--
INSERT INTO BLC_PAGE_TMPLT (PAGE_TMPLT_ID, LOCALE_CODE, TMPLT_NAME, TMPLT_DESCR, TMPLT_PATH) VALUES (2, 'es', 'Basic Spanish Template', 'This template provides a basic layout with header and footer surrounding the content and title.', '/content/default') ;

--
-- Map both the spanish template to this field group.
--
INSERT INTO BLC_PGTMPLT_FLDGRP_XREF(PAGE_TMPLT_ID, FLD_GROUP_ID, GROUP_ORDER) VALUES (2,1,0);


--if GBP then use EUR
insert into BLC_PL_CRITERIA_RULE values(1,'MVEL.eval("toUpperCase()",locale.localeCode).contains(MVEL.eval("toUpperCase()","en_GB"))')
insert into BLC_PRICE_LIST_RULE(PRICE_LIST_RULE_ID,PRICE_LIST,PRIORITY,FRIENDLY_NAME) VALUES(1,3,1,'GB Pound if contains en_GB');
INSERT INTO BLC_PL_RULE_MAP VALUES (1,1,'LOCALE');
--if US then use EUR
insert into BLC_PL_CRITERIA_RULE values(2,'MVEL.eval("toUpperCase()",locale.localeCode).contains(MVEL.eval("toUpperCase()","en_US"))')
insert into BLC_PRICE_LIST_RULE(PRICE_LIST_RULE_ID,PRICE_LIST,PRIORITY,FRIENDLY_NAME) VALUES(2,1,2,'US Dollar if contains en_US');
INSERT INTO BLC_PL_RULE_MAP VALUES (2,2,'LOCALE');
--if GBP then use EUR
insert into BLC_PL_CRITERIA_RULE values(3,'MVEL.eval("toUpperCase()",locale.localeCode).contains(MVEL.eval("toUpperCase()","es_ES"))')
insert into BLC_PRICE_LIST_RULE(PRICE_LIST_RULE_ID,PRICE_LIST,PRIORITY,FRIENDLY_NAME) VALUES(3,2,3,'EUR Dollar if contains es_ES');
INSERT INTO BLC_PL_RULE_MAP VALUES (3,3,'LOCALE');
--if US then use EUR
insert into BLC_PL_CRITERIA_RULE values(4,'MVEL.eval("toUpperCase()",locale.localeCode).contains(MVEL.eval("toUpperCase()","MX"))')
insert into BLC_PRICE_LIST_RULE(PRICE_LIST_RULE_ID,PRICE_LIST,PRIORITY,FRIENDLY_NAME) VALUES(4,4,4,'Mexican Peso if contains MX');
INSERT INTO BLC_PL_RULE_MAP VALUES (4,4,'LOCALE');
--if GBP then use EUR
insert into BLC_PL_CRITERIA_RULE values(5,'MVEL.eval("toUpperCase()",locale.localeCode).contains(MVEL.eval("toUpperCase()","FR"))')
insert into BLC_PRICE_LIST_RULE(PRICE_LIST_RULE_ID,PRICE_LIST,PRIORITY,FRIENDLY_NAME) VALUES(5,2,5,'EUR Dollar if contains FR');
INSERT INTO BLC_PL_RULE_MAP VALUES (5,5,'LOCALE');
--if US then use EUR
insert into BLC_PL_CRITERIA_RULE values(6,'MVEL.eval("toUpperCase()",locale.localeCode).contains(MVEL.eval("toUpperCase()","US"))')
insert into BLC_PRICE_LIST_RULE(PRICE_LIST_RULE_ID,PRICE_LIST,PRIORITY,FRIENDLY_NAME) VALUES(6,1,6,'US Dollar if contains US');
INSERT INTO BLC_PL_RULE_MAP VALUES (6,6,'LOCALE');
