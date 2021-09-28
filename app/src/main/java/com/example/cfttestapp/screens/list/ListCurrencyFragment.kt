package com.example.cfttestapp.screens.list

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cfttestapp.R
import com.example.cfttestapp.databinding.FragmentListCurrencyBinding
import com.example.cfttestapp.models.CurrencyInfo
import com.example.cfttestapp.models.Time

class ListCurrencyFragment : Fragment() {

    private var binding: FragmentListCurrencyBinding? = null
    private val mBinding get() = binding!!

    private lateinit var mViewModel: ListCurrencyViewModel

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: CurrencyAdapter

    private lateinit var mObserverList: Observer<Time>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListCurrencyBinding.inflate(layoutInflater, container, false)

        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mAdapter = CurrencyAdapter()
        mRecyclerView = mBinding.recycler
        mRecyclerView.adapter = mAdapter
        mObserverList = Observer {
            val list = mViewModel.getDataToList(it.currency)
            Log.d(TAG, "initialization: ${it.currency}")
            mAdapter.setList(list)
        }

        mViewModel = ViewModelProvider(this).get(ListCurrencyViewModel::class.java)
        mViewModel.getCurrency()
        mViewModel.currencyList.observe(this, mObserverList)

        //кнопка обновления
        mBinding.btnRefresh.setOnClickListener {
            mViewModel.getCurrency()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        mViewModel.currencyList.removeObserver(mObserverList)
        mRecyclerView.adapter = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.refresh_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.bnt_refresh_currency_request -> {
                mViewModel.getCurrency()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
