package com.nicholas.t04_2072008

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.nicholas.t04_2072008.databinding.EditProfileViewBinding

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: EditProfileViewBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = EditProfileViewBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.btnEditProf.setOnClickListener {
            val intent = Intent(this@EditProfileActivity, HomeActivity::class.java);
            intent.putExtra("nrp", binding.etNrp.text.toString());
            intent.putExtra("namaD", binding.etNamad.text.toString());
            intent.putExtra("namaB", binding.etnNamab.text.toString());
            intent.putExtra("email", binding.etEmail.text.toString());
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
        Log.d("cek", "$nrps");

        binding.etNrp.setText(nrps);
        binding.etNrp.isEnabled = false;
        binding.etNamad.setText(namad);
        binding.etnNamab.setText(namab);
        binding.etEmail.setText(emails);

    }
}