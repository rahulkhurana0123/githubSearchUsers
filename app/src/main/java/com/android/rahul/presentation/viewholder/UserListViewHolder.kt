package com.android.rahul.presentation.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup

import com.android.rahul.R

/**
 * Created by rahul khurana on 13.05.2020.
 */

class UserListViewHolder(parent: ViewGroup) {

    var recyclerView: androidx.recyclerview.widget.RecyclerView

    init {
        recyclerView = LayoutInflater.from(parent.context).inflate(R.layout.user_list_layout, parent, false) as androidx.recyclerview.widget.RecyclerView
    }
}
