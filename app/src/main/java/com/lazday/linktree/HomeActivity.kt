package com.lazday.linktree

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val image = findViewById<ImageView>(R.id.image)
        val title = findViewById<TextView>(R.id.title)
        val subtitle = findViewById<TextView>(R.id.subtitle)
        val list = findViewById<RecyclerView>(R.id.list)

        image.setImageResource(R.drawable.avatar)
        title.text = "Muhammad Irsyad"
        subtitle.text = "Android Developer"
        list.adapter = linkAdapter
    }

    private val linkAdapter by lazy {
        val items = listOf<LinktreeModel>(
            LinktreeModel("WhatsApp", R.drawable.wa, "https://wa.me/6285746182445"),
            LinktreeModel("Instagram", R.drawable.ig, "https://www.instagram.com/lazdayid/"),
            LinktreeModel("Facebook", R.drawable.fb, "https://facebook.com/lazdayid"),
            LinktreeModel("YouTube", R.drawable.yt, "https://youtube.com/channel/UCnJFFAhsxC1DWrJqySPPAIw"),
            LinktreeModel("Website", R.drawable.web, "https://lazday.com/"),
        )
        LinkAdapter(items, object : LinkAdapter.AdapterListener{
            override fun onClick(link: LinktreeModel) {
                openUrl( link.url )
            }
        })
    }

    private fun openUrl(url: String) {
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse( url )
        startActivity(openURL)
    }
}