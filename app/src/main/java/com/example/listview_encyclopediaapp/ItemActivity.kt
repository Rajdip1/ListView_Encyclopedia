package com.example.listview_encyclopediaapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.listview_encyclopediaapp.databinding.ItemActivityMainBinding
import com.example.listview_encyclopediaapp.ui.theme.ListView_EncyclopediaAppTheme
import de.hdodenhof.circleimageview.CircleImageView

class ItemActivity : ComponentActivity() {

    lateinit var binding: ItemActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ItemActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //getting info through intent
        val name = intent.getStringExtra("name")
        val sci_name = intent.getStringExtra("sciname")
        val species = intent.getStringExtra("sp")
        val places = intent.getStringExtra("plc")
        val imgeId = intent.getIntExtra("imgId", R.drawable.pic1)

//        val tvName = findViewById<TextView>(R.id.tvName)
//        val tvSciName = findViewById<TextView>(R.id.tvSciNmae)
//        val tvSpecies = findViewById<TextView>(R.id.tvSpecies)
//        val tvPlaces = findViewById<TextView>(R.id.tvPlaces)
//        val imageId = findViewById<CircleImageView>(R.id.profile_image)
//
//        tvName.text = name
//        tvSciName.text = sci_name
//        tvSpecies.text = species
//        tvPlaces.text = places
//        imageId.setImageResource(imgeId)

        binding.tvName?.text = name
        binding.tvSciname?.text = sci_name
        binding.tvSpecies?.text = species
        binding.tvPlaces?.text = places
        binding.profileImage?.setImageResource(imgeId)
    }
}

