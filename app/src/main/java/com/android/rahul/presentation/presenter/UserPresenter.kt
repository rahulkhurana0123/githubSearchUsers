package com.android.rahul.presentation.presenter

import java.util.ArrayList

import com.android.rahul.domain.github_repo.GitHubRepository
import com.android.rahul.domain.github_repo.GitHubUser
import com.android.rahul.domain.interactor.UserModel
import com.android.rahul.domain.usecase.UserUseCase
import com.android.rahul.presentation.view.UserView

/**
 * Created by rahul khurana on 13.05.2020.
 */

class UserPresenter(private val interactor: UserUseCase) {
    private var view: UserView? = null

    private var user: GitHubUser? = null
    private var repos: ArrayList<GitHubRepository>? = null
    private var pinnedRepos: ArrayList<GitHubRepository>? = null

    fun setView(view: UserView) {
        this.view = view
    }

    fun start() {
        view!!.init()
        updateUser()
    }

    private fun updateUser() {
        val user = interactor.user
        repos = ArrayList<GitHubRepository>()
        view!!.setUser(user)
        interactor.getUser(this)
        interactor.getRepositories(this)
        //interactor.getPinnedRepositories(this);

    }

    fun onUserReceived(user: GitHubUser) {
        this.user = user
        view!!.setUser(user)
        view!!.hideUserLoading()
    }

    fun onReposReceived(repos: ArrayList<GitHubRepository>) {
        this.repos!!.addAll(repos)
        view!!.hideRepoLoading()
        if (pinnedRepos == null)
            view!!.notifyReposUpdate(0, this.repos!!.size)
        else
            updateReposWithPinned()
    }

    fun onPinnedReposReceived(repos: ArrayList<GitHubRepository>) {
        pinnedRepos = repos
        updateReposWithPinned()
    }

    private fun updateReposWithPinned() {
        if (repos == null || pinnedRepos == null) return
        for (repo in repos!!) {
            for (pinRepo in pinnedRepos!!) {
                if (repo.id == pinRepo.id) {
                    repos!!.remove(repo)
                    repos!!.add(0, repo)
                }
            }
        }
        view!!.notifyReposUpdate(0, repos!!.size)
    }

    fun openInBrowser() {
        interactor.openInBrowser()
    }

    fun onBackPressed() {
        view!!.closeView()
    }

    fun showLoadingError() {
        view!!.showLoadingError()
    }

    fun showParseError() {
        view!!.showParseError()
    }

    fun showUnexpectedError() {
        view!!.showUnexpectedError()
    }

    fun onFavorClick(userShort: UserModel) {
        userShort.setFavorite(!userShort.isFavorite())
        interactor.notifyFavorChanged(userShort)
    }

    fun getRepositoryAt(i: Int): GitHubRepository {
        return repos!![i]
    }

    fun onRepoClick(repository: GitHubRepository) {
        interactor.onRepoClick(repository)
    }

    val reposCount: Int
        get() = repos!!.size
}
