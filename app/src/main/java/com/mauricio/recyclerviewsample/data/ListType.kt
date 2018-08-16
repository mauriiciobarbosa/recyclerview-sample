package com.mauricio.recyclerviewsample.data

enum class ListType(val id: Int) {
    LIST(1), GRID(2), STAGGERED_GRID(3);

    companion object {
        fun getById(id: String) : ListType = when (id) {
            "1" -> LIST
            "2" -> GRID
            "3" -> STAGGERED_GRID
            else -> throw IllegalArgumentException("Enum id doesn't exist")
        }
    }


}