package com.example.fighterverses

import android.content.Context
import com.example.fighterverses.adapter.ItemAdapter
import com.example.fighterverses.model.Verse
import org.junit.Test

import org.junit.Assert.*
import org.mockito.MockedConstruction
import org.mockito.Mockito.mock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FighterVersesUnitTest {
    private val context = mock(Context::class.java)

    /* Verify size of the adapter equals size of the list passed to the adapter */
    @Test
    fun adapter_size() {
        /* List for testing purpose */
        val data = listOf(
            Verse(R.string.verse1, R.drawable.image1),
            Verse(R.string.verse2, R.drawable.image2)
        )
        val adapter = ItemAdapter(context, data)

        assertEquals("ItemAdapter is not the correct size:", data.size, adapter.itemCount)
    }
}