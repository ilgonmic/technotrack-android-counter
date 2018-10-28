package com.ilgonmic.converter

import com.ilgonmic.converter.Ordinal.*
import org.junit.Assert.assertEquals
import org.junit.Test

class ConverterKtTest {

    @Test
    fun convertHundreds1() {
        assertEquals(
            listOf(HUNDRED),
            convertHundreds(100)
        )
    }

    @Test
    fun convertHundreds110() {
        assertEquals(
            listOf(HUNDRED, TEN),
            convertHundreds(110)
        )
    }

    @Test
    fun convertHundreds201() {
        assertEquals(
            listOf(HUNDRED_2, ONE),
            convertHundreds(201)
        )
    }

    @Test
    fun convertHundreds999() {
        assertEquals(
            listOf(HUNDRED_9, NINETY, NINE),
            convertHundreds(999)
        )
    }

    @Test
    fun convertDecimals11() {
        assertEquals(
            listOf(ELEVEN),
            convertDecimals(11)
        )
    }

    @Test
    fun convertDecimals25() {
        assertEquals(
            listOf(TWENTY, FIVE),
            convertDecimals(25)
        )
    }

    @Test
    fun convertUnits7() {
        assertEquals(
            listOf(SEVEN),
            convertDecimals(7)
        )
    }
}