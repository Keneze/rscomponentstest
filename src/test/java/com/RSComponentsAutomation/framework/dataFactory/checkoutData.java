package com.RSComponentsAutomation.framework.dataFactory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class checkoutData {
     private String productPrice;
     private String productStockNo;
     private String quantity = "1";
     private String basketGrandTotal;
}
