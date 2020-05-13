package com.android.rahul.presentation.presenter

import java.net.URL

import com.android.rahul.domain.SystemInterface
import com.android.rahul.domain.interactor.MainInteractor
import com.android.rahul.domain.usecase.UserUseCase
import com.android.rahul.presentation.view.CoordinatorView

/**
 * Created by rahul khurana on 13.05.2020.
 */

class CoordinatorPresenter(system: SystemInterface) {

    private val interactor: MainInteractor
    private var view: CoordinatorView? = null

    init {
        interactor = MainInteractor(this, system)
    }

    fun setView(view: CoordinatorView) {
        this.view = view
    }

    fun start() {
        view!!.init()
    }

    fun onSearchInput(text: String) {
        interactor.onSearchInput(text)
    }

    fun onStartButton() {
        view!!.openSearchView()
        view!!.openUserList(UserListPresenter(interactor.userListUseCase!!))
    }

    fun onOpenUser(useCase: UserUseCase) {
        view!!.openUser(UserPresenter(useCase))
    }

    fun openInBrowser(url: URL) {
        view!!.openBrowser(url)
    }

    fun onFavoritesMenuClick() {
        interactor.onFavoritesOpen()
    }

    fun onBackPressed() {
        if (view!!.isUserOpened)
            view!!.closeUser()
        else
            view!!.closeView()
    }
}
