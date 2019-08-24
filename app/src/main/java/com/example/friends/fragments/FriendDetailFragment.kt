package com.example.friends.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.friends.MyApp
import com.example.friends.R
import com.example.friends.activities.MainActivity
import com.example.friends.model.entity.friends.VkFriend
import com.example.friends.presenters.FriendDetailPresenter
import com.example.friends.views.FriendsDetailView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_friend_detail.*

class FriendDetailFragment : MvpAppCompatFragment(), FriendsDetailView{
    companion object{
        val KEY_FRIEND = "KEY_FRIEND"

        fun getNewInstance(friend: VkFriend): FriendDetailFragment{
            val fragment = FriendDetailFragment()
            val args = Bundle()
            args.putSerializable(KEY_FRIEND, friend)
            fragment.arguments = args
            return fragment
        }

        fun toFriendDetailFragment(activity: MainActivity, friend: VkFriend){
            activity.fragmentManager.beginTransaction().replace(R.id.container, FriendDetailFragment.getNewInstance(friend))
                .addToBackStack(null).commit()
        }
    }

    lateinit var friend: VkFriend

    @InjectPresenter
    lateinit var friendDetailPresenter: FriendDetailPresenter

    @ProvidePresenter
    fun providePresenter() : FriendDetailPresenter {
        friend = arguments?.get(KEY_FRIEND) as VkFriend
        return FriendDetailPresenter(friend)
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

    override fun navigateToPotos(userId: Int) {
        PhotosFragment.toPhotosFragment(activity as MainActivity, userId)
    }
}
