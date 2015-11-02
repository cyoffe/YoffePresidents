package yoffe.presidents;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PresidentPagerAdapter extends PagerAdapter{

    private President[] presidents;

    public PresidentPagerAdapter(President[] presidents) {
        this.presidents = presidents;
    }

    @Override
    public int getCount() {
        return presidents.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {//will create a page


       View view = LayoutInflater
               .from(container.getContext())
               .inflate(R.layout.president_pager_item, null);

        TextView name = (TextView) view.findViewById(R.id.name);
        TextView number = (TextView) view.findViewById(R.id.number);

        President president = presidents[position];
        name.setText(president.getPresident());
        number.setText(president.getNumber());

        //container holds the pages so need to add view to container
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
