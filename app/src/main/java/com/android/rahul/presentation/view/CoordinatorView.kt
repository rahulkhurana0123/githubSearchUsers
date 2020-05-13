package com.android.rahul.presentation.view

import java.net.URL

import com.android.rahul.presentation.presenter.UserListPresenter
import com.android.rahul.presentation.presenter.UserPresenter

/**
 * Created by rahul khurana on 13.05.2020.
 */

interface CoordinatorView {
    fun init()
    fun openSearchView()
    fun openUserList(presenter: UserListPresenter)
    fun openUser(presenter: UserPresenter)
    fun openBrowser(url: URL)
    fun closeView()
    fun closeUser()
    val isUserOpened: Boolean
}
