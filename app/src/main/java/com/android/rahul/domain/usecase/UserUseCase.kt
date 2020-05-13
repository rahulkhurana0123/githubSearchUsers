package com.android.rahul.domain.usecase

import com.android.rahul.domain.github_repo.GitHubRepository
import com.android.rahul.domain.interactor.UserModel
import com.android.rahul.presentation.presenter.UserPresenter

/**
 * Created by rahul khurana on 13.05.2020.
 */

interface UserUseCase {
    fun getUser(presenter: UserPresenter)
    val user: UserModel
    fun getRepositories(presenter: UserPresenter)
    fun getPinnedRepositories(presenter: UserPresenter)
    fun openInBrowser()
    fun notifyFavorChanged(userShort: UserModel)
    fun onRepoClick(repository: GitHubRepository)
}
