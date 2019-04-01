package com.qingmei2.samplepaging.ui.header_multitype

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.qingmei2.samplepaging.R
import com.qingmei2.samplepaging.ui.header_proxy.HeaderProxyAdapter
import com.qingmei2.samplepaging.viewmodel.CommonViewModel
import kotlinx.android.synthetic.main.activity_basic_usage.*

class HeaderMultiTypeActivity : AppCompatActivity() {

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T = CommonViewModel(application) as T
        }).get(CommonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_header_usage)

        val adapter = HeaderProxyAdapter()
        recyclerView.adapter = adapter

        viewModel.allStudents.observe(this, Observer { adapter.submitList(it) })
    }
}
