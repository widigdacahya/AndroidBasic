package com.example.cahyasanote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cahyasanote.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)


        val aDataSA = intent.getParcelableExtra<Architecture>(EXTRA_DATA) as Architecture

        detailBinding.apply {
            ivSaDiagramDetailUI.setImageResource(aDataSA.archDiagram)
            ivSaIconDetailUI.setImageResource(aDataSA.archIcon)
            tvSaNameDetailUI.text  = aDataSA.archName
            tvSaDescDataDetailUI.text = aDataSA.archDesc
            tvSaUsageDataDetailUI.text = aDataSA.archUsage
            tvSaShortcomingDataDetailUI.text = aDataSA.archShortcoming
            tvSaMoreexpDataDetailUI.text = aDataSA.archExp
        }

        supportActionBar?.title = aDataSA.archName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"
    }
}