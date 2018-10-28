package com.ilgonmic.converter

import com.ilgonmic.converter.Ordinal.*
import org.junit.Assert.assertEquals
import org.junit.Test

class RussianConverterKtTest {

    val dictionary = mapOf(
        ZERO to "ноль",
        ONE to "один",
        TWO to "два",
        THREE to "три",
        FOUR to "четыре",
        FIVE to "пять",
        SIX to "шесть",
        SEVEN to "семь",
        EIGHT to "восемь",
        NINE to "девять",
        TEN to "десять",

        ELEVEN to "одиннадцать",
        TWELVE to "двенадцать",
        THIRTEEN to "тринадцать",
        FOURTEEN to "четырнадцать",
        FIFTEEN to "пятнадцать",
        SIXTEEN to "шестнадцать",
        SEVENTEEN to "семнадцать",
        EIGHTEEN to "восемнадцать",
        NINETEEN to "девятнадцать",

        TWENTY to "двадцать",
        THIRTY to "тридцать",
        FOURTY to "сорок",
        FIFTY to "пятьдесят",
        SIXTY to "шестьдесят",
        SEVENTY to "семьдесят",
        EIGHTY to "восемьдесят",
        NINETY to "девяносто",

        HUNDRED to "сто",
        HUNDRED_2 to "двести",
        HUNDRED_3 to "триста",
        HUNDRED_4 to "четыреста",
        HUNDRED_5 to "пятьсот",
        HUNDRED_6 to "шестьсот",
        HUNDRED_7 to "семьсот",
        HUNDRED_8 to "восемьсот",
        HUNDRED_9 to "девятьсот",

        THOUSAND to "тысяча"
    )

    @Test
    fun convert1000() {
        assertEquals(
            "тысяча",
            convert(1000, dictionary)
        )
    }

    @Test
    fun convert999() {
        assertEquals(
            "девятьсот девяносто девять",
            convert(999, dictionary)
        )
    }

    @Test
    fun convert811() {
        assertEquals(
            "восеьмсот одиннадцать",
            convert(911, dictionary)
        )
    }

    @Test
    fun convert701() {
        assertEquals(
            "семьсот один",
            convert(701, dictionary)
        )
    }

    @Test
    fun convert600() {
        assertEquals(
            "шестьсот",
            convert(600, dictionary)
        )
    }

    @Test
    fun convert42() {
        assertEquals(
            "сорок два",
            convert(42, dictionary)
        )
    }
}