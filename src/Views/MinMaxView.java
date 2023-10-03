import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class MinMaxView implements View {

    double min;
    double max;
    JTextField jtfMin;
    JTextField jtfMax;
    String name;

    public MinMaxView() {
        min = 0;
        max = 0;
        jtfMin = new JTextField(10);
        jtfMin.setEditable(false);
        jtfMax = new JTextField(10);
        jtfMax.setEditable(false);
        name = "Min/Max";
    }

    @Override
    public void update(ArrayList<Double> numbers) {
        min = BasicStats.min(BasicStats.getArrayDouble(numbers));
        max = BasicStats.max(BasicStats.getArrayDouble(numbers));

        jtfMin.setText("Min: " + min );
        jtfMax.setText("Max: " + max);
    }

    @Override
    public void reset() {
        min = 0;
        max = 0;
        jtfMin.setText("");
        jtfMax.setText("");
    }

    @Override
    public JTextComponent show() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(jtfMin);
        panel.add(jtfMax);
        
        JScrollPane scrollPane = new JScrollPane(panel);
        JTextPane textPane = new JTextPane();
        textPane.insertComponent(scrollPane);

        return textPane;
       
    }

    @Override
    public String getName() {
        return name;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}