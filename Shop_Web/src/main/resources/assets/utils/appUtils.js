class AppUtils {

    static BASE_API_URL = 'http://localhost:8080/api'
    static BASE_PRODUCTS_API = this.BASE_API_URL + '/products'
    static BASE_BRANCHS_API = this.BASE_API_URL + '/branchs'
    static BASE_BANPRODUCT_API = this.BASE_API_URL + '/products/ban'
    static BASE_UNBANPRODUCT_API = this.BASE_API_URL + '/products/unBan'
    static BASE_ORDERSCONFIRMING_API = this.BASE_API_URL + '/orders/confirming'
    static BASE_ORDERSCONFIRMED_API = this.BASE_API_URL + '/orders/confirmed'
    static BASE_ORDERSCANCELED_API = this.BASE_API_URL + '/orders/canceled'
    static BASE_ORDERS_API = this.BASE_API_URL + '/orders'
    static BASE_ORDERSDETAILS_API = this.BASE_API_URL + '/orders/orderDetails'
    static BASE_PRODUCTIMPORTS_API = this.BASE_API_URL + '/product-imports'

    static BASE_CLOUDINARY_URL = 'https://res.cloudinary.com/dev-share/image/upload'
    static BASE_SCALE_700_530_100 = 'c_scale,w_700,h_530,q_100'
    static BASE_SCALE_280_200_85 = 'c_scale,w_280,h_200,q_85'

    static showSuccess = (text) => {
        $.toast({
            heading: 'Success',
            text: text,
            showHideTransition: 'slide',
            icon: 'success',
            position: 'top-right',
        })
    }

    static showError = (text) => {
        $.toast({
            heading: 'Error',
            text: text,
            showHideTransition: 'fade',
            icon: 'error',
            position: 'top-right',
        })
    }
}