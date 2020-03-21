package com.ashehata.uploadpdf

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val MY_REQUEST_CODE: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            val mimetypes = arrayOf("application/pdf")
            val intent = Intent().apply {
                type = "application/pdf"
                action = Intent.ACTION_GET_CONTENT
                putExtra(Intent.EXTRA_MIME_TYPES, mimetypes)
            }
            startActivityForResult(Intent.createChooser(intent, "Choose Pdf"), MY_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MY_REQUEST_CODE) {
            // Get the Uri of the selected file
            val uri: Uri? = data!!.data
            val uriString: String = uri.toString()
            Toast.makeText(this, uriString, Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(this, "empty", Toast.LENGTH_LONG).show()
        }
    }

}