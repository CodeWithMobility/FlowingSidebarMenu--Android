package com.mobiledev.flowingsidebarmenu.flowingsidemenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mobiledev.flowingsidebarmenu.R;
import com.mobiledev.flowingsidebarmenu.sidebarDataSource.SideBarAdapter;
import com.mobiledev.flowingsidebarmenu.sidebarDataSource.SideMenuItem;

import java.util.ArrayList;

/**
 * Created by Manu on 7/22/2017.
 */

public class DrawerFragment extends Fragment {
    private boolean isShown;
    private ListView menuListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drawer_fragment_layout, container,
                false);
        menuListView = (ListView) view.findViewById(R.id.menulistview);
        prepareArraySidemenuList();
        SideBarAdapter adapter = new SideBarAdapter(getActivity(), itemList);
        menuListView.setAdapter(adapter);

        //   ivMenuUserProfilePhoto = (ImageView) view.findViewById(R.id.ivMenuUserProfilePhoto);

        return view;
    }

    private ArrayList<SideMenuItem> itemList;

    public void prepareArraySidemenuList() {
        itemList = new ArrayList<SideMenuItem>();

        AddObjectToList(R.drawable.home, "Home");
        AddObjectToList(R.drawable.profile, "Profile");
        AddObjectToList(R.drawable.aboutus, "About us");
        AddObjectToList(R.drawable.suggestions, "Suggestions");
        AddObjectToList(R.drawable.notification, "Notifications");
        AddObjectToList(R.drawable.contactus, "Contact us");
        AddObjectToList(R.drawable.settings, "Settings");
    }

    // Add one item into the Array List
    public void AddObjectToList(int image, String title) {
        SideMenuItem bean = new SideMenuItem();

        bean.setImage(image);
        bean.setTitle(title);
        itemList.add(bean);
    }

    public void show(int y) {
        if (!isShown) {
            isShown = true;
        }
        menuListView.setVisibility(View.VISIBLE);
        menuListView.startLayoutAnimation();
    }

    public void hideView(){
        isShown = false;
        menuListView.setVisibility(View.GONE);

    }


}
