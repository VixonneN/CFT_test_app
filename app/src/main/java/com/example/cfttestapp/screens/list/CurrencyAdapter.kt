package com.example.cfttestapp.screens.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cfttestapp.R
import com.example.cfttestapp.models.CurrencyInfo
import com.example.cfttestapp.models.Time
import kotlinx.android.synthetic.main.currency_item.view.*

class CurrencyAdapter: RecyclerView.Adapter<CurrencyAdapter.CurrentHolder>() {

    private var mListCurrency = emptyList<CurrencyInfo>()

    class CurrentHolder(view: View): RecyclerView.ViewHolder(view){
        val shortNameCurrency: TextView = view.currency_short_name
        val longNameCurrency: TextView = view.currency_long_name
        val counterAfter: TextView = view.count_current
        val nominal: TextView = view.nominal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.currency_item, parent, false)
        return CurrentHolder(view)
    }

    override fun onBindViewHolder(holder: CurrentHolder, position: Int) {
        holder.shortNameCurrency.text = mListCurrency[position].charCode
        holder.longNameCurrency.text = mListCurrency[position].name
        holder.counterAfter.text = mListCurrency[position].value.toString()
        holder.nominal.text = mListCurrency[position].nominal.toString()
    }

    override fun getItemCount(): Int = mListCurrency.size

    fun setList(list: MutableList<CurrencyInfo>) {
        mListCurrency = list
        notifyDataSetChanged()
    }

}