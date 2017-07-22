package com.mobiledev.flowingsidebarmenu.sidebarDataSource;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobiledev.flowingsidebarmenu.R;

import java.util.ArrayList;

/**
 * Created by Manu on 7/22/2017.
 */

public class SideBarAdapter extends BaseAdapter{

    ArrayList<SideMenuItem> itemList;

    public Context context;
    public LayoutInflater inflater;

    public SideBarAdapter(Context context,ArrayList<SideMenuItem> itemList) {
        super();

        this.context = context;
        this.itemList = itemList;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static class ViewHolder
    {
        ImageView imgViewLogo;
        TextView txtViewTitle;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        ViewHolder holder;
        if(convertView==null)
        {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.sidemenu_item, null);
            holder.imgViewLogo = (ImageView) convertView.findViewById(R.id.icons);
            //  holder.txtViewTitle = (TextView) convertView.findViewById(R.id.txtViewTitle);

            convertView.setTag(holder);
        }
        else
            holder=(ViewHolder)convertView.getTag();


        holder.imgViewLogo.setImageResource(itemList.get(position).getImage());
        // holder.txtViewTitle.setText(bean.getTitle());

        return convertView;
    }

}