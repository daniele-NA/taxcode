import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FieldPanel extends JPanel {
    private final JLabel surname = new JLabel("COGNOME");
    private final JLabel name = new JLabel("NOME");
    private final JLabel cadastralCode = new JLabel("CODICE CATASTALE     ");
    private final JLabel sex =new JLabel("SESSO  ");
    private final JLabel date =new JLabel("DATA DI NASCITA  ");

    private final JTextField inputSurname = new JTextField(15);
    private final JTextField inputName = new JTextField(10);
    private final JTextField inputCadastralCode = new JTextField(4);


    private final ButtonGroup bg = new ButtonGroup();
    private JRadioButton m = new JRadioButton("M");
    private JRadioButton f = new JRadioButton("F");

    private final String []day={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15"
            ,"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private final String[] month ={"01","02","03","04","05","06","07","08","09","10","11","12"};
    private final String[] year={"2024","2023","2022","2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010"
            ,"2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"};

    private final JComboBox<String> daysComboBox =new JComboBox<>(day);
    private final JComboBox<String> monthComboBox =new JComboBox<>(month);
    private final JComboBox<String> yearsComboBox =new JComboBox<>(year);


    FieldPanel() {
        setLayout(new GridBagLayout());
        setBackground(Color.LIGHT_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        setBorder(border);

        gbc.insets = new Insets(1, 1, 13, 1);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        surname.setForeground(Color.YELLOW);
        this.add(surname, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inputSurname.setBorder(border);
        this.add(inputSurname, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        name.setForeground(Color.YELLOW);
        this.add(name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        inputName.setBorder(border);
        this.add(inputName, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        sex.setForeground(Color.yellow);
        this.add(sex,gbc);


        gbc.gridx = 3;
        gbc.gridy = 1;
        m.setActionCommand("m");
        f.setActionCommand("f");
        m.setBackground(Color.LIGHT_GRAY);
        f.setBackground(Color.LIGHT_GRAY);
        bg.add(m);
        bg.add(f);
        this.add(m,gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        this.add(f,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        cadastralCode.setForeground(Color.YELLOW);
        this.add(cadastralCode, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        inputCadastralCode.setBorder(border);
        this.add(inputCadastralCode, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        date.setForeground(Color.yellow);
        this.add(date,gbc);


        gbc.gridx = 3;
        gbc.gridy = 2;
        this.add(daysComboBox,gbc);


        gbc.gridx = 4;
        gbc.gridy = 2;
        this.add(monthComboBox,gbc);

        gbc.gridx = 5;
        gbc.gridy = 2;
        this.add(yearsComboBox,gbc);
    }

    public void clear(){
        inputSurname.setText("");
        inputName.setText("");
        inputCadastralCode.setText("");
        bg.clearSelection();
    }



    public JTextField getInputSurname() {
        return inputSurname;
    }

    public JTextField getInputName() {
        return inputName;
    }

    public JTextField getInputCadastralCode() {
        return inputCadastralCode;
    }

    public ButtonGroup getBg() {
        return bg;
    }



    public JComboBox<String> getDaysComboBox() {
        return daysComboBox;
    }

    public JComboBox<String> getMonthComboBox() {
        return monthComboBox;
    }

    public JComboBox<String> getYearsComboBox() {
        return yearsComboBox;
    }
}
