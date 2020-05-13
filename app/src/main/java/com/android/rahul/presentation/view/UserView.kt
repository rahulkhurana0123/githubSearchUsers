package com.android.rahul.presentation.view

import com.android.rahul.domain.github_repo.GitHubUser
import com.android.rahul.domain.interactor.UserModel

/**
 * Created by rahul khurana on 13.05.2020.
 */

interface UserView {
    fun init()
    fun showWithAnimation()
    fun setUser(param: GitHubUser)
    fun setUser(userShort: UserModel)
    fun notifyReposUpdate(offset: Int, count: Int)
    fun closeView()
    fun showLoadingError()
    fun showParseError()
    fun showUnexpectedError()
    fun showUserLoading()
    fun hideUserLoading()
    fun showRepoLoading()
    fun hideRepoLoading()
}
