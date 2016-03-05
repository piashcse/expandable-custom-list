package soganiabhijeet.com.expandablecustomlistview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import soganiabhijeet.com.expandablecustomlistview.holder.BaseViewHolder;
import soganiabhijeet.com.expandablecustomlistview.holder.CategoriesViewHolder;
import soganiabhijeet.com.expandablecustomlistview.holder.StoreViewHolder;
import soganiabhijeet.com.expandablecustomlistview.holder.TitleViewHolder;
import soganiabhijeet.com.expandablecustomlistview.model.BaseListModel;
import soganiabhijeet.com.expandablecustomlistview.model.CategoriesModel;
import soganiabhijeet.com.expandablecustomlistview.model.StoreModel;
import soganiabhijeet.com.expandablecustomlistview.model.TitleModel;

/**
 * Created by abhijeetsogani on 2/13/16.
 */
public class ListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private LayoutInflater inflater = null;
    private Context context;
    private List<BaseListModel> itemList;
    public static final int HEADER = 1;
    public static final int CHILD = 0;
    public static final int CATEGORY = 1001;
    public static final int STORE = 1002;

    public ListAdapter(Context context, List<BaseListModel> itemList) {
        this.context = context;
        this.itemList = itemList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case CATEGORY:
                view = inflater.inflate(R.layout.category_list_item, parent, false);
                return new CategoriesViewHolder(view, this);
            case STORE:
                view = inflater.inflate(R.layout.store_list_item, parent, false);
                return new StoreViewHolder(view, this);
            case HEADER:
                view = inflater.inflate(R.layout.title_list_item, parent, false);
                return new TitleViewHolder(view, this);

        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (itemList.get(position) instanceof CategoriesModel) {
            return CATEGORY;
        }
        if (itemList.get(position) instanceof StoreModel) {
            return STORE;
        } else {
            return HEADER;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        holder.populate(itemList.get(position));
        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemList.get(position) instanceof TitleModel) {
                    headerAnimation(position, ((TitleModel) itemList.get(position)).isCurrentlyOpen);
                } else if (itemList.get(position) instanceof CategoriesModel) {
                    Toast.makeText(context, "Open activity for category", Toast.LENGTH_LONG).show();
                } else if (itemList.get(position) instanceof StoreModel) {
                    Toast.makeText(context, "Open activity for store", Toast.LENGTH_LONG).show();
                }
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void onListTitleClicked(int position) {
        if (itemList.get(position) instanceof TitleModel) {
            TitleModel model = (TitleModel) itemList.get(position);
            if (!model.isCurrentlyOpen) {
                int count = 0;
                //add items
                for (BaseListModel child : model.children) {
                    count++;
                    itemList.add(position + count, child);
                }
                notifyItemRangeInserted(position + 1, count);

            } else {
                int count = model.children.size();
                //remove items
                for (int i = 1; i <= model.children.size(); i++) {
                    itemList.remove(position + count);
                    count--;
                }

                notifyItemRangeRemoved(position + 1, model.children.size());

            }
            model.isCurrentlyOpen = !model.isCurrentlyOpen;
            notifyItemChanged(position);
            //notifyDataSetChanged();
        }
    }

    public void onListItemClicked(int position) {
        if (itemList.get(position) instanceof StoreModel) {
            StoreModel storeModel = (StoreModel) itemList.get(position);
            Toast.makeText(context, "Open activity for store " + storeModel.name, Toast.LENGTH_LONG).show();
        }
        if (itemList.get(position) instanceof CategoriesModel) {
            CategoriesModel categoriesModel = (CategoriesModel) itemList.get(position);
            Toast.makeText(context, "Open activity for category " + categoriesModel.name, Toast.LENGTH_LONG).show();
        }


    }

}
