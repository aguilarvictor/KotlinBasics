package com.example.fighterverses.data

import com.example.fighterverses.R
import com.example.fighterverses.model.Verse

class Datasource {
    fun loadVerses(): List<Verse>{
        return listOf<Verse>(
            Verse(R.string.verse1, R.drawable.image1),
            Verse(R.string.verse2, R.drawable.image2),
            Verse(R.string.verse3, R.drawable.image3),
            Verse(R.string.verse4, R.drawable.image4),
            Verse(R.string.verse5, R.drawable.image5),
            Verse(R.string.verse6, R.drawable.image6),
            Verse(R.string.verse7, R.drawable.image7),
            Verse(R.string.verse8, R.drawable.image8),
            Verse(R.string.verse9, R.drawable.image9),
            Verse(R.string.verse10, R.drawable.image10),
            Verse(R.string.verse11, R.drawable.image11),
            Verse(R.string.verse12, R.drawable.image12),
            Verse(R.string.verse13, R.drawable.image13),
            Verse(R.string.verse14, R.drawable.image14),
            Verse(R.string.verse15, R.drawable.image15)
        )
    }
}