package com.example.amazonapp.Helper;

/**
 * Created by admin on 08/11/2017.
 */

public class Config {
  // public static final String MAIN_URL = "http://development.ifuturz.com/core/FLAT_TEST/ecart_new/admin/webservice.php";


  public static final String GET_CATEGORIES="  http://18.216.15.198:3000/api/category/getcategories";
  public static final String LOGIN_USER="  http://18.216.15.198:3000/api/customeruser/authcustomeruser";
  public static final String POPULAR_PRODUCT=" http://18.216.15.198:3000/api/product/featureproduct?companyid=1";
  public static final String GET_COUNTERY=" http://18.216.15.198:3000/api/countries/country";
  public static final String PROVINCE=" http://18.216.15.198:3000/api/provinces/province";
  public static final String CREATEUSER="http://18.216.15.198:3000/api/customeruser/createcustomeruser";
  public static final String GETPRODCUTBYCATEGORY="http://18.216.15.198:3000/api/product/getproducts?category=";
  public static final String PRODUCTDETAILS="http://18.216.15.198:3000/api/product/getproductbyId?ProductId=";
  public static final String SEARCHPRODUCT="http://18.216.15.198:3000/api/product/getproducts?ProductName=";
  public static final String PURCHASEPRODUCT="http://18.216.15.198:3000/api/sales/createsales";
  public static final String FORGETPASSWORD="http://18.216.15.198:3000/api/customeruser/forgetPasswordCustomer";
  public static final String COMPANYDETAIL="http://18.216.15.198:3000/api/companyuser/getCompanyById?CompanyId=1";
  public static final String ORDERHISTORY=" http://18.216.15.198:3000/api/sales/getsalesbycustomerid";

}
