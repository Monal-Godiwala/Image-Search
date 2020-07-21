package com.mg.imagegallery.ui.imageLIst

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.mg.imagegallery.R
import com.mg.imagegallery.data.network.*
import com.mg.imagegallery.data.repository.ImageRepository
import kotlinx.android.synthetic.main.activity_image_search.*


class ImageSearchActivity : AppCompatActivity(), ApiListener {

    private lateinit var viewModel: ImageSearchViewModel

    //<editor-fold desc="Override Methods">
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_search)

        setupBindings()
        handleViews()
    }
    //</editor-fold>

    //<editor-fold desc="Private Methods">

    private fun setupBindings() {
        val imageRepository =
            ImageRepository(ApiInterface(NetworkConnectionInterceptor(this), HeaderInterceptor()))
        val factory = ImageSearchViewModelFactory(imageRepository)

        viewModel = ViewModelProvider(this, factory).get(ImageSearchViewModel::class.java)

        viewModel.apiListener = this

    }

    private fun handleViews() {

        /** Set up image grid view */
        list_image.apply {
            layoutManager =
                GridLayoutManager(this@ImageSearchActivity, 2, GridLayoutManager.VERTICAL, false)
        }

        /** Call API on Edittext text change */
        input_search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                viewModel.getImages(s.toString())
            }

            override fun afterTextChanged(s: Editable) {
            }

        })

    }

    //</editor-fold>

    //<editor-fold desc="API Call">

    override fun onStarted(requestCode: Int) {
        /** Show shimmer effect before API call */
        list_image.visibility = View.GONE
        group_no_data.visibility = View.GONE
        shimmer_list_image.startShimmer()
        shimmer_list_image.visibility = View.VISIBLE
    }

    override fun onSuccess(response: Any, requestCode: Int) {
        /** Populate adapter with response */
        val res = response as ImageResponse
        if (res.data != null && res.data?.size ?: 0 > 0) {
            list_image.visibility = View.VISIBLE
            group_no_data.visibility = View.GONE
            list_image.adapter =
                ImageListAdapter(this@ImageSearchActivity, res.data!!)
        } else {
            list_image.visibility = View.GONE
            group_no_data.visibility = View.VISIBLE
        }
        shimmer_list_image.stopShimmer()
        shimmer_list_image.visibility = View.GONE
    }

    override fun onFailure(message: String, requestCode: Int) {
        /** Handle API response failure */
        runOnUiThread {
            shimmer_list_image.stopShimmer()
            shimmer_list_image.visibility = View.GONE
            list_image.visibility = View.GONE
            group_no_data.visibility = View.VISIBLE
            Toast.makeText(this@ImageSearchActivity, message, Toast.LENGTH_SHORT).show()
        }
    }

    //</editor-fold>

}