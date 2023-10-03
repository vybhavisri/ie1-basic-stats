import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class MinMaxView implements View {

    double min;
    //double max;
    JTextField jtfMinMax;
    String name;

    public MinMaxView() {
        min = 0;
        //max = 0;
        jtfMinMax = new JTextField(10);
        jtfMinMax.setEditable(false);
        name = "Min/Max";
    }

    @Override
    public void update(ArrayList<Double> numbers) {
        min = BasicStats.findMinMax(BasicStats.getArrayDouble(numbers));
        //max = BasicStats.max(BasicStats.getArrayDouble(numbers));

        jtfMinMax.setText("Min: " + min );
    }

    @Override
    public void reset() {
        min = 0;
        //max = 0;
        jtfMinMax.setText("");
    }

    @Override
    public JTextComponent show() {
        return jtfMinMax;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getMin() {
        return min;
    }

    //public double getMax() {
        //return max;
    //}
}