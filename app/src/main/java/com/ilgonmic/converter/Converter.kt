package com.ilgonmic.converter

import com.ilgonmic.converter.Ordinal.*

fun Int.length() = when (this) {
    0 -> 1
    else -> Math.log10(Math.abs(toDouble())).toInt() + 1
}

fun convert(
    value: Int,
    convertMap: Map<Ordinal, String>
): String {

    if (value in 11..19) {
        return convertDecimals(value)
            .asSequence()
            .map {
                convertMap.getOrElse(it) {
                    throw IllegalArgumentException("Convert map doesn't contain value for $value")
                }
            }
            .joinToString(separator = " ") { it }

    }

    val order = value.length() - 1

    return when (order) {
        1 -> convertUnits(value)
        2 -> convertDecimals(value)
        3 -> convertHundreds(value)
        4 -> listOf(THOUSAND)
        else -> throw IllegalArgumentException("Unable to convert to tens $value")
    }.asSequence()
        .map {
            convertMap.getOrElse(it) {
                throw IllegalArgumentException("Convert map doesn't contain value for $value")
            }
        }
        .joinToString(separator = " ") { it }

}

fun convertHundreds(value: Int): List<Ordinal> {
    return listOf(
        when (value) {
            in 100..199 -> HUNDRED
            in 200..299 -> HUNDRED_2
            in 300..399 -> HUNDRED_3
            in 400..499 -> HUNDRED_4
            in 500..599 -> HUNDRED_5
            in 600..699 -> HUNDRED_6
            in 700..799 -> HUNDRED_7
            in 800..899 -> HUNDRED_8
            in 900..999 -> HUNDRED_9
            else -> throw IllegalArgumentException("Unable to convert to hundreds $value")
        }
    ) + convertDecimals(value % 100)
}

fun convertDecimals(value: Int): List<Ordinal> {

    if (value.length() == 1) {
        return convertUnits(value)
    }

    return when (value) {
        0 -> emptyList()
        10 -> listOf(TEN)
        11 -> listOf(ELEVEN)
        12 -> listOf(TWELVE)
        13 -> listOf(THIRTEEN)
        14 -> listOf(FOURTEEN)
        15 -> listOf(FIFTEEN)
        16 -> listOf(SIXTEEN)
        17 -> listOf(SEVENTEEN)
        18 -> listOf(EIGHTEEN)
        19 -> listOf(NINETEEN)
        in 20..29 -> listOf(TWENTY) + convertUnits(value % 10)
        in 30..39 -> listOf(THIRTY) + convertUnits(value % 10)
        in 40..49 -> listOf(FOURTY) + convertUnits(value % 10)
        in 50..59 -> listOf(FIFTY) + convertUnits(value % 10)
        in 60..69 -> listOf(SIXTY) + convertUnits(value % 10)
        in 70..79 -> listOf(SEVENTY) + convertUnits(value % 10)
        in 80..89 -> listOf(EIGHTY) + convertUnits(value % 10)
        in 90..99 -> listOf(NINETY) + convertUnits(value % 10)
        else -> throw IllegalArgumentException("Unable to convert to tens $value")
    }
}

fun convertUnits(value: Int): List<Ordinal> {
    if (value == 0) {
        return emptyList()
    }

    return listOf(
        when (value) {
            1 -> ONE
            2 -> TWO
            3 -> THREE
            4 -> FOUR
            5 -> FIVE
            6 -> SIX
            7 -> SEVEN
            8 -> EIGHT
            9 -> NINE
            else -> throw IllegalArgumentException("Unable to convert to units $value")
        }
    )
}

enum class Ordinal {
    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,

    ELEVEN,
    TWELVE,
    THIRTEEN,
    FOURTEEN,
    FIFTEEN,
    SIXTEEN,
    SEVENTEEN,
    EIGHTEEN,
    NINETEEN,

    TWENTY,
    THIRTY,
    FOURTY,
    FIFTY,
    SIXTY,
    SEVENTY,
    EIGHTY,
    NINETY,

    HUNDRED,
    HUNDRED_2,
    HUNDRED_3,
    HUNDRED_4,
    HUNDRED_5,
    HUNDRED_6,
    HUNDRED_7,
    HUNDRED_8,
    HUNDRED_9,

    THOUSAND
}