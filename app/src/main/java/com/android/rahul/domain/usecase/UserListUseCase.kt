package com.android.rahul.domain.usecase

import com.android.rahul.domain.interactor.UserModel
import com.android.rahul.presentation.presenter.UserListPresenter

/**
 * Created by rahul khurana on 13.05.2020.
 */

interface UserListUseCase {
    fun subscribe(presenter: UserListPresenter)
    fun updateList(limit: Int, offset: Int)
    fun openUser(user: UserModel)
    fun pushFavorite(user: UserModel)
}
