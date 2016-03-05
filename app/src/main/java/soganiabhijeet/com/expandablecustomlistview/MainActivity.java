package soganiabhijeet.com.expandablecustomlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

import soganiabhijeet.com.expandablecustomlistview.model.BaseListModel;
import soganiabhijeet.com.expandablecustomlistview.model.CategoriesModel;
import soganiabhijeet.com.expandablecustomlistview.model.StoreModel;
import soganiabhijeet.com.expandablecustomlistview.model.TitleModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAdapter adapter;
    private ArrayList<BaseListModel> listModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        listModels = new ArrayList<>();
        adapter = new ListAdapter(this, listModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        addDummyList();
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addDummyList() {
        //Boring stuff
        TitleModel categoryTitle = new TitleModel();
        categoryTitle.name = "Categories";
        categoryTitle.children = new ArrayList<>();
        categoryTitle.children.addAll(Arrays.asList(addDummyCategoryList()));
        categoryTitle.isCurrentlyOpen = true;
        categoryTitle.viewType = ListAdapter.HEADER;
        listModels.add(categoryTitle);
        listModels.addAll(Arrays.asList(addDummyCategoryList()));

        TitleModel storeTitle = new TitleModel();
        storeTitle.name = "Stores";
        storeTitle.children = new ArrayList<>();
        storeTitle.children.addAll(Arrays.asList(addDummyStoreList()));
        storeTitle.isCurrentlyOpen = true;
        storeTitle.viewType = ListAdapter.HEADER;
        listModels.add(storeTitle);
        listModels.addAll(Arrays.asList(addDummyStoreList()));

    }

    private CategoriesModel[] addDummyCategoryList() {
        CategoriesModel[] categoriesModels = new CategoriesModel[6];
        categoriesModels[0] = new CategoriesModel("(100)", "Apparel");
        categoriesModels[1] = new CategoriesModel("(70)", "Mobile");
        categoriesModels[2] = new CategoriesModel("(10)", "Travel");
        categoriesModels[3] = new CategoriesModel("(90)", "Home Appliances");
        categoriesModels[4] = new CategoriesModel("(15)", "Electronics");
        categoriesModels[5] = new CategoriesModel("(17)", "Cars");
        return categoriesModels;
    }

    private StoreModel[] addDummyStoreList() {
        StoreModel[] storeModels = new StoreModel[5];
        storeModels[0] = new StoreModel(getResources().getDrawable(R.drawable.amazon), "10% off On Electronics", "Amazon");
        storeModels[1] = new StoreModel(getResources().getDrawable(R.drawable.flipkart), "5% off On ICICI", "Flipkart");
        storeModels[2] = new StoreModel(getResources().getDrawable(R.drawable.myntra), "10% off On Apparel", "Myntra");
        storeModels[3] = new StoreModel(getResources().getDrawable(R.drawable.snapdeal), "10% off On Electronics", "Snapdeal");
        storeModels[4] = new StoreModel(getResources().getDrawable(R.drawable.paytm), "10% cashback On Recharge", "Paytm");
        return storeModels;
    }
}
