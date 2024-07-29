package fr.gobelins.dmi1

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHomeCompute = findViewById(R.id.btn_home_compute)

        btnHomeCompute.setOnClickListener {
            val intent = Intent(this, ComputeActivity::class.java)
            intent.extras?.putString("operation", "ADD")
            startActivity(intent)
        }
        btnEmergencyCall = findViewById(R.id.btn_emergency_call)

        btnEmergencyCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:911") // Remplacez "911" par le numéro d'urgence approprié pour votre région
            startActivity(intent)
        }
        btnGoogleSearch = findViewById(R.id.btn_google_search)

        btnGoogleSearch.setOnClickListener {
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, "Recherche Google")
            startActivity(intent)
        }
        btnShareMessage = findViewById(R.id.btn_share_message)

        btnShareMessage.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Votre message à partager")
            startActivity(Intent.createChooser(intent, "Partager via"))
        }
        btnLaunchMaps = findViewById(R.id.btn_launch_maps)

        btnLaunchMaps.setOnClickListener {
            val gmmIntentUri = Uri.parse("google.navigation:q=1+Infinite+Loop,+Cupertino,+California")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
    private lateinit var btnHomeCompute: Button
    private lateinit var btnEmergencyCall: Button
    private lateinit var btnGoogleSearch: Button
    private lateinit var btnShareMessage: Button
    private lateinit var btnLaunchMaps: Button
}



