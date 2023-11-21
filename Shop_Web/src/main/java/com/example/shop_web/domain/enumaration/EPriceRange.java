<<<<<<<< HEAD:Shop_Web/src/main/java/com/example/shop_web/domain/enumaration/EPriceRange.java
package com.example.shop_web.domain.enumaration;
========
package com.example.shop_web.domain.enumDomain;
>>>>>>>> 201b73342554c322b0b1d87c3cf3347c4aca8a5d:Shop_Web/src/main/java/com/example/shop_web/domain/enumDomain/EPriceRange.java

public enum EPriceRange {
    DEFAULT(7, "Price Range"),
    UNDER_100_USD(1, "UNDER 100 USD"),
    RANGE_100_299_USD(2, "100 - 299 USD"),
    RANGE_300_499_USD(3, "300 - 499 USD"),
    RANGE_500_699_USD(4, "500 - 699 USD"),
    RANGE_700_999_USD(5, "700 - 999 USD"),
    OVER_999_USD(6, "OVER 999 USD");
    private int id;
    private String title;
    public int getId() {
        return id;
    }
    private EPriceRange(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public static EPriceRange getEPriceRange(String title) {
        for (EPriceRange ePriceRange : EPriceRange.values()) {
            if (ePriceRange.toString().equals(title)) {
                return ePriceRange;
            }
        }
        return null; // Trả về null nếu không tìm thấy EPriceRange phù hợp với title
    }
}

