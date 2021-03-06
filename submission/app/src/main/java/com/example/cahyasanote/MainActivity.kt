package com.example.cahyasanote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cahyasanote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val swArchlist = ArrayList<Architecture>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //[1. set fixed size recyler view]
        binding.rvItemSaUI.setHasFixedSize(true)

        //[2. call data]
        swArchlist.addAll(listOfSWArch)


        //[3. show the Recyclerlist]
        showArcRecylerList()

    }

    //[--3. define the func. to show the Recycler list]
    private fun showArcRecylerList() {
        binding.rvItemSaUI.layoutManager = LinearLayoutManager(this)

        val listSWArchAdapter = ListArchAdapter(swArchlist)
        binding.rvItemSaUI.adapter = listSWArchAdapter


        //[--4 click item for toast]
        listSWArchAdapter.setOnItemClickCallback(object :ListArchAdapter.OnItemClickCallback {
            override fun onItemClicked(dataArch: Architecture) {
                anItemClicked(dataArch)

                val intentDataArchToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                //[5.to DetailActivity data]
                intentDataArchToDetail.putExtra("EXTRA_DATA", dataArch)
                startActivity(intentDataArchToDetail)

            }
        })
    }


    //[--2.create listOfSwArch from string,xml]
    private val listOfSWArch:ArrayList<Architecture>
        get() {
            val archDataName = resources.getStringArray(R.array.data_sa_name)
            val archDataDesc = resources.getStringArray(R.array.data_sa_description)
            val archDataUsage = resources.getStringArray(R.array.data_sa_usage)
            val archDataShortcoming = resources.getStringArray(R.array.data_sa_shortcomings)
            val archDataDiagram = resources.obtainTypedArray(R.array.data_sa_diagram)
            val archDataIcon = resources.obtainTypedArray(R.array.data_sa_icon)
            val archExpl = resources.getStringArray(R.array.data_sa_explanation)

            val listOfDataSWArch = ArrayList<Architecture>()
            for(i in archDataName.indices) {
                val swArch = Architecture(archDataName[i],archDataDesc[i],archDataUsage[i],archDataShortcoming[i], archDataDiagram.getResourceId(i,-1), archDataIcon.getResourceId(i,-1), archExpl[i])

                listOfDataSWArch.add(swArch)
            }
            archDataDiagram.recycle()
            archDataIcon.recycle()

            return listOfDataSWArch
        }


    //[4.click an item]
    private fun anItemClicked(architecture: Architecture) {
        Toast.makeText(this, "${architecture.archName} detail", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.about_menu) {
            val intentToAbout = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intentToAbout)
        }
        return super.onOptionsItemSelected(item)
    }


}