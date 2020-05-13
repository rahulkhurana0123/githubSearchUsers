package com.android.rahul.presentation.view

/**
 * Created by rahul khurana on 13.05.2020.
 */

interface UserListView {

    fun init()
    fun notifyUsersAdded(offset: Int, count: Int)
    fun clearList()
    fun showLoadingError()
    fun showParseError()
    fun showUnexpectedError()
    fun closeView()
    fun hideLoading()
    fun showLoading()
    fun notifyUserChanged(i: Int)
}
