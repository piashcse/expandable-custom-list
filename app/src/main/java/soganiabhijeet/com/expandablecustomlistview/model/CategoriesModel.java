package soganiabhijeet.com.expandablecustomlistview.model;

/**
 * Created by abhijeetsogani on 2/13/16.
 */
public class CategoriesModel extends BaseListModel {

    public String noOffers;
    public String name;

    public CategoriesModel(String noOffers, String name) {
        this.noOffers = noOffers;
        this.name = name;
    }
}
