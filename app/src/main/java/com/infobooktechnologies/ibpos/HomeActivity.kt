package com.infobooktechnologies.ibpos

import android.os.Bundle
import com.infobooktechnologies.ibpos.fragment.CartViewFragment
import com.infobooktechnologies.ibpos.fragment.MenuItemViewFragment
import com.infobooktechnologies.ibpos.other.Constants

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.cart_view_container,
            CartViewFragment(),Constants.CARTVIEWFRAGMENT).commit()

        supportFragmentManager.beginTransaction().add(R.id.menu_item_container,
            MenuItemViewFragment(),Constants.MENUITEMLISTVIEWFRAGMENT).commit()
    }
}