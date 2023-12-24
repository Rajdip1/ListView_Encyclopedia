package com.example.listview_encyclopediaapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.listview_encyclopediaapp.databinding.ActivityMainBinding
import com.example.listview_encyclopediaapp.ui.theme.ListView_EncyclopediaAppTheme

class MainActivity : ComponentActivity() {

    lateinit var itemArrayList : ArrayList<Item>

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //data of items
        val flower_name  = arrayOf("Rose", "Lily", "Sunflower", "Orchid", "Jasmine", "Daisy", "Tulip")

        val sci_nameOfFlower = arrayOf("Rosa Rubiginosa", "Lilium", "Helianthus annuus", "Orchidaceae",
            "Jasminum", "Bellis perennis", "Tulipa")

        val species = arrayOf("Rosaceae", "Liliaceae", "Unknown", "Orchidaceae", "Oleaceae", "Unknown",
            "Liliaceae")

        val place = arrayOf("Anywhere in the world", "Northern Hemisphere", "Anywhere in the world",
            "Tropical rainforests to Arctic Tundra", "Subtropical region og Eurasia, Africa and Oceania",
            "garderns", "Central Asia")

        val image = intArrayOf(R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,
            R.drawable.pic6,R.drawable.pic7)

        //initialized item arrayList
        itemArrayList= ArrayList()

        //startingIndex means starts from '0'
        for (startingIndex in flower_name.indices){
            val items = Item(flower_name[startingIndex],
                sci_nameOfFlower[startingIndex],
                species[startingIndex],
                place[startingIndex],
                image[startingIndex])

            //adding items one by one
            itemArrayList.add(items)
        }
        binding.listViewEncyclopedia.isClickable = true

        //set adapter
        binding.listViewEncyclopedia.adapter = MyAdapter(this, itemArrayList)

        //actions perform when click on each item
        binding.listViewEncyclopedia.setOnItemClickListener { parent, view, position, id ->
            //took all info of each item
            val name = flower_name[position]
            val sciname = sci_nameOfFlower[position]
            val sp = species[position]
            val plc = place[position]
            val imgId = image[position]

            //open new actiivuty
            val itemActivity = Intent(this, ItemActivity::class.java)
            itemActivity.putExtra("name",name)
            itemActivity.putExtra("sci_name",sciname)
            itemActivity.putExtra("species",sp)
            itemActivity.putExtra("placeToFound",plc)
            itemActivity.putExtra("img",imgId)
            startActivity(itemActivity)
        }
    }
}

