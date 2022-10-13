package com.nicholas.t04_2072008

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.nicholas.t04_2072008.databinding.HomeViewBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: HomeViewBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = HomeViewBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.btnEditProf.setOnClickListener {
            val intent = Intent(this@HomeActivity, EditProfileActivity::class.java);
            intent.putExtra("nrp", binding.tvNrp.text.toString());
            intent.putExtra("namaD", binding.tvNamad.text.toString());
            intent.putExtra("namaB", binding.tvNamab.text.toString());
            intent.putExtra("email", binding.tvEmail.text.toString());
            startActivity(intent);
            this.finish();
        }

    }

    override fun onStart() {
        super.onStart();
        val nrps = intent.getStringExtra("nrp");
        val namad = intent.getStringExtra("namaD");
        val namab = intent.getStringExtra("namaB");
        val emails = intent.getStringExtra("email");

        binding.tvNrp.text = nrps.toString();
        binding.tvNamad.text = namad.toString();
        binding.tvNamab.text = namab.toString();
        binding.tvEmail.text = emails.toString();


    }
}