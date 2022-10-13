package com.nicholas.t04_2072008

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.nicholas.t04_2072008.databinding.LoginViewBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginViewBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginViewBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.button.setOnClickListener {
            val nrp = binding.etEmail.text.toString();
            val pass = binding.etPassword.text.toString();
            if ((nrp.equals("2072008") && (pass.equals("1")))) {
                val intent = Intent(this@LoginActivity, HomeActivity::class.java);
                intent.putExtra("nrp", nrp);
                intent.putExtra("namaD", "Nicholas C");
                intent.putExtra("namaB", "Hanafi");
                intent.putExtra("email", "2072008@maranatha.ac.id");
                startActivity(intent);
                this.finish();
            } else {
                if (nrp.trim().isEmpty()) {
                    binding.etEmail.error = resources.getString(R.string.msg_err_empty_email);
                }
                if (pass.trim().isEmpty()) {
                    binding.etPassword.error = resources.getString(R.string.msg_err_empty_pass);
                }
                Snackbar.make(
                    this,
                    binding.button,
                    resources.getString(R.string.msg_failed),
                    Snackbar.LENGTH_SHORT
                ).show();

            }
        }
    }
}