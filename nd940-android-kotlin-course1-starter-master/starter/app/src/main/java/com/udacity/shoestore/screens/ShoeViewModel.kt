package com.udacity.shoestore.screens

import androidx.lifecycle.ViewModel

class ShoeViewModel: ViewModel() {


    //Lists of show details
    private val ultraBeat = ShoeItem("Ultrabeat", "Abidas", 42, "Ideal for outside running")
    private val airForza = ShoeItem("Air Forza", "Mike", 44, "Train with style")
    private val fakeTechque = ShoeItem("Fake Techque", "Redbook", 43, "The weekender classic")
    private val checoMx = ShoeItem("Checo MX", "Pumba", 42, "Win as the 3rd best in F1 2021")
    private val yeeja = ShoeItem("Yeeja", "Abidas", 41, "The plug-and-play of the shoes")

    val shoeList = mutableListOf<ShoeItem>(
        ultraBeat,
        airForza,
        fakeTechque,
        checoMx,
        yeeja
    )


}

class ShoeItem(val name : String, val company: String, val size: Int, val description: String){

}
