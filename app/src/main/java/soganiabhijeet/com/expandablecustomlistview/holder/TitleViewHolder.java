package soganiabhijeet.com.expandablecustomlistview.holder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import soganiabhijeet.com.expandablecustomlistview.ListAdapter;
import soganiabhijeet.com.expandablecustomlistview.R;
import soganiabhijeet.com.expandablecustomlistview.model.TitleModel;

/**
 * Created by abhijeetsogani on 2/27/16.
 */
public class TitleViewHolder extends BaseViewHolder<TitleModel> {

    private TextView titleName;
    private ImageView arrowImg;
    private ListAdapter adapter;

    public TitleViewHolder(View itemView, ListAdapter adapter) {
        super(itemView);
        titleName = (TextView) itemView.findViewById(R.id.title_name);
        arrowImg = (ImageView) itemView.findViewById(R.id.arrow_img);
        this.adapter = adapter;
    }

    @Override
    public void populate(TitleModel titleModel) {
        titleName.setText(titleModel.name);
        if (titleModel.isCurrentlyOpen) {
            arrowImg.setImageResource(R.drawable.arrow_up_black);
        } else {
            arrowImg.setImageResource(R.drawable.arrow_down_black);
        }
    }

    @Override
    public void onClick(View v) {
        Log.e("TitleViewHolder", "position " + getAdapterPosition());
        adapter.onListTitleClicked(getAdapterPosition());
    }
}
