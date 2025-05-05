import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FieldPanel extends JPanel {
    private final JLabel surname = new JLabel("COGNOME");
    private final JLabel name = new JLabel("NOME");
    private final JLabel cadastralCode = new JLabel("CODICE CATASTALE");
    private final JLabel sex = new JLabel("SESSO");
    private final JLabel date = new JLabel("DATA DI NASCITA");

    private final JTextField inputSurname = new JTextField(15);
    private final JTextField inputName = new JTextField(10);
    private final JTextField inputCadastralCode = new JTextField(4);

    private final ButtonGroup bg = new ButtonGroup();
    private final JRadioButton m = new JRadioButton("M");
    private final JRadioButton f = new JRadioButton("F");

    private final String []day={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15"
            ,"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private final String[] month ={"01","02","03","04","05","06","07","08","09","10","11","12"};
    private final String[] year={"2024","2023","2022","2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010"
            ,"2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"};

    private final JComboBox<String> daysComboBox = new JComboBox<>(day);
    private final JComboBox<String> monthComboBox = new JComboBox<>(month);
    private final JComboBox<String> yearsComboBox = new JComboBox<>(year);

    FieldPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(38, 50, 56)); // dark gray-blue
        setBorder(new EmptyBorder(20, 20, 20, 20));

        Font labelFont = new Font("SansSerif", Font.BOLD, 13);
        Color accentColor = new Color(255, 202, 40);  // amber
        Color inputBg = new Color(55, 71, 79);
        Color inputFg = Color.WHITE;

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel[] labels = {surname, name, cadastralCode, sex, date};
        for (JLabel l : labels) {
            l.setForeground(accentColor);
            l.setFont(labelFont);
        }

        JTextField[] fields = {inputSurname, inputName, inputCadastralCode};
        for (JTextField tf : fields) {
            tf.setBackground(inputBg);
            tf.setForeground(inputFg);
            tf.setCaretColor(Color.WHITE);
            tf.setBorder(BorderFactory.createLineBorder(new Color(0x00ACC1), 1));
        }


        m.setActionCommand("M");
        f.setActionCommand("F");

        JRadioButton[] radios = {m, f};
        for (JRadioButton r : radios) {
            r.setForeground(inputFg);
            r.setBackground(getBackground());
            r.setFont(labelFont);
            bg.add(r);
        }

        // Aggiungi i componenti come nel tuo codice ma con spacing coerente
        gbc.gridx = 0; gbc.gridy = 0; add(surname, gbc);
        gbc.gridx = 1; add(inputSurname, gbc);

        gbc.gridx = 0; gbc.gridy = 1; add(name, gbc);
        gbc.gridx = 1; add(inputName, gbc);
        gbc.gridx = 2; add(sex, gbc);
        gbc.gridx = 3; add(m, gbc);
        gbc.gridx = 4; add(f, gbc);

        gbc.gridx = 0; gbc.gridy = 2; add(cadastralCode, gbc);
        gbc.gridx = 1; add(inputCadastralCode, gbc);
        gbc.gridx = 2; add(date, gbc);
        gbc.gridx = 3; add(daysComboBox, gbc);
        gbc.gridx = 4; add(monthComboBox, gbc);
        gbc.gridx = 5; add(yearsComboBox, gbc);
    }

    public void clear() {
        inputSurname.setText("");
        inputName.setText("");
        inputCadastralCode.setText("");
        bg.clearSelection();
    }

    public JTextField getInputSurname() { return inputSurname; }
    public JTextField getInputName() { return inputName; }
    public JTextField getInputCadastralCode() { return inputCadastralCode; }
    public ButtonGroup getBg() { return bg; }
    public JComboBox<String> getDaysComboBox() { return daysComboBox; }
    public JComboBox<String> getMonthComboBox() { return monthComboBox; }
    public JComboBox<String> getYearsComboBox() { return yearsComboBox; }
}
