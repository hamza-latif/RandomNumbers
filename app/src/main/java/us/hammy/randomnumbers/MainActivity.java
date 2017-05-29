package us.hammy.randomnumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });

        graph.addSeries(series);
    }

    public void createRandomNumber(View view)
    {
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        int rb0_id = R.id.radioButton0;
        int i = rg.getCheckedRadioButtonId();
        //int r = (int)(Math.random()*100) +1;
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(Integer.toString(i-rb0_id));

        //rg.setVisibility(View.GONE);
    }

    public double createRandomGaussian(double mean, double var)
    {
        return 0.0;
    }

    public void showGaussian(View view)
    {
        ((LinearLayout) findViewById(R.id.uniformLayout)).setVisibility(View.GONE);
        ((LinearLayout) findViewById(R.id.gaussianLayout)).setVisibility(View.VISIBLE);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.removeAllSeries();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(-2, .05),
                new DataPoint(-1, .3),
                new DataPoint(0, .6),
                new DataPoint(1, .3),
                new DataPoint(2, .05)
        });

        graph.addSeries(series);
    }

    public void showUniform(View view)
    {
        ((LinearLayout) findViewById(R.id.gaussianLayout)).setVisibility(View.GONE);
        ((LinearLayout) findViewById(R.id.uniformLayout)).setVisibility(View.VISIBLE);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.removeAllSeries();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(-2, .25),
                new DataPoint(-1, .25),
                new DataPoint(0, .25),
                new DataPoint(1, .25),
                new DataPoint(2, .25)
        });

        graph.addSeries(series);
    }
}
