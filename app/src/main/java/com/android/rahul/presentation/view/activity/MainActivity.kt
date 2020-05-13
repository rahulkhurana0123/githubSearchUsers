package com.android.rahul.presentation.view.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup

import com.arlib.floatingsearchview.FloatingSearchView
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion

import java.net.URL

import com.android.rahul.R
import com.android.rahul.presentation.AndroidInterface
import com.android.rahul.presentation.presenter.CoordinatorPresenter
import com.android.rahul.presentation.presenter.UserListPresenter
import com.android.rahul.presentation.presenter.UserPresenter
import com.android.rahul.presentation.utils.AViewContainer
import com.android.rahul.presentation.view.CoordinatorView
import com.android.rahul.presentation.view.aview.UserAView
import com.android.rahul.presentation.view.aview.UserListAView
import com.android.rahul.presentation.view.view_etc.AnimationManager
import com.android.rahul.presentation.view.view_etc.PermissionManager
import com.android.rahul.presentation.view.view_etc.SuggestionsManager
import com.android.rahul.presentation.viewholder.MainViewHolder

class MainActivity : AppCompatActivity(), CoordinatorView {

    private var presenter: CoordinatorPresenter? = null
    private var permissionManager: PermissionManager? = null
    private var suggestionsManager: SuggestionsManager? = null
    private var viewHolder: MainViewHolder? = null
    private var userContainer: AViewContainer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewHolder = MainViewHolder(findViewById(R.id.activity_main) as ViewGroup)
        permissionManager = PermissionManager(this)
        permissionManager!!.requestBasePermissions(this) {
            presenter = CoordinatorPresenter(AndroidInterface(this@MainActivity))
            presenter!!.setView(this@MainActivity)
            presenter!!.start()
        }
    }

    override fun init() {
        val onStartBtn = View.OnClickListener { presenter!!.onStartButton() }
        viewHolder!!.helloContent.setOnClickListener(onStartBtn)
        viewHolder!!.searchImage.setOnClickListener(onStartBtn)
        suggestionsManager = SuggestionsManager(viewHolder!!.searchView)
        suggestionsManager!!.init()
        viewHolder!!.searchView.setOnSearchListener(object : FloatingSearchView.OnSearchListener {
            override fun onSuggestionClicked(searchSuggestion: SearchSuggestion) {
                presenter!!.onSearchInput(searchSuggestion.body)
            }

            override fun onSearchAction(currentQuery: String) {
                suggestionsManager!!.saveSuggestion(currentQuery.trim { it <= ' ' })
                presenter!!.onSearchInput(currentQuery)
            }
        })
        viewHolder!!.searchView.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.favorites -> {
                    viewHolder!!.searchView.clearQuery()
                    viewHolder!!.searchView.clearSearchFocus()
                    presenter!!.onFavoritesMenuClick()
                }
            }
        }
        viewHolder!!.searchView.setOnQueryChangeListener { _, newQuery -> suggestionsManager!!.suggest(newQuery) }
        viewHolder!!.searchView.setOnFocusChangeListener(object : FloatingSearchView.OnFocusChangeListener {
            override fun onFocus() {
                suggestionsManager!!.suggest(viewHolder!!.searchView.query)
            }

            override fun onFocusCleared() {

            }
        })
        userContainer = AViewContainer(viewHolder!!.viewContainer)
    }

    override fun openSearchView() {
        viewHolder!!.searchImage.setOnClickListener(null)
        viewHolder!!.helloContent.setOnClickListener(null)
        AnimationManager.openSearchView(viewHolder) { viewHolder!!.searchView.setSearchFocused(true) }
    }

    override fun openUserList(presenter: UserListPresenter) {
        UserListAView(AViewContainer(viewHolder!!.userSearchContent), presenter).open()
    }

    override fun openUser(presenter: UserPresenter) {
        UserAView(userContainer!!, presenter).open()
    }

    override fun openBrowser(url: URL) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url.toString())))
    }

    override fun closeView() {
        finish()
    }

    override fun closeUser() {
        userContainer!!.closeView()
    }

    override val isUserOpened: Boolean
        get() = userContainer!!.viewOpened()

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        permissionManager!!.onPermissionCallback(requestCode, permissions, grantResults)
    }

    override fun onBackPressed() {
        presenter!!.onBackPressed()
    }
}
