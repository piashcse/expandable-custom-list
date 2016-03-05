package soganiabhijeet.com.expandablecustomlistview.holder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import soganiabhijeet.com.expandablecustomlistview.ListAdapter;
import soganiabhijeet.com.expandablecustomlistview.R;
import soganiabhijeet.com.expandablecustomlistview.model.StoreModel;

/**
 * Created by abhijeetsogani on 2/27/16.
 */
public class StoreViewHolder extends BaseViewHolder<StoreModel> {
    private ImageView storeImg;
    private TextView storeTitle;
    private TextView offerDescription;
    private ListAdapter adapter;

    public StoreViewHolder(View itemView, ListAdapter adapter) {
        super(itemView);
        storeImg = (ImageView) itemView.findViewById(R.id.store_img);
        storeTitle = (TextView) itemView.findViewById(R.id.store_title);
        offerDescription = (TextView) itemView.findViewById(R.id.store_offers);
        this.adapter=adapter;
    }

    @Override
    public void populate(StoreModel storeModel) {
        storeImg.setImageDrawable(storeModel.image);
        storeTitle.setText(storeModel.name);
        offerDescription.setText(storeModel.storeDescription);
    }

    @Override
    public void onClick(View v) {
        Log.e("StoreViewHolder", "position " + getAdapterPosition());
        adapter.onListItemClicked(getAdapterPosition());
    }
}
