package com.example.codilitytest.ui.feature

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codilitytest.databinding.ActivityMainBinding
import com.example.codilitytest.ui.feature.adapter.DataAdapter
import com.example.kotlindemo.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var context: Context
    private val viewModel: MainActivityViewModel by viewModels()
//    lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            CodilityTestTheme {
////                DetailScreen()
//            }
//        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.getRoot()
        setContentView(view)

        context = this@MainActivity

//        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]


        binding.btnClick.setOnClickListener {
            viewModel.fetchDetailData();
            binding.wp7progressBar.showProgressBar()

            viewModel.detailData.observe(this, Observer { detailModelList ->
                binding.recyclerview.layoutManager = LinearLayoutManager(this)
                binding.wp7progressBar.hideProgressBar()
                val adapter = DataAdapter(detailModelList)
                binding.recyclerview.adapter = adapter

            })

        }
    }
}
