package com.cammace.rothko.core.results

import androidx.annotation.StringRes

/**
 * A generic class that holds a value with its loading status.
 */
data class Resource<out T>(val status: Status, val data: T?, val message: String?, @StringRes val msgRes: Int?) {

    /**
     * Status of a resource that is provided to the UI.
     */
    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null, null)
        }

        fun <T> error(data: T?, msg: String? = null, @StringRes msgRes: Int? = null): Resource<T> {
            return Resource(Status.ERROR, data, msg, msgRes)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null, null)
        }
    }
}
