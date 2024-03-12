package com.example.task7.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.task7.R
import com.example.task7.data.entity.Yapilacaklar
import com.example.task7.databinding.CardTasarimBinding
import com.example.task7.ui.fragment.AnasayfaFragmentDirections
import com.example.task7.ui.viewmodel.AnasayfaViewModel
import com.example.task7.utils.gecis
import com.google.android.material.snackbar.Snackbar

class YapilacaklarAdapter(
    var mContext: Context,
    var yapilacaklarListesi: List<Yapilacaklar>,
    var viewModel: AnasayfaViewModel
) : RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: YapilacaklarAdapter.CardTasarimTutucu, position: Int) {
        val yapilacak = yapilacaklarListesi[position]
        val tasarim = holder.tasarim
        tasarim.textViewYapilacakText.text = yapilacak.yapilacakText

        tasarim.imageViewSil.setOnClickListener {
            Snackbar.make(it, "Bu not silinsin mi?", Snackbar.LENGTH_SHORT)
                .setBackgroundTint(ContextCompat.getColor(mContext, R.color.favColor))
                .setActionTextColor(ContextCompat.getColor(mContext, R.color.black))
                .setTextColor(ContextCompat.getColor(mContext, R.color.black))
                .setAction("EVET") {
                    sil(yapilacak.yapilacakID)
                }.show()
        }

        tasarim.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.yapilacakDetayGecis(yapilacak = yapilacak)
            Navigation.gecis(it, gecis)
        }

    }

    override fun getItemCount(): Int {
        return yapilacaklarListesi.size
    }

    fun sil(yapilacakID: Int) {
        viewModel.sil(yapilacakID)
    }

}