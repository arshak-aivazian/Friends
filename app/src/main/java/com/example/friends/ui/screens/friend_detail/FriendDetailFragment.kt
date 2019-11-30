package com.example.friends.ui.screens.friend_detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.friends.MyApp
import com.example.friends.R
import com.example.friends.model.entity.friends.VkFriend
import com.example.friends.ui.cicerone.FriendDetailScreen
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_friend_detail.*

class FriendDetailFragment : MvpAppCompatFragment(),
    FriendsDetailView {

    companion object{
        fun getNewInstance(): FriendDetailFragment {
            return FriendDetailFragment()
        }
    }

    lateinit var friend: VkFriend

    @InjectPresenter
    lateinit var friendDetailPresenter: FriendDetailPresenter

    @ProvidePresenter
    fun providePresenter() : FriendDetailPresenter {
        val router = (activity?.application as MyApp).router
        friend = arguments?.get(FriendDetailScreen.KEY_FRIEND) as VkFriend
        return FriendDetailPresenter(router, friend)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_friend_detail, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonShowPhotos.setOnClickListener({
            friend?.id?.let { it1 -> friendDetailPresenter.navigateToPhotos(it1) }
        })
    }

    override fun showFriendInfo(info: String, avatar: String) {
        textView.text = info
        Picasso.get().load(avatar).into(imageViewPhoto)
    }
}
