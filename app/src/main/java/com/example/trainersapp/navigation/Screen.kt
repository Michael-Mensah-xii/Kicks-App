package com.example.trainersapp.navigation

sealed class Screen(val route: String ){
     object LoadingPage:Screen( "onBoarding")
     object SignUpScreen:Screen( "signUp")
     object HomeScreen:Screen( "home")
     object ShoeViewPage:Screen( "details/{item}")
     object SimilarMatchRow:Screen( "similar_items")
     object CartScreen:Screen( "cart")
     object PaymentList:Screen( "pay_select")
     object VisaPaymentScreen:Screen( "visa_select")
     object MastercardPaymentScreen:Screen( "mastercard_select")

     fun createRouteWithItem(item : Int):String {
          return "details/$item"
     }
}
