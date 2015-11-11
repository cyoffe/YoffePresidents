package yoffe.presidents;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PresidentPagerAdapter extends PagerAdapter{

    private President[] presidents;
    private Integer[] pictures;

    public PresidentPagerAdapter(President[] presidents, Integer[] pictures) {
        this.presidents = presidents;
        this.pictures = pictures;
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
        TextView yearsLived = (TextView) view.findViewById(R.id.yearsLived);
        TextView officeYears = (TextView) view.findViewById(R.id.officeYears);
        TextView party = (TextView) view.findViewById(R.id.party);
        ImageView image = (ImageView) view.findViewById(R.id.presImage);


        President president = presidents[position];
        image.setImageResource(pictures[position]);
        name.setText((president.getPresident()));
        number.setText("President #" + String.valueOf(president.getNumber()));

        if(president.getDeathYear() == null){
            yearsLived.setText("Years: " + String.valueOf(president.getBirthYear()) + " - Present");
        }else {
            yearsLived.setText("Years: " + String.valueOf(president.getBirthYear() + "-" + String.valueOf(president.getDeathYear())));
        }

        if(president.getLeftOffice() == null){
            officeYears.setText("Office " + president.getTookOffice() + " - Present");
        }else {
            officeYears.setText("Office " + president.getTookOffice() + " - " + president.getLeftOffice());
        }

        party.setText(new StringBuilder().append("Party: ").append(president.getParty()).toString());

        //container holds the pages so need to add view to container
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
