package com.mg.imagegallery.ui.imageDetail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mg.imagegallery.R
import com.mg.imagegallery.data.database.AppDatabase
import com.mg.imagegallery.data.network.ImageResponse
import kotlinx.android.synthetic.main.activity_image_detail.*

class ImageDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: ImageDetailViewModel

    //<editor-fold desc="Override Methods">

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)
        setSupportActionBar(toolbar)

        /** Set Toolbar back icon */
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        setupBindings()
        handleViews()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    //</editor-fold>

    private fun setupBindings() {

        val intent = intent
        val imageDetail = intent.getSerializableExtra("imageObject") as ImageResponse.Data?

        val factory = ImageDetailViewModelFactory(imageDetail, AppDatabase(this))

        viewModel = ViewModelProvider(this, factory).get(ImageDetailViewModel::class.java)

    }

    private fun handleViews() {

        /** Set toolbar title */
        title = viewModel.imageDetail?.title

        viewModel.imageDetail?.let { imageData ->

            /** Set larger image */
            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.image_load)
            Glide.with(this@ImageDetailActivity).load(viewModel.getImageUrl()).apply(options)
                .into(image_detail)

            /** Setup recyclerview */
            list_comment.apply {
                layoutManager = LinearLayoutManager(this@ImageDetailActivity)
            }

            /** Load existing comment */
            imageData.id?.let { imageId ->
                viewModel.refreshCommentList(imageId)
            }

            /** Populate comment adapter with existing comments */
            viewModel.commentList.observe(this@ImageDetailActivity, Observer { comments ->
                list_comment.adapter = CommentListAdapter(comments)
            })

        }

        button_submit.setOnClickListener {
            /** Insert comment to local database */
            if (input_comment.text?.toString()?.length ?: 0 > 0) {
                viewModel.insertComment(input_comment.text.toString())
                input_comment.text.clear()
            } else {
                Toast.makeText(
                    this@ImageDetailActivity,
                    getString(R.string.message_add_comment),
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

    }

}