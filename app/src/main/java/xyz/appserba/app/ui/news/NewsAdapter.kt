package xyz.appserba.app.ui.news

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import xyz.appserba.app.R
import xyz.appserba.app.data.model.Attributes
import xyz.appserba.app.databinding.ItemNewsBinding
import xyz.appserba.app.ui.base.BaseAdapter

class NewsAdapter(val context: Context) : BaseAdapter<Attributes>(R.layout.item_news) {
    override fun onBind(binding: ViewDataBinding?, data: Attributes) {
        val mBinding = binding as ItemNewsBinding
        Glide.with(context).load(data.pic).into(mBinding.itemPic)

    }

    override fun onClick(binding: ViewDataBinding?, data: Attributes) {
        val intent = Intent(context, NewsActivity::class.java)
        intent.putExtra(NewsActivity.OPEN_NEWS, data)
        context.startActivity(intent)
    }
}