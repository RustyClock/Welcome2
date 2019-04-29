package com.rustyclock.welcome2

data class Card(val value: Int, val type: String) {

    fun getIcon(): Int {
        when (type) {
            TYPE_BIS -> return R.drawable.ic_mail
            TYPE_POOL -> return R.drawable.ic_swimming_pool
            TYPE_FOREST -> return R.drawable.ic_forest
            TYPE_FENCE -> return R.drawable.ic_fence
            TYPE_VALUE -> return R.drawable.ic_real_estate
            TYPE_CONSTRUCTION -> return R.drawable.ic_barrier
        }

        return 0
    }

    companion object {
        const val TYPE_POOL = "POOL"
        const val TYPE_FOREST = "FOREST"
        const val TYPE_VALUE = "VALUE"
        const val TYPE_CONSTRUCTION = "CONSTRUCTION"
        const val TYPE_BIS = "BIS"
        const val TYPE_FENCE = "FENCE"
    }

}