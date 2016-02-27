package soganiabhijeet.com.expandablecustomlistview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import soganiabhijeet.com.expandablecustomlistview.model.BaseListModel;

/**
 * Created by abhijeetsogani on 2/27/16.
 */
public abstract class BaseViewHolder<T extends BaseListModel> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void populate(T baseSliderModel);

}
