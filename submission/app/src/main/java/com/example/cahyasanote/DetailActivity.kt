package com.example.cahyasanote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cahyasanote.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"
    }

    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)


        val aDataSA = intent.getParcelableExtra<Architecture>(EXTRA_DATA) as Architecture

        detailBinding.ivSaDiagramDetailUI.setImageResource(aDataSA.archDiagram)

        detailBinding.ivSaIconDetailUI.setImageResource(aDataSA.archIcon)

        val saName = detailBinding.tvSaNameDetailUI
        saName.text = aDataSA.archName.toString()

        //detailBinding.tvSaNameDetailUI.text=aDataSA.archName


        val saDesc = detailBinding.tvSaDescDataDetailUI
        saDesc.text = aDataSA.archDesc

        //detailBinding.tvSaDescDataDetailUI.text=aDataSA.archDesc



        //detailBinding.tvSaUsageDataDetailUI.text=aDataSA.archUsage
        val saUsage = detailBinding.tvSaUsageDataDetailUI
        saUsage.text = aDataSA.archUsage


        //detailBinding.tvSaShortcomingDataDetailUI.text=aDataSA.archUsage
        val saShortcoming = detailBinding.tvSaShortcomingDataDetailUI
        saShortcoming.text = aDataSA.archShortcoming


    }
}