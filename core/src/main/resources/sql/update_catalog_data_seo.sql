-- Add SEO properties for category
UPDATE BLC_CATEGORY SET META_DESCRIPTION = 'Heat Clinic Hot Sauces', META_KEYWORDS = 'hot, sauce, heat, peppers', META_ROBOT = 'INDEX,FOLLOW', TITLE_FRAGMENT = 'Hot Sauces - Broadleaf Demo - Heat Clinic' WHERE CATEGORY_ID = 2002;
UPDATE BLC_CATEGORY SET META_DESCRIPTION = 'Heat Clinic Merchandise', META_KEYWORDS = 'hot, peppers, shirts, t-shirts, all sizes', META_ROBOT = 'INDEX,FOLLOW', TITLE_FRAGMENT = 'Merchandise - Broadleaf Demo - Heat Clinic' WHERE CATEGORY_ID = 2003;
UPDATE BLC_CATEGORY SET META_DESCRIPTION = 'Heat Clinic Clearance Sale', META_KEYWORDS = 'clearance, sale, act now, offer', TITLE_FRAGMENT = 'Clearance - Broadleaf Demo - Heat Clinic' WHERE CATEGORY_ID = 2004;

-- Add Twitter properties for category
UPDATE BLC_CATEGORY SET TWITTER_CARD = 'summary', TWITTER_URL = 'https://heat-clinic.com/hot-sauces', TWITTER_TITLE = 'Heat Clinic Hot Sauces', TWITTER_DESCRIPTION = 'The best hot sauces you can find', TWITTER_IMAGE = 'https://heat-clinic.com/hot.png' WHERE CATEGORY_ID = 2002;
UPDATE BLC_CATEGORY SET TWITTER_CARD = 'summary' WHERE CATEGORY_ID = 2003;

-- Add SEO properties for product
UPDATE BLC_PRODUCT SET META_DESCRIPTION = 'Sudden death sauce', META_KEYWORDS = 'death sauce, scoville, heat, sauce', META_ROBOT = 'INDEX,FOLLOW', TITLE_FRAGMENT = 'Sudden Death Sauce - Hot Sauces' WHERE PRODUCT_ID = 1;
UPDATE BLC_PRODUCT SET META_DESCRIPTION = 'Sweet death sauce', META_KEYWORDS = 'sweet sauce, scoville, heat, sauce', META_ROBOT = 'INDEX,FOLLOW', TITLE_FRAGMENT = 'Sweet Death Sauce - Hot Sauces' WHERE PRODUCT_ID = 2;
UPDATE BLC_PRODUCT SET META_DESCRIPTION = 'Hoppin hot sauce', META_KEYWORDS = 'hot sauce, scoville, heat, sauce', META_ROBOT = 'INDEX,FOLLOW', TITLE_FRAGMENT = 'Hoppin'' Hot Sauce - Hot Sauces' WHERE PRODUCT_ID = 3;